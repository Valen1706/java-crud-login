# Java CRUD + Login System

This is a Java project that implements a user registration, login, and CRUD (Create, Read, Update, Delete) system connected to a MySQL database using the **MVC** (Model-View-Controller) pattern.

## ✨ Features

- User registration
- User login
- Create personal records
- View records by last name or full list
- Update existing records
- Delete records by ID

## 🛠️ Technologies Used

- Java
- JDBC (Java Database Connectivity)
- MySQL
- IntelliJ IDEA
- Git + GitHub

## ⚙️ Requirements

- JDK 17 or higher
- MySQL Server running locally (or remotely)
- IntelliJ IDEA (or any Java IDE)

## 📦 Project Structure

src/
├── app/
│ └── Main.jav
│
├── auth/
│ ├── UserLogin.java # Handles login logic
│ └── Registration.java
│
├── controller/
│ └── PersonController.java
│
├── database/
│ └── SQLconnection.java
│
├── menu/
│ ├── Selection.java
│ └── CRUD_Selection.java
│
├── model/
│ ├── Person.java
│ └── PersonDAO.java
│
└── view/
└── PersonView.java


## 🚀 How to Run

1. Clone the repository.
2. Create a MySQL database named `mydb` with the tables `personal_details` and `userlogin`.
3. Open the project in IntelliJ IDEA.
4. Update the DB credentials in `database/SQLconnection.java` if needed.
5. Run `Main.java`.

## ✅ Notes

- The project uses a basic terminal interface (no GUI).
- All operations are handled through the console.
- Follows MVC to separate logic, data, and interface.

## 👤 Author

**Valen1706**