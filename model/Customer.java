package model;

import java.util.ArrayList;
import java.util.List;

public class Customer {
    public int id;
    public String name;
    public int pin;
    public double balance;
    public List<LoanRequest> loanRequests = new ArrayList<>();

    public Customer(int id, String name, int pin, double balance) {
        this.id = id;
        this.name = name;
        this.pin = pin;
        this.balance = balance;
    }
}
