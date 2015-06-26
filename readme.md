      sbt clean compile
      sbt one-jar
      java -jar   target/scala-2.10/serverphaseone_2.10-1.0-SNAPSHOT-one-jar.jar
      http://localhost:9000/