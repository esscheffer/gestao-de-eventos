FROM gradle:8.14.3-jdk17-alpine AS build

COPY src /app/src
COPY build.gradle /app/build.gradle
COPY settings.gradle /app/settings.gradle
COPY gradlew /app/gradlew
COPY gradle /app/gradle

WORKDIR /app

RUN ./gradlew build

FROM amazoncorretto:21-alpine3.21

COPY --from=build /app/build/libs/gestaoeventos-0.0.1-SNAPSHOT.jar /app/app.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]