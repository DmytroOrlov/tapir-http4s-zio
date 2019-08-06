lazy val Versions = new {
  val zio = "1.0.0-RC11-1"
  val zioCats = "2.0.0.0-RC2"
  val cats = "2.0.0-RC1"
  val catsEffect = "2.0.0-M5"
  val http4s = "0.21.0-M3"
  val circe = "0.12.0-M4"
  val tapir = "0.9.1"
  val logback = "1.2.3"
}

lazy val `tapir-http4s-zio` = (project in file("."))
  .enablePlugins(DockerPlugin, JavaServerAppPackaging)
  .settings(
    inThisBuild(Seq(
      scalaVersion := "2.13.0",
      version := "0.1.0-SNAPSHOT",
      organization := "io.github.DmytroOrlov"
    )),
    addCompilerPlugin("org.typelevel" %% "kind-projector" % "0.10.3"),
    addCompilerPlugin("com.olegpy" %% "better-monadic-for" % "0.3.1"),
    scalacOptions ++= List("-language:higherKinds", "-feature"),
    libraryDependencies ++= Seq(
      "io.circe" %% "circe-core",
      "io.circe" %% "circe-generic",
      "io.circe" %% "circe-parser"
    ).map(_ % Versions.circe) ++ Seq(
      "dev.zio" %% "zio" % Versions.zio,
      "dev.zio" %% "zio-interop-cats" % Versions.zioCats,
      "org.http4s" %% "http4s-dsl" % Versions.http4s,
      "org.http4s" %% "http4s-blaze-server" % Versions.http4s,
      "com.softwaremill.tapir" %% "tapir-http4s-server" % Versions.tapir,
      "com.softwaremill.tapir" %% "tapir-openapi-circe-yaml" % Versions.tapir,
      "com.softwaremill.tapir" %% "tapir-openapi-docs" % Versions.tapir,
      "com.softwaremill.tapir" %% "tapir-json-circe" % Versions.tapir,
      "com.softwaremill.tapir" %% "tapir-swagger-ui-http4s" % Versions.tapir,
      "org.typelevel" %% "cats-core" % Versions.cats,
      "org.typelevel" %% "cats-effect" % Versions.catsEffect,

      "ch.qos.logback" % "logback-classic" % Versions.logback,

      "org.scalatest" %% "scalatest" % "3.0.8" % Test,
    )
  )
