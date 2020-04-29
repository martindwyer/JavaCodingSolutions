package threads;

// CHANGED for THREAD IMPLEMENTATION
// ENTIRE CLASS FILE

import java.sql.Timestamp;
import java.util.Date;
import mvc.ResponderView;
import mvc.WERSController;
import planning.Interview;
import planning.Plan;
import planning.Planner;


/**
 * Thread source for planning threads
 *
 * @author Martin Dwyer
 * @date 2019.10.10
 *
 */
public class PlanThread extends Thread {

    public Plan plan;
    public Interview interview;

    public void run() {
        try {
            Date date = new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);


            System.out.println("PLAN REQUESTED FOR VIEW: " + interview.toString() + " ON THREAD " + PlanThread.currentThread().getName() + " AT: " + ts);

        } catch (Exception e) {
            // Throwing an exception 
            System.out.println("Exception is caught");
        }
    }

}
