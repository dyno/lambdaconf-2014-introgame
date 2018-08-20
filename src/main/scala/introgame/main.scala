package introgame

import game._
import testdata._

object Main extends App {
  mainLoop.runGame(GameState(TestMap, Player(x = 0, y = 0, health = 100))).get.unsafeStart
}
