// CHANGED for FAÇADE DECOUPLING IMPLEMENTATION

package scenarios;

import mvc.AdminView;
import mvc.ResponderView;
import mvc.WERSController;

public class Facade {
    
    // Create Model and View
    public static ResponderView view1	= new ResponderView();
    public static ResponderView view2 = new ResponderView();
        
    //create Controller. tell it about Model and View, initialize model
    //public static WERSController controller = new WERSController();
    
    public static WERSController controller = new WERSController();
    
    public static void startOneViewSession(){
        OneView.startSession();
    }
    public static void startTwoViewSession(){
        TwoView.startSession();
    }
    public static void startTwoViewAdminSession(){
        TwoViewAdmin.startSession();
        AdminView av = new AdminView(); 
    }
}
