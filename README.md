# 🏙️ CitySync

> A collaborative municipal project management platform for city departments.

[![Live Demo](https://img.shields.io/badge/Live%20Demo-citysync--fh2m.onrender.com-brightgreen?style=for-the-badge&logo=render)](https://citysync-fh2m.onrender.com)
[![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=openjdk)](https://openjdk.org/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.x-green?style=for-the-badge&logo=springboot)](https://spring.io/projects/spring-boot)
[![MySQL](https://img.shields.io/badge/MySQL-8.0-blue?style=for-the-badge&logo=mysql)](https://www.mysql.com/)
[![Docker](https://img.shields.io/badge/Docker-Enabled-2496ED?style=for-the-badge&logo=docker)](https://www.docker.com/)

---

## 📋 About

**CitySync** is a full-stack web application built for city departments to coordinate, collaborate, and manage municipal projects efficiently. It provides role-based dashboards for Admins and Department Users, allowing real-time project tracking, resource sharing, meeting scheduling, and inter-department communication.

---

## ✨ Features

### 👤 User Features
- 🗂️ **Project Management** — Create, view, and track projects with statuses (Active / Finished)
- 🤝 **Collaboration** — Send and respond to collaboration requests across departments
- 🏊 **Resource Pool** — Share and request resources between departments
- 📅 **Meeting Scheduler** — Schedule meetings and send invitations to other users
- 💬 **Messaging** — Send and receive messages; view approved/pending communications
- 🏢 **Departments** — View all registered city departments

### 🛡️ Admin Features
- 👥 **User Management** — Register and manage department users
- 🏢 **Department Registration** — Create and manage city departments
- 🔑 **Role Assignment** — Assign/update user roles
- 📦 **Resource Pool Oversight** — View all pooled resources across the city
- 📩 **Message Moderation** — View and manage all inter-department messages

---

## 🧰 Tech Stack

| Layer | Technology |
|---|---|
| **Language** | Java 21 |
| **Framework** | Spring Boot 3.x |
| **Security** | Spring Security (role-based auth) |
| **Frontend** | Thymeleaf (server-side rendering) |
| **Styling** | Vanilla CSS |
| **ORM** | Spring Data JPA / Hibernate |
| **Database** | MySQL 8 (prod) / H2 In-Memory (dev) |
| **Build** | Maven |
| **Container** | Docker |
| **Hosting** | Render (backend) + TiDB Cloud (MySQL) |

---

## 🚀 Live Demo

🌐 **[https://citysync-fh2m.onrender.com](https://citysync-fh2m.onrender.com)**

> ⚠️ Hosted on Render's free tier — the app may take **~50 seconds** to wake up after inactivity.

### Demo Credentials

| Role | Username | Password |
|---|---|---|
| Admin | `admin` | `admin` |
| User 1 | `user` | `user` |
| User 2 | `user2` | `user2` |
| User 3 | `user3` | `user3` |

---

## 🏗️ Project Structure

```
citysync/
├── Dockerfile
├── pom.xml
└── src/
    └── main/
        ├── java/com/IOE/cs/city_sync/
        │   ├── Controllers/         # HTTP request handlers (Admin, User, Project, Meeting, etc.)
        │   ├── DTOs/                # Data Transfer Objects
        │   ├── Entities/            # JPA Entity classes (mapped to DB tables)
        │   ├── Repos/               # Spring Data JPA Repositories
        │   ├── Services/            # Business logic layer
        │   ├── Security/            # Spring Security config, custom handlers
        │   └── enums/               # ProjectStatus, Response enums
        └── resources/
            ├── application.properties       # Dev config (H2 in-memory)
            ├── application-prod.properties  # Prod config (MySQL)
            ├── data.sql                     # Seed data (departments + users)
            ├── static/css/                  # Stylesheets
            └── templates/                   # Thymeleaf HTML templates
                ├── admin/                   # Admin dashboard pages
                ├── user/                    # User dashboard pages
                ├── fragments/               # Reusable nav fragments
                └── login.html
```

---

## ⚙️ Local Development

### Prerequisites
- Java 21+
- Maven 3.8+

### Run Locally (H2 in-memory DB — no MySQL needed)

```bash
git clone https://github.com/Yesh-jain/CitySync.git
cd CitySync
./mvnw spring-boot:run
```

Open: [http://localhost:8080](http://localhost:8080)

H2 Console (dev only): [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

---

## 🐳 Run with Docker

```bash
docker build -t citysync .
docker run -p 8080:8080 \
  -e DB_URL=jdbc:mysql://localhost:3306/citysync \
  -e DB_USERNAME=root \
  -e DB_PASSWORD=yourpassword \
  citysync
```

---

## ☁️ Deployment Guide

This app is deployed using Docker on **Render** with **TiDB Cloud** as the managed MySQL provider.

### Environment Variables (set on Render)

| Variable | Description |
|---|---|
| `DB_URL` | Full JDBC MySQL connection URL |
| `DB_USERNAME` | Database username |
| `DB_PASSWORD` | Database password |
| `PORT` | Server port (auto-set by Render to `8080`) |

The `spring.profiles.active=prod` flag is set inside the `Dockerfile` `ENTRYPOINT`, which activates `application-prod.properties` automatically on deployment.

---

## 🔐 Roles & Access

| URL Pattern | Access |
|---|---|
| `/login`, `/` | Public |
| `/user/**` | Authenticated users (role: `USER`) |
| `/admin/**` | Admins only (role: `admin`) |

---

## 👨‍💻 Author

**Yesh Jain**
- GitHub: [@Yesh-jain](https://github.com/Yesh-jain)

---

## 📄 License

This project is for academic and demonstration purposes.
