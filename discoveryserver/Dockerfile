FROM openjdk:8
VOLUME /tmp
EXPOSE 8761
ADD ./target/discoveryserver-0.0.1-SNAPSHOT.jar discoveryserver.jar
ENTRYPOINT ["java" , "-jar", "/discoveryserver.jar"]