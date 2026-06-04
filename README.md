# 🛒 E-Commerce Platform 🛍

https://github.com/user-attachments/assets/424d3aa0-1b27-4a42-983c-10bba1e735b6

> 🎥 User Service Demonstration!

---

## Table of Contents
- [Introduction](#introduction)
- [Project Structure](#project-structure)
- [Tech Stack](#tech-stack)
- [Product Requirements Document (PRD)](#product-requirements-document-prd)
  - [Functional Requirements](#functional-requirements)
    - [User Management](#1%EF%B8%8F⃣-user-management)
    - [Product Catalog](#2%EF%B8%8F⃣-product-catalog)
    - [Cart & Checkout](#3%EF%B8%8F⃣-cart--checkout)
    - [Order Management](#4%EF%B8%8F⃣-order-management)
    - [Payment](#5%EF%B8%8F⃣-payment)
    - [Authentication](#6%EF%B8%8F⃣-authentication)
  - [High-Level Design (HLD)](#high-level-design-hld)
    - [Architecture Components](#architecture-components)
      - [Load Balancers (LB)](#architecture-components)
      - [API Gateway](#architecture-components)
      - [Microservices Architecture](#architecture-components)
      - [Databases](#architecture-components)
      - [Message Broker (Kafka)](#architecture-components)
      - [Caching (Redis)](#architecture-components)
      - [Search & Analytics (Elasticsearch)](#architecture-components)      
  - [Typical Flow](#typical-flow)
    - [Part 1: Product Search](#part-1-product-search)
    - [Part 2: Add to Cart](#part-2-add-to-cart)
    - [Part 3: Checkout](#part-3-checkout)
- [Resources](#resources)
- [Contributing](#contributing)
- [License](#license)
- [Author](#author)

---

## Introduction

A scalable and modular e-commerce platform built using a microservices architecture. The system is designed to handle core e-commerce functionalities such as product management, cart operations, order processing, payment integration, and user management through independently deployable backend services.

The project demonstrates real-world backend engineering concepts including RESTful APIs, database design, asynchronous communication, scalability, service abstraction, caching, payment gateway integration, and microservices-based system design using Spring Boot and related technologies.

---

## Project Structure

**

---

## Tech Stack

| Technology                     | Purpose                              |
| ------------------------------ | ------------------------------------ |
| Java 21                        | Programming Language                 |
| Spring Boot 3.4.6              | Backend Framework                    |
| Spring Web                     | REST API Development                 |
| Spring Data JPA                | ORM & Database Access                |
| MySQL                          | Relational Database                  |
| Spring Security                | Authentication & Authorization       |
| OAuth 2.1 Authorization Server | Token-Based Security & Authorization |
| Apache Commons Lang            | Utility Library                      |
| Lombok                         | Boilerplate Code Reduction           |
| Maven                          | Dependency Management & Build Tool   |
| JUnit 5                        | Unit & Integration Testing           |
| IntelliJ IDEA                  | Development Environment              |


---

## Product Requirements Document (PRD)

### Functional Requirements

### 1️⃣ User Management
- **Registration**: Allow users to register via email or social media profiles.
- **Login**: Secure user login with credentials.
- **Profile Management**: Enable users to view and edit their profiles.
- **Password Reset**: Allow password resets through secure email links.

### 2️⃣ Product Catalog
- **Browsing**: Users can browse products by category.
- **Product Details**: Product pages include images, descriptions, specifications, and more.
- **Search**: Provide search functionality with keyword-based queries.

### 3️⃣ Cart & Checkout
- **Add to Cart**: Users can add products to their cart.
- **Cart Review**: View selected items with price, quantity, and totals.
- **Checkout**: Seamless process to finalize purchases, including delivery details and payment options.

### 4️⃣ Order Management
- **Order Confirmation**: Confirm orders with details after purchase.
- **Order History**: Allow users to view past orders.
- **Order Tracking**: Provide delivery status tracking.

### 5️⃣ Payment
- **Multiple Payment Options**: Support credit/debit cards, online banking, and other methods.
- **Secure Transactions**: Ensure secure payment handling.
- **Payment Receipt**: Generate receipts for successful payments.

### 6️⃣ Authentication
- **Secure Authentication**: Protect user data during login and active sessions.
- **Session Management**: Allow users to stay logged in until they log out or after a specified duration.

## High-Level Design (HLD)

### Architecture Components

1️⃣ **Load Balancers (LB)**: Distribute traffic across servers for high availability (e.g., AWS ELB).

2️⃣ **API Gateway**: Entry point for routing requests, managing rate limits, and handling authentication (e.g., Kong).

3️⃣ **Microservices**: Separate services for modular and scalable architecture.

4️⃣ **Databases**: MySQL and MongoDB for structured and unstructured data.

5️⃣ **Message Broker (Kafka)**: Enable asynchronous inter-service communication.

6️⃣ **Caching (Redis)**: Boost response times for frequently accessed data.

7️⃣ **Search & Analytics (Elasticsearch)**: Efficient product searches with advanced capabilities.

## Typical Flow

### Part 1: Product Search
1️⃣ User logs in and searches for a product.

2️⃣ Request passes through the Load Balancer to the API Gateway.

3️⃣ API Gateway routes the search request to the Product Catalog Service.

4️⃣ Product Catalog Service queries Elasticsearch for results.

### Part 2: Add to Cart
1️⃣ User adds a product to the cart.

2️⃣ Cart Service stores the item in MongoDB and produces a Kafka message.

### Part 3: Checkout
1️⃣ User checks out.

2️⃣ Order Management Service processes the order and sends a Kafka message.

3️⃣ Payment Service consumes the message to handle payment.

---

## Resources

[![Spring Security](https://img.shields.io/badge/Spring-Security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white)](https://docs.spring.io/spring-security/reference/features/authentication/index.html)
[![BCrypt](https://img.shields.io/badge/BCrypt-Password%20Hashing-F57C00?style=for-the-badge&logo=auth0&logoColor=white)](https://auth0.com/blog/hashing-in-action-understanding-bcrypt/)
[![Auth0](https://img.shields.io/badge/Auth0-Access%20Tokens-EB5424?style=for-the-badge&logo=auth0&logoColor=white)](https://auth0.com/docs/secure/tokens/access-tokens)
[![Auth0](https://img.shields.io/badge/Auth0-Refresh%20Tokens-EB5424?style=for-the-badge&logo=auth0&logoColor=white)](https://auth0.com/blog/refresh-tokens-what-are-they-and-when-to-use-them/)
[![JWT](https://img.shields.io/badge/JWT-Java%20SDK-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)](https://github.com/jwtk/jjwt)
[![BCrypt](https://img.shields.io/badge/BCrypt-Generator-F57C00?style=for-the-badge&logo=securityscorecard&logoColor=white)](https://bcrypt-generator.com/)
[![MDN](https://img.shields.io/badge/Web-CORS-1572B6?style=for-the-badge&logo=mdnwebdocs&logoColor=white)](https://developer.mozilla.org/en-US/docs/Web/HTTP/Guides/CORS)
[![AWS](https://img.shields.io/badge/AWS-CORS-FF9900?style=for-the-badge&logo=amazonaws&logoColor=white)](https://aws.amazon.com/what-is/cross-origin-resource-sharing/)
[![Spring Authorization Server](https://img.shields.io/badge/Spring-Authorization%20Server-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://docs.spring.io/spring-authorization-server/reference/getting-started.html)
[![Spring Authorization Server](https://img.shields.io/badge/Spring-JPA%20Integration-6DB33F?style=for-the-badge&logo=spring&logoColor=white)](https://docs.spring.io/spring-authorization-server/reference/guides/how-to-jpa.html)
[![JWT](https://img.shields.io/badge/JWT-Token%20Debugger-000000?style=for-the-badge&logo=jsonwebtokens&logoColor=white)](https://www.jwt.io/)

---

## Contributing

Contributions are welcome. Before submitting changes, please review:
- [Contributing Guide](./Contributing.md)
- [Code of Conduct](./CODE_OF_CONDUCT.md)
- [Security Policy](./SECURITY.md)

---

## License
This project is licensed under the [Apache 2.0 License](./LICENSE).

---

## Author

[**Sahil Sharma**](https://github.com/sahil-me)

Thank you for exploring this project. If you find it helpful, consider giving the repository a ⭐ to support its continued development.

