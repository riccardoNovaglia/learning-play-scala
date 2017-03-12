name := """play-scala"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1" % Test
)

// some issue with Selenium/Play/IntelliJ. Needed to run Integration Spec
libraryDependencies += "org.apache.httpcomponents" % "httpcore" % "4.4.4"
libraryDependencies += "org.apache.httpcomponents" % "httpclient" % "4.5.2"

libraryDependencies += "io.rest-assured" % "scala-support" % "3.0.2"


fork in run := true
