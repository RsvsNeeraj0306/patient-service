FROM maven:3.8-openjdk-17 AS builder

WORKDIR /app

COPY patient-service/pom.xml ./

RUN mvn dependency:go-offline -B

COPY patient-service/src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jre AS runner

WORKDIR /app

COPY --from=builder /app/target/patient-service-0.0.1-SNAPSHOT.jar ./app.jar

EXPOSE 4000

ENTRYPOINT ["java", "-jar", "app.jar"]