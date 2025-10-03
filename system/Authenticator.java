package system;

import model.Customer;

public class Authenticator {
    public static Customer authenticate(String name, int pin) {
        for (Customer c : BankSystem.customers) {
            if (c.name.equalsIgnoreCase(name) && c.pin == pin) {
                return c;
            }
        }
        return null;
    }
}
