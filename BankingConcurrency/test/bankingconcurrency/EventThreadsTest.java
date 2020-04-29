/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingconcurrency;

import java.util.ArrayList;
import java.util.TreeMap;
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
public class EventThreadsTest {
    
    /**
     * Test of newSessionThread method, of class EventThreads.
     */
    @Test
    public void testNewSessionThread() {
        
        // Testing functionality of one thread
        Customer customer = new Customer();
        Account account = new Account(customer);
        EventThread newBankingSession = EventThreads.newSessionThread(customer, account);
        
        int expResult = newBankingSession.account.accountBalance + 100;
        int result = newBankingSession.account.makeDeposit(100);
         
        // Testing functionality of concurrent threads
        // Three customers : 1000 iterations
        
        ArrayList<EventThread> threads = new ArrayList<>();
        TreeMap<Customer,Account> bank = new TreeMap<>();
        for(int i = 0; i < 1000; i++) {
            Customer newCustomer = new Customer();
            Account newAccount = new Account(newCustomer);
            threads.add(EventThreads.newSessionThread(newCustomer, newAccount));
        }
        for(EventThread thread: threads) {
            expResult = thread.account.accountBalance + 100;
            result = thread.account.makeDeposit(100);
            assertEquals("makeDeposit() fails",expResult, result);
        
            
        }
        
    }
    
    
    
}
