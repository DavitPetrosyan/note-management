FROM openjdk:8
MAINTAINER davit.petrosyan.1990@gmail.com
EXPOSE 8888
VOLUME /tmp
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
