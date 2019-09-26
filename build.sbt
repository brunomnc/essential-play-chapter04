lazy val root = project
  .in(file("."))
  .settings(
    name := "chapter4macro",
    version := "0.1",
    scalaVersion := "2.12.8",
    libraryDependencies ++= Seq(
      akkaHttpServer,
      logback,
      "org.scalatest" %% "scalatest" % "3.0.8"
    )
  )
  .enablePlugins(PlayService)