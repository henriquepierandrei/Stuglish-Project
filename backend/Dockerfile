# Use imagem base com Java 21
FROM eclipse-temurin:21-jdk-alpine

# Define o diretório de trabalho
WORKDIR /app

# Copia o JAR compilado para dentro da imagem
COPY target/Stuglish-0.0.1-SNAPSHOT.jar /app/app.jar

# Executa o JAR
CMD ["java", "-jar", "/app/app.jar"]
