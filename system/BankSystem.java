package system;

import model.Customer;
import model.LoanRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BankSystem {
    public static List<Customer> customers = new ArrayList<>();
    public static List<LoanRequest> loanRequests = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static void initializeData() {
        customers.add(new Customer(1, "Ravi", 1234, 5000));
        customers.add(new Customer(2, "Priya", 2345, 7000));
        customers.add(new Customer(3, "Suresh", 3456, 10000));
        loanRequests.add(new LoanRequest(1, 5000));
        loanRequests.add(new LoanRequest(2, 10000));
    }
}
