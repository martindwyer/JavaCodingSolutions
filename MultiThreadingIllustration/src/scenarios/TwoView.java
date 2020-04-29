package scenarios;

import mvc.ResponderView;
import mvc.WERSController;
import threads.ViewThreads;

/**
 * Simple simulation of two responder view.
 * Connects responder views and controller.
 * Controller connects to planner thence to plans and registers 
 *   the view with the plan for the Observer pattern.
 */
public class TwoView {
	
	public static void main(String [] args) throws InterruptedException {
         
        // CHANGED for THREAD IMPLEMENTATION
        // METHODS DECOUPLED TO THREAD OBJECT CLASS ViewThreads    
            
        String[] arg = new String[0];
        ViewThreads.main(arg);
        
        ViewThreads.main(arg);


	} 

}
