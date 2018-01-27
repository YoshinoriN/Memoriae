//import com.typesafe.sbt.SbtScalariform._
//import scalariform.formatter.preferences._

name := "memoriae"
version := "0.0.1"

scalaVersion := "2.12.4"

resolvers += Resolver.jcenterRepo

scalacOptions ++= Seq(
  "-deprecation",
  "-feature",
  "-unchecked"
)
