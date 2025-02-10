#Stage 1: build and package
FROM maven:3.9.9-eclipse-temurin-21-alpine AS build
LABEL author="bwilton"
WORKDIR /docsapp
COPY . .
RUN mvn package

#Stage 2: Production
FROM eclipse-temurin:21-jre-alpine
LABEL author="bwilton"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/docsapp/docsapp.jar"]
WORKDIR /docsapp
VOLUME /docsapp/h2
COPY --from=build /docsapp/target/docsapp-0.0.1-SNAPSHOT.jar /docsapp/docsapp.jar