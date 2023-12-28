package placement_training;
public class BankAccount {
    private int accountId;
    private String name;
    private double balance;

    public BankAccount(int accountId, String name, double balance) {
        this.accountId = accountId;
        this.name = name;
        this.balance = balance;
    }

    public boolean transfer(BankAccount recipient, double amount) {
        if (balance >= amount) {
            balance -= amount;
            recipient.balance += amount;
            return true;
        } else {
            System.out.println("Insufficient funds for the transfer.");
            return false;
        }
    }

    public void printReceipt() {
        System.out.println("Account id: " + accountId);
        System.out.println("Name: " + name);
        System.out.println("Account Balance: Rs. " + balance);
        System.out.println();
    }

    public static void main(String[] args) {
        // Create Account A and Account B
        BankAccount accountA = new BankAccount(12344, "Account A", 5000);
        BankAccount accountB = new BankAccount(56789, "Account B", 2500);

        // Transfer amount of 1500 from Account A to B
        if (accountA.transfer(accountB, 1500)) {
            System.out.println("Receipt after transferring 1500 from Account A to B:");
            accountA.printReceipt();
            accountB.printReceipt();
        }

        // Transfer amount of 3000 from Account B to A
        if (accountB.transfer(accountA, 3000)) {
            System.out.println("Receipt after transferring 3000 from Account B to A:");
            accountA.printReceipt();
            accountB.printReceipt();
        }
    }
}
