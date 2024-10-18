# Usa una imagen base de Java 17
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR generado
COPY target/employee-server-0.0.1-SNAPSHOT.jar employee-server.jar

# Expone el puerto 8080
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "employee-server.jar"]
