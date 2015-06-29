name := "ServerPhaseTwo"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.11.1"


libraryDependencies ++= Seq(
  "com.typesafe.play" % "play-cache_2.11" % "2.3.0",
  "net.minidev" % "json-smart" % "2.1.1",
  "javax.mail" % "mail" % "1.4.7",
  "com.nimbusds" % "lang-tag" % "1.4",
  "com.nimbusds" % "nimbus-jose-jwt" % "3.10",
  "com.nimbusds" % "oauth2-oidc-sdk" % "4.13"
)

resolvers ++= Seq(
    "Local Maven Repository" at "file://"+Path.userHome.absolutePath+"/.m2/repository",
    "Sonatype snapshots repository" at "https://oss.sonatype.org/content/repositories/snapshots/",
    "Pablo repo" at "https://raw.github.com/fernandezpablo85/scribe-java/mvn-repo/",
    "Maven central" at "http://repo1.maven.org/maven2/"
)



