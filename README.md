# Dollop-world
📌 Dollop World - Donation Management System

Dollop World is a console-based Java application that allows donors to contribute essential items to orphanages and old-age homes.
The system supports secure user authentication, donation tracking, and MySQL database storage.

This project is designed for:
NGOs managing donations.
Individuals looking to contribute items securely.
A centralized system for tracking donations and beneficiaries.
🛠️ Tech Stack
Programming Language: Java (JDBC)
Database: MySQL
Development Tools: Eclipse / IntelliJ IDEA, MySQL Workbench
Version Control: Git & GitHub
🎯 Features
✔️ User & Donor Registration/Login
✔️ Donors can donate items to orphanages
✔️ Database integration using MySQL (JDBC)
✔️ Validation of email and contact numbers
✔️ Admin can view donation records
✔️ Secure data handling

📂 Project Structure
Dollop-World/
│── 📄 README.md        # Project Summary
│── 📁 src/             # Java Source Code
│   ├── 📄 Main.java          # Entry point
│   ├── 📄 DBConnection.java  # Manages MySQL connection
│   ├── 📄 UserHandler.java   # Handles user authentication
│   ├── 📄 DonorHandler.java  # Manages donors
│   ├── 📄 DonationHandler.java # Handles donations
│   ├── 📄 User.java          # User Model
│   ├── 📄 Donor.java         # Donor Model
│   ├── 📄 Orphanage.java     # Orphanage Model
│   ├── 📄 Donation.java      # Donation Model
│   ├── 📄 Validator.java     # Validates email & phone numbers
│
├── 📁 sql/             # Database Scripts
│   ├── 📄 database_schema.sql  # MySQL table structures
│   ├── 📄 insert_data.sql       # Sample data for testing
│   ├── 📄 queries.sql           # SQL queries used in Java code
│
└── 📁 docs/            # Additional documentation
    ├── 📄 ER_Diagram.png
🏗️ Setup Instructions
1️⃣ Clone the Repository
git clone https://github.com/your-username/Dollop-World.git
cd Dollop-World
2️⃣ Set Up MySQL Database
Run the following SQL scripts to create tables and insert sample data:
mysql -u root -p < sql/database_schema.sql
mysql -u root -p < sql/insert_data.sql
3️⃣ Configure Java Database Connection
Update the MySQL credentials inside DBConnection.java:
private static final String URL = "jdbc:mysql://localhost:3306/organization";
private static final String USER = "root";   // Change to your MySQL username
private static final String PASSWORD = "your_password";  // Change to your MySQL password
4️⃣ Compile and Run the Application
🔹 Compile Java Files
javac -cp ".;mysql-connector-java-8.0.32.jar" src/*.java
🔹 Run the Application
java -cp ".;mysql-connector-java-8.0.32.jar" src.Main
🚀 Running the Application
1️⃣ When the application starts, you'll see:
Welcome to the Dollop World Donation System!
Are you a [1] User or [2] Donor?
👉 Enter 1 to register/login as a User (NGO or Orphanage).
👉 Enter 2 to register/login as a Donor.

2️⃣ Login/Register Process

If you are new, select [2] Register.
If you already have an account, select [1] Login.
3️⃣ Making a Donation After logging in as a donor, you can enter donation details:
Enter the name of the orphanage you want to donate to: Helping Hands
Enter the item you want to donate: Blankets
Enter the quantity: 10
Thank you for your donation!
4️⃣ Viewing Donation Records Admins can fetch donations using:
SELECT * FROM donations;
🛠️ Troubleshooting
If you encounter errors, try the following:

🔹 MySQL Connection Issues
Ensure MySQL is running (sudo service mysql start on Linux).
Verify MySQL credentials in DBConnection.java.
Run:
mysql -u root -p -e "SHOW DATABASES;"
🔹 Java Compilation Issues
Ensure JDK 8 or higher is installed (java -version).
Make sure the MySQL JDBC Driver is available in the classpath.
