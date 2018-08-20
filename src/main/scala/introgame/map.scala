package introgame

import monocle.Lens
import monocle.macros.Lenses

@Lenses case class GameMap[A](value: Vector[Vector[A]]) {
  def cols = value.length

  def rows(x: Int): Int =
    if (x < 0 || x >= cols) {
      0
    } else {
      value(x).length
    }

  def contains(x: Int, y: Int): Boolean = x >= 0 && x < cols && y >= 0 && y < rows(x)
}

object GameMap {
  // https://stackoverflow.com/questions/31919994/how-to-update-map-using-monocle
  // https://stackoverflow.com/questions/12610990/updating-a-2d-table-of-counts
  def _cell[A](x: Int, y: Int): Lens[GameMap[A], A] =
    Lens[GameMap[A], A](map => map.value(x)(y))(v =>
      map => map.copy(value = map.value.updated(x, map.value(x).updated(y, v))))
}
