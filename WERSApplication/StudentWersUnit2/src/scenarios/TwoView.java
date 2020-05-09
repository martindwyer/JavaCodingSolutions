package scenarios;


/**
 * Simple simulation of two responder view.
 * Connects responder views and controller.
 * Controller connects to planner thence to plans and registers 
 *   the view with the plan for the Observer pattern.
 */
public class TwoView extends Facade {

    // CHANGED for FAÇADE DECOUPLING IMPLEMENTATION
    public static void startSession() {
        
        controller.addView(view1);
        controller.addView(view2);
        view1.addController(controller);
        view2.addController(controller);
        
    }

}
