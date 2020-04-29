/**
 * Student:     Martin Dwyer
 * School:      Walden University
 * Course:      ITEC 6130: Spring 2019
 * Assignment:  Software application, Week 6.
 *
 * Description: The application herein uses the Java TreeMap to construct a contact
 * list, add entries to the list, look up entries, edit entries, delete entries
 * and save the address book.  All address books created in this program are written
 * to files in the src/books package.
 *
 */
package addressbook;

import java.io.FileNotFoundException;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 * Class AddressBook contains the interface for the main menu of the address
 * book application.
 *
 * @author Martin Dwyer
 */
public class AddressBook {

    /**
     * The main() method of the AddressBook class contains the menu driven
     * interface for the Address Book application
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Person sample = new Person("Sample Person", "Street", "City", "State", 12345, 3195551212L, "email@domain.com", "www.website.com");
        TreeMap<String, Person> addressBook = new TreeMap<String, Person>();

        String addressFileName = null;
        String input = null;
        int userSelection = 999;
        boolean systemIsRunning = true;

        String addressBookSelected = "None";

        while (systemIsRunning) {
            // Displaying main menu and forcing a proper selection (1-8)
            try {
                input = JOptionPane.showInputDialog(null, InputOutput.mainMenuMessage(addressBookSelected));
            } catch (NullPointerException e) {
                // Do nothing.  Menu will keep displaying for proper input
                userSelection = 999;
            }
            if (input != null && input.equalsIgnoreCase("help")) {
                JOptionPane.showMessageDialog(null,InputOutput.getHelpMessage());
            } else {
                try {
                    userSelection = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    // Do nothing so that menu will be displayed again
                    userSelection = 999;
                }
                switch (userSelection) {
                    // Create new address book
                    case 1:
                        addressBookSelected = InputOutput.getNewAddressBookName();
                        InputOutput.createNewAddressBook(addressBook, sample);
                        break;

                    // Get existing address book
                    case 2:
                        addressBookSelected = InputOutput.getAddressBookName();
                        try {
                            addressBook = InputOutput.getExistingAddressBook(addressBookSelected);
                        } catch(FileNotFoundException e) {
                            JOptionPane.showMessageDialog(null,"File name not found. Try again.");
                        }                        
                        break;

                    // Display current address book
                    case 3:
                        InputOutput.displayAddressBook(addressBook);
                        break;

                    // Search current address book    
                    case 4:
                        InputOutput.searchAddressBook(addressBook);
                        break;

                    // Add new contact    
                    case 5:
                        addressBook = InputOutput.addNewContact(addressBook);
                        break;

                    // Delete existing contact
                    case 6:
                        addressBook = InputOutput.deleteContact(addressBook);
                        break;

                    // Edit existing contact
                    case 7:
                        addressBook = InputOutput.editContact(addressBook);
                        break;

                    case 8:
                        JOptionPane.showMessageDialog(null, "Thank you for using the address book application");
                        systemIsRunning = false;
                        break;

                }
            }

        }
        // Writing objects to file on exit from address book
        InputOutput.writeAddressObjects(addressBook, addressBookSelected);

    }

}
