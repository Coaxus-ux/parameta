# parameta
# Employee Client & Server Application

Este proyecto es una aplicación distribuida compuesta por dos módulos principales: `employee-client` y `employee-server`. La aplicación gestiona empleados utilizando Spring Boot y Eureka para el descubrimiento de servicios.

## Requisitos

- **Java 17** (Corretto)
- **Gradle 8.10.2**
- **Spring Boot**
- **Eureka Discovery Server**

## Configuración

En el archivo `application.properties` de `employee-client`, encontrarás configuraciones clave para la aplicación:

- **Nombre de la aplicación**: `spring.application.name=employee-client`
- **Puerto del servidor**: `server.port=8080`
- **Servicio Eureka**: `eureka.client.serviceUrl.defaultZone=http://localhost:8888/eureka/`
- **Ruta del endpoint del empleado**: `employee.endpoint.path=/employee`

En el caso del `employee-server`, se pueden configurar similares parámetros, adaptados al servicio específico del servidor.

