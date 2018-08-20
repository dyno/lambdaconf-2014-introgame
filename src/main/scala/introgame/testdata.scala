package introgame

object testdata {
  val RustySword = Item("Rusty Sword")

  val TestMap = GameMap[Cell](
    Vector(
      Vector( // 0
        Cell("Haunted Oak Forest", "A spooky-looking forest filled with ancient oak trees.", RustySword :: Nil),
        Cell("The Glades", "A grassy, wide open expanse that stretches for miles in every direction", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil)
      ),
      Vector( // 1
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil)
      ),
      Vector( // 2
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil)
      ),
      Vector( // 3
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil)
      ),
      Vector( // 4
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil),
        Cell("Desert", "A barren expanse of nothingness.", Nil)
      )
    ))
}
