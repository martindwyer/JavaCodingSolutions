package scenarios;

import mvc.AdminView;
import mvc.ResponderView;
import mvc.WERSController;

/**
 * Simple simulation of two responders and one administrator situation.
 *   Connects responder and admin views and controller.
 *   Controller connects to plans and administrator and registers then
 *     the plan for the Observer pattern.
 */
public class TwoViewAdmin {

	public static void main(String[] args) {

		// create Model
		WERSController controller = new WERSController();
                
                AdminView av = new AdminView();
		
                // CHANGED for OBSERVER IMPLEMENTATION
		controller.addView(av);
		av.addController(controller);

		// add views to Controller (thence to Model).
		ResponderView myView1 = new ResponderView();
		controller.addView(myView1);
		myView1.addController(controller);

		ResponderView myView2 = new ResponderView();
		controller.addView(myView2);
		myView2.addController(controller);

		

	}

}
