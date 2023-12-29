package placement_training;
interface Account {
    void deposit(double amount);

    void withdraw(double amount);

    double checkBalance();
}
abstract class BankAccount1 implements Account {
    protected double balance;
    public BankAccount1(double initialBalance) {
        this.balance = initialBalance;
    }
    @Override
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or insufficient funds.");
        }
    }
    @Override
    public double checkBalance() {
        return balance;
    }
}
class SavingsAccount extends BankAccount1 {
    private double interestRate;
    public SavingsAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;
    }
    public void applyInterest() {
        double interestAmount = balance * interestRate;
        balance += interestAmount;
        System.out.println("Interest applied. New balance: $" + balance);
    }
}
class CheckingAccount extends BankAccount1 {
    private double overdraftLimit;
    public CheckingAccount(double initialBalance, double overdraftLimit) {
        super(initialBalance);
        this.overdraftLimit = overdraftLimit;
    }
    @Override
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= -overdraftLimit) {
            balance -= amount;
            System.out.println("Withdrawal successful. New balance: $" + balance);
        } else {
            System.out.println("Invalid withdrawal amount or exceeding overdraft limit.");
        }
    }
}
class LoanAccount extends BankAccount1 {
    private double interestRate;
    public LoanAccount(double initialBalance, double interestRate) {
        super(initialBalance);
        this.interestRate = interestRate;
    }
    public void applyInterest() {
        double interestAmount = balance * interestRate;
        balance += interestAmount;
        System.out.println("Interest applied. New balance: $" + balance);
    }
}
public class BankAcnt {
    public static void main(String[] args) {
        SavingsAccount savingsAccount = new SavingsAccount(1000, 0.05);
        CheckingAccount checkingAccount = new CheckingAccount(2000, 500);
        LoanAccount loanAccount = new LoanAccount(-5000, 0.1);
        System.out.println("Initial balances:");
        System.out.println("Savings Account: $" + savingsAccount.checkBalance());
        System.out.println("Checking Account: $" + checkingAccount.checkBalance());
        System.out.println("Loan Account: $" + loanAccount.checkBalance());
        savingsAccount.deposit(200);
        checkingAccount.withdraw(300);
        loanAccount.applyInterest();
        System.out.println("\nFinal balances:");
        System.out.println("Savings Account: $" + savingsAccount.checkBalance());
        System.out.println("Checking Account: $" + checkingAccount.checkBalance());
        System.out.println("Loan Account: $" + loanAccount.checkBalance());
    }
}
