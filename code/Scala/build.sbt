lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.7",
      version      := "0.1.0-SNAPSHOT"
    )),
    name := "DevFest2018",

    libraryDependencies += "org.scalatest" % "scalatest_2.12" % "3.0.5" % "test",

    scalacOptions in Test ++= Seq("-Yrangepos")
  )
