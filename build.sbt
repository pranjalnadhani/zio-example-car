name := "Car"

version := "0.1"

scalaVersion := "2.13.4"

scalafixDependencies += "com.github.liancheng" %% "organize-imports" % "0.4.4"

libraryDependencies ++= Seq(
  "dev.zio" %% "zio" % "1.0.3"
)

addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.11.1" cross CrossVersion.full)

onChangedBuildSource := ReloadOnSourceChanges