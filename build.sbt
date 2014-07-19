name := "moro"

organization := "ml.wolfe"

organizationHomepage := Some(url("http://www.wolfe.ml/"))

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.3"

licenses := Seq("The Apache Software License, Version 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.txt"))

homepage := Some(url("http://wolfe-pack.github.io/moro"))

resolvers ++= Seq(
  "IESL Release" at "https://dev-iesl.cs.umass.edu/nexus/content/groups/public",
  "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository",
  Resolver.sonatypeRepo("snapshots"),
  Resolver.sonatypeRepo("releases")
)

// disable using the Scala version in output paths and artifacts
crossPaths := false

pomExtra := (
  <scm>
    <url>https://github.com/wolfe-pack/moro</url>
    <connection>scm:git:git://github.com/wolfe-pack/moro.git</connection>
    <developerConnection>scm:git:git@github.com:wolfe-pack/moro.git</developerConnection>
    <tag>HEAD</tag>
  </scm>
  <developers>
    <developer>
      <name>Sameer Singh</name>
      <email>sameeersingh@gmail.com</email>
      <organization>University of Washington</organization>
      <organizationUrl>http://www.sameersingh.org</organizationUrl>
    </developer>
  </developers>
  )

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

publishMavenStyle := true

publishTo := {
  val nexus = "https://dev-iesl.cs.umass.edu/nexus/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "content/repositories/releases")
}

publishArtifact in Test := false

libraryDependencies ++= Seq(
  "net.sf.trove4j" % "trove4j" % "3.0.3",
  "org.scalautils" % "scalautils_2.10" % "2.0",
  "org.scalatest" %% "scalatest" % "2.0" % "test",
  "com.nativelibs4java" %% "scalaxy-loops" % "0.3-SNAPSHOT" % "provided",
  "com.fasterxml.jackson.module" % "jackson-module-scala_2.10" % "2.2.3",
  "com.fasterxml.jackson.core" % "jackson-databind" % "2.2.2",
  "eu.henkelmann" % "actuarius_2.10.0" % "0.2.6",
  "org.scala-lang" % "scala-compiler" % "2.10.3",
  "ml.wolfe" %% "wolfe-core" % "0.1.0-SNAPSHOT",
  "org.sameersingh.htmlgen" % "htmlgen" % "0.1",
  "org.sameersingh.scalaplot" % "scalaplot" % "0.0.3",
  "ml.wolfe" %% "wolfe-examples" % "0.1.0-SNAPSHOT",
  "org.scala-lang" % "scala-library" % "2.10.3"
)

play.Project.playScalaSettings
