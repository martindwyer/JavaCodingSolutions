
package planning;

// CHANGED for ABSTRACT FACTORY IMPLEMENTATION

import data.Capability;
import data.ResponderInformation;

/**
 *
 * @author Martin Dwyer
 */
public class PlanFactory implements AbstractPlanFactory {

    // CHANGED for ABSTRACT FACTORY IMPLEMENTATION
 
    public static Plan makeNewPlan(Interview interview) {
        Plan plan;
        if (AbstractPlanFactory.getSpillCase(interview).equalsIgnoreCase("acidChloride")) {
            plan = new AcidSpillPlan(interview);
        } else {
            plan = new NonAcidSpillPlan(interview);
        }
	return plan;
    }
    
    // CHANGED for ABSTRACT FACTORY IMPLEMENTATION
    
    public static Plan buildActionPlan(Planner planner,
            Interview interview) {
        System.err.println("Building plan for " + interview);
        String contact = interview.firstName + " " + interview.lastName;
        
        // CHANGED for ABSTRACT FACTORY IMPLEMENTATION        
        Plan p = makeNewPlan(interview);
        ResponderInformation r = planner.getResponder(contact, interview.materialSpilled);
        if (r != null) {
            // responder found
            if (r.capabilities().contains(Capability.chemicalResponder)) {
                // is a qualified chemical responder
                p = makeNewPlan(interview);
                p.setAreaInfo(planner.findArea(interview.room,
                        interview.building));
            } else {
                p = planner.theDefaultPlan.clone(interview);
            }
            if (p.getAreaInfo() != null) {
                // area was recognized
                p.notifications.add(p.getAreaInfo().getResponsibleParty());
                String kitLoc = p.getAreaInfo().nearSpillKit();
                String[] parms = kitLoc.split(" ");
                System.err.println("Spill kit loc = " + kitLoc + " or "
                        + parms[1] + "," + parms[2]);
                planner.consumeSpillKit(parms[1], parms[2]);
            } else {
                // area was not recognized
                p.setAreaInfo(planner.getEhsAreaInfo());
            }
        } else {
            // responder is not qualified
            p = planner.theDefaultPlan.clone(interview);
        }
        p.responders.addAll(planner.defaultResponders);
        if (interview.spillSize > 12) {
            p.notifications.add("large spill must notify EHS");
        }
        // TODO: check for EHS notification requirements
        System.err.println("got plan");
        return p;
    }

}
