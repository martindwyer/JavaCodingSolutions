/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalstuff;

import java.util.Objects;

/**
 *
 * @author marti
 */
public class Mammal extends Animal {
  
    /**
     * Constructor for Mammal objects
     * @param kind String representing the kind of Mammal
     */
    public Mammal(String kind) {
        super(kind,"hair");
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
            result = "I run fast on four legs";
        } else {
            result = "I walk slow on four legs";
        }
        return result;
    }
    
    
    /**
     * sound() method to provide sound description
     * @return String to describe sound
     */
    @Override
    public String sound() {
        return "Roar";
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
        final Mammal other = (Mammal) obj;
        if (!Objects.equals(this.kind, other.kind)) {
            return false;
        }
        if (!Objects.equals(this.integument, other.integument)) {
            return false;
        }
        return true;
    }    
       
}
