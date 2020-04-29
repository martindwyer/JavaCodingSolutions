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
public class EventThreads {

    public static void main(String[] args) throws InterruptedException {
        //EventThread newSession = new EventThread();
        //newSession.start();
    }
    
    public static EventThread newSessionThread(Customer customer,Account account) {        
                
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        
        EventThread newSessionThread = new EventThread();
        System.out.println("NEW PLANNING THREAD CREATED: " + newSessionThread.getName() + " IS ALIVE AT: " + ts);
        newSessionThread.customer = customer;
        newSessionThread.account = account;
        newSessionThread.start();
        return newSessionThread;

    }
    
    


}
