# 💰 Money Manager - Java + MongoDB (MVC Architecture)

A simple, layered personal expense tracker built using:

- Java (Core + Swing)
- MongoDB Atlas (Cloud)
- Maven for Dependency Management
- MVC (Model-View-Controller) Design Pattern

---

## 📦 Features

- Add, view, and delete expenses
- Data persistence using MongoDB
- Clean, layered architecture
- Swing-based GUI

---

## 🗂 Project Structure

money_manager/
├── model/ → POJO (Expense.java)
├── dao/ → DB access (MongoExpenseDAO)
├── service/ → Business logic
├── controller/ → App flow control
├── ui/ → GUI (Swing)
└── src.main.Main.java → Entry point


---

## ⚙️ MongoDB Setup

Use your MongoDB Atlas URI and replace `<db_password>` in `MongoExpenseDAO.java`:


Make sure the `expenses` collection exists under `expense_manager` database.

---

## ✅ Run

```bash
mvn compile
mvn exec:java -Dexec.mainClass="src.main.Main"
