/*
	Student:  	Martin Dwyer
	Assignment: 	Unit 3 Application
	Class: 		ITEC 6130, Walden University
	Date: 		Week ending March 24, 2019
	Description: 	This application illustrates the use of abstract classes
 */
package accounts;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit test class for SavingsAccount
 * 
 * @author Martin Dwyer
 */
public class SavingsAccountTest {
    
    /**
     * Test of deposit method, of class BankAccount
     */
    @Test
    public void testDeposit() {
        System.out.println("Testing SavingsAccount.deposit");
        SavingsAccount account = new SavingsAccount("Barney Rubble",5000000);
        int cents = 1200000;
        account.deposit(cents);
        int expResult = 5000000 + 1200000;
        int result = account.balance();
        assertEquals("Test fails for deposit",expResult,result);
    }

    /**
     * Test of withdraw method, of class BankAccount.
     */
    @Test
    public void testWithdraw() {
        System.out.println("Testing SavingsAccount.withdraw");
        SavingsAccount account = new SavingsAccount("Barney Rubble",5000000);
        // Testing where sufficient funds are available for withdrawal
        int cents = 1200000;
        boolean expResult = true;
        boolean result = account.withdraw(cents);
        assertEquals(expResult, result);
        // Testing where sufficient funds are not available for withdrawal
        cents = 120000000;
        expResult = false;
        result = account.withdraw(cents);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of balance method, of class BankAccount.
     */
    @Test
    public void testBalance() {
        System.out.println("Testing SavingsAccount.balance");
        SavingsAccount account = new SavingsAccount("Barney Rubble",5000000);
        int expResult = 5000000;
        int result = account.balance();
        assertEquals(expResult, result);
    }

    /**
     * Test of transfer method, of class BankAccount.
     */
    @Test
    public void testTransfer() {
        System.out.println("Testing SavingsAccount.transfer");
        // Testing where sufficient funds are available
        CheckingAccount checking = new CheckingAccount("Barney Rubble",5000000);
        SavingsAccount savings = new SavingsAccount("Barney Rubble",36500000);
        int cents = 5000000;
        boolean expResult = true;
        boolean result = BankAccount.transfer(cents, savings, checking);
        assertEquals(expResult, result);
        // Testing where sufficient funds are not available
        cents = 500000000;
        expResult = false;
        result = BankAccount.transfer(cents, savings, checking);
        assertEquals(expResult, result);
    }

    
}
