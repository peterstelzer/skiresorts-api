##########################################333
##  Build stage
##########################################
FROM eclipse-temurin:16-jdk AS builder
WORKDIR /workspace/app
RUN mkdir -p src/main/java
COPY build.gradle .
COPY gradle gradle
COPY gradlew .
COPY ./src/main/java/net/bipper/website/SkiResortsApplication.java src/main/java/net/bipper/website/SkiResortsApplication.java

#download dependencies first to speed up later builds
#This step should only need to re-run when the build file dependencies change
RUN ["chmod", "+x", "gradlew"]
USER root
RUN export GRADLE_OPTS="-Djdk.lang.Process.launchMechanism=vfork" && ./gradlew build -x test --continue

#Copy source
COPY lombok.config .
COPY src src

#build the war
WORKDIR /workspace/app
RUN export GRADLE_OPTS="-Djdk.lang.Process.launchMechanism=vfork" &&  ./gradlew  bootJar

##########################################333
##  Deployable container stage
##########################################333
FROM eclipse-temurin:16-jdk

#update OS
RUN apt-get update && apt-get upgrade -y

# set time zone
ARG DEBIAN_FRONTEND=noninteractive
ENV TZ=AmericalLosAngeles
RUN apt-get install -y tzdata

RUN addgroup spring
RUN adduser spring --ingroup spring
USER spring:spring
COPY --from=builder /workspace/app/build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]