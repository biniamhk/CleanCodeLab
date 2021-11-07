FROM openjdk:16
ADD target/CleanCodeLia1-1.0-SNAPSHOT.jar CleanCodeLia1-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar","CleanCodeLia1-1.0-SNAPSHOT.jar"]