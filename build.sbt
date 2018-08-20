organization := "com.github.jdegoes.lambdaconf"
name := "introfp"
version := "0.1-SNAPSHOT"

scalaVersion := "2.12.6"
scalacOptions ++= Seq(
  "-feature",
  "-language:implicitConversions",
  "-language:higherKinds",
  "-language:existentials",
  "-language:postfixOps"
)

lazy val monocleVersion                = "1.5.0"     // http://julien-truffaut.github.io/Monocle/
lazy val scalaCheckVersion             = "1.14.0"    // https://www.scalacheck.org/
lazy val scalaParserCombinatorsVersion = "1.1.1"     // https://github.com/scala/scala-parser-combinators
lazy val scalaTestVersion              = "3.0.5"     // http://www.scalatest.org/
lazy val scalazVersion                 = "7.3.0-M24" // https://javadoc.io/doc/org.scalaz/scalaz-core_2.11/
lazy val specs2Version                 = "0.5.2"     // https://github.com/typelevel/scalaz-specs2
lazy val paradiseVersion               = "2.1.1"     // https://docs.scala-lang.org/overviews/macros/paradise.html

val monocleCore             = "com.github.julien-truffaut" %% "monocle-core"              % monocleVersion
val monocleMacro            = "com.github.julien-truffaut" %% "monocle-macro"             % monocleVersion
val scalaCheck              = "org.scalacheck"             %% "scalacheck"                % scalaCheckVersion % "test"
val scalaParserCombinators  = "org.scala-lang.modules"     %% "scala-parser-combinators"  % scalaParserCombinatorsVersion
val scalaTest               = "org.scalatest"              %% "scalatest"                 % scalaTestVersion % "test"
val scalazConcurrent        = "org.scalaz"                 %% "scalaz-concurrent"         % scalazVersion
val scalazCore              = "org.scalaz"                 %% "scalaz-core"               % scalazVersion
val scalazScalaCheckBinding = "org.scalaz"                 %% "scalaz-scalacheck-binding" % scalazVersion % "test"
val scalazSpecs2            = "org.typelevel"              %% "scalaz-specs2"             % specs2Version % "test"
val paradise                = "org.scalamacros"            %% "paradise"                  % paradiseVersion cross CrossVersion.full

libraryDependencies ++= Seq(
  monocleCore,
  monocleMacro,
  scalaCheck,
  scalaParserCombinators,
  scalaTest,
  scalazConcurrent,
  scalazCore,
  scalazScalaCheckBinding,
  scalazSpecs2,
)

// https://www.scala-sbt.org/1.x/docs/Compiler-Plugins.html
autoCompilerPlugins := true
addCompilerPlugin(paradise)

mainClass := Some("Main")
