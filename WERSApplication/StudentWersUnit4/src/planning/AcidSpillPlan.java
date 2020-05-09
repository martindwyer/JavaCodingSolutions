package planning;

// CHANGED for ABSTRACT FACTORY IMPLEMENTATION

import data.ResponderInformation;
import java.util.Vector;

/**
 *
 * @author Martin Dwyer
 */
public class AcidSpillPlan extends Plan {

    // CHANGED for ABSTRACT FACTORY IMPLEMENTATION
    
    public AcidSpillPlan(Interview interview) {
        state = ResponseState.immediate;
        this.interview = interview;

        responders = new Vector<ResponderInformation>();
        location = "unknown";
        immediateActions = new Vector<String>();
        immediateActions.add("1. Notify lab personnel and neighbors of the accident.");
        immediateActions.add("2. Isolate the area. Close lab doors and evacuate the immediate area if necessary.");
        immediateActions.add("3. Remove ignition sources and unplug nearby electrical equipment.");
        immediateActions.add("4. Establish exhaust ventilation. Vent vapors to outside of building only (open windows and turn on fume hoods.");

        containActions = new Vector<String>();
        containActions.add("5. Locate spill kit.");
        containActions.add("6. Choose appropriate personal protective equipment (goggles, face shield, impervious gloves, lab coat, apron, etc.) Note: All lab personnel MUST be properly fit tested before using a respirator. Contact EH&S (855-6311) for more information.()");
        containActions.add("7. Confine and contain spill. Cover with appropriate absorbent material. Acid and base spills should be neutralized prior to cleanup. Sweep solid material into a plastic dust pan and place in a sealed 5 gallon container.)");
        containActions.add("8. Wet mop spill area. Be sure to decontaminate broom, dustpan, etc. Put all contaminated items (gloves, clothing, etc.) into a sealed 5 gallon container or plastic bag. Bring all waste to the next Waste Open House or call EH&S if a special pickup is necessary.");

        // CHANGED for ABSTRACT FACTORY IMPLEMENTATION
        
        String[] aa = {"oil-dri", "zorb-al", "dry sand"};
        absorbents = new Absorbents();
        absorbents.setAbsorbents(aa);
        String[] ac = {"avoid water", "avoid sodium bicarbonate"};
        cautions = new Cautions();
        cautions.setCautions(ac);

        notifications = new Vector<String>();
        if (getAreaInfo() != null) {
            responsibleParty = getAreaInfo().getResponsibleParty();
        }
        notifications.add(responsibleParty);

    }
       
}
