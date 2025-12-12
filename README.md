# 📚 BookVerse - Monolith to Microservices

<div align="center">

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.0.0-6DB33F?style=for-the-badge&logo=spring-boot&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-8.14-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Ready-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

**Monolitik bir Spring Boot uygulamasının mikroservis mimarisine dönüştürülmesini adım adım gösteren eğitim projesi.**

[🚀 Başlangıç](#-hızlı-başlangıç) •
[📖 Dokümantasyon](#-proje-yapısı) •
[🏗️ Mimari](#️-mimari-diyagram) •
[🤝 Katkıda Bulun](#-katkıda-bulunma)

</div>

---

## 📋 İçindekiler

- [Proje Hakkında](#-proje-hakkında)
- [Özellikler](#-özellikler)
- [Mimari Diyagram](#️-mimari-diyagram)
- [Proje Yapısı](#-proje-yapısı)
- [Teknolojiler](#-teknolojiler)
- [Hızlı Başlangıç](#-hızlı-başlangıç)
- [API Endpoints](#-api-endpoints)
- [Geliştirme Aşamaları](#-geliştirme-aşamaları)
- [Katkıda Bulunma](#-katkıda-bulunma)
- [Lisans](#-lisans)

---

## 🎯 Proje Hakkında

**BookVerse**, katmanlı bir monolitik uygulamadan mikroservis mimarisine geçiş sürecini pratik olarak deneyimlemenizi sağlayan bir eğitim projesidir. Bu proje ile:

- ✅ Monolitik uygulama yapısını anlama
- ✅ Strangler Fig Pattern kullanarak güvenli geçiş
- ✅ REST tabanlı mikroservis iletişimi
- ✅ Docker ile containerization
- ✅ Clean Architecture prensiplerini uygulama

konularında hands-on deneyim kazanabilirsiniz.

---

## ✨ Özellikler

| Özellik | Açıklama |
|---------|----------|
| 📖 **Kitap Yönetimi** | Kitap listeleme ve detay görüntüleme |
| 👤 **Kullanıcı Servisi** | Bağımsız user-service mikroservisi |
| 🔗 **REST İletişim** | RestTemplate ile servisler arası haberleşme |
| 🐳 **Docker Desteği** | Multi-stage Dockerfile ile optimize build |
| 🧪 **Test Altyapısı** | JUnit 5 ile birim testler |

---

## 🏗️ Mimari Diyagram

### Monolitik Yapı (Başlangıç)
```
┌─────────────────────────────────────────────────────┐
│                    MONOLITH                         │
│  ┌─────────────────────────────────────────────┐   │
│  │              Controllers                     │   │
│  │         ┌──────────────────┐                │   │
│  │         │  BooksController │                │   │
│  │         └────────┬─────────┘                │   │
│  └──────────────────┼──────────────────────────┘   │
│  ┌──────────────────┼──────────────────────────┐   │
│  │              Services                        │   │
│  │         ┌────────▼─────────┐                │   │
│  │         │  BookServiceImpl │                │   │
│  │         └────────┬─────────┘                │   │
│  └──────────────────┼──────────────────────────┘   │
│  ┌──────────────────┼──────────────────────────┐   │
│  │            Repositories                      │   │
│  │    ┌─────────────▼──────────────┐           │   │
│  │    │  InMemoryBookRepository    │           │   │
│  │    └────────────────────────────┘           │   │
│  └─────────────────────────────────────────────┘   │
└─────────────────────────────────────────────────────┘
```

### Mikroservis Mimarisi (Hedef)
```
┌──────────────────┐         ┌──────────────────┐
│   BOOK SERVICE   │◄───────►│   USER SERVICE   │
│    (Port 8080)   │  REST   │    (Port 8081)   │
│                  │         │                  │
│ ┌──────────────┐ │         │ ┌──────────────┐ │
│ │  Controller  │ │         │ │  Controller  │ │
│ └──────┬───────┘ │         │ └──────┬───────┘ │
│ ┌──────▼───────┐ │         │ ┌──────▼───────┐ │
│ │   Service    │ │         │ │   Service    │ │
│ └──────┬───────┘ │         │ └──────┬───────┘ │
│ ┌──────▼───────┐ │         │ ┌──────▼───────┐ │
│ │  Repository  │ │         │ │  Repository  │ │
│ └──────────────┘ │         │ └──────────────┘ │
└──────────────────┘         └──────────────────┘
         │                            │
         └────────────┬───────────────┘
                      │
              ┌───────▼───────┐
              │  API Gateway  │
              │   (Opsiyonel) │
              └───────────────┘
```

---

## 📁 Proje Yapısı

```
bookverse-monolith-to-microservices/
│
├── 📄 README.md
│
└── 📂 single-file-monolith/          # Monolitik uygulama
    ├── 📄 build.gradle               # Gradle yapılandırması
    ├── 📄 Dockerfile                 # Docker build dosyası
    ├── 📄 gradlew                    # Gradle wrapper (Unix)
    ├── 📄 gradlew.bat                # Gradle wrapper (Windows)
    │
    └── 📂 src/
        ├── 📂 main/
        │   ├── 📂 java/com/bookverse/single_file_monolith/
        │   │   ├── 📄 DemoApplication.java       # Ana uygulama sınıfı
        │   │   │
        │   │   ├── 📂 controllers/
        │   │   │   └── 📄 BooksController.java   # REST API endpoints
        │   │   │
        │   │   ├── 📂 services/
        │   │   │   ├── 📄 BookService.java       # Servis interface
        │   │   │   └── 📄 BookServiceImpl.java   # Servis implementasyonu
        │   │   │
        │   │   ├── 📂 repositories/
        │   │   │   ├── 📄 BookRepository.java        # Repository interface
        │   │   │   └── 📄 InMemoryBookRepository.java # In-memory implementasyon
        │   │   │
        │   │   ├── 📂 entities/
        │   │   │   └── 📄 Book.java              # Kitap entity
        │   │   │
        │   │   ├── 📂 dto/
        │   │   │   └── 📄 UserDTO.java           # Kullanıcı DTO
        │   │   │
        │   │   └── 📂 clients/
        │   │       └── 📄 UserServiceClient.java # Mikroservis client
        │   │
        │   └── 📂 resources/
        │       └── 📄 application.properties     # Uygulama ayarları
        │
        └── 📂 test/
            └── 📂 java/...                       # Test sınıfları
```

---

## 🛠️ Teknolojiler

<table>
  <tr>
    <td align="center"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" width="40"/><br><b>Java 17</b></td>
    <td align="center"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg" width="40"/><br><b>Spring Boot 4.0</b></td>
    <td align="center"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/gradle/gradle-original.svg" width="40"/><br><b>Gradle 8.14</b></td>
    <td align="center"><img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original.svg" width="40"/><br><b>Docker</b></td>
  </tr>
</table>

### Bağımlılıklar

```groovy
dependencies {
    implementation 'org.springframework.boot:spring-boot-starter-webmvc'
    testImplementation 'org.springframework.boot:spring-boot-starter-webmvc-test'
    testRuntimeOnly 'org.junit.platform:junit-platform-launcher'
}
```

---

## 🚀 Hızlı Başlangıç

### Ön Gereksinimler

- ☕ **Java 17** veya üzeri
- 🐘 **Gradle 8.x** (veya wrapper kullanın)
- 🐳 **Docker** (opsiyonel)

### Kurulum

1. **Projeyi klonlayın:**
```bash
git clone https://github.com/YOUR_USERNAME/bookverse-monolith-to-microservices.git
cd bookverse-monolith-to-microservices
```

2. **Uygulamayı çalıştırın:**

**Gradle ile:**
```bash
cd single-file-monolith
./gradlew bootRun
```

**Windows için:**
```powershell
cd single-file-monolith
.\gradlew.bat bootRun
```

3. **Docker ile çalıştırın:**
```bash
cd single-file-monolith
docker build -t bookverse-monolith .
docker run -p 8080:8080 bookverse-monolith
```

4. **Uygulamayı test edin:**
```bash
curl http://localhost:8080/api/books
```

---

## 📡 API Endpoints

### Books API

| Method | Endpoint | Açıklama |
|--------|----------|----------|
| `GET` | `/api/books` | Tüm kitapları listeler |
| `GET` | `/api/books/{id}` | ID'ye göre kitap getirir |

### Örnek İstekler

**Tüm kitapları getir:**
```bash
curl -X GET http://localhost:8080/api/books
```

**Yanıt:**
```json
[
  {
    "id": 1,
    "title": "Yazılım Tasarımı ve Mimarisi",
    "author": "Özal YILDIRIM"
  },
  {
    "id": 2,
    "title": "Tasarım Desenleri",
    "author": "Erich Gamma"
  },
  {
    "id": 3,
    "title": "Temiz Kod",
    "author": "Robert C. Martin"
  }
]
```

**ID'ye göre kitap getir:**
```bash
curl -X GET http://localhost:8080/api/books/1
```

---

## 📈 Geliştirme Aşamaları

Bu proje aşamalı olarak geliştirilmektedir:

### ✅ Aşama 1: Monolitik Yapı
- [x] Katmanlı mimari (Controller → Service → Repository)
- [x] In-memory veri depolama
- [x] REST API endpoints
- [x] Docker desteği

### 🔄 Aşama 2: User Service Çıkarma (Devam Ediyor)
- [x] UserDTO tanımlama
- [x] UserServiceClient implementasyonu
- [ ] Bağımsız user-service projesi
- [ ] Servisler arası iletişim testi

### 📋 Aşama 3: Gelecek Planlar
- [ ] API Gateway entegrasyonu
- [ ] Service Discovery (Eureka)
- [ ] Veritabanı entegrasyonu (PostgreSQL)
- [ ] Kubernetes deployment

---

## 🤝 Katkıda Bulunma

Katkılarınızı bekliyoruz! 🎉

1. Bu repoyu fork edin
2. Feature branch oluşturun (`git checkout -b feature/YeniOzellik`)
3. Değişikliklerinizi commit edin (`git commit -m 'Yeni özellik eklendi'`)
4. Branch'inizi push edin (`git push origin feature/YeniOzellik`)
5. Pull Request açın

---

## 📝 Lisans

Bu proje MIT lisansı altında lisanslanmıştır. Detaylar için [LICENSE](LICENSE) dosyasına bakın.

---

## 👨‍💻 Yazar

<div align="center">

**BookVerse Projesi**

Eğitim amaçlı oluşturulmuştur.

⭐ Bu projeyi beğendiyseniz yıldız vermeyi unutmayın!

</div>

---

<div align="center">

📚 **Happy Coding!** 📚

</div>
