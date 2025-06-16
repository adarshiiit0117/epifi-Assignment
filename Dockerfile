FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

# ✅ Copy the existing JAR from target folder
COPY target/app.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
