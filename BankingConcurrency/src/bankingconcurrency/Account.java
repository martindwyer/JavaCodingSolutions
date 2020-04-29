package bankingconcurrency;

public class Account {
    
    public int accountNumber;
    public int accountBalance = 0;
    public int customerNumber;
    public static int nextAccountNumber = 90001;
    
    
    public Account(int customerNumber) {
        this.accountNumber = nextAccountNumber;
        this.customerNumber = customerNumber;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }
    
    public synchronized boolean withdrawal(int amount) {
        boolean validWithdrawal;
        int balance = this.getAccountBalance();
        int newBalance = balance - amount;
        if(newBalance > 0) {
            validWithdrawal = true;
            this.setAccountBalance(newBalance);
        } else {
            validWithdrawal = false;
        }
        return validWithdrawal;
    }
    
}

