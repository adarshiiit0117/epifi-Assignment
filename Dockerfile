# Use Java 17 base image
FROM eclipse-temurin:21-jdk-jammy

# Set working directory inside the container
WORKDIR /app

# Copy the built jar into the image
COPY target/app.jar app.jar

# Expose the default Spring Boot port
EXPOSE 8080

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "app.jar"]
