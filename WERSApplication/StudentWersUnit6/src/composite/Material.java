package composite;

// CHANGED for ITERATOR AND COMPOSITE IMPLEMENTATION
// Entire class added

/**
 * Class to provide data structure for hazardous materials
 * 
 * @author Martin Dwyer
 * @date 2019.10.4
 * 
 */
public class Material {
   
    /**
     * The name of the material
     */
    public String materialName;

    /**
     * Constructor to create Material object
     * @param materialName a String with the name of the material
     */
    public Material(String materialName) {
        this.materialName = materialName;
    }

    /**
     * Method to retrieve the name of the material
     * @return the name of the material, a string
     */
    public String getMaterialName() {
        return materialName;
    }

    /**
     * Method to produce object string
     * @return the name of the material, a string
     */
    @Override
    public String toString() {
        return this.materialName;
    }
    
}
