package scenarios;

/**
 * Simple simulation of two responders and one administrator situation.
 *   Connects responder and admin views and controller.
 *   Controller connects to plans and administrator and registers then
 *     the plan for the Observer pattern.
 */
public class TwoViewAdmin extends Facade {

    // CHANGED for FAÇADE DECOUPLING IMPLEMENTATION
    public static void startSession() {
        
        controller.addView(view1);
        controller.addView(view2);
        view1.addController(controller);
        view2.addController(controller);
    }
}
