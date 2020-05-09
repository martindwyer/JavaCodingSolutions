package threads;

import java.util.Date;
import java.sql.Timestamp;


// CHANGED for THREAD IMPLEMENTATION
// ENTIRE CLASS FILE

/**
 * Class for view thread objects
 * 
 * @author Martin Dwyer
 * @date 2019.10.10
 * 
 */
public class ViewThreads {

    public static void main(String[] args) throws InterruptedException {
        
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);

        ViewThread newViewThread = new ViewThread();
        System.out.println("NEW VIEW THREAD CREATED: " + newViewThread.getName() + " AT: " + ts);
        
        newViewThread.start();

        
    }

}
