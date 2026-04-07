package hostel;

import java.io.*;
import java.util.*;

/**
 * Main Class: Smart Hostel Management System (BITS Pilani Goa Campus)
 * Purpose: Demonstrates and tests all 11 project requirements.
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Admin warden = new Admin("Dr. Manoj", "WARDEN_01", "0832-2580101");
        MessManager mess = new MessManager();
        FinanceManager finance = new FinanceManager();

        System.out.println(
            "=================================================="
        );
        System.out.println("   BITS PILANI GOA - SMART HOSTEL SYSTEM         ");
        System.out.println(
            "=================================================="
        );

        System.out.println("\n[1] Initializing System Logs...");
        try {
            File menuFile = new File("mess_menu.txt");
            if (!menuFile.exists()) {
                PrintWriter pw = new PrintWriter(new FileWriter(menuFile));
                pw.println("Monday: Paneer Butter Masala");
                pw.println("Tuesday: BITS Special Biryani");
                pw.println("Wednesday: Goa Fish Curry/Veg Thali");
                pw.close();
            }

            mess.displayMenu();
        } catch (IOException e) {
            System.out.println("Error setting up file system.");
        }

        System.out.println("\n[2] Registering Residents...");
        Student s1 = new Student("Aaryan", "2023A7PS0001G");
        Student s2 = new Student(
            "Ananya",
            "2023B3AA0123G",
            "9888877777",
            "Eco",
            "Mrs. Sharma",
            "Mother"
        );

        System.out.println("Location: " + Room.RoomMetadata.hostelBlock);
        System.out.println("Resident 1: " + s2.getDetails());

        System.out.println("\n[3] Testing Emergency Notifications...");
        warden.notifyResidents(
            "Fire Drill at 5 PM today",
            s1.bitsID,
            s2.bitsID,
            "2023A1PS0999G"
        );

        System.out.println(
            "\n[4] Testing Room Allocation & RoomFullException..."
        );
        Room r101 = new Room(101);
        try {
            r101.allocate(); // Student 1
            r101.allocate(); // Student 2
            r101.allocate(); // This will trigger the exception (Capacity is 2)
        } catch (RoomFullException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        System.out.println(
            "\n[5] Testing Finance Module (Overloaded Methods)..."
        );
        try {
            // Variation 1: Basic
            finance.processPayment(s1.bitsID, 5000.0);
            // Variation 2: Online with ID
            finance.processPayment(s2.bitsID, 12000.0, "TXN_BITS8899");
            // Variation 3: Bank Transfer
            finance.processPayment(s1.bitsID, 20000.0, "SBI-Goa", "REF12345");

            // Exception Case 2: Negative Payment
            System.out.println("Attempting invalid payment...");
            finance.processPayment(s1.bitsID, -100.0);
        } catch (PaymentFailedException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }

        System.out.println("\n[6] Resident Feedback System (Scanner Test)");
        System.out.print("Enter Mess Feedback for " + s1.bitsID + ": ");
        String feedbackInput = sc.nextLine();
        mess.recordFeedback(s1.bitsID, feedbackInput);

        finance.displayFinancialReport();

        try (
            PrintWriter logWriter = new PrintWriter(
                new FileWriter("security_logs.txt", true)
            )
        ) {
            logWriter.println(
                "Security Audit Completed by " +
                    warden.name +
                    " at " +
                    new Date()
            );
            System.out.println("\nSecurity logs updated in security_logs.txt");
        } catch (IOException e) {
            System.out.println("Security log update failed.");
        }

        System.out.println(
            "\n=================================================="
        );
        System.out.println(
            "   SYSTEM TEST COMPLETED SUCCESSFULLY             "
        );
        System.out.println(
            "=================================================="
        );

        sc.close();
    }
}
