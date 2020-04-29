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
 * JUnit test class for CheckingAccount
 * 
 * @author Martin Dwyer
 */
public class CheckingAccountTest {
    
    /**
     * Test of writeCheck method, of class CheckingAccount.
     */
    @Test
    public void testWriteCheck() {
        System.out.println("Testing CheckingAccount.writeCheck");
        CheckingAccount account = new CheckingAccount("Barney Rubble",100000000);
        // Testing where check can be written
        String result = account.writeCheck(150000);
        String expResult = "ONE THOUSAND FIVE HUNDRED DOLLARS AND 0 CENTS";
        assertEquals("Testing for write check fails when funds available",expResult,result);
        // Testing different check amounts
        result = account.writeCheck(45852648);
        expResult = "FOUR HUNDRED FIFTY EIGHT THOUSAND FIVE HUNDRED TWENTY SIX DOLLARS AND 48 CENTS";
        assertEquals("Testing for write check fails when funds available",expResult,result);
        result = account.writeCheck(164289);
        expResult="ONE THOUSAND SIX HUNDRED FORTY TWO DOLLARS AND 89 CENTS";
        assertEquals("Testing for write check fails when funds available",expResult,result);
        result = account.writeCheck(5845236);
        expResult="FIFTY EIGHT THOUSAND FOUR HUNDRED FIFTY TWO DOLLARS AND 36 CENTS";
        assertEquals("Testing for write check fails when funds available",expResult,result);
        result = account.writeCheck(500);
        expResult="FIVE DOLLARS AND 0 CENTS";
        assertEquals("Testing for write check fails when funds available",expResult,result);
        // Testing for items too small (under $0.10)
        result = account.writeCheck(2);
        expResult = "ITEM TOO SMALL (MUST BE OVER $0.09)";
        assertEquals("Testing for write check fails when item too small",expResult,result);
        // Testing for items too large 
        result = account.writeCheck(200000000);
        expResult = "ITEM TOO LARGE FOR AUTOMATED PROCESSING (Over $1 Million)";
        assertEquals("Testing for write check fails when item too large",expResult,result);
        // Testing for insufficient funds
        result = account.writeCheck(60000000);
        expResult = "INSUFFICIENT FUNDS";
        assertEquals("Testing for write check fails when insufficient funds",expResult,result);
    }
    
    /**
     * Test of deposit method, of class BankAccount
     */
    @Test
    public void testDeposit() {
        System.out.println("Testing CheckingAccount.deposit");
        CheckingAccount account = new CheckingAccount("Barney Rubble",5000000);
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
        System.out.println("Testing CheckingAccount.withdraw");
        CheckingAccount account = new CheckingAccount("Barney Rubble",5000000);
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
        System.out.println("Testing CheckingAccount.balance");
        CheckingAccount account = new CheckingAccount("Barney Rubble",5000000);
        int expResult = 5000000;
        int result = account.balance();
        assertEquals(expResult, result);
    }

    /**
     * Test of transfer method, of class BankAccount.
     */
    @Test
    public void testTransfer() {
        System.out.println("Testing CheckingAccount.transfer");
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
