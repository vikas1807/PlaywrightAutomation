# ==========================================
# Stage 1: Build and compile the application
# ==========================================
FROM maven:3.9.6-eclipse-temurin-21-alpine AS builder

# Set the inside working directory
WORKDIR /app

# Optimization: Copy only pom.xml to cache dependencies
COPY pom.xml .

# Fetch all dependencies. If pom.xml doesn't change, this layer is cached
RUN mvn dependency:go-offline -B

# Copy the actual source code
COPY src ./src

# Pack the application without running tests for faster builds
RUN mvn clean package -DskipTests

# ==========================================
# Stage 2: Runtime environment for execution
# ==========================================
FROM eclipse-temurin:21-jre-alpine

WORKDIR /app

# Copy the compiled JAR file from the builder stage
# Note: Adjust 'my-app-1.0.0.jar' to match your actual generated JAR name
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port (typically 8080 for Spring Boot)
EXPOSE 8081

# Run the thin JAR application
ENTRYPOINT ["java", "-jar", "app.jar"]
