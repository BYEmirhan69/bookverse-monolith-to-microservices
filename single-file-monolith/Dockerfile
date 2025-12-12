# Build asamasi icin Gradle ve Java iceren bir imaj kullan
FROM gradle:8.14-jdk17 AS build
WORKDIR /app
COPY . .
RUN gradle clean build -x test --no-daemon

# Run asamasi icin sadece JRE iceren daha kucuk bir imaj kullan
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
