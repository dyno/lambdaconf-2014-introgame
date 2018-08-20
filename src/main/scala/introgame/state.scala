package introgame

import monocle.Lens
import monocle.macros.Lenses

@Lenses("_") case class Item(name: String) { override def toString = name }
@Lenses("_") case class Cell(name: String, description: String, items: List[Item])

@Lenses("_") case class Player(x: Int, y: Int, health: Int)
object Player {
  val _location = Lens[Player, (Int, Int)](player => (player.x, player.y))(location =>
    player => player.copy(x = location._1, y = location._2))
}

@Lenses("_") case class GameState(map: GameMap[Cell], player: Player)
