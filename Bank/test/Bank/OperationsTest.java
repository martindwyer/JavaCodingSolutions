/*
	Student:  	Martin Dwyer
	Assignment: 	Unit 3 Application
	Class: 		ITEC 6130, Walden University
	Date: 		Week ending March 24, 2019
	Description: 	This application illustrates the use of abstract classes
 */
package Bank;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * JUnit testing for Bank.Operations
 * 
 * @author Martin Dwyer
 */
public class OperationsTest {
    
    /**
     * Test of validateInput method, of class Operations.
     */
    @Test
    public void testValidateInput() {
        System.out.println("Testing Operations.validateInput");
        String menuSelection = "9";
        int expResult = 0;
        int result = Operations.validateInput(menuSelection);
        assertEquals("validateInput() fails",expResult, result);
        menuSelection = "1";
        expResult = 1;
        result = Operations.validateInput(menuSelection);
        assertEquals("validateInput() fails",expResult, result);
        menuSelection = "2";
        expResult = 2;
        result = Operations.validateInput(menuSelection);
        assertEquals("validateInput() fails",expResult, result);
        menuSelection = "3";
        expResult = 3;
        result = Operations.validateInput(menuSelection);
        assertEquals("validateInput() fails",expResult, result);
        menuSelection = "4";
        expResult = 4;
        result = Operations.validateInput(menuSelection);
        assertEquals("validateInput() fails",expResult, result);
        menuSelection = "5";
        expResult = 5;
        result = Operations.validateInput(menuSelection);
        assertEquals("validateInput() fails",expResult, result);
        menuSelection = "-100";
        expResult = 0;
        result = Operations.validateInput(menuSelection);
        assertEquals("validateInput() fails",expResult, result);
    }

    /**
     * Test of getCentsValue method, of class Operations.
     */
    @Test
    public void testGetCentsValue() {
        System.out.println("Testing Operations.getCentsValue for 12.34");
        String stringNumber = "12.34";
        int expResult = 1234;
        int result = Operations.getCentsValue(stringNumber);
        assertEquals("getCentsValue fails",expResult, result);
        System.out.println("Testing Operations.getCentsValue for $12.34");
        stringNumber = "$12.34";
        expResult = 1234;
        result = Operations.getCentsValue(stringNumber);
        assertEquals("getCentsValue fails",expResult, result);
        System.out.println("Testing Operations.getCentsValue for 12.");
        stringNumber = "12.";
        expResult = 1200;
        result = Operations.getCentsValue(stringNumber);
        assertEquals("getCentsValue fails",expResult, result);
        System.out.println("Testing Operations.getCentsValue for 12");
        stringNumber = "12";
        expResult = 1200;
        result = Operations.getCentsValue(stringNumber);
        assertEquals("getCentsValue fails",expResult, result);
    }

    /**
     * Test of getDollarString method, of class Operations.
     */
    @Test
    public void testGetDollarString() {
        System.out.println("Testing Operations.getDollarString for 1234 cents");
        int balance = 1234;
        String expResult = "$12.34";
        String result = Operations.getDollarString(balance);
        assertEquals(expResult, result);        
        System.out.println("Testing Operations.getDollarString for 123456 cents");
        balance = 123456;
        expResult = "$1,234.56";
        result = Operations.getDollarString(balance);
        assertEquals(expResult, result);
        System.out.println("Testing Operations.getDollarString for 12345678 cents");
        balance = 12345678;
        expResult = "$123,456.78";
        result = Operations.getDollarString(balance);
        assertEquals(expResult, result);

    }

    /**
     * Test of balanceToString method, of class Operations.
     */
    @Test
    public void testBalanceToString() {
       System.out.println("Testing Operations.getDollarString for 1234 cents");
        int balance = 1234;
        String expResult = "TWELVE DOLLARS AND 34 CENTS";
        String result = Operations.balanceToString(balance);
        assertEquals(expResult, result);        
        System.out.println("Testing Operations.getDollarString for 123456 cents");
        balance = 123456;
        expResult = "ONE THOUSAND TWO HUNDRED THIRTY FOUR DOLLARS AND 56 CENTS";
        result = Operations.balanceToString(balance);
        assertEquals(expResult, result);
        System.out.println("Testing Operations.getDollarString for 12345678 cents");
        balance = 12345678;
        expResult = "ONE HUNDRED TWENTY THREE THOUSAND FOUR HUNDRED FIFTY SIX DOLLARS AND 78 CENTS";
        result = Operations.balanceToString(balance);
        assertEquals(expResult, result);
    }


}
