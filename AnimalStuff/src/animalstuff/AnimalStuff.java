package animalstuff;

import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 * AnimalStuff includes a main class used to present a library of animals which
 * are descendants of the Animal class. The program is menu driven, allowing
 * users to select animals from a menu or enter them by name.
 *
 * The list of animals can be printed with their descriptions at any time.
 *
 * @author Martin Dwyer
 *
 * Prepared for ITEC 6130, Walden University, March 15, 2019
 */
public class AnimalStuff {

    /**
     * Main method for project
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        ArrayList<Animal> animalList = new ArrayList<>();
        String menuSelection = "";          // For user response to menu
        String animalSelection = "";        // For user to type animal name
        int numberSelected = 999;           // When user selects menu item
        boolean keepLooking = true;         // Control variable for menu display
        while (keepLooking) {
            // Display main menu
            menuSelection = JOptionPane.showInputDialog(null, getMainMenu());
            // Parse valid selection and ignore invalid selections
            try {
                numberSelected = Integer.parseInt(menuSelection);
            } catch (NumberFormatException e) {
                numberSelected = 999;
            }
            // Create animal selected from menu
            Animal newAnimal = null;
            switch (numberSelected) {
                case 1:
                    newAnimal = Animal.newInstance("duck");
                    animalList = addNewAnimal(newAnimal, animalList);
                    break;
                case 2:
                    newAnimal = Animal.newInstance("turkey");
                    animalList = addNewAnimal(newAnimal, animalList);
                    break;
                case 3:
                    newAnimal = Animal.newInstance("rooster");
                    animalList = addNewAnimal(newAnimal, animalList);
                    break;
                case 4:
                    newAnimal = Animal.newInstance("ostrich");
                    animalList = addNewAnimal(newAnimal, animalList);
                    break;
                case 5:
                    newAnimal = Animal.newInstance("human");
                    animalList = addNewAnimal(newAnimal, animalList);
                    break;
                case 6:
                    newAnimal = Animal.newInstance("horse");
                    animalList = addNewAnimal(newAnimal, animalList);
                    break;
                case 7:
                    newAnimal = Animal.newInstance("cow");
                    animalList = addNewAnimal(newAnimal, animalList);
                    break;
                case 8:
                    newAnimal = Animal.newInstance("pig");
                    animalList = addNewAnimal(newAnimal, animalList);
                    break;
                case 9:
                    animalSelection = JOptionPane.showInputDialog(null, "Enter animal name.\n\n");
                    newAnimal = Animal.newInstance(animalSelection);
                    animalList = addNewAnimal(newAnimal, animalList);
                    break;
                case 10:
                    if (animalList.size() > 0) {
                        printList(animalList);
                    } else {
                        JOptionPane.showMessageDialog(null, "Your list has no animals yet\n\n");
                    }
                    break;
                case 11:
                    keepLooking = false;
                    JOptionPane.showMessageDialog(null, "Thanks for using our animal library.");
                    break;
            }
            numberSelected = 999;
        }
    }
    /**
     * getMainMenu() provides the String text for the main menu
     * @return String main menu text
     */
    public static String getMainMenu() {
        String output = "Welcome to our animal encyclopedia. we have \n"
                + "the following animals with brief descriptions. This\n"
                + "program allows you to build your own list of animals.\n\n"
                + "Please select a number to add the animal to your list: \n"
                + "Or enter 11 to exit.\n\n"
                + "Birds\n"
                + "1.  Duck\n"
                + "2.  Turkey\n"
                + "3.  Rooster\n"
                + "4.  Ostrich\n\n"
                + "Mammals\n"
                + "5.  Human\n"
                + "6.  Horse\n"
                + "7.  Cow\n"
                + "8.  Pig\n\n"
                + "9.  Enter animal by name\n\n"
                + "10. Print List\n\n"
                + "11. Exit program\n\n";
        return output;
    }

    /**
     * addNewAnimal() takes the list of animals and the new animal as arguments, and
     * adds the new animal to the list if (1) it is in the library, and (2) it is not
     * a duplicate 
     * 
     * @param newAnimal the new Animal object to be considering for adding
     * @param list the list of animals for adding to
     * @return a revised list of animals
     */
    public static ArrayList<Animal> addNewAnimal(Animal newAnimal, ArrayList<Animal> list) {
        boolean isDuplicate = false;
        ArrayList<Animal> animalList = list;
        // Checking to see if newAnimal is null (not in list) 
        if (newAnimal != null) {
            // Checking to see if animal selected is already in list
            for (Animal animal : animalList) {
                if (animal.equals(newAnimal)) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                animalList.add(newAnimal);
                JOptionPane.showMessageDialog(null, "Animal added to list.\n\n");
            } else {
                JOptionPane.showMessageDialog(null, getDuplicateMessage());
            }

        } else {

            JOptionPane.showMessageDialog(null, getErrorMessage());
        }

        return list;
    }

    /**
     * getErrorMessage() provides the text for animals which are not in library
     * 
     * @return error message 
     */
    public static String getErrorMessage() {
        String output = "You have entered an animal not in our library.\n"
                + "Click 'Ok' to return to the main menu";
        return output;
    }

    /**
     * getDuplicateMessage() provides the text for attempts to add duplicate animals
     * 
     * @return duplicate error message
     */
    public static String getDuplicateMessage() {
        String output = "You already have that animal in your list\n"
                + "Click 'Ok' to return to the main menu";
        return output;
    }

    /**
     * printList() prints the current collection of animal descriptions
     * @param animalList 
     */
    public static void printList(ArrayList<Animal> animalList) {
        String output = "Here are descriptions for the animals selected:\n\n";
        for (Animal animal : animalList) {
            output += animal.toString() + "\n\n";
        }
        JOptionPane.showMessageDialog(null, output);
    }

}
