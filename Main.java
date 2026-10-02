import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Bank bank = new Bank();

        while(true) {

            System.out.println("\n=====BANKING MANAGEMENT SYSTEM=====");

            System.out.println("1. Create Account");

            System.out.println("2. Deposit");

            System.out.println("3. Withdraw");

            System.out.println("4. Check Balance");

            System.out.println("5. Transfer Money");

            System.out.println("6. Transaction History");

            System.out.println("7. Exit");

            System.out.println("Enter choice:");

            int choice = sc.nextInt();
            try {
                switch(choice) {
                    case 1: System.out.println("Account Number: ");
                            int accNo = sc.nextInt();
                            sc.nextLine();

                            System.out.println("Holder Name: ");
                            String name = sc.nextLine();

                            System.out.println("Create PIN: ");
                            String pin = sc.nextLine();

                            System.out.println("Initial Balance: ");
                            double balance = sc.nextDouble();

                            bank.createAccount(new Account(accNo, name, pin, balance));
                            break;

                    case 2: System.out.println("Account Number: ");
                            accNo = sc.nextInt();

                            Account account = bank.getAccount(accNo);

                            if(account == null) {
                            System.out.println("Account not found.");
                            break;
                            }

                            System.out.println("Amount: ");
                            double amount = sc.nextDouble();
                            account.deposit(amount);

                            System.out.println("Money Deposit Successfully.");
                            break;

                    case 3: System.out.println("Account Number: ");
                            accNo = sc.nextInt();

                            account = bank.getAccount(accNo);

                            if(account == null) {
                                System.out.println("Account not found.");
                                break;
                            }

                            System.out.println("Amount: ");
                            amount = sc.nextDouble();

                            account.withdraw(amount);

                        System.out.println("Money Withdraw Successfully.");
                        break;

                    case 4: System.out.println("Account Number: ");
                            accNo = sc.nextInt();

                            account = bank.getAccount(accNo);

                            if(account == null) {
                                System.out.println("Account not found.");
                            }
                            else {
                                System.out.println("Balance: Rs." + account.getBalance());
                            }
                            break;

                    case 5: System.out.println("Sender Account: ");
                            int sender = sc.nextInt();

                            System.out.println("Receiver Account: ");
                            int receiver = sc.nextInt();

                            System.out.println("Amount: ");
                            amount = sc.nextDouble();

                            bank.transfer(sender, receiver, amount);
                            break;

                    case 6: System.out.println("Account Number: ");
                            accNo = sc.nextInt();

                            account = bank.getAccount(accNo);

                            if(account == null) {
                                System.out.println("Account not found.");
                            }
                            else {
                                account.showTransaction();
                            }
                            break;

                    case 7: System.out.println("Thank You!");
                            sc.close();
                            return;

                    default: System.out.println("Invalid choice.");
                }
            }
            catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
