FROM gradle:8.1.1-jdk17

WORKDIR /opt/app

COPY ./build/libs/Crowdfund-0.0.1-SNAPSHOT.jar ./

#CHECK
ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar Crowdfund-0.0.1-SNAPSHOT.jar"]