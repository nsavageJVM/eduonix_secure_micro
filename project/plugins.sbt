resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

dependencyOverrides += "org.scala-sbt" % "sbt" % "0.13.0"


// The Play plugin
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.2.1")

// web plugins

addSbtPlugin("com.typesafe.sbt" % "sbt-coffeescript" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-less" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-jshint" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-rjs" % "1.0.1")

addSbtPlugin("com.typesafe.sbt" % "sbt-digest" % "1.0.0")

addSbtPlugin("com.typesafe.sbt" % "sbt-mocha" % "1.0.0")


addSbtPlugin("org.scala-sbt.plugins" % "sbt-onejar" % "0.8")