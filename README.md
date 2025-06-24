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
│ └── Main.java # Entry point, launches Selection menu
│
├── auth/
│ ├── UserLogin.java # Handles login logic
│ └── Registration.java # Handles user registration
│
├── controller/
│ └── PersonController.java # Controls CRUD operations for Person
│
├── database/
│ └── SQLconnection.java # Manages MySQL database connection
│
├── menu/
│ ├── Selection.java # Main menu (Login / Register / Exit)
│ └── CRUD_Selection.java # CRUD menu after login
│
├── model/
│ ├── Person.java # POJO representing a person
│ └── PersonDAO.java # Handles database operations (DAO)
│
└── view/
└── PersonView.java # Manages user input/output

markdown
Copiar
Editar

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