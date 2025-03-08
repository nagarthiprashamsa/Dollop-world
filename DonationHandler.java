package cbp;

import java.sql.*;
import java.util.Scanner;

public class DonationHandler {

    public static void makeDonation(Scanner scanner, Connection connection) {
        System.out.print("Enter your name: ");
        String donorName = scanner.nextLine();
        System.out.print("Enter the organization name you want to donate to: ");
        String orgName = scanner.nextLine();
        System.out.print("Enter the item you want to donate: ");
        String item = scanner.nextLine();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO donations (dname, oname, item, quantity, donation_time) VALUES (?, ?, ?, ?, NOW())")) {
            stmt.setString(1, donorName);
            stmt.setString(2, orgName);
            stmt.setString(3, item);
            stmt.setInt(4, quantity);
            stmt.executeUpdate();
            System.out.println("Thank you for your donation!");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
