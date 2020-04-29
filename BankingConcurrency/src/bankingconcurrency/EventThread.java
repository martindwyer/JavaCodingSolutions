/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingconcurrency;

import java.sql.Timestamp;
import java.util.Date;

/**
 *
 * @author marti
 */
public class EventThread extends Thread {

    public Account account;
    public Customer customer;

    public void run() {
        try {
        
            Date date = new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);

            System.out.println("Session for customer: " + this.customer.toString() + " ON THREAD " + EventThread.currentThread().getName() + " AT: " + ts);
            
        } catch (Exception e) {
            // Throwing an exception 
            System.out.println("Exception is caught");
        }
    }
    


}
