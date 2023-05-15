# Pobieranie obrazu JDK 11 w wersji slim
FROM adoptopenjdk/openjdk11:alpine-slim

# Instalacja niezbędnych narzędzi systemowych
RUN apk update && apk upgrade && apk add --no-cache bash curl

# Utworzenie folderu app
RUN mkdir /opt/render/project/src/app

# Kopiowanie plików projektu do folderu app
COPY . /opt/render/project/src/app

# Ustawienie folderu roboczego
WORKDIR /opt/render/project/src/app

# Budowanie aplikacji z wykorzystaniem Maven
RUN ./mvnw package -DskipTests

# Port, na którym działa aplikacja
EXPOSE 8080

# Uruchomienie aplikacji
CMD ["java", "-jar", "/opt/render/project/src/app/out/artifacts/Apka_web_jar/Apka_web.jar"]
