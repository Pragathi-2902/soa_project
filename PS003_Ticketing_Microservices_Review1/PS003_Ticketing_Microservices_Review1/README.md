# PS003 - High-Concurrency Entertainment Ticketing & Seat Allocation Engine (Unique Project Names)
## Review-1 Ready Spring Boot Microservices Starter

This project is prepared for Review-1 with:

- Eureka Service Discovery
- API Gateway
- User/Auth Service
- JWT token generation
- JWT validation at API Gateway
- Movie Service
- Show Service
- Booking Service
- Basic REST APIs
- Eureka-based load-balanced routing

## Technology

- Java 17
- Spring Boot 3.4.5
- Spring Cloud 2024.0.2
- Spring Cloud Gateway
- Netflix Eureka
- Spring Security
- JWT (JJWT)
- Maven

## Projects and ports

| Project | Port |
|---|---:|
| ticket-eureka-server | 8761 |
| ticket-api-gateway | 8080 |
| ticket-user-service | 8081 |
| ticket-movie-service | 8082 |
| ticket-show-service | 8083 |
| ticket-booking-service | 8084 |

## Import into Eclipse / STS

1. Extract this ZIP.
2. Open Eclipse/STS.
3. Go to `File -> Import`.
4. Select `Maven -> Existing Maven Projects`.
5. Select the extracted `PS003_Ticketing_Microservices_Review1` folder.
6. Eclipse should detect all 6 Maven projects.
7. Click Finish.
8. If dependencies are not downloaded immediately, right-click each project:
   `Maven -> Update Project`.

Use Java 17.

## Run order

Start these applications in this order:

1. EurekaServerApplication
2. UserServiceApplication
3. MovieServiceApplication
4. ShowServiceApplication
5. BookingServiceApplication
6. ApiGatewayApplication

Open:
http://localhost:8761

You should see the registered services.

## Review-1 Postman test

### 1. Register

POST
http://localhost:8080/auth/register

Body -> raw -> JSON:

{
  "username": "neha",
  "password": "1234"
}

### 2. Login and receive JWT

POST
http://localhost:8080/auth/login

Body:

{
  "username": "neha",
  "password": "1234"
}

Expected response contains:

{
  "username": "neha",
  "token": "..."
}

Copy the token.

### 3. Test protected Movie API

GET
http://localhost:8080/movies

Authorization:
Bearer Token

Paste the JWT.

Expected:
Movie Service: Inception, Interstellar, Avengers

### 4. Test Show API

GET
http://localhost:8080/shows

Authorization:
Bearer Token

### 5. Test Booking API

POST
http://localhost:8080/bookings

Authorization:
Bearer Token

Body:

{
  "username": "neha",
  "movie": "Inception",
  "show": "6:00 PM",
  "seat": "A10"
}

### 6. Prove JWT protection

Call:

GET
http://localhost:8080/movies

WITHOUT the Authorization header.

Expected:
401 Unauthorized

This demonstrates that API Gateway blocks protected APIs without a valid JWT.

## Important Review-1 explanation

Client
  -> API Gateway
  -> JWT validation
  -> Eureka service discovery
  -> Movie / Show / Booking Service

The `/auth/**` endpoints are public because the user must login before obtaining a JWT.

The `/movies/**`, `/shows/**`, and `/bookings/**` endpoints require a valid JWT.

## Demo login

Username: neha
Password: 1234

This is intentionally an in-memory demo for Review-1. It is not a production authentication database.

## What is intentionally left for Review-2

The project does NOT yet implement the full high-concurrency seat allocation engine.

For Review-2 you can add:

- MySQL/PostgreSQL
- Movie and show database tables
- Screen and seat tables
- Real booking table
- Seat availability
- Atomic seat locking
- Transaction management
- Concurrent booking tests
- Prevention of double booking
- Frontend
- Optional Redis/Kafka if required by your course

The current project gives you a clean Review-1 foundation.
