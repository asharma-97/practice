name := "practice"

version := "0.1"

scalaVersion := "2.13.4"

val akkaVersion = "2.6.10"
val scalaTestVersion = "3.2.3"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "org.scalatest" %% "scalatest" % scalaTestVersion,
)
