🧾 OneID Pension System  
**Unified Platform for Identifying Overlapping Pension Benefits**

---

## 📱 Project Overview

**OneID Pension System** is an Android application built using **Kotlin** that aims to simplify and centralize the management of pension-related data for government and private organizations.  
The system provides each pensioner with a **unique OneID**, enabling efficient tracking, verification, and management of pension benefits — eliminating redundancy and fraud in pension disbursement.

This project was developed as part of the **Mobile Application Development** coursework, integrating all key Android development concepts such as **Views & Components, Application Communication, Fragments, Custom Views, Data Storage, and Navigation**.

---

## 🎯 Objectives

- Create a **single digital identity (OneID)** for pensioners.  
- Detect and prevent **overlapping or duplicate pension benefits**.  
- Allow users to **apply, track, and manage** their pension applications digitally.  
- Enable **data storage, notifications, and record keeping** through a user-friendly interface.  

---

## ⚙️ Tech Stack

| Category | Technologies Used |
|-----------|-------------------|
| **Language** | Kotlin |
| **IDE** | Android Studio |
| **Architecture** | MVVM (Model-View-ViewModel) |
| **Database** | SQLite / Room Database |
| **UI Design** | XML Layouts, Material Design |
| **Navigation** | Jetpack Navigation Component |
| **Data Storage** | SharedPreferences, Room |
| **Communication** | Intents, Bundles, Broadcast Receivers |
| **Notifications** | Android Notification Manager |

---

## 🧩 Major Modules / Screens

| Unit | Feature | Description |
|------|----------|-------------|
| **Unit I - Views & Components** | Pensioner Dashboard | Basic UI elements, buttons, text fields, and forms. |
| **Unit II - App Communication** | Pension Application Form | Inter-activity communication and file uploads. |
| **Unit III - Fragments & Pickers** | Pension Status Tracker | Fragment-based navigation with date and time pickers. |
| **Unit IV - Custom Views** | Payment Ledger | Custom view for displaying transaction summaries. |
| **Unit V - Data Storage** | Pension Record Storage | Stores pensioner details in local Room database. |
| **Unit VI - Navigation** | Pension Flow | Complete app navigation using Jetpack Navigation Component. |

---

## 🏗️ Features

- 👤 **Unique OneID generation** for pensioners  
- 📝 **Digital pension application form**  
- 📊 **Payment ledger** with real-time tracking  
- 🔔 **Notifications** for application updates  
- 🧭 **Smooth navigation** using fragments  
- 💾 **Offline data storage** using Room Database  
- 🕵️ **Overlapping pension detection logic**

---

## 📂 Project Structure

```

app/
├── java/com/example/oneidpension/
│   ├── activities/
│   │   ├── MainActivity.kt
│   │   ├── ApplicationStatusActivity.kt
│   │   ├── PensionFormActivity.kt
│   │   └── PaymentLedgerActivity.kt
│   ├── fragments/
│   │   ├── DashboardFragment.kt
│   │   ├── PensionFlowFragment.kt
│   │   └── ProfileFragment.kt
│   ├── database/
│   │   ├── PensionerDao.kt
│   │   └── PensionerDatabase.kt
│   ├── models/
│   │   └── Pensioner.kt
│   ├── adapters/
│   │   └── LedgerAdapter.kt
│   └── utils/
│       └── NotificationHelper.kt
├── res/
│   ├── layout/
│   ├── drawable/
│   ├── values/
│   └── navigation/
└── AndroidManifest.xml

````

---

## 🚀 How to Run the Project

1. **Clone the Repository**
   ```bash
   git clone https://github.com/your-username/OneID-Pension-System.git
````

2. **Open in Android Studio**

   * File → Open → Select the cloned project folder.

3. **Build the Project**

   * Let Gradle sync dependencies automatically.

4. **Run on Emulator or Device**

   * Click ▶️ to launch the app on your Android emulator or a connected device.

---

## 🧠 Learning Outcomes

* Mastered Android fundamentals using Kotlin.
* Implemented **Room Database** for persistent local storage.
* Learned **activity-to-fragment communication** and navigation.
* Designed **custom UI views and components**.
* Gained experience with **notifications and background tasks**.

---

## 🔒 Future Enhancements

* Integration with **Aadhaar / PAN APIs** for identity verification.
* Cloud sync using **Firebase** or **RESTful APIs**.
* **Admin dashboard** for government officials.
* Advanced **data analytics and reporting** for pension tracking.
* Multi-language support (English, Hindi, Marathi).

---

## 👨‍💻 Developer

**Name:** Mohit Dayma
**University:** Lovely Professional University, Phagwara
**Degree:** B.Tech in Computer Science Engineering (2022–2026)
**Location:** Nanded, Maharashtra
**Tech Stack Expertise:** MERN Stack, Java, Kotlin, C++, DSA

---

## 🏷️ License

This project is licensed under the **MIT License** — feel free to use, modify, and distribute with attribution.

---

> “Building trust and transparency in pension management through a unified digital identity — OneID Pension System.”

```
