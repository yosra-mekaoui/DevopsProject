FROM maven:3.8.2-jdk-11

WORKDIR /spring-app
COPY . .
RUN mvn clean install -Dmaven.test.skip

CMD mvn spring-boot:run

