package cbp;

import java.sql.*;
import java.util.Scanner;

public class UserHandler {
    
    public static void handleUser(Scanner scanner) {
        Connection connection = DBConnection.getConnection();

        System.out.println("Do you want to [1] Login or [2] Register?");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            if (!loginUser(scanner, connection)) {
                System.out.println("Login failed. Exiting.");
            }
        } else if (choice == 2) {
            registerUser(scanner, connection);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static boolean loginUser(Scanner scanner, Connection connection) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your contact number: ");
        String contact = scanner.nextLine();

        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE email = ? AND contact = ?")) {
            stmt.setString(1, email);
            stmt.setString(2, contact);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful! Welcome " + rs.getString("oname"));
                return true;
            } else {
                System.out.println("Invalid credentials.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private static void registerUser(Scanner scanner, Connection connection) {
        System.out.print("Enter your organization name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your contact number: ");
        String contact = scanner.nextLine();
        System.out.print("Enter your foundation name: ");
        String foundation = scanner.nextLine();

        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO users (oname, foundation, contact, email) VALUES (?, ?, ?, ?)")) {
            stmt.setString(1, name);
            stmt.setString(2, foundation);
            stmt.setString(3, contact);
            stmt.setString(4, email);
            stmt.executeUpdate();
            System.out.println("Registration successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
