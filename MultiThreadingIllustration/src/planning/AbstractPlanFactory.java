
package planning;

// CHANGED for ABSTRACT FACTORY IMPLEMENTATION

/**
 *
 * @author Martin Dwyer
 */
public interface AbstractPlanFactory {
    
    
    // CHANGED for ABSTRACT FACTORY IMPLEMENTATION
    static String getSpillCase(Interview interview) {
        String s = interview.materialSpilled.toString();
        return s;
    };
    
}
