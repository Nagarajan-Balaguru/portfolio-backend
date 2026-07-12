
# 📁 Portfolio Backend API

A **reactive REST API** built with **Spring Boot 3** and **WebFlux** to power a personal portfolio website. It manages portfolio data (profile, projects, skills, experience, education) stored in **MongoDB** and provides a contact form with **email notification** support.

---

## 🚀 Tech Stack

| Layer        | Technology                           |
|--------------|---------------------------------------|
| Framework    | Spring Boot 3.5 (WebFlux - Reactive)  |
| Language     | Java 21                               |
| Database     | MongoDB (Reactive Driver)             |
| Email        | Spring Boot Mail (Gmail SMTP)         |
| Validation   | Jakarta Bean Validation               |
| Boilerplate  | Lombok                                |
| Config       | spring-dotenv (`.env` support)        |
| Build Tool   | Maven                                 |

---

## 📂 Project Structure

```
portfolio-backend/
├── src/
│   └── main/
│       ├── java/com/nagarajan/profolio/
│       │   ├── ProfolioApplication.java       # Entry point
│       │   ├── config/
│       │   │   └── CorsConfig.java            # CORS configuration
│       │   ├── controller/
│       │   │   ├── ProfileController.java
│       │   │   ├── ProjectController.java
│       │   │   ├── SkillController.java
│       │   │   ├── ExperienceController.java
│       │   │   ├── EducationController.java
│       │   │   ├── ContactController.java
│       │   │   └── GlobalExceptionHandler.java
│       │   ├── model/
│       │   │   ├── Profile.java
│       │   │   ├── Project.java
│       │   │   ├── Skill.java
│       │   │   ├── Experience.java
│       │   │   ├── Education.java
│       │   │   └── ContactMessage.java
│       │   ├── repository/                    # Reactive MongoDB repositories
│       │   └── service/
│       │       ├── ProfileService.java
│       │       ├── ProjectService.java
│       │       ├── SkillService.java
│       │       ├── ExperienceService.java
│       │       ├── EducationService.java
│       │       ├── ContactService.java
│       │       └── EmailService.java
│       └── resources/
│           └── application.properties
├── .env                                       # Local secrets (never commit)
├── .gitignore
└── pom.xml
```

---

## ⚙️ Configuration

### Environment Variables

Create a `.env` file at the project root (already git-ignored):

```env
MONGODB_URI=mongodb+srv://<username>:<password>@cluster.mongodb.net/
MAIL_PASSWORD=your_gmail_app_password
NOTIFICATION_EMAIL=your_email@gmail.com
PORT=8080
```

> **Note:** For Gmail SMTP, use an **App Password** (not your regular password).
> Go to: Google Account → Security → 2-Step Verification → App Passwords to generate one.

### `application.properties` Overview

```properties
# MongoDB
spring.data.mongodb.uri=${MONGODB_URI}
spring.data.mongodb.database=portfolio_db

# Server Port
server.port=${PORT:8080}

# Gmail SMTP
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=your_email@gmail.com
spring.mail.password=${MAIL_PASSWORD}
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true

# Notification recipient
app.notification.email=${NOTIFICATION_EMAIL}
```

---

## 📡 API Reference

Base URL: `http://localhost:8080`

All responses are in **JSON** format. The API is fully **reactive** (non-blocking).

---

### 👤 Profile

| Method | Endpoint       | Description               |
|--------|----------------|---------------------------|
| GET    | `/api/profile` | Get the portfolio profile |

**Response Schema:**
```json
{
  "id": "string",
  "name": "string",
  "tagline": "string",
  "bio": "string",
  "avatarUrl": "string",
  "resumeUrl": "string",
  "location": "string",
  "email": "string",
  "phone": "string",
  "socialLinks": {
    "github": "string",
    "linkedin": "string",
    "twitter": "string"
  }
}
```

---

### 🛠️ Projects

| Method | Endpoint        | Description          |
|--------|-----------------|----------------------|
| GET    | `/api/projects` | Get all projects     |

**Response Schema (array):**
```json
[
  {
    "id": "string",
    "title": "string",
    "description": "string",
    "techStack": ["string"],
    "githubUrl": "string",
    "liveUrl": "string",
    "thumbnail": "string",
    "featured": true,
    "order": 1,
    "category": "string",
    "company": "string"
  }
]
```

---

### 🎯 Skills

| Method | Endpoint      | Description    |
|--------|---------------|----------------|
| GET    | `/api/skills` | Get all skills |

**Response Schema (array):**
```json
[
  {
    "id": "string",
    "name": "string",
    "icon": "string",
    "category": "string",
    "proficiency": 90
  }
]
```

> `proficiency` is a value from `0` to `100` representing skill level.

---

### 💼 Experience

| Method | Endpoint          | Description              |
|--------|-------------------|--------------------------|
| GET    | `/api/experience` | Get all work experiences |

**Response Schema (array):**
```json
[
  {
    "id": "string",
    "company": "string",
    "companyLogoUrl": "string",
    "role": "string",
    "startDate": "string",
    "endDate": "string",
    "current": false,
    "highlights": ["string"],
    "order": 1
  }
]
```

---

### 🎓 Education

| Method | Endpoint         | Description               |
|--------|------------------|---------------------------|
| GET    | `/api/education` | Get all education records |

