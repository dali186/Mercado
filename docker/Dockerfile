FROM openjdk:21
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /Mercado.jar
ENTRYPOINT ["java", "-jar", "/Mercado.jar"]