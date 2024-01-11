public class Account {
    protected double balance = 0.0;

    public Account() {
    }

    public Account(double init_balance) {
        this.balance += init_balance;
    }

    public boolean deposit(double amount) {
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        boolean result = false;
        if (balance >= amount) {
            balance -= amount;
            result = true;
        }
        return result;
    }

    public double getBalance() {
        return balance;
    }
}