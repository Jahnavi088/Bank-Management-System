package system;

import model.Customer;

public class TransactionService {
    public static void deposit(Customer c, double amount) {
        c.balance += amount;
        System.out.println("Deposit successful.");
    }

    public static void withdraw(Customer c, double amount) {
        if (c.balance >= amount) {
            c.balance -= amount;
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public static void transfer(Customer sender, String receiverName, double amount) {
        Customer receiver = null;
        for (Customer c : BankSystem.customers) {
            if (c.name.equalsIgnoreCase(receiverName)) {
                receiver = c;
                break;
            }
        }
        if (receiver == null) {
            System.out.println("Receiver not found.");
            return;
        }
        if (sender.balance >= amount) {
            sender.balance -= amount;
            receiver.balance += amount;
            System.out.println("Transfer successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }
}
