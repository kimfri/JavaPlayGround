#FROM openjdk:11
#COPY target/classes/ /tmp
#WORKDIR /tmp
#CMD java org.kimfri.docker.Main

FROM maven:3.5.3-jdk-8-alpine
COPY ./. /

