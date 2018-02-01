import scalariform.formatter.preferences._

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
  "org.mariadb.jdbc" % "mariadb-java-client" % "2.2.1",
  "org.flywaydb" % "flyway-core" % "5.0.7",
  guice
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)

//********************************************************
// Scalariform settings
//********************************************************

scalariformAutoformat := true
