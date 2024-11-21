# Usa una imagen de Java para correr la aplicación
FROM openjdk:17-jdk-alpine

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el archivo JAR de tu aplicación al contenedor
COPY target/veterinaria.jar app.jar

# Expone el puerto en el que corre tu aplicación Spring Boot (por defecto, 8080)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "app.jar"]
