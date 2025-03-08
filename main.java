package cbp;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static List<User> users = new ArrayList<>();
    private static List<Donor> donors = new ArrayList<>();
    private static List<Orphanage> orphanages = new ArrayList<>();
    private static List<Donation> donations = new ArrayList<>();

    public static void main(String[] args) {
        populateOrphanages(); // Initialize some orphanage data for demo purposes
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Donation Management System!");
        System.out.println("Are you a [1] User or [2] Donor?");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            handleUser(scanner);
        } else if (choice == 2) {
            handleDonor(scanner);
        } else {
            System.out.println("Invalid choice. Exiting.");
        }

        scanner.close();
    }

    private static void handleUser(Scanner scanner) {
        System.out.println("Do you want to [1] Login or [2] Register?");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            if (!loginUser(scanner)) {
                System.out.println("Login failed. Exiting.");
                return;
            }
        } else if (choice == 2) {
            registerUser(scanner);
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        processDonation(scanner);
    }

    private static void handleDonor(Scanner scanner) {
        System.out.println("Do you want to [1] Login or [2] Register?");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1) {
            if (!loginDonor(scanner)) {
                System.out.println("Login failed. Exiting.");
                return;
            }
        } else if (choice == 2) {
            registerDonor(scanner);
        } else {
            System.out.println("Invalid choice.");
            return;
        }

        processDonation(scanner);
    }

    private static void processDonation(Scanner scanner) {
        Orphanage selectedOrphanage = null;

        while (selectedOrphanage == null) {
            System.out.print("Enter the name of the orphanage you want to donate to: ");
            String orphanageName = scanner.nextLine();
            selectedOrphanage = findOrphanageByName(orphanageName);

            if (selectedOrphanage != null) {
                System.out.println("Orphanage found: " + selectedOrphanage.getName());
            } else {
                System.out.println("Sorry, the orphanage you mentioned is not in our database.");
                System.out.println("Here is a list of available orphanages:");
                for (Orphanage orphanage : orphanages) {
                    System.out.println("- " + orphanage.getName());
                }

                System.out.println("Do you want to [1] Try again or [2] Exit?");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                if (choice != 1) {
                    System.out.println("Exiting the donation process.");
                    return;
                }
            }
        }

        System.out.print("Enter the item you want to donate: ");
        String item = scanner.nextLine();
        System.out.print("Enter the quantity: ");
        int quantity = scanner.nextInt();

        Donation donation = new Donation("D" + (donations.size() + 1), "Donor", selectedOrphanage.getOrphanageId(), item, quantity);
        donations.add(donation);
        System.out.println("Thank you for your donation!");
    }

    private static Orphanage findOrphanageByName(String name) {
        for (Orphanage orphanage : orphanages) {
            if (orphanage.getName().equalsIgnoreCase(name)) {
                return orphanage;
            }
        }
        return null;
    }

    private static boolean loginUser(Scanner scanner) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        if (!Validator.isValidEmail(email)) {
            System.out.println("Invalid email format. Exiting.");
            return false;
        }

        System.out.print("Enter your contact number: ");
        String contactNumber = scanner.nextLine();
        if (!Validator.isValidPhoneNumber(contactNumber)) {
            System.out.println("Invalid phone number. It must be 10 digits. Exiting.");
            return false;
        }

        for (User user : users) {
            if (user.getEmail().equals(email) && user.getContactNumber().equals(contactNumber)) {
                System.out.println("Login successful! Welcome " + user.getName());
                return true;
            }
        }
        System.out.println("Invalid credentials.");
        return false;
    }

    private static boolean loginDonor(Scanner scanner) {
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        if (!Validator.isValidEmail(email)) {
            System.out.println("Invalid email format. Exiting.");
            return false;
        }

        System.out.print("Enter your contact number: ");
        String contactNumber = scanner.nextLine();
        if (!Validator.isValidPhoneNumber(contactNumber)) {
            System.out.println("Invalid phone number. It must be 10 digits. Exiting.");
            return false;
        }

        for (Donor donor : donors) {
            if (donor.getEmail().equals(email) && donor.getContactNumber().equals(contactNumber)) {
                System.out.println("Login successful! Welcome " + donor.getName());
                return true;
            }
        }
        System.out.println("Invalid credentials.");
        return false;
    }

    private static void registerUser(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        if (!Validator.isValidEmail(email)) {
            System.out.println("Invalid email format. Registration failed.");
            return;
        }

        System.out.print("Enter your contact number: ");
        String contactNumber = scanner.nextLine();

        if (!Validator.isValidPhoneNumber(contactNumber)) {
            System.out.println("Invalid phone number. It must be 10 digits. Registration failed.");
            return;
        }

        User user = new User(name, email, contactNumber);
        users.add(user);
        System.out.println("Registration successful!");
    }

    private static void registerDonor(Scanner scanner) {
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        if (!Validator.isValidEmail(email)) {
            System.out.println("Invalid email format. Registration failed.");
            return;
        }

        System.out.print("Enter your contact number: ");
        String contactNumber = scanner.nextLine();

        if (!Validator.isValidPhoneNumber(contactNumber)) {
            System.out.println("Invalid phone number. It must be 10 digits. Registration failed.");
            return;
        }

        Donor donor = new Donor(name, email, contactNumber, contactNumber);
        donors.add(donor);
        System.out.println("Registration successful!");
    }

    private static void populateOrphanages() {
        orphanages.add(new Orphanage("Hope Home", "hope@example.com", "1234567890", "O001"));
        orphanages.add(new Orphanage("Safe Shelter", "safe@example.com", "0987654321", "O002"));
        orphanages.add(new Orphanage("Bright Future", "bright@example.com", "1122334455", "O003"));
    }
}