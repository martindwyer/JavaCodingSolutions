package composite;

// CHANGED for ITERATOR AND COMPOSITE IMPLEMENTATION
// Entire class added

/**
 * Class provides data structure for rooms
 * 
 * @author Martin Dwyer
 * @date 2019.10.4
 */
public class Room {
    
    /**
     * Room number attribute
     */
    public int roomNumber;

    /**
     * Constructor for new rooms
     * @param roomNumber 
     */
    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }

    /**
     * Method to get room number
     * 
     * @return an integer, the room number 
     */
    public int getRoomNumber() {
        return roomNumber;
    }

    /**
     * Converts the room number to String
     * @return a String
     */
    @Override
    public String toString() {
            return Integer.toString(this.roomNumber);
    }
}
