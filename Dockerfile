# Use openjdk
FROM eclipse-temurin:22-jdk-alpine

# Create a non-root user and group
RUN addgroup -S spring && adduser -S spring -G spring

# Set the working directory
WORKDIR /app

# Change the ownership of the app directory to the non-root user
RUN chown -R spring:spring /app

# Copy the application JAR file to the container
ADD target/api-admin-visivalid.jar /app/api-admin-visivalid.jar

# Change the ownership of the JAR file to the non-root user
RUN chown spring:spring /app/api-admin-visivalid.jar

# Switch to the non-root user
USER spring

# Expose Port 8080
EXPOSE 8080

# Entrypoint app
ENTRYPOINT ["java", "-jar", "/app/api-admin-visivalid.jar"]