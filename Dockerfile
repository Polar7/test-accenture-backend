# Utiliza una imagen base de Gradle para compilar la aplicación
FROM gradle:8.10.2-jdk21 AS builder

# Copia los archivos de compilación necesarios al contenedor
COPY build.gradle .
COPY src ./src

# Compila la aplicación y genera el archivo JAR
RUN gradle build -x test

# Utiliza una imagen base de OpenJDK para ejecutar la aplicación
FROM eclipse-temurin:21-jdk-alpine

# Directorio de trabajo en el contenedor
WORKDIR /app

# Copia el archivo JAR generado en el paso anterior al contenedor
COPY --from=builder /home/gradle/build/libs/app-test-accenture.jar .

# Expone el puerto en el que la aplicación está escuchando
EXPOSE 9090

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "app-test-accenture.jar", "--spring.profiles.active=prod"]
