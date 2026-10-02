import java.util.HashMap;
import java.util.Map;

public class Bank {
    private Map<Integer, Account> accounts = new HashMap<>();

    public void createAccount(Account account) {
        if(accounts.containsKey(account.getAccountNumber())) {
            System.out.println("Account already exists.");
            return;
        }

        accounts.put(account.getAccountNumber(), account);

        System.out.println("Account created successfully.");
    }

    public Account getAccount(int accountNumber) {
        return accounts.get(accountNumber);
    }

    public void transfer(int from, int to, double amount) {
        Account sender = accounts.get(from);
        Account receiver = accounts.get(to);
        if(sender == null || receiver == null) {
            System.out.println("Account not found.");
            return;
        }
        sender.withdraw(amount);
        receiver.deposit(amount);

        System.out.println("Money transferred successfully.");
    }
}
