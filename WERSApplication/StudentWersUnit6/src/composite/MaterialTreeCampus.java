package composite;

import data.MaterialDb.MaterialRecord;
import java.util.List;

// CHANGED for ITERATOR AND COMPOSITE IMPLEMENTATION
// Entire class added

/**
 *  Class extends MaterialTree for the purpose of creating a material tree for
 *  the campus.
 * 
 *  @author Martin Dwuyer
 *  @date 2019.10.4
 */
public class MaterialTreeCampus<T> extends MaterialTree<T> {

    /**
     * Constructor specifies the root identity for the main campus
     */
    public MaterialTreeCampus() {
        super();
        this.root = new MaterialTree<String>("Main Campus");
    }

    /**
     * Method provides for inserting MaterialRecord data items into the data tree
     * 
     * @param mr a MaterialRecord data type with building, room, and material 
     * attributes
     */
    public void insertMaterialRecord(MaterialRecord mr) {
        
        // Establish new composite objects based on data type
        Building mrBuilding = new Building(mr.building);
        Room mrRoom = new Room(mr.room);
        Material mrMaterial = new Material(mr.material);

        // Adding building to root
        MaterialTree<String> newBuilding = new MaterialTree<String>();
        if(this.root.getChildData().contains(mrBuilding.toString())) {
            newBuilding = this.root.getChild(mrBuilding.toString());
        } else {
            newBuilding = new MaterialTree<String>(mrBuilding.toString());
            this.root.addChild(newBuilding);            
        }
        
        // Adding rooms to building
        MaterialTree<String> newRoom = new MaterialTree<String>(null);
        if (newBuilding.getChildData().contains(mrRoom.toString())) {
            newRoom = newBuilding.getChild(mrRoom.toString());
        } else {
            newRoom = new MaterialTree<String>(mrRoom.toString());
            newBuilding.addChild(newRoom);
        }
        
        // Adding materials to rooms, setting as leaf, adding to materials TreeSet
        MaterialTree<String> newMaterial = new MaterialTree<String>(null);
        if (newRoom.getChildData().contains(mrMaterial.toString())) {
            // Do nothing.  Material already listed
        } else {
            newMaterial = new MaterialTree<String>(mrMaterial.toString());
            newMaterial.setIsLeaf(true);
            newRoom.addChild(newMaterial);
            materials.add(mrMaterial.toString());
        }

    }

    /**
     * Provides method to produce String for printing MaterialTree item
     * 
     * @return a String for printing the tree
     */
    @Override
    public String toString() {
        String appender = "\t\t\t";
        String treeString = "\n";
        treeString += "" + this.root.getData() + "\t\t" + "Building" + 
                        "\t\t" + "Room" + "\t\t\t" + "Materials" + "\n\n";
        
        List<MaterialTree<String>> buildings = this.root.getChildren();
        for (MaterialTree<String> building : buildings) {
            treeString += (appender + building.getData() + "\n");
            List<MaterialTree<String>> rooms = building.getChildren();
            for (MaterialTree<String> room : rooms) {
                treeString += (appender + appender + room.getData() + "\n");
                List<MaterialTree<String>> materials = room.getChildren();
                for(MaterialTree<String> material: materials) {
                    treeString += appender + appender + appender + material.getData() + "\n";
                }
            }
        }
        
        return treeString;
    }
    
}
