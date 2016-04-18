name := """myproject"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  javaJdbc,
  cache,
  javaWs
)

// add custom repo 
// resolvers += Resolver.url("In-house Repository stable", url("https://mycompany.com/repo"))(Resolver.ivyStylePatterns)
// resolvers += Resolver.sonatypeRepo("snapshots")