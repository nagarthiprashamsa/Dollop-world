# **Dollop World**

## **Project Description**

Dollop World is a digital platform designed to connect donors with charitable organizations, such as food banks, shelters, and old-age homes, in need of surplus resources. It enables individuals, communities, and businesses to donate excess food, clothing, and essential goods, ensuring they reach the people who need them most. By offering a user-friendly interface, Dollop World streamlines the donation process and helps reduce waste while supporting vulnerable populations.

## **Features**

- ✅ Donor and organization registration and authentication  
- ✅ Secure login and data validation  
- ✅ Item donation management system  
- ✅ Real-time tracking of donations  
- ✅ Estimated delivery date calculation  

## **Technology Stack**

- **Programming Language**: Java  
- **Database**: MySQL  
- **Backend Framework**: JDBC (Java Database Connectivity)  
- **Development Environment**: Eclipse  

## **Installation and Setup**

### **Prerequisites**

- Install **Java Development Kit (JDK)**
- Install **MySQL Database**
- Install **Eclipse IDE**

### **Steps to Run the Project**

1. **Clone the Repository**
   ```sh
   git clone <repository_url>
   cd Dollop-World
   ```

2. **Import Project into Eclipse**
   - Open Eclipse IDE
   - Select **File → Import → Existing Projects into Workspace**
   - Browse and select the project folder
   - Click **Finish**

3. **Configure the Database**
   - Create a MySQL database (refer to `schema.sql` for table structure)
   - Update the database connection credentials in the `Main.java` file

4. **Compile and Run the Project**
   ```sh
   javac Main.java
   java Main
   ```

## **How to Use the Application**

### **User Registration/Login**
- Organizations can register by providing details such as name, foundation type, and contact information.
- Users log in using their email and contact number.

### **Donor Registration/Login**
- Donors register with their name, email, and contact details.
- Existing donors can log in to donate items.

### **Donating Items**
- Donors select an organization (orphanage, old-age home, etc.).
- Specify the item and quantity to donate.
- Receive confirmation along with an estimated delivery date.

## **Database Schema**

The application maintains structured data using the following tables:

- **Users Table** – Stores details of registered organizations.
- **Donors Table** – Stores details of registered donors.
- **Donations Table** – Tracks donated items, their quantities, and recipients.

## **Expected Outputs**

- Successful registration of users and donors.
- Secure login and authentication.
- Display of available organizations for donation selection.
- Confirmation of donations, including timestamps and estimated delivery schedules.

## **Conclusion**

Dollop World is a transformative initiative that bridges the gap between surplus resources and those in need. By facilitating seamless donations, the platform contributes to waste reduction, poverty alleviation, and improved well-being for underprivileged communities. Through technology, we aim to foster a culture of generosity and sustainability.

## **References**

- [Java Servlets](https://www.javatpoint.com/servlet-tutorial)  
- [JDBC Documentation](https://www.javatpoint.com/java-jdbc)  
- [MySQL Commands](https://www.w3schools.com/MySQL/default.asp)  
- [Apache Tomcat](https://tomcat.apache.org/)

