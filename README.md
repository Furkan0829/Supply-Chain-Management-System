# Supply-Chain-Management-System
 
A Spring Boot application for managing Orders, Suppliers, Customers, and Products efficiently. <br>
A robust Spring Boot application designed to streamline supply chain operations by managing Orders, Suppliers, Customers, and Products efficiently. <br>
This system provides a structured approach to handling inventory, tracking orders, and maintaining supplier-customer relationships.

Features <br>
✅ Orders – Create, update, delete, and track order status <br>
✅ Suppliers – Manage supplier details and relationships <br>
✅ Customers – Store customer information and order history <br>
✅ Products – Track inventory, stock updates, and availability <br>

Tech Stack  <br>
Backend: Spring Boot (Java) <br>
Database: PostgreSQL <br>
Architecture: Spring Boot layers (Controller, Service, Repository, Entity) <br>
API Testing: Postman

Installation & Setup <br>
create a simple spring project using https://start.spring.io/ <br>
add four dependencies while creating <br>
1️⃣ Spring Web 🌐 <br>
2️⃣ Spring Data JPA 🗄️ <br>
3️⃣ Your Database Driver (MySQL/PostgreSQL/etc.) 💾 <br>
4️⃣ Spring Boot DevTools (Optional, but Recommended) ⚡ <br>

Clone the Repository <br>
->git clone https://github.com/Furkan0829/Supply-Management-System.git <br>
->cd Supply-Management-System

Configure Database <br>
->Update application.properties with database credentials (I used vikasbanavara confg files "https://github.com/vikasbanavara/configuration-files/blob/main/application.properties%20for%20postgres%20SQL")

Run the Application

API Endpoints Resource Method Endpoint Description Orders- GET /api/orders Get all orders <br>
Orders- POST /api/orders Create a new order <br>
Suppliers- GET /api/suppliers Get all suppliers <br>
Customers- GET /api/customers Get all customers <br>
Products- GET /api/products Get all products <br>
for more endpoints go through the code. <br>

Contributions are welcome! Fork the repository and submit a pull request.
