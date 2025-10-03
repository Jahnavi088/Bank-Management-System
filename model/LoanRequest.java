package model;

public class LoanRequest {
    public int customerId;
    public double amount;
    public String status;

    public LoanRequest(int customerId, double amount) {
        this.customerId = customerId;
        this.amount = amount;
        this.status = "Pending";
    }
}
