FROM openjdk:21
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} /Mercado.jar
RUN mkdir -p /var/log
ENTRYPOINT ["java", "-jar", "/Mercado.jar"]