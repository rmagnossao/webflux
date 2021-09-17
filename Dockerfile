#syntaxe=docker/dockerfile:1
FROM openjdk
LABEL mainteiner="Rodrigo Magnossao"
VOLUME /main-app
ADD build/libs/webflux-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]