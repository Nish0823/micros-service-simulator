FROM openjdk:11
EXPOSE 8090
ADD target/service-a.jar service-a.jar
ENTRYPOINT ["java","-jar","/service-a.jar"]