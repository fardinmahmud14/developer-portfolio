# Build the application with Maven and Java 21.
FROM maven:3.9-eclipse-temurin-21 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -B -DskipTests package

# Run the packaged Spring Boot application on a smaller Java 21 image.
FROM eclipse-temurin:21-jre
WORKDIR /app
COPY --from=build /app/target/developer-portfolio-0.0.1-SNAPSHOT.jar app.jar
ENV PORT=8080
EXPOSE 8080
ENTRYPOINT ["sh", "-c", "java -Dserver.port=${PORT:-8080} -Dserver.address=0.0.0.0 -jar app.jar"]
