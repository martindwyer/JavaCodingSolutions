package animalstuff;

import java.util.Objects;

/**
 * Human class for constructing human objects
 * 
 * @author Martin Dwyer
 * 
 * Prepared for ITEC 6130, Walden University, March 15, 2019
 */
public class Pig extends Mammal {
    
    /**
     * Primary constructor for humans
     */
    public Pig() {
        super("Pig");
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
            result = "I run real fast on four legs for very short distances";
        } else {
            result = "I walk very slowly on four legs";
        }
        return result;
    }
    
    /**
     * Method for describing sound
     * @return String sound description
     */
    @Override
    public String sound() {
        return "Oink oink oink";
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
        final Pig other = (Pig) obj;
        if (!Objects.equals(this.kind, other.kind)) {
            return false;
        }
        if (!Objects.equals(this.integument, other.integument)) {
            return false;
        }
        return true;
    }
}
