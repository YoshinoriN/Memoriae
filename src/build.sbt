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

resolvers += Resolver.jcenterRepo

libraryDependencies ++= Seq(
  "org.mariadb.jdbc" % "mariadb-java-client" % "2.2.1",
  "io.getquill" %% "quill-jdbc" % "2.3.2",
  "org.flywaydb" % "flyway-core" % "5.0.7",
  "org.springframework.security" % "spring-security-web" % "5.0.1.RELEASE",
  "net.codingwell" %% "scala-guice" % "4.1.1",
  "com.iheart" %% "ficus" % "1.4.3",
  "com.mohiva" %% "play-silhouette" % "5.0.3",
  "com.mohiva" %% "play-silhouette-password-bcrypt" % "5.0.3",
  "com.mohiva" %% "play-silhouette-persistence" % "5.0.3",
  "com.mohiva" %% "play-silhouette-crypto-jca" % "5.0.3",
  "com.mohiva" %% "play-silhouette-testkit" % "5.0.3" % "test",
  "org.scalatest" %% "scalatest" % "3.0.4" % "test",
  "org.mockito" % "mockito-core" % "2.15.0" % "test",
  ehcache,
  guice,
  filters
)

lazy val root = (project in file(".")).enablePlugins(PlayScala)

routesGenerator := InjectedRoutesGenerator
