package animalstuff;

import java.util.Objects;

/**
 * Turkey class for construction of all sorts of birds
 * 
 * @author Martin Dwyer
 * 
 * Prepared for ITEC 6130, Walden University, March 15, 2019
 */
public class Turkey extends Bird {
    
     /**
     * Primary constructor for Turkey objects
     * 
     */
    public Turkey() {
        super("Turkey");
    }
    
    /**
     * toString() method for bird movement description
     * @param fast a boolean true if fast, false if slow
     * @return String description of movement type
     */
    @Override
    public String movement(boolean fast) {
        String result;
        if(fast) {
            result = "I fly for short distances, and then run on two legs";
        } else {
            result = "I walk on two legs";
        }
        return result;
    }
    
    /**
     * sound() method to provide sound description
     * @return String to describe sound
     */
    @Override
    public String sound() {
        return "Gobble gobble gobble";
    }
    
    /**
     * An object method to determine equality with another Animal object
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
        final Turkey other = (Turkey) obj;
        if (!Objects.equals(this.kind, other.kind)) {
            return false;
        }
        if (!Objects.equals(this.integument, other.integument)) {
            return false;
        }
        return true;
    }
}
