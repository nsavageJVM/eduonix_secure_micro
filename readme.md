      sbt clean compile
      sbt one-jar
      java -jar   target/scala-2.11/serverphaseone_2.11-1.0-SNAPSHOT-one-jar.jar
      http://localhost:9000/