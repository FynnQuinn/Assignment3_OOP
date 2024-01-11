import java.lang.annotation.IncompleteAnnotationException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Bank Account\n");

        Account savingAccount = new SavingAccount();
        Account checkingAccount = new CheckingAccount();

        do {
            int choice;
            System.out.println("1. Saving");
            System.out.println("2. Checking");
            System.out.println("3. Exit\n");

            System.out.print("Choose your option: ");
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid option. Integer only!\n");
                input.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    subMenu(savingAccount);
                    break;
                case 2:
                    subMenu(checkingAccount);
                    break;
                case 3: {
                    System.out.println("Thank you for using our service.");
                    System.exit(0);
                }
                    ;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.\n");
                    break;
            }

        } while (true);

    }

    public static void subMenu(Account account) {
        Scanner input = new Scanner(System.in);
        int choice;
        do {
            System.out.println("1. Deposit");
            System.out.println("2. Balance");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit\n");

            System.out.print("Choose your option: ");
            try {
                choice = input.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid option. Integer only!\n");
                input.nextLine();
                continue;
            }

            switch (choice) {
                case 1: {
                    System.out.print("Enter amount to deposit: RM");
                    double amount = input.nextDouble();
                    if (amount <= 0) {
                        System.out.println("Invalid amount. Please try again.\n");
                        break;
                    }
                    if (account instanceof SavingAccount) {
                        ((SavingAccount) account).monthlyInterestDeposit(amount);
                    } else {
                        account.deposit(amount);
                    }
                    System.out.println();
                }

                    ;
                    break;
                case 2: {
                    System.out.printf("Your balance: RM %.2f\n\n", account.getBalance());
                }
                    ;
                    break;
                case 3: {
                    System.out.print("Enter amount to withdraw: RM");
                    double amount = input.nextDouble();

                    if (account instanceof CheckingAccount) {
                        ((CheckingAccount) account).withdraw(amount);
                        System.out.println();
                    } else {
                        System.out
                                .println(account.withdraw(amount) ? "Withdraw successfully.\n" : "Withdraw failed.\n");
                    }
                }
                    ;
                    break;
                case 4:
                    return;
                default:
                    System.out.println("Invalid option. Please try again.\n");
                    break;
            }
        } while (true);
    }
}