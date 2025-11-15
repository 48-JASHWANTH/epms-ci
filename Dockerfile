# Stage 1: build the JAR using Maven + JDK 21
FROM maven:3.9.4-eclipse-temurin-21-alpine AS build
WORKDIR /app

# copy pom and source
COPY pom.xml .
COPY src ./src

# download dependencies (uses cache)
RUN mvn dependency:copy-dependencies

# package the app (skip tests to speed up in CI)
RUN mvn -X package -DskipTests

# Stage 2: runtime image with JRE only
FROM eclipse-temurin:21-alpine
WORKDIR /app

# copy the built jar from the build stage
COPY --from=build /app/target/*.jar employeeprofilemanagement.jar

# document intended port
EXPOSE 8200

# command to run the app
ENTRYPOINT ["java", "-jar", "employeeprofilemanagement.jar"]
