FROM openjdk:17-oracle
ADD target/miniproject-0.0.1-SNAPSHOT.jar docker-miniproject-0.0.1-SNAPSHOT.jar
EXPOSE 11111
ENTRYPOINT ["java","-jar","/docker-miniproject-0.0.1-SNAPSHOT.jar"]