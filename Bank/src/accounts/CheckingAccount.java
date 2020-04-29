/*
	Student:  	Martin Dwyer
	Assignment: 	Unit 3 Application
	Class: 		ITEC 6130, Walden University
	Date: 		Week ending March 24, 2019
	Description: 	This application illustrates the use of abstract classes
 */
package accounts;

import static Bank.Operations.balanceToString;

/**
 * CheckingAccount is used to create checking account objects and to hold methods 
 * which are unique to checking accounts.
 * 
 * @author Martin Dwyer
 */
public class CheckingAccount extends BankAccount {

    /**
     * CheckingAccount constructor uses the framework from the abstract class
     * BankAccount for creating new checking accounts
     * 
     * @param name a String representing the account holder
     * @param balance an integer representing the opening balance in cents
     */
    public CheckingAccount(String name,int balance) {
        super(name, balance);
    }

    /**
     * Method for writing checks out of checking account objects.  If the account has 
     * sufficient funds, and the check is within size limits, the method returns a 
     * string appropriate to be written on a check for the amount description
     * 
     * @param cents the amount of the check to be written in cents
     * @return a String representing the check amount, or an error if the amount of
     * the check is inappropriate
     */
    public String writeCheck(int cents) {
        String result = null;
        boolean isTooLarge = false;
        boolean isTooSmall = false;
        if (cents >= 100000000) {
            isTooLarge = true;
            result = "ITEM TOO LARGE FOR AUTOMATED PROCESSING (Over $1 Million)";
        } else if(cents <= 9) {
            isTooSmall = true;
            result = "ITEM TOO SMALL (MUST BE OVER $0.09)";
        }
        if (!isTooLarge && !isTooSmall) {
            if (cents <= this.accountBalance) {
                result = Bank.Operations.balanceToString(cents);
                this.accountBalance -= cents;
            } else {
                result = "INSUFFICIENT FUNDS";
            }
        }
        return result;
    }
}
