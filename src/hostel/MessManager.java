package hostel;

import java.io.*;
import java.util.Scanner;

class MessManager {

    public void displayMenu() {
        System.out.println("\n--- Weekly Mess Menu (BITS Goa) ---");
        try (
            BufferedReader br = new BufferedReader(
                new FileReader("mess_menu.txt")
            )
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println(
                "Note: data/mess_menu.txt not found. Displaying default: Dal-Chawal."
            );
        }
    }

    public void recordFeedback(String studentID, String feedback) {
        System.out.println(
            "Feedback recorded for " + studentID + ": " + feedback
        );
    }
}
