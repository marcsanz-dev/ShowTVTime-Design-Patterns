# 🎬 ShowTVTime | Desktop Media Community

![Java](https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![Swing](https://img.shields.io/badge/GUI-Java_Swing-blue?style=for-the-badge)
![Architecture](https://img.shields.io/badge/Architecture-Layered_%26_Patterns-green?style=for-the-badge)
![Testing](https://img.shields.io/badge/Testing-JUnit-lightgrey?style=for-the-badge)

**ShowTVTime** is a desktop application designed to manage media collections (Movies & Series) and foster user communities. The project focuses on **Software Architecture**, implementing a strictly decoupled **3-Layer Architecture** and standard **Design Patterns** to solve business requirements like dynamic filtering and group management.

## 📸 Application Interface

### Content Discovery & Strategy Pattern
<img src="img/main_screen.png" width="100%">
*The main dashboard allows users to filter and sort media dynamically (Top 10, By IMDB Score, By Stars). This sorting logic is underpinned by the **Strategy Pattern**, allowing interchangeable algorithms at runtime.*

### Community & Access Control
<img src="img/groups_screen.png" width="100%">
*Users can browse and join communities. Access to exclusive groups is gated by an **Automated Admission System** (Logic Challenge) that validates user knowledge before granting membership.*

---

## 🏗️ Technical Architecture

This project was built to demonstrate proficiency in **Object-Oriented Design (SOLID)** and structural organization:

### 1. Layered Architecture
The code is strictly separated into three layers to ensure maintainability:
* **Presentation (View):** Java Swing components handling UI events.
* **Domain (Controller/Model):** Contains the business rules (Ratings, User Management).
* **Data (Persistence):** Handles file-based storage, isolated from the rest of the app.

### 2. Design Patterns Implemented
* **⚙️ Strategy Pattern:** Applied to the **Filtering Engine**. It encapsulates the sorting logic (e.g., `SortByIMDB`, `SortByRating`), making the system easily extensible without modifying the main controller.
* **🏢 Facade Pattern:** Used to provide a simplified interface to the complex logic of the Domain layer, creating a clean entry point for the UI.
* **🏭 Factory Pattern:** Manages the instantiation of entities (Movies, Series, Users), keeping the creation logic centralized.
* **🔒 Singleton Pattern:** Ensures that critical controllers (like the `DomainController`) have only one active instance throughout the application lifecycle.

## 🚀 Key Features
* **Validation Logic:** Automated Q&A "Gatekeeper" system for group admission.
* **Scoring System:** Implementation of arithmetic mean algorithms to calculate global ratings based on user feedback.
* **Data Persistence:** Custom local storage system to save state between sessions (Users, Reviews, Groups).
* **User Roles:** Distinction between regular users and group members.

## 💻 How to Run
1.  Clone the repository.
2.  Open the project in **IntelliJ IDEA**.
3.  Locate the `AppMain.java` file (Entry Point).
4.  Run to launch the Java Swing GUI.

---
*Developed for the Software Design course, showcasing clean code principles.*
