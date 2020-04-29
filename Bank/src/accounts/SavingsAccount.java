/*
	Student:  	Martin Dwyer
	Assignment: 	Unit 3 Application
	Class: 		ITEC 6130, Walden University
	Date: 		Week ending March 24, 2019
	Description: 	This application illustrates the use of abstract classes
 */
package accounts;

/**
 * SavingsAccount class is for the creation of savings accounts by extending the
 * abstract class BankAccount
 * 
 * @author marti
 */
public class SavingsAccount extends BankAccount {
    
    /**
     * Constructor creates a SavingsAccount object using the BankAccount constructor
     * framework
     * 
     * @param name a String representing the account holder
     * @param balance an integer representing the opening balance in cents
     */
    public SavingsAccount(String name, int balance) {
        super(name,balance);
    }
}
