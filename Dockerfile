FROM adoptopenjdk/openjdk11:alpine
WORKDIR /app
COPY build/libs/spring-elastic-genie-0.0.1.jar ./spring-elastic-genie-0.0.1.jar
COPY entrypoint.sh ./entrypoint.sh
