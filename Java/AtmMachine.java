import java.util.InputMismatchException;
import java.util.Scanner;

public class AtmMachine {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Enter account balance: ");
        double accountBalance = scanner.nextDouble();
        // updating user balance
        UserBank transaction = new UserBank(accountBalance);
        checkBalance(transaction);

        userMenu(); // displaying user options
        boolean quit = false;
        while (!quit) {
            try{
                System.out.println("Enter your choice: ");
                int action = scanner.nextInt(); // Read user's choice
                switch (action) {
                    case 0 -> {
                        quit = true;
                        System.out.println("Exiting the ATM. Please remove your card.");
                    }
                    case 1 -> withdrawMoney(transaction);
                    case 2 -> depositMoney(transaction);
                    case 3 -> checkBalance(transaction);
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            }catch (InputMismatchException e){
                System.out.println("Please enter a valid input");
            }
        }

    }
    // withdraw method
    private static void withdrawMoney(UserBank userBank) {
        System.out.println("Enter the amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (userBank.getAccountBalance() >= amount) {
            userBank.setAccountBalance(userBank.getAccountBalance() - amount);
            System.out.println("You have withdrawn: " + amount + " and new balance is: "
                    + userBank.getAccountBalance());
        }else {
            System.out.println("Transaction failed. Insufficient funds.");
        }
    }
    // deposit method
    private static void depositMoney(UserBank userBank) {
        System.out.println("Enter the amount to deposit: ");
        double amount = scanner.nextDouble();
        userBank.setAccountBalance(userBank.getAccountBalance() + amount);
        System.out.println("You have deposited: " + amount + " and account balance is: " + userBank.getAccountBalance());
    }

    private static void checkBalance(UserBank userBank) {
        System.out.println("Your account balance is: " + userBank.getAccountBalance());
    }

    private static void userMenu() {
        System.out.println("""
                0   Quit
                1   Withdraw
                2   Deposit
                3   Check Balance
                Choose an option of which you want to do""");
    }
}
