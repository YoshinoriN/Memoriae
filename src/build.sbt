import scalariform.formatter.preferences._

val Organization = "net.yoshinorin"
val Name = "memoriae"
val version = "0.0.1"

scalaVersion := "2.12.5"

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked"
)

resolvers += Resolver.jcenterRepo

libraryDependencies ++= Seq(
  "org.mariadb.jdbc" % "mariadb-java-client" % "2.2.3",
  "io.getquill" %% "quill-jdbc" % "2.3.3",
  "org.flywaydb" % "flyway-core" % "5.0.7",
  "org.springframework.security" % "spring-security-web" % "5.0.4.RELEASE",
  "net.codingwell" %% "scala-guice" % "4.2.0",
  "com.iheart" %% "ficus" % "1.4.3",
  "com.mohiva" %% "play-silhouette" % "5.0.3",
  "com.mohiva" %% "play-silhouette-password-bcrypt" % "5.0.3",
  "com.mohiva" %% "play-silhouette-persistence" % "5.0.3",
  "com.mohiva" %% "play-silhouette-crypto-jca" % "5.0.3",
  "com.mohiva" %% "play-silhouette-testkit" % "5.0.3" % "test",
  "org.scalatest" %% "scalatest" % "3.0.5" % "test",
  "org.mockito" % "mockito-core" % "2.18.0" % "test",
  ehcache,
  guice,
  filters
)

lazy val root = (project in file(".")).enablePlugins(PlayScala, SbtWeb)
pipelineStages := Seq(digest)
pipelineStages in Assets := Seq(digest)

routesGenerator := InjectedRoutesGenerator
