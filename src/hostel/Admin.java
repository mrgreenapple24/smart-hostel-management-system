package hostel;

class Admin extends User {

    public Admin(String name, String bitsID, String contact) {
        super(name, bitsID, contact);
    }

    @Override
    public void displayRole() {
        System.out.println("User Type: Administrator (Warden/Office)");
    }

    public void notifyResidents(String message, String... studentIDs) {
        System.out.println("ALERT SENT: " + message);
        for (String id : studentIDs) {
            System.out.println("Notification delivered to: " + id);
        }
    }

    public void generatePaymentReminder(String studentID) {
        System.out.println("Reminder: Pending fees for " + studentID);
    }

    public void generatePaymentReminder(String studentID, double amount) {
        System.out.println("Urgent: Pay Rs." + amount + " for " + studentID);
    }

    public void generatePaymentReminder(
        String studentID,
        double amount,
        String deadline
    ) {
        System.out.println(
            "Final Notice: " +
                studentID +
                " must pay Rs." +
                amount +
                " by " +
                deadline
        );
    }
}
