import java.util.*;

public class ATMmachine {

}

class ATM {
    float Balance = 0; // Initialize balance to 0
    int PIN = 2222;

    Scanner sc = new Scanner(System.in); // Declare scanner only once

    public void checkPin() {
        System.out.print("Enter Your PIN: ");
        int enteredPin = sc.nextInt();

        if (enteredPin == PIN) {
            menu();
        } else {
            System.out.println("Enter a valid Pin");
            checkPin(); // Ask for PIN again if invalid
        }
    }

    public void menu() {
        System.out.println("Enter Your Choice: ");
        System.out.println("1. Check A/C Balance");
        System.out.println("2. Withdraw Amount");
        System.out.println("3. Deposit Amount");
        System.out.println("4. Exit");

        int opt = sc.nextInt();

        if (opt == 1) {
            checkBalance();
        } else if (opt == 2) {
            withdraw();
        } else if (opt == 3) {
            deposit();
        } else if (opt == 4) {
            return;
        }

        else {
            System.out.println("Enter Valid Choice");
            menu(); // Show menu again if invalid choice
        }
    }

    public void checkBalance() {
        System.out.println("Balance: " + Balance);
        menu();
    }

    public void withdraw() {
        System.out.println("Enter Amount: ");
        int amount = sc.nextInt();
        if (amount > Balance) {
            System.out.println("Insufficient Balance");
            menu(); // Go back to menu
        } else {
            Balance = Balance - amount;
            System.out.println("Amount Withdraw Successful");
            menu(); // Go back to menu
        }
    }

    public void deposit() {
        System.out.println("Enter Amount to Deposit: ");
        float amount = sc.nextFloat();
        Balance += amount;
        System.out.println("Money Deposited Successfully");
        menu(); // Go back to menu
    }

    public static void main(String arg[]) {
        ATM obj = new ATM();
        obj.checkPin();
    }
}