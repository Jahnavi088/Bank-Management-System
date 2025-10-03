import system.BankSystem;
import system.MenuService;

public class Main {
    public static void main(String[] args) {
        BankSystem.initializeData();

        while (true) {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. Admin");
            System.out.println("2. Customer");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = BankSystem.sc.nextInt();

            switch (choice) {
                case 1 -> MenuService.showAdminMenu();
                case 2 -> MenuService.showCustomerMenu();
                case 3 -> {
                    System.out.println("Exiting Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
