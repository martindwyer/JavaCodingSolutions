package scenarios;

import mvc.ResponderView;
import mvc.WERSController;
import threads.ViewThreads;

/**
 * Simple simulation of one responder view. Connects responder view and
 * controller. Controller connects to planer and registers the view with the
 * plan for the Observer pattern.
 *
 */
public class OneView {

    public static void main(String[] args) throws InterruptedException {
        
        // CHANGED for THREAD IMPLEMENTATION
        // METHODS DECOUPLED TO THREAD OBJECT CLASS ViewThreads

        String[] arg = new String[0];
        ViewThreads.main(arg);
        
    }

}
