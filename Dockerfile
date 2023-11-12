FROM openjdk:11-jre-slim
EXPOSE 8089
WORKDIR /app

RUN apt-get update && apt-get install -y curl

RUN curl -o devopsproject-2.1.jar -L "http://192.168.117.135:8081/repository/maven-releases/tn/esprit/DevOps_Project/2.1/devopsproject-2.1.jar"


ENTRYPOINT ["java", "-jar", "devopsproject-2.1.jar"]