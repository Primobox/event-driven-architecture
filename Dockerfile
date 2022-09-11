FROM maven:3.8.6-eclipse-temurin-17-alpine as build

ADD . /app
WORKDIR /app
RUN mvn package -DskipTests
RUN java -Djarmode=layertools -jar ./target/event-driven-architecture-0.0.1-SNAPSHOT.jar extract

FROM arm32v7/eclipse-temurin:17-jre as release

# Add Tini
ENV TINI_VERSION v0.19.0
ADD https://github.com/krallin/tini/releases/download/${TINI_VERSION}/tini-armhf /tini
RUN chmod +x /tini
ENTRYPOINT ["/tini", "--"]

WORKDIR /app
COPY --from=build /app/dependencies/ ./
COPY --from=build /app/snapshot-dependencies/ ./
#Keep this to avoid issue decribed here https://github.com/moby/moby/issues/37965
RUN true
COPY --from=build /app/spring-boot-loader/ ./
COPY --from=build /app/application/ ./
#COPY newrelic.jar /app/newrelic.jar
#COPY newrelic.yml /app/newrelic.yml

CMD java -XshowSettings:vm org.springframework.boot.loader.JarLauncher

