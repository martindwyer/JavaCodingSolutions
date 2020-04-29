package planning;

import java.util.Vector;
import java.util.HashMap;

import mvc.ResponderView;

import data.AreaDb;
import data.AreaInformation;
import data.ResponderInformation;
import data.ResponderDb;
import exceptions.LocationNotFoundException;
import exceptions.ResponderNotFoundException;
import threads.PlanThreads;


/*
 * A singleton planner instantiating data base and standard plan elements
 * primary purpose is to map views to models and establish correct observation
 * */

public class Planner { 

	public static Planner thePlanner = null;
	public Vector<Plan> plans = null;
	
	private final AreaDb areaDb = AreaDb.getDb();
	final private ResponderDb responderDb = ResponderDb.getDb();
	
	
	public Vector<ResponderInformation> defaultResponders = null;
	public DefaultPlan theDefaultPlan = null;
	Vector<ResponderView> views = new Vector<ResponderView>();

	HashMap<ResponderView, Plan> planMap = new HashMap<ResponderView, Plan>();


	public Planner() {
		plans = new Vector<Plan>();
		defaultResponders = new Vector<ResponderInformation>();
		ResponderInformation r = responderDb.get("EHS"); // EHS should always be there!
		defaultResponders.add(r);
		r = responderDb.get("Public Safety"); // Public Safety should always be there!
		defaultResponders.add(r);
		theDefaultPlan = new DefaultPlan();
	}

	// return the singleton planner - creating a planner if none exists
	public static Planner getThePlanner() {
		if (thePlanner == null)
			thePlanner = new Planner();
		return thePlanner;
	}

	// return a plan from information given for interview
	// used by unit tests
	public Plan getPlan(String[] inputs, SpillCase spill, int sz) {
		Interview interview = new Interview(inputs, spill, sz);
		return getPlan(interview);
	}

	// returns a plan determined by contents of the interview
	private Plan getPlan(Interview interview) {
                // CHANGED for THREAD IMPLEMENTATION
                // METHODS DECOUPLED TO THREAD OBJECT CLASS PlanThreads
                Plan p = PlanThreads.newPlanThread(this,interview);
		plans.add(p);
		return p;
	}

	// record a responder view in the planner
	// TODO: complete view <--> plan map
	public void addView(ResponderView v) {
		System.out.println("Planner: adding view" + v);
		views.add(v);
	}

	// TODO: change to AdminView
	public void registerView(ResponderView view) {
		this.views.add(view);	
	}

	// find a responder in the database 
	// exceptions for name not found or name not qualified
	// TODO: eventually improve name match
        // CHANGED for CATCH-THROW IMPLEMENTATION
        // METHOD NO LONGER RETURNS NULL OBJECTS 
	ResponderInformation getResponder(String contact, SpillCase material) 
                throws ResponderNotFoundException {
		
                ResponderInformation r = responderDb.get(contact);
                
                if(r == null) throw new ResponderNotFoundException();
                
		return r;
	}

        // CHANGED for CATCH-THROW IMPLEMENTATION
        // METHOD NO LONGER RETURNS NULL OBJECTS 
	// return area information information
	public AreaInformation findArea(String rm, String bldg) 
                                        throws LocationNotFoundException {
		//AreaInfo info = database.getArea(rm, bldg);
		AreaInformation info = null;
                int bldgNo = 0;
		int roomNo = 0;
		try {
			bldgNo = Integer.parseInt(bldg);
		} catch (NumberFormatException e) {
			bldgNo = 0;
		}
		try {
			roomNo = Integer.parseInt(rm);
		} catch (NumberFormatException e) {
			roomNo = 0;
		}
		// just return EHS if building, room unrecognized!
                if (bldgNo == 0) {
                    throw new LocationNotFoundException();
                } else {
                    info = areaDb.find(bldgNo, roomNo);    
                }
                
		return info;
		
	}

	// EHS information used as a default
	public AreaInformation getEhsAreaInfo() {
		return areaDb.ehsAreaInfo;
	}
        
        
    // CHANGED for THREAD SAFETY IMPLEMENTATION
	public synchronized void consumeSpillKit(String building, String room) {
		/// database.consumeSpillKit(building,room);
                
		int rm = Integer.parseInt(room);
		int bldg = Integer.parseInt(building);
		areaDb.consumeSpillKit(bldg, rm);
                
                
	}
	

}