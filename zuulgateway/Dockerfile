FROM openjdk:8
VOLUME /tmp
EXPOSE 8090
ADD ./target/zuulgateway-0.0.1-SNAPSHOT.jar zuulgateway.jar
ENTRYPOINT ["java" , "-jar", "/zuulgateway.jar"]