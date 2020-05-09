package scenarios;

//import mvc.ResponderView;
//import mvc.WERSController;

/**
 * Simple simulation of one responder view.
 * Connects responder view and controller.
 * Controller connects to planer and registers 
 *   the view with the plan for the Observer pattern.
 *
 */
public class OneView extends Facade {
	
    // CHANGED for FAÇADE DECOUPLING IMPLEMENTATION
    public static void startSession() {
        
        controller.addView(view1);
        view1.addController(controller);
        
    }

}
