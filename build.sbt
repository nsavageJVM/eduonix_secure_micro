name := "ServerPhaseOne"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.3"

oneJarSettings

libraryDependencies ++= Seq(
  "org.pac4j" % "play-pac4j_java" % "1.4.1-SNAPSHOT",
  "org.pac4j" % "pac4j-http" % "1.7.2-SNAPSHOT",
  "org.pac4j" % "pac4j-openid" % "1.7.2-SNAPSHOT",
  "org.pac4j" % "pac4j-oauth" % "1.7.2-SNAPSHOT",
  "org.pac4j" % "pac4j-oidc" % "1.7.2-SNAPSHOT",
  "com.typesafe.play" % "play-cache_2.10" % "2.2.1"
)

resolvers ++= Seq(
    "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository",
    "Sonatype snapshots repository" at "https://oss.sonatype.org/content/repositories/snapshots/",
    "Pablo repo" at "https://raw.github.com/fernandezpablo85/scribe-java/mvn-repo/"
)

play.Project.playJavaSettings

mainClass in (Compile, run) := Some("EntryPoint")