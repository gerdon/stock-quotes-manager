FROM openjdk:11-oracle

RUN mkdir app

ARG JAR_FILE

ADD /target/${JAR_FILE} /app/stock-quotes-manager.jar

WORKDIR /app

ENTRYPOINT java -jar stock-quotes-manager.jar

EXPOSE 8081