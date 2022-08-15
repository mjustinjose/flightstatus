#base image
FROM openjdk:11
LABEL maintainer ="Eurowings Digital"
ADD /target/flight.status-0.0.1-SNAPSHOT.jar ewd-flightstatus.jar
ENTRYPOINT ["java","-jar","ewd-flightstatus.jar"]