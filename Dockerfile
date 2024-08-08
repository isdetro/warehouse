#FROM maven:3.9.5 AS BUILD
#
#COPY pom.xml ./
#
#RUN mvn dependency:resolve
#
#COPY src src
#RUN mvn package -DskipTests
#
#FROM amazoncorretto:19
#WORKDIR app
#COPY --from=BUILD target/*.jar app.jar
#ENTRYPOINT ["java","-jar","app.jar"]

# Stage 1: Build the application
FROM gradle:8.2.1 AS BUILD

COPY build.gradle settings.gradle ./
RUN gradle build --no-daemon || return 0

COPY src src
RUN gradle build -x test --no-daemon

# Stage 2: Create the runtime image
FROM amazoncorretto:19
WORKDIR app
COPY --from=BUILD /home/gradle/build/libs/*.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]

