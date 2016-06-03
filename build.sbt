name := "CodeKata"

version := "1.0"

scalaVersion := "2.11.8"

lazy val versions = new {
    val scalaTest = "2.2.6"
}

libraryDependencies += "org.scalatest" %% "scalatest" % versions.scalaTest % "test"