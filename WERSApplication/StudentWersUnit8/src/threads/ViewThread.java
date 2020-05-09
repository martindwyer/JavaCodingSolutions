package threads;

// CHANGED for THREAD IMPLEMENTATION
import java.sql.Timestamp;
import java.util.Date;
import mvc.ResponderView;
import mvc.WERSController;

// ENTIRE CLASS FILE
/**
 * Class for view threads
 *
 * @author Martin Dwyer
 * @date 2019.10.10
 *
 */
public final class ViewThread extends Thread {

    @Override
    public void run() {
        try {
            Date date = new Date();
            long time = date.getTime();
            Timestamp ts = new Timestamp(time);

            WERSController controller = new WERSController();
            ResponderView view = new ResponderView();
            controller.addView(view);
            view.addController(controller);

            System.out.println("RESPONDER VIEW CREATED: " + view.toString() + 
                    " ON THREAD: " + ViewThread.currentThread().getName() + 
                    " at time: " + ts);
            System.out.println("CONTROLLER CREATED: " + controller.toString() + 
                    " ON THREAD: " + ViewThread.currentThread().getName() + 
                    " at time: " + ts);
            System.out.println("PLANNER DEPLOYED: " + controller.planner.toString() + 
                    " ON THREAD: " + ViewThread.currentThread().getName() + 
                    " at time: " + ts);
            
        } catch (Exception e) {
            // Throwing an exception 
            System.out.println("Exception is caught");
        }
    }

}
