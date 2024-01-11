public class SavingAccount extends Account {
    private double annualInterest = 0.0025;

    public SavingAccount() {
        super();
    }

    public SavingAccount(double init_balance) {
        super(init_balance);
    }

    public boolean monthlyInterestDeposit(double amount) {
        balance += (amount * annualInterest) / 12;
        balance += amount;
        return true;
    }

}
