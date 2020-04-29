/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingconcurrency;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marti
 */
public class AccountTest {
    
    @Test
    public void testMakeDeposit() {
        
        
        
        Customer customerOne = new Customer();
        Account accountOne = new Account(customerOne);
        
        int expResult = accountOne.accountBalance + 100;
        accountOne.makeDeposit(100);
        int result = accountOne.accountBalance;
        
        assertEquals("makeDeposit() fails",expResult, result);
        
        
        
        
    }
    
}
