/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package planning;

import java.util.HashMap;
import mvc.ResponderView;

/**
 *
 * @author marti
 */
public interface PlanFacade {
    
    HashMap<ResponderView, Plan> viewPlanMap = new HashMap<ResponderView, Plan>();
    
    public static Planner getThePlanner() {
        Planner planner = Planner.getThePlanner();
        return planner;
    }
}
