/*
	Student:  	Martin Dwyer
	Assignment: 	Unit 3 Application
	Class: 		ITEC 6130, Walden University
	Date: 		Week ending March 24, 2019
	Description: 	This application illustrates the use of abstract classes
 */
package accounts;

/**
 * BankAccount is an abstract class representing the necessary elements of bank accounts of 
 * all types.  This class is abstract, and as such cannot be used directly for the
 * instantiation of objects.
 * 
 * @author Martin Dwyer
 */
public abstract class BankAccount {
    
    /**
     * Every account has three attributes: account name, number, and balance 
     */
    public String accountName;          // name on account

    /**
     * accountNumber is assigned with the static variable nextAccountNumber
     */
    public int accountNumber;           // number assigned to account

    /**
     * accountBalance is the balance of the account
     */
    public int accountBalance;          // balance available in account
    private static int nextAccountNumber = 1567; // uused to set up new accounts
    
    /**
     * Constructor for new accounts
     * @param name a String to represent the account holder
     * @param balance an integer to represent the opening balance in cents
     */
    public BankAccount(String name, int balance) {
        this.accountName = name;
        this.accountBalance = balance;
        this.accountNumber = nextAccountNumber;       
        nextAccountNumber ++;
    }
    
    /**
     * Method for making deposits into accounts
     * @param cents an integer represent the deposit amount in cents
     */
    public void deposit(int cents) {
        this.accountBalance += cents;
    }
    
    /**
     * Method to make account withdrawals
     * @param cents the amount to be withdrawn in cents
     * @return true if withdrawal completed, false otherwise
     */
    public boolean withdraw(int cents) {
        boolean isComplete;
        if(cents <= this.accountBalance) {
            this.accountBalance -= cents;
            isComplete = true;
        } else {
            isComplete = false;
        }
        return isComplete;
    }
    
    /**
     * Method to get the balance in an account
     * @return the balance in cents (an integer)
     */
    public int balance() {
        return accountBalance;
    }
    
    /**
     * Method to transfer funds between accounts
     * 
     * @param cents an integer representing the amount to transfer
     * @param fromAccount represents the account providing the funds
     * @param toAccount represents the account receiving the funds
     * @return true if transfer can be completed, false otherwise
     */
    public static boolean transfer(int cents, BankAccount fromAccount, BankAccount toAccount) {
        boolean isComplete;
        if(cents <= fromAccount.accountBalance) {
            fromAccount.accountBalance -= cents;
            toAccount.accountBalance += cents;
            isComplete = true;
        } else {
            isComplete = false;
        }
        return isComplete;
    }
    
}
