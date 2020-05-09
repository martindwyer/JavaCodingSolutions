package animalstuff;

import java.util.Objects;

/**
 * Horse class for constructing horse objects
 * 
 * @author Martin Dwyer
 * 
 * Prepared for ITEC 6130, Walden University, March 15, 2019
 */
public class Horse extends Mammal {
    
    /**
     * Primary constructor for horses
     */
    public Horse() {
        super("Horse");
    }
    
    /**
     * Method for determining movement 
     * @param fast if true, slow if false
     * @return String description of movement
     */
    @Override
    public String movement(boolean fast) {
        String result;
        if(fast) {
            result = "I run real fast on four legs";
        } else {
            result = "I walk on four legs";
        }
        return result;
    }
    
    
    /**
     * Method for describing sound
     * @return String sound description
     */
    @Override
    public String sound() {
        return "Neigh Neigh";
    }
    
    /**
     * An object method to determine equality with another object
     * @param obj an object
     * @return true if equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Horse other = (Horse) obj;
        if (!Objects.equals(this.kind, other.kind)) {
            return false;
        }
        if (!Objects.equals(this.integument, other.integument)) {
            return false;
        }
        return true;
    }
}
