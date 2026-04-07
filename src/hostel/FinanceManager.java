package hostel;

import java.util.ArrayList;

public class FinanceManager {

    private ArrayList<Double> paymentHistory = new ArrayList<>();
    private Double totalRevenue = 0.0;

    public void processPayment(String studentID, double amount)
        throws PaymentFailedException {
        if (amount <= 0) {
            throw new PaymentFailedException(
                "Invalid payment amount: " + amount
            );
        }
        recordTransaction(amount);
        System.out.println(
            "Payment of Rs." +
                amount +
                " received for Student: " +
                studentID +
                " (Mode: Cash/General)"
        );
    }

    public void processPayment(
        String studentID,
        double amount,
        String transactionID
    ) throws PaymentFailedException {
        if (transactionID == null || transactionID.isEmpty()) {
            throw new PaymentFailedException(
                "Transaction ID missing for Online Payment."
            );
        }
        recordTransaction(amount);
        System.out.println(
            "Payment of Rs." + amount + " verified. TXN ID: " + transactionID
        );
    }

    public void processPayment(
        String studentID,
        double amount,
        String bankName,
        String refNo
    ) throws PaymentFailedException {
        recordTransaction(amount);
        System.out.println(
            "Bank Transfer from " +
                bankName +
                " (Ref: " +
                refNo +
                ") processed for " +
                amount
        );
    }

    private void recordTransaction(double amount) {
        paymentHistory.add(Double.valueOf(amount));
        totalRevenue += amount;
    }

    public void displayFinancialReport() {
        System.out.println("\n--- BITS Goa Hostel Financial Report ---");
        System.out.println("Total Transactions: " + paymentHistory.size());
        System.out.println("Total Revenue Collected: Rs." + totalRevenue);
    }
}
