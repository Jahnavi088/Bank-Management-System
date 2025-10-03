package system;

import model.Customer;
import model.LoanRequest;

public class LoanService {
    public static void applyLoan(Customer c, double amount) {
        LoanRequest lr = new LoanRequest(c.id, amount);
        BankSystem.loanRequests.add(lr);
        c.loanRequests.add(lr);
        System.out.println("Loan request submitted.");
    }

    public static void viewLoanStatus(Customer c) {
        boolean found = false;
        for (LoanRequest lr : BankSystem.loanRequests) {
            if (lr.customerId == c.id) {
                System.out.printf("Amount: %.2f, Status: %s\n", lr.amount, lr.status);
                found = true;
            }
        }
        if (!found) System.out.println("No loan requests found.");
    }

    public static void viewAllRequests() {
        for (LoanRequest lr : BankSystem.loanRequests) {
            System.out.printf("Customer ID: %d, Amount: %.2f, Status: %s\n", lr.customerId, lr.amount, lr.status);
        }
    }

    public static void updateLoanStatus(int customerId, String status) {
        for (LoanRequest lr : BankSystem.loanRequests) {
            if (lr.customerId == customerId && lr.status.equals("Pending")) {
                lr.status = status;
                System.out.println("Loan " + status + " for Customer ID " + customerId);
                return;
            }
        }
        System.out.println("No pending loan found for Customer ID " + customerId);
    }
}
