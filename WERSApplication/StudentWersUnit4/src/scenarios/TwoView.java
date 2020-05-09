package scenarios;

import mvc.ResponderView;
import mvc.WERSController;

/**
 * Simple simulation of two responder view.
 * Connects responder views and controller.
 * Controller connects to planner thence to plans and registers 
 *   the view with the plan for the Observer pattern.
 */
public class TwoView {
	
	public static void main(String [] args) {
		//create Model and View
		WERSController myController = new WERSController();

		//tell Model about View. 
		ResponderView myView3 	= new ResponderView();
		myController.addView(myView3);
		myView3.addController(myController);

		
		ResponderView myView4 	= new ResponderView();
		myController.addView(myView4);
		myView4.addController(myController);
	} 

}
