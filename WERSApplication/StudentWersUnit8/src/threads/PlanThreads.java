package threads;

import java.sql.Timestamp;
import java.util.Date;
import mvc.WERSController;
import mvc.ResponderView;
import planning.Interview;
import planning.Plan;
import planning.Planner;

// CHANGED for THREAD IMPLEMENTATION
// ENTIRE CLASS FILE

/**
 * Class for planning thread objects
 * 
 * @author Martin Dwyer
 * @date 2019.10.10
 * 
 */
public class PlanThreads {

    public static void main(String[] args) throws InterruptedException {

    }

    public static Plan newPlanThread(Planner planner, Interview interview) {
        
                
        Date date = new Date();
        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        
        PlanThread newPlanThread = new PlanThread();
        System.out.println("NEW PLANNING THREAD CREATED: " + newPlanThread.getName() + " IS ALIVE AT: " + ts);
        newPlanThread.start();
        newPlanThread.plan = Plan.buildActionPlan(planner, interview);

        return newPlanThread.plan;
        
        
    }

}
