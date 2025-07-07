# 🤖 Chatbot Groq (Spring Boot + Angular)

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.3-green)
![Angular](https://img.shields.io/badge/Angular-20.0.2-red)
![Groq](https://img.shields.io/badge/Groq-API-blue)

## 📦 Installation

### Prérequis
- Java 17
- Node.js 18+
- Clé API Groq

### 1. Backend (Port 8866)
```bash
cd mcp-client
./mvnw spring-boot:run
```

### 2. Frontend (Port 4200)
```bash
cd chat-frontend
npm install && ng serve
```

## 🔧 Configuration
Ajoutez votre clé Groq dans :
`mcp-client/src/main/resources/application.properties`
```properties
groq.api.key=votre_cle_ici
```

## 🌟 Fonctionnalités
- Chat intelligent via API Groq
- Interface Angular moderne
- Documentation Swagger intégrée

## 🔗 Accès

- Swagger UI : http://localhost:8866/swagger-ui.html

---
![mcp-result](https://github.com/user-attachments/assets/b059f327-f8ae-4ee1-8833-21dfb2175f77)

---
![mcp-client](https://github.com/user-attachments/assets/0bb27782-9dd8-4290-b3d0-8d6a81883de6)

---

- Frontend : http://localhost:4200
---
![image](https://github.com/user-attachments/assets/84e34885-d649-4ef4-8f8e-bd9220112ffa)
