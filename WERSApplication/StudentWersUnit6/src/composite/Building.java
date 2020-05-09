package composite;

// CHANGED for ITERATOR AND COMPOSITE IMPLEMENTATION
// Entire class added


/**
 * Class added for specifying building data structures
 * 
 * @author Martin Dwyer
 * @date 2019.10.4
 */
public class Building {
    
    /**
     * Building number attribute, an integer
     */
    public int buildingNumber;

    /**
     * Constructor based on building number
     * @param number an integer
     */
    public Building(int number) {
        this.buildingNumber = number;
    }

    /**
     * Method to obtain building number
     * @return building number, an integer
     */
    public int getBuildingNumber() {
        return this.buildingNumber;
    }


    /**
     * Provides String for Building objects
     * @return a String of the building number
     */
    @Override
    public String toString() {
        return Integer.toString(this.buildingNumber);
    }
    
}
