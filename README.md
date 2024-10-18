# Parameta Employee Management System

This project is a microservices-based employee management system built using Spring Boot, Eureka for service discovery, and Spring Cloud Gateway for API routing. It includes the following services:

- **API Gateway**: Acts as a gateway for routing requests to microservices.
- **Eureka Server**: Service discovery for registering and locating services.
- **Employee Client**: Front-end service that communicates with the Employee Server.
- **Employee Server**: Back-end service responsible for managing employee data stored in MySQL.

## Project Structure

```plaintext
parameta/
│
├── docker-compose.yml         # Configuration to run all services in Docker containers
├── api-gateway/               # API Gateway microservice
├── eureka-server/             # Eureka Service Discovery Server
├── employeeClient/            # Employee Client Service
└── employee-server/           # Employee Server Service
```
## API Gateway

The API Gateway routes requests to the appropriate services based on URL patterns. It is configured in the application.yml file.

    Port: 8089
    Routes:
        /employees/** -> employee-client

## Eureka Server

The Eureka server is responsible for service discovery. All microservices register with the Eureka server so they can discover each other.

    Port: 8888

## Employee Client

This service acts as a client that interacts with the employee-server to retrieve or send employee data.

    Port: 8080
    Endpoints:
        /employees: Interacts with the employee-server to manage employee data.

## Employee Server

This service manages the employee data stored in a MySQL database.

    Port: 9000
    Database: MySQL
        DB Name: employee-server
        User: employee-server-user
        Password: secret_password

 ## Prerequisites

    Docker
    Docker Compose

## Running the Project

  Clone the repository:


    git clone https://github.com/Coaxus-ux/parameta.git
    cd parameta

Start the services using Docker Compose:

    docker-compose up --build

    Access the services:
        API Gateway: http://localhost:8089
        Eureka Server: http://localhost:8888
        Employee Client: http://localhost:8080
        Employee Server: http://localhost:9000

## To add a employee

      <Employee>
          <name>John</name>
          <lastName>Doe</lastName>
          <citizenshipType>Passport</citizenshipType>
          <citizenshipId>123456789</citizenshipId>
          <birthDate>1980-01-15T00:00:00</birthDate>
          <hireDate>2020-06-01T00:00:00</hireDate>
          <job>Software Engineer</job>
          <salary>50000</salary>
      </Employee>
        
## Technologies Used

    Java 17 (Corretto)
    Spring Boot
    Spring Cloud Gateway
    Eureka Server
    MySQL
    Docker & Docker Compose

License

This project is licensed under the MIT License - see the LICENSE file for details.

vbnet


This `README.md` provides a clear overview of the project's purpose, structure, and setup instructions. Let me know if you'd like to make any adjustments.

