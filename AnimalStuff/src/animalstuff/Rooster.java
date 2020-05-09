package animalstuff;

import java.util.Objects;

/**
 * Rooster class for construction of all sorts of birds
 * 
 * @author Martin Dwyer
 * 
 * Prepared for ITEC 6130, Walden University, March 15, 2019
 */
public class Rooster extends Bird {
    
    /**
     * Primary constructor for Rooster objects
     * 
     */
    public Rooster() {
        super("Rooster");
    }
    
    /**
     * Instance method for movement speed
     * @param fast true if fast, false is slow
     * @return a String describing the movement method
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
        return "Cock-a-doodle-doo";
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
        final Rooster other = (Rooster) obj;
        if (!Objects.equals(this.kind, other.kind)) {
            return false;
        }
        if (!Objects.equals(this.integument, other.integument)) {
            return false;
        }
        return true;
    }
    
}
