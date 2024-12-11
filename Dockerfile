# Use Gradle image to build and run the application in the same stage
FROM gradle:8.1.1-jdk17

# Set the working directory
WORKDIR /opt/app

# Copy the entire project into the container
COPY --chown=gradle:gradle . .

# Build the application and create the JAR file
RUN gradle build --no-daemon

# Set the entry point to run the application
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar build/libs/Crowdfund-0.0.1-SNAPSHOT.jar"]

# I added this so that it uses the file application-docker.properties instead of the local setup
ENV PROFILE=docker

ENV JWT_SECRET=$JWT_SECRET
ENV DB_USERNAME=$DB_USERNAME
ENV DB_PASSWORD=$DB_PASSWORD
