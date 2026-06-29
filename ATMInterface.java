import java.util.ArrayList;
import java.util.Scanner;

public class ATMInterface {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String userId = "admin";
        String userPin = "1234";

        double balance = 10000;
        ArrayList<String> history = new ArrayList<>();

        System.out.println("==================================");
        System.out.println("         ATM INTERFACE");
        System.out.println("==================================");

        System.out.print("Enter User ID: ");
        String enteredId = sc.nextLine();

        System.out.print("Enter PIN: ");
        String enteredPin = sc.nextLine();

        if (enteredId.equals(userId) && enteredPin.equals(userPin)) {

            System.out.println("\nLogin Successful!");

            int choice;

            do {

                System.out.println("\n========== ATM MENU ==========");
                System.out.println("1. Transaction History");
                System.out.println("2. Withdraw");
                System.out.println("3. Deposit");
                System.out.println("4. Transfer");
                System.out.println("5. Check Balance");
                System.out.println("6. Quit");
                System.out.print("Enter Choice: ");

                choice = sc.nextInt();

                switch (choice) {

                    case 1:
                        System.out.println("\n----- Transaction History -----");

                        if (history.isEmpty()) {
                            System.out.println("No Transactions Found.");
                        } else {
                            for (String transaction : history) {
                                System.out.println(transaction);
                            }
                        }
                        break;

                    case 2:
                        System.out.print("Enter Amount to Withdraw: ");
                        double withdrawAmount = sc.nextDouble();

                        if (withdrawAmount <= balance) {
                            balance -= withdrawAmount;
                            history.add("Withdraw: Rs." + withdrawAmount);
                            System.out.println("Withdrawal Successful!");
                            System.out.println("Remaining Balance: Rs." + balance);
                        } else {
                            System.out.println("Insufficient Balance!");
                        }
                        break;

                    case 3:
                        System.out.print("Enter Amount to Deposit: ");
                        double depositAmount = sc.nextDouble();

                        balance += depositAmount;
                        history.add("Deposit: Rs." + depositAmount);

                        System.out.println("Deposit Successful!");
                        System.out.println("Current Balance: Rs." + balance);
                        break;

                    case 4:
                        sc.nextLine();

                        System.out.print("Enter Receiver Account Number: ");
                        String accountNo = sc.nextLine();

                        System.out.print("Enter Amount to Transfer: ");
                        double transferAmount = sc.nextDouble();

                        if (transferAmount <= balance) {

                            balance -= transferAmount;

                            history.add("Transfer Rs." +
                                    transferAmount +
                                    " to Account " +
                                    accountNo);

                            System.out.println("Transfer Successful!");
                            System.out.println("Remaining Balance: Rs." + balance);

                        } else {
                            System.out.println("Insufficient Balance!");
                        }

                        break;

                    case 5:
                        System.out.println("Current Balance: Rs." + balance);
                        break;

                    case 6:
                        System.out.println("Thank You For Using ATM!");
                        break;

                    default:
                        System.out.println("Invalid Choice!");
                }

            } while (choice != 6);

        } else {

            System.out.println("Invalid User ID or PIN!");
        }

        sc.close();
    }
}
