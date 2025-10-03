package system;

import model.Customer;

public class MenuService {
    public static void showAdminMenu() {
        while (true) {
            System.out.println("\n===== Admin Menu =====");
            System.out.println("1. View All Accounts");
            System.out.println("2. View Loan Requests");
            System.out.println("3. Approve Loan");
            System.out.println("4. Reject Loan");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = BankSystem.sc.nextInt();
            switch (choice) {
                case 1 -> BankSystem.customers.forEach(c ->
                        System.out.printf("ID: %d, Name: %s, Balance: %.2f\n", c.id, c.name, c.balance));
                case 2 -> LoanService.viewAllRequests();
                case 3 -> {
                    System.out.print("Enter Customer ID to approve: ");
                    int id = BankSystem.sc.nextInt();
                    LoanService.updateLoanStatus(id, "Approved");
                }
                case 4 -> {
                    System.out.print("Enter Customer ID to reject: ");
                    int id = BankSystem.sc.nextInt();
                    LoanService.updateLoanStatus(id, "Rejected");
                }
                case 5 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }

    public static void showCustomerMenu() {
        System.out.print("Enter your name: ");
        String name = BankSystem.sc.next();
        System.out.print("Enter your PIN: ");
        int pin = BankSystem.sc.nextInt();
        Customer customer = Authenticator.authenticate(name, pin);
        if (customer == null) {
            System.out.println("Authentication failed.");
            return;
        }

        while (true) {
            System.out.println("\n===== Customer Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Transfer Money");
            System.out.println("5. Apply for Loan");
            System.out.println("6. View Loan Status");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            int choice = BankSystem.sc.nextInt();
            switch (choice) {
                case 1 -> System.out.printf("Balance: %.2f\n", customer.balance);
                case 2 -> {
                    System.out.print("Enter amount to deposit: ");
                    double amount = BankSystem.sc.nextDouble();
                    TransactionService.deposit(customer, amount);
                }
                case 3 -> {
                    System.out.print("Enter amount to withdraw: ");
                    double amount = BankSystem.sc.nextDouble();
                    TransactionService.withdraw(customer, amount);
                }
                case 4 -> {
                    System.out.print("Enter receiver's name: ");
                    String receiver = BankSystem.sc.next();
                    System.out.print("Enter amount to transfer: ");
                    double amount = BankSystem.sc.nextDouble();
                    TransactionService.transfer(customer, receiver, amount);
                }
                case 5 -> {
                    System.out.print("Enter loan amount: ");
                    double amount = BankSystem.sc.nextDouble();
                    LoanService.applyLoan(customer, amount);
                }
                case 6 -> LoanService.viewLoanStatus(customer);
                case 7 -> { return; }
                default -> System.out.println("Invalid choice.");
            }
        }
    }
}
