# First stage: Build the application using Gradle
FROM gradle:8.1.1-jdk17 AS build

# Set the working directory for the Gradle build
WORKDIR /opt/app

# Copy only the necessary files to reduce the size of the build context
COPY --chown=gradle:gradle . .

# Build the application and create the JAR file
RUN gradle build --no-daemon

# Second stage: Create a smaller image for running the application
FROM eclipse-temurin:17-jdk

# Set the working directory for the application
WORKDIR /opt/app

# Copy the JAR file from the build stage
COPY --from=build /opt/app/build/libs/Crowdfund-0.0.1-SNAPSHOT.jar ./

# Set the entry point to run the application
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar Crowdfund-0.0.1-SNAPSHOT.jar"]
