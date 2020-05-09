package animalstuff;

import java.util.Objects;

/**
 * Animal class for construction of all sorts of animals with attributes of
 * animal kind and integument (covering)
 * 
 * @author Martin Dwyer
 * 
 * Prepared for ITEC 6130, Walden University, March 15, 2019
 */
public class Animal {
    
    public String kind;
    public String integument;

    /**
     * Private constructor to prohibit creation of "plain" animal
     */
    private Animal() {

    }
    
    /**
     * Primary object constructor for Animal
     * @param kind a String representing the animal kind
     * @param integument a String representing the animal covering
     */
    public Animal(String kind, String integument) {
        this.kind = kind;
        this.integument = integument;
    }
     
    /**
     * A method for the animal movement
     * @param fast a boolean, if true going fast, if false not going fast
     * @return the movement action, a String
     */
    public String movement(boolean fast) {
        String result;
        if(fast) {
            result = "I run on four legs.";
        } else {
            result = "I walk on four legs.";
        }
        return result;
    }
    
    /**
     * A method for the animal sounds
     * @return a String describing the animal sound
     */
    public String sound() {
        return "";
    }
   
    /**
     * A static Animal class method for creating new objects from sub-classes
     * @param kind represents the kind of animal to be created
     * @return the appropriate Animal object based on kind
     */
    public static Animal newInstance(String kind) {
        Animal object;
        switch(kind.toLowerCase()) {
            case "duck":
                object = new Duck();
                break;
                
            case "turkey":
                object = new Turkey();
                break;

            case "rooster":
                object = new Rooster();
                break;
                
            case "ostrich":
                object = new Ostrich();
                break;
                
            case "cow":
                object = new Cow();
                break;
                
            case "pig":
                object = new Pig();
                break;
                
            case "horse":
                object = new Horse();
                break;
                
            case "human":
                object = new Human();
                break;
                
            default:  
                object = null;   
        }        
        return object;
    }
    
    /**
     * Method to print out Animal description based on animal kind
     * @param kind a String to represent the animal kind to be printed
     */
    public static void print(String kind) {
        Object a = Animal.newInstance(kind);
        System.out.print(a.toString());
    }
    
    /**
     * An object method to return a String animal description based on animal kind
     * @return the description of the object, a String
     */
    @Override
    public String toString() {
        String output = "I am a " + this.kind + "\n";
        output += "\tI have " + this.integument + "\n";
        output += "\tWhen I go slowly, " + this.movement(false) + "\n";
        output += "\tWhen I go fast, " + this.movement(true) + "\n";
        output += "\tThe sound I make is '" + this.sound() + "'.";
        return output;
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
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.kind, other.kind)) {
            return false;
        }
        if (!Objects.equals(this.integument, other.integument)) {
            return false;
        }
        return true;
    }
    
}
