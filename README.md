# 📸 Photography Portfolio WebServer

This is the backend service for a Photography Portfolio web application. It handles image upload, album management, and image retrieval. Built using **Spring Boot** and **PostgreSQL**, this backend supports storing actual image data in the database (as BLOBs) along with associated metadata.

---

## 🔧 Tech Stack

- **Java 17**
- **Spring Boot**
- **Spring Data JPA**
- **PostgreSQL**
- **Spring Web**
- **Lombok (optional)**
- **Jakarta Persistence (JPA)**

---

## 🎯 Features

- Upload photograph(s) to a selected album
- Store images as binary (BLOB) in the database
- Associate images with albums and track upload dates
- Retrieve all photographs or filter by album
- Delete photographs
- Count total images in the system

---

## 🖼️ Photograph Entity (Database Schema)

| Field         | Type      | Description                    |
|---------------|-----------|--------------------------------|
| photographId  | Long      | Primary key                    |
| imageData     | byte[]    | Raw image data stored as LONGBLOB |
| album         | Album     | Many-to-one relationship       |
| date          | String    | Upload date                    |

---

## 📦 API Endpoints (Planned)

| Method | Endpoint                 | Description              |
|--------|--------------------------|--------------------------|
| POST   | `/photograph/upload`     | Upload a photo           |
| GET    | `/photograph/all`        | Get all photos           |
| GET    | `/photograph/album/{id}` | Get photos by album ID   |
| DELETE | `/photograph/{id}`       | Delete a photo           |

> Controller is still under construction — contributions welcome!

---
