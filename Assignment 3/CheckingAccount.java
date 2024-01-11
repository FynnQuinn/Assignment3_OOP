public class CheckingAccount extends Account {
    private double insufficientFee = 10.0;

    public CheckingAccount() {
        super();
    }

    public CheckingAccount(double init_balance) {
        super(init_balance);
    }

    @Override
    public boolean withdraw(double amount) {
        boolean result = false;
        if (balance >= amount) {
            balance -= amount;
            result = true;
        } else {
            balance -= amount + insufficientFee;
        }
        return result;
    }

}
