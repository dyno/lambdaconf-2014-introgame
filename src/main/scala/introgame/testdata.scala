package introgame

object testdata {
  val RustySword = Item("Rusty Sword")

  val TestMap = GameMap[Cell](
    Vector(
      Vector( // 0
        Cell("(0, 0) Haunted Oak Forest", "A spooky-looking forest filled with ancient oak trees.", RustySword :: Nil),
        Cell("(0, 1) The Glades", "A grassy, wide open expanse that stretches for miles in every direction", Nil),
        Cell("(0, 2) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(0, 3) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(0, 4) Desert", "A barren expanse of nothingness.", Nil)
      ),
      Vector( // 1
        Cell("(1, 0) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(1, 1) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(1, 2) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(1, 3) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(1, 4) Desert", "A barren expanse of nothingness.", Nil)
      ),
      Vector( // 2
        Cell("(2, 0) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(2, 1) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(2, 2) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(2, 3) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(2, 4) Desert", "A barren expanse of nothingness.", Nil)
      ),
      Vector( // 3
        Cell("(3, 0) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(3, 1) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(3, 2) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(3, 3) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(3, 4) Desert", "A barren expanse of nothingness.", Nil)
      ),
      Vector( // 4
        Cell("(4, 0) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(4, 1) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(4, 2) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(4, 3) Desert", "A barren expanse of nothingness.", Nil),
        Cell("(4, 4) Desert", "A barren expanse of nothingness.", Nil)
      )
    ))
}
