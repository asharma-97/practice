name := "practice"

version := "0.1"

scalaVersion := "2.13.4"

val akkaVersion = "2.6.10"
val akkaHttpVersion = "10.2.1"
val scalaTestVersion = "3.2.3"
val cats = "2.1.1"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-actor" % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion,
  // Akka Http
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
  "com.typesafe.akka" %% "akka-http-testkit" % akkaHttpVersion,
  // Testing
  "com.typesafe.akka" %% "akka-testkit" % akkaVersion,
  "org.scalatest" %% "scalatest" % scalaTestVersion,
  "org.typelevel" %% "cats-core" % cats,
  // JWT
  "com.pauldijou" %% "jwt-spray-json" % "4.3.0"
)