**Response Schema (array):**
```json
[
  {
    "id": "string",
    "institution": "string",
    "degree": "string",
    "grade": "string",
    "startDate": "string",
    "endDate": "string",
    "location": "string",
    "type": "string",
    "order": 1
  }
]
```

---

### 📬 Contact

| Method | Endpoint       | Description                                    |
|--------|----------------|------------------------------------------------|
| POST   | `/api/contact` | Submit a contact message (saves + sends email) |

**Request Body:**
```json
{
  "name": "string",      // Required, 2-50 characters
  "email": "string",     // Required, valid email format
  "message": "string"    // Required, 10-1000 characters
}
```

**Success Response (200):**
```json
{
  "id": "string",
  "name": "string",
  "email": "string",
  "message": "string",
  "timestamp": "2026-07-12T15:00:00Z",
  "read": false
}
```

**Validation Error (400 Bad Request):**
```json
{
  "status": 400,
  "error": "Bad Request",
  "message": "Name is required"
}
```

> On successful submission, an **email notification** is sent to the configured `NOTIFICATION_EMAIL` via Gmail SMTP.
> The reply-to header is automatically set to the sender's email for easy direct replies.

---

## 🌐 CORS Configuration

Configured in `CorsConfig.java` using Spring WebFlux `CorsWebFilter`:

| Origin                                              | Environment |
|-----------------------------------------------------|-------------|
| `http://localhost:5173`                             | Local Dev   |
| `https://portfolio-frontend-navy-phi.vercel.app`   | Production  |

All HTTP methods and headers are permitted for the allowed origins.

---

## 🗄️ MongoDB Collections

| Collection         | Model            | Description                  |
|--------------------|------------------|------------------------------|
| `profile`          | `Profile`        | Personal info & social links |
| `projects`         | `Project`        | Portfolio projects           |
| `skills`           | `Skill`          | Technical skills             |
| `experience`       | `Experience`     | Work history                 |
| `education`        | `Education`      | Academic background          |
| `contact_messages` | `ContactMessage` | Submitted contact messages   |

---

## 🏃 Running Locally

### Prerequisites

- Java 21+
- Maven 3.8+
- MongoDB Atlas account (or local MongoDB instance)

### Steps

1. **Clone the repository:**
   ```bash
   git clone https://github.com/Nagarajan-Balaguru/portfolio-backend.git
   cd portfolio-backend
   ```

2. **Create your `.env` file** at the project root (see [Configuration](#️-configuration) above)

3. **Run the application:**

   On Linux/macOS:
   ```bash
   ./mvnw spring-boot:run
   ```
   On Windows:
   ```cmd
   mvnw.cmd spring-boot:run
   ```

4. **Verify the server is running:**
   ```
   GET http://localhost:8080/api/profile
   ```

---

## 🏗️ Building for Production

```bash
./mvnw clean package -DskipTests
java -jar target/profolio-0.0.1-SNAPSHOT.jar
```

---

## 🧪 Testing the APIs

You can test the endpoints using **cURL**, **Postman**, or any HTTP client.

**Get Profile:**
```bash
curl http://localhost:8080/api/profile
```

**Get All Projects:**
```bash
curl http://localhost:8080/api/projects
```

**Get All Skills:**
```bash
curl http://localhost:8080/api/skills
```

**Get Work Experience:**
```bash
curl http://localhost:8080/api/experience
```

**Get Education:**
```bash
curl http://localhost:8080/api/education
```

**Submit Contact Form:**
```bash
curl -X POST http://localhost:8080/api/contact \
  -H "Content-Type: application/json" \
  -d '{
    "name": "John Doe",
    "email": "john@example.com",
    "message": "Hello! I would love to connect with you."
  }'
```

---

## 🔒 Security Notes

- The `.env` file is **git-ignored** — never commit secrets to version control.
- `application-prod.properties` and `application-local.properties` are also git-ignored.
- Use **Gmail App Passwords** instead of your actual account password for SMTP.
- MongoDB URI contains credentials — always inject via environment variables.

---

## 🚀 Deployment

This backend can be deployed on any platform that supports Java:

| Platform            | Notes                                                   |
|---------------------|---------------------------------------------------------|
| Railway / Render    | Set env variables in the platform dashboard             |
| Heroku              | Use `heroku config:set VAR=value` for secrets           |
| Docker              | Build image from JAR; pass `--env-file .env`            |
| Google Cloud Run    | Use Secret Manager for sensitive env variables          |
| AWS EC2             | Deploy JAR; inject env variables via systemd or `.env`  |

> Before deploying, add your production frontend URL to `CorsConfig.java` in the `allowedOrigins` list.

---

## 🔮 Future Improvements

- [ ] Add admin API with JWT authentication for managing portfolio data via CMS
- [ ] Add rate limiting on `/api/contact` to prevent spam submissions
- [ ] Integrate Swagger / OpenAPI documentation (`springdoc-openapi`)
- [ ] Add pagination and filtering support for projects and skills
- [ ] Add image upload support (e.g., Cloudinary integration)
- [ ] Add analytics endpoint to track project view counts
- [ ] Add support for a blog posts collection
- [ ] Write integration tests with `@WebFluxTest` and `Mockito`

---

## 👨‍💻 Author

**Nagarajan Balaguru**
📧 nnnagarajan16@gmail.com

---

## 📄 License

This project is open-source and available for personal use and learning purposes.
