package planning;

import java.util.Iterator;
import java.util.Vector;

//import data.Action;
import data.AreaInformation;
import data.ResponderInformation;

/**
 * Represents one plan for a single responder. Each plan is observable so that
 * the responder may view it in the (thus slightly modified)MVC pattern.
 */
public class Plan extends java.util.Observable {

    public ResponseState state;
    public Interview interview;
    public Vector<ResponderInformation> responders;
    public String location;
    public Vector<String> immediateActions;
    public Vector<String> containActions;
    Absorbents absorbents;
    Cautions cautions;
    public Vector<String> notifications;
    public AreaInformation areaInfo;
    public String responsibleParty;
    
    // CHANGED for ABSTRACT FACTORY IMPLEMENTATION
    // Plan(Interview interview) constructor was deleted
    // buildActionPlan(Planner planner, Interview interview) moved to PlanFactory

    public String immediateActionsToString() {
        String rslt = new String();
        rslt += "\n\n\n   IMMEDIATE ACTIONS";
        Iterator<String> it = immediateActions.iterator();
        while (it.hasNext()) {
            rslt += "\n\n" + it.next();
        }
        return rslt;
    }

    public String containmentActionsToString() {
        String rslt = new String();
        // TODO: replace \n with System property value
        rslt += "\n\n\n   CONTAINMENT ACTIONS";
        Iterator<String> cit = containActions.iterator();
        while (cit.hasNext()) {
            String a = cit.next();
            rslt += "\n\n " + a.toString();
        }

        rslt += "\n\n    ABSORBENTS:";
        rslt += absorbents;
        rslt += "\n\n    SPECIAL CAUTIONS:";
        rslt += cautions;
        rslt += "\n\n    SPILL KIT LOC: " + getAreaInfo().nearSpillKit();
        return rslt;
    }

    public String notificationsToString() {
        String rslt = new String();
        Iterator<String> nit = notifications.iterator();
        while (nit.hasNext()) {
            String a = nit.next();
            if (a != null) {
                rslt += "\n\n" + a;
            }
        }
        if (!rslt.isEmpty()) {
            return "\n\n\n   REQUIRED NOTIFICATIONS" + rslt;
        } else {
            return "";
        }
    }

    public String toString() {
        String rslt = "Plan for \n" + interview.toString();
        rslt += immediateActionsToString();
        rslt += containmentActionsToString();
        rslt += notificationsToString();
        rslt += helpToString();
        return rslt;
    }

    private String helpToString() {
        String rslt = new String();
        rslt += "\n\n    FOR HELP";
        rslt += "\n\n Contact list:";
        Iterator<ResponderInformation> rit = responders.iterator();
        while (rit.hasNext()) {
            ResponderInformation r = rit.next();
            rslt += "\n" + r.getName() + " at " + r.getContacts();
        }
        return rslt;
    }

    public Plan makePlan(String[] inputs, SpillCase sc, int sz) {
        Plan p = makePlan(inputs, sc, sz);
        System.out.println("\n\n\tplan formed\n" + p);
        return p;
    }

    public void change() {
        setChanged();
        
        // CHANGED for OBSERVER IMPLEMENTATION
        notifyObservers(this.toString());
        
    }

    public String getLocation() {
        return interview.building + " " + interview.room;
    }

    public String getMaterial() {
        if (interview.materialSpilled == SpillCase.acidChloride) {
            return new String("acid chloride");
        }
        return "unknown";
    }

    public String getResponsibleParty() {
        return this.responsibleParty;
    }

    public void setAreaInfo(AreaInformation areaInfo) {
        this.areaInfo = areaInfo;
    }

    public AreaInformation getAreaInfo() {
        return areaInfo;
    }
}
