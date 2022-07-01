FROM openjdk:17-alpine3.14

MAINTAINER Dion "dion.smakolli@bbzbl-it.ch"

EXPOSE 7070

WORKDIR /usr/local/bin

COPY ./target/crm-web-0.0.1-SNAPSHOT.jar crm-web.jar

CMD ["java", "-jar", "crm-web.jar"]