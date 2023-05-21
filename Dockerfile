FROM adoptopenjdk/openjdk11:alpine-slim

RUN apk update && apk upgrade && apk add --no-cache bash curl

RUN mkdir /app

COPY . /app

WORKDIR /app

RUN chmod +x mvnw

RUN ./mvnw package -DskipTests

EXPOSE 443

CMD ["java", "-jar", "/app/out/artifacts/Apka_web_jar/Apka_web.jar"]