package cbp;

import java.sql.*;
import java.util.Scanner;

public class DonorHandler {
    
    public static void handleDonor(Scanner scanner) {
        Connection connection = DBConnection.getConnection();

        System.out.println("Do you want to [1] Login or [2] Register?");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            if (!loginDonor(scanner, connection)) {
                System.out.println("Login failed. Exiting.");
            }
        } else if (choice == 2) {
            registerDonor(scanner, connection);
        } else {
            System.out.println("Invalid choice.");
        }
    }

    private static boolean loginDonor(Scanner scanner, Connection connection) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your contact number: ");
        String contact = scanner.nextLine();

        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM donors WHERE demail = ? AND dcontact = ?")) {
            stmt.setString(1, email);
            stmt.setString(2, contact);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                System.out.println("Login successful! Welcome " + rs.getString("dname"));
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

    private static void registerDonor(Scanner scanner, Connection connection) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your contact number: ");
        String contact = scanner.nextLine();

        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO donors (dname, demail, dcontact) VALUES (?, ?, ?)")) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setString(3, contact);
            stmt.executeUpdate();
            System.out.println("Registration successful!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
