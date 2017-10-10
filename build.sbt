lazy val commonSettings = Seq[Setting[_]](
    name := "hotel-reservation",
    version := "1.0.0",
    organization := "com.logdown.mycodetub",
    scalaVersion := "2.12.3",
    scalacOptions ++= Seq(
        "-target:jvm-1.8",
        "-encoding", "UTF-8",
        "unchecked",
        "-Xlint")
)

lazy val versions = new {
    val scalatest = "3.0.4"
    val hamsters = "1.5.1"
}

lazy val libDependencies = Seq(
    "io.github.scala-hamsters" % "hamsters_2.12" % versions.hamsters,
    "org.scalatest" % "scalatest_2.12" % versions.scalatest % "test"
)

lazy val root = Project(id = "hotel-reservation", file("."))
    .settings(commonSettings)
    .settings(libraryDependencies ++= libDependencies)