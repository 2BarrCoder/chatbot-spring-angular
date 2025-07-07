# 🤖 Chatbot Groq – Mini Projet Full Stack (Angular + Spring Boot + MCP + Groq AI)

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.5.3-green)
![Angular](https://img.shields.io/badge/Angular-20.0.2-red)
![Groq](https://img.shields.io/badge/Groq-API-blue)

---

## 🧠 Présentation du projet

Ce projet est un chatbot intelligent basé sur l’**API Groq AI**, construit avec les technologies suivantes :

- **Spring Boot (Backend & Client)** : communication REST + exécution d'outils métier
- **Angular (Frontend)** : interface utilisateur moderne pour discuter avec le chatbot
- **MCP (Model Context Protocol)** : permet de définir et utiliser des outils métier dynamiques
- **Groq AI** : moteur de génération de réponses contextuelles avec appels de fonctions (tools)

---

## 📌 Fonctionnalités

- 💬 Chatbot avec UI responsive (Angular)
- 🤖 Génération de réponse contrôlée via Groq AI
- 🧩 Appels automatiques d'outils métier (tools) via MCP
- 🔐 API sécurisée via clé API
- 🛠️ Architecture claire : Frontend <=> Client <=> Serveur (port 8888)
- 🧪 Interface Swagger pour test des endpoints

---

## 🗂️ Architecture du projet

```
.
├── chat-frontend/           # Application Angular (Chat UI)
│   ├── src/app/             # Composants: app, chat, services
│   ├── angular.json
│   └── package.json
│
├── mcp-client/             # Client Spring Boot qui appelle l’API Groq
│   ├── agents/             # GroqService, DeepSeekService...
│   ├── controllers/        # Web API côté client
│   └── application.properties
│
├── mcp-server/             # Serveur Spring Boot (port 8888) – point d’entrée outils MCP
│   ├── tools/              # Implémentation des outils (ex: StockTolls.java)
│   └── controllers/        # Contrôleurs REST
│
├── python-mcp-server/      # Version alternative Python du serveur (optionnelle)
│
└── src/                    # Exemple simple Java (hors microservices)
```

---

## 🔧 Configuration requise

- **Java 17**
- **Node.js 18+**
- **Angular CLI**
- **Groq API Key** (clé gratuite disponible sur https://console.groq.com)

---

## ⚙️ Configuration de la clé API

Ajoutez votre clé dans :

```properties
# Fichier : mcp-client/src/main/resources/application.properties
groq.api.key=VOTRE_CLE_ICI
groq.api.url=https://api.groq.com/openai/v1/chat/completions
groq.model=mixtral-8x7b-32768
```

---

## 🚀 Lancer le projet

### 1. Lancer le **serveur REST (mcp-server)**

```bash
cd mcp-server
./mvnw spring-boot:run
# Écoute sur le port : 8888
```

### 2. Lancer le **client Groq (mcp-client)**

```bash
cd mcp-client
./mvnw spring-boot:run
# Envoie les requêtes à Groq API et communique avec le serveur
# Port : 8866
```

### 3. Lancer le **frontend Angular**

```bash
cd chat-frontend
npm install
ng serve
# Accès sur : http://localhost:4200
```

---

## 🧠 Comment fonctionne GroqService ?

Le `GroqService` est responsable de :

1. Recevoir un message de l'utilisateur.
2. Créer un prompt système strict (ne pas halluciner, utiliser uniquement les outils).
3. Lister dynamiquement les outils via `McpSyncClient`.
4. Envoyer le prompt + les outils à l’API Groq.
5. Si Groq déclenche un `tool_call`, exécuter l'outil métier concerné.
6. Faire un second appel à Groq avec la sortie des outils.
7. Renvoyer une réponse propre à l'utilisateur.

⚠️ Le modèle Groq **n’est pas libre de répondre comme il veut** : il **doit utiliser les outils fournis** pour répondre.

---

## 🧪 Tester les API (Swagger)

Swagger UI disponible sur :

```
http://localhost:8866/swagger-ui.html
```

---

## 🧼 .gitignore – Fichiers ignorés

Les fichiers suivants sont exclus du projet Git pour garder le dépôt propre :

- `node_modules/`, `.idea/`, `__pycache__/`, `.rar`, `dist/`
- `.gitignore` est présent dans presque chaque sous-module (`chat-frontend`, `mcp-client`, `mcp-server`, etc.)

---

## 🗨️ Exemple de flux de données

```
Utilisateur → Angular UI → MCP Client → MCP Server → Groq API
                                                      ↓
                                               Tools métiers exécutés
                                                      ↓
                                         Réponse formatée & envoyée à l’utilisateur
```

---

## 📸 Aperçu (images à ajouter)

- Interface utilisateur
- Swagger UI
- Réponse formatée de l’IA

---

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
