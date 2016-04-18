name := """01_Dependency-Injection"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs,
  filters,
  "org.iban4j" % "iban4j" % "3.2.0" // for validating as well as converting IBAN and BIC
)




// New in Play 2.5 - in addition to command line "activator -Dhttp.port=9001"
// PlayKeys.devSettings := Seq("play.server.http.port" -> "9001")

// Debugging: activator -jvm-debug 9999

// Not needed anymore
//routesGenerator := InjectedRoutesGenerator

// Switch back to old static behaviour
//routesGenerator := StaticRoutesGenerator