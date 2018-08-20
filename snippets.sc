import scala.io.StdIn.readLine

trait Monad[M[_]] {
  def point[A](a: => A): M[A]

  def flatMap[A, B](ma: M[A])(f: A => M[B]): M[B]

  def map[A, B](ma: M[A])(f: A => B): M[B] = flatMap(ma)(a => point[B](f(a)))
}

class IO[A] private (run0: => A) {
  def run = run0

  def flatMap[B](f: A => IO[B]): IO[B] = IO(f(run).run)

  def map[B](f: A => B): IO[B] = flatMap(a => IO(f(a)))
}
object IO {
  def apply[A](v: => A): IO[A] = new IO(v)
}

def getLine: IO[String]           = IO(readLine())
def putStrLn(v: String): IO[Unit] = IO(println(v))

implicit val IOMonad: Monad[IO] = new Monad[IO] {
  def point[A](a: => A): IO[A] = IO(a)

  def flatMap[A, B](ma: IO[A])(f: A => IO[B]): IO[B] = ma.flatMap(f)
}

implicit val OptionMonad: Monad[Option] = new Monad[Option] {
  def point[A](a: => A): Option[A] = Some(a)

  def flatMap[A, B](ma: Option[A])(f: A => Option[B]): Option[B] = ma.flatMap(f)
}

case class StateT[M[_], S, A](run: S => M[(S, A)]) {
  def flatMap[B](g: A => StateT[M, S, B])(implicit M: Monad[M]): StateT[M, S, B] = StateT { s0: S =>
    M.flatMap(run(s0)) {
      case (s1, a) => g(a).run(s1)
    }
  }

  def map[B](f: A => B)(implicit M: Monad[M]): StateT[M, S, B] = flatMap(a => StateT.point(f(a)))
}
object StateT {
  def point[M[_], S, A](v: A)(implicit M: Monad[M]): StateT[M, S, A] = StateT(run = s => M.point((s, v)))
}

case class Lens[S, A](get: S => A, set: (S, A) => S) {
  def |->[B](that: Lens[A, B]): Lens[S, B] = Lens(
    get = that.get compose get,
    set = (s, b) => set(s, that.set(get(s), b))
  )

  def modify(s: S)(f: A => A): S = set(s, f(get(s)))
}

case class PlayerState(health: Int)

object PlayerState {
  val health = Lens[PlayerState, Int](_.health, (s, a) => s.copy(a))
}

case class GameState(player: PlayerState)

object GameState {
  val player = Lens[GameState, PlayerState](_.player, (s, a) => s.copy(a))
}

GameState.player |-> PlayerState.health

type Game[A] = StateT[IO, GameState, A]

def state[A](f: GameState => (GameState, A)): Game[A] = StateT[IO, GameState, A](s => IO(f(s)))

def liftIO[A](io: IO[A]): Game[A] = StateT[IO, GameState, A](s => io.map(a => (s, a)))

import GameState._
import PlayerState._

def update[A](lens: Lens[GameState, A])(f: A => A): Game[A] = state[A] { s: GameState =>
  val newValue = f(lens.get(s))

  lens.set(s, newValue) -> newValue
}

def updateHealth(delta: Int): Game[Int] = update(player |-> health)(_ + delta)

def getLineG: Game[String]           = liftIO(getLine)
def putStrLnG(v: String): Game[Unit] = liftIO(putStrLn(v))

def gameLoop: Game[Unit] =
  for {
    _     <- putStrLnG("What would you like to do?")
    input <- getLineG
    _     <- putStrLnG("So, you want to " + input + ", do you?")
    _ <- if (input == "fight") {
      for {
        newHealth <- updateHealth(-10)
        _         <- putStrLnG("Your new health is: " + newHealth)
        _         <- gameLoop
      } yield {
        Unit
      }
    } else if (input == "quit") {
      liftIO(IO(Unit))
    } else {
      for {
        _ <- putStrLnG("I'm sorry, I don't understand your command.")
        _ <- gameLoop
      } yield {
        Unit
      }
    }
  } yield {
    Unit
  }

gameLoop.run(GameState(PlayerState(100))).run