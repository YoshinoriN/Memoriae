val Organization = "net.yoshinorin"
val Name = "memoriae"
val version = "0.0.1"

scalaVersion := "2.12.4"

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked"
)

libraryDependencies ++= Seq(
  "net.codingwell" %% "scala-guice" % "4.1.0",
  guice
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)
