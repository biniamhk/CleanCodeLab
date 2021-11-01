FROM maven:latest
ENV APP_HOME=/app/
COPY CleanCodeLia1/pom.xml $APP_HOME
COPY CleanCodeLia1/src $APP_HOME/src/
WORKDIR $APP_HOME
RUN mvn package
ENV JAR_FILE=target/CleanCodeLia1-1.0-SNAPSHOT.jar
RUN mv ${JAR_FILE} /CleanCodeLia1-1.0-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "CleanCodeLia1-1.0-SNAPSHOT.jar"]