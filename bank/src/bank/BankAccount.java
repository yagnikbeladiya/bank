package bank;

public class BankAccount {
          String accountNumber;
           double balance;
           double depositLimit;
           double withdrawalLimit;
           double minimumBalance;

    public BankAccount(String accountNumber, double initialBalance, double depositLimit, double withdrawalLimit, double minimumBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.depositLimit = depositLimit;
        this.withdrawalLimit = withdrawalLimit;
        this.minimumBalance = minimumBalance;
    }

    public void deposit(double amount) {
        if (amount > depositLimit) {
            System.out.println("Deposit amount exceeds the deposit limit of " + depositLimit);
        } else {
            balance += amount;
            System.out.println("Deposited: " + amount);
            System.out.println("New Balance: " + balance);
        }
    }

    public void withdraw(double amount) {
        if (amount > withdrawalLimit) {
            System.out.println("Withdrawal amount exceeds the withdrawal limit of " + withdrawalLimit);
        } else if (balance - amount < minimumBalance) {
            System.out.println("Withdrawal denied. Insufficient funds to maintain the minimum balance of " + minimumBalance);
        } else {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("New Balance: " + balance);
        }
    }

    public double getBalance() {
        return balance;
    }

    public static void main(String[] args) {

        BankAccount account = new BankAccount("123456789", 1000.0, 5000.0, 1000.0, 500.0);

        System.out.println("\nAttempting to deposit 6000:");
        account.deposit(6000.0); 
        System.out.println("\nAttempting to deposit 3000:");
        account.deposit(3000.0); 

 System.out.println("\nAttempting to withdraw 2000:");
        account.withdraw(2000.0);
        System.out.println("\nAttempting to withdraw 300:");
        account.withdraw(300.0); 
        System.out.println("\nAttempting to withdraw 1500:");
        account.withdraw(1500.0); 
}
}
