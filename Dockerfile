# Stage 1: Build
FROM eclipse-temurin:17-jdk AS build
WORKDIR /app
COPY .mvn/ .mvn/
COPY mvnw mvnw
COPY pom.xml .
COPY thymeleaf-querystring-1.0-SNAPSHOT.jar .
RUN chmod +x mvnw
# Download dependencies first (layer caching)
RUN ./mvnw dependency:go-offline -B || true
COPY src/ src/
RUN ./mvnw clean package -DskipTests -B

# Stage 2: Run
FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/target/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
