FROM eclipse-temurin:21-jdk

WORKDIR /app

# Copy the entire project and build it inside the container
COPY . .

RUN ./mvnw clean package -DskipTests

# Use the generated jar file
COPY target/weather-App-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
