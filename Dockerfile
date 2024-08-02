FROM --platform=linux/amd64 openjdk:8
VOLUME /tmp
COPY target/resume-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]