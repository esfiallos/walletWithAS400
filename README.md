# 🏦 LegacyWallet: Integración Bancaria Híbrida AS400 with React

> **Prueba de Concepto** de ingeniería de software que demuestra la interoperabilidad crítica entre sistemas Core Bancarios Legacy (IBM i / AS400) y arquitecturas modernas de microservicios.

![Java](https://img.shields.io/badge/Backend-Java%2017%20%7C%20Spring%20Boot-green)
![React](https://img.shields.io/badge/Frontend-React%2019%20%7C%20Vite-blue)
![IBM](https://img.shields.io/badge/Legacy-IBM%20i%20(AS400)-orange)
![License](https://img.shields.io/badge/License-MIT-lightgrey)

---


## 💡 Descripción del Proyecto

En el ecosistema financiero actual, el verdadero desafío no es solo crear interfaces web atractivas, sino **conectarlas con sistemas "Legacy"** que gestionan la data crítica desde hace décadas.

**LegacyWallet** es una solución Full Stack que simula una billetera digital moderna capaz de consultar saldos históricos en tiempo real directamente desde un Mainframe **IBM AS400**, eliminando la necesidad de procesos por lotes (batch) y ofreciendo datos en vivo al usuario final.

---

## ⚙️ Arquitectura de la Solución

El sistema utiliza una arquitectura de **Middleware en Java** que traduce las peticiones HTTP modernas a protocolos nativos de base de datos IBM.

```mermaid
graph LR
    A[Cliente Web (React)] -- Petición HTTP/JSON --> B[API Gateway (Spring Boot)]
    B -- JDBC / JTOpen Protocol --> C[(IBM i / AS400)]
    C -- Datos DB2 --> B
    B -- JSON Response --> A
```

Frontend: SPA (Single Page Application) construida en React + Vite.

Backend: Microservicio Spring Boot actuando como puente seguro.

Database: Instancia DB2 for i alojada en un servidor IBM público (Pub400.com).

---

## 🛠 Stack Tecnológico

Backend (API & Lógica)
Lenguaje: Java 17 LTS.

Framework: Spring Boot 3.4.1 (Spring Web, Spring Data JPA).

Integración Legacy: JTOpen (IBM Toolbox for Java 11.1) - Driver crítico para la comunicación nativa con AS400.

Gestión de Conexiones: HikariCP
Build Tool: Maven.
Build Tool: Vite
Estilos: CSS3 nativo con diseño Flexbox y Glassmorphism
Conexión: Fetch API con manejo asíncrono.


## 🚀 Instalación y Despliegue
Sigue estos pasos para levantar el entorno completo en tu máquina local.

Prerrequisitos
Java JDK 17+.
Node.js (v18+).
Acceso a internet (para conectar con Pub400).

1. Configurar y Ejecutar el Backend (Java)
Navega a la carpeta del servidor:


cd Back-IBM
(Opcional) Si tienes tus propias credenciales de AS400, edita src/main/resources/application.properties.

Ejecuta la aplicación:

```
./mvnw spring-boot:run
```
Nota: El servidor iniciará en el puerto 9090 para evitar conflictos comunes con el puerto 8080.

2. Configurar y Ejecutar el Frontend (React)
Abre una nueva terminal y ve a la carpeta del cliente:

```
cd frontend-wallet
```

Instala las dependencias:

```
npm install
```

Levanta el servidor de desarrollo:

```
npm run dev
```

Abre tu navegador en http://localhost:5173.

---

## Estructura del Proyecto
LegacyWallet/
├── Back-IBM/                  # Lógica del Servidor
│   ├── src/main/java/com/uth/wallet/
│   │   ├── Controller/        # Endpoints REST (ClienteController.java)
│   │   ├── Entity/            # Modelo de Datos (ClienteLegacy.java)
│   │   └── Repository/        # Interfaz de Acceso a Datos (JPA)
│   └── src/main/resources/
│       └── application.properties # Configuración de Conexión AS400
│
└── frontend-wallet/           # Interfaz de Usuario
    ├── src/
    │   ├── App.jsx            # Lógica de componentes y consumo de API
    │   ├── App.css            # Estilos de la Tarjeta Bancaria
    │   └── main.jsx           # Punto de entrada
    └── vite.config.js         # Configuración de Vite
