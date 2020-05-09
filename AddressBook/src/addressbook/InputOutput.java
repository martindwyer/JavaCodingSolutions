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

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 * The InputOutput class handles all operations of the address book application
 * 
 * @author Martin Dwyer
 */
public class InputOutput {

    /**
     * The mainMenuMessage() method produces a String output for the main message to 
     * appear on the user's screen
     * 
     * @param bookSelected the file name of the current address book (selected by user)
     * @return a customized string for the user reflecting the current address book
     */
    public static String mainMenuMessage(String bookSelected) {
        String output = "";
        output += "<html>"
                + "<style>body {width:250px;margin:25px 0 25px 0;} "
                + "li {margin-bottom: 5px;} "
                + "h2, h4, h5 {margin:10px 0px 5px 20px;}"
                + "p {margin-left: 20px;}</style>"
                + "<h2>Address Book</h2>"
                + "<h4>Main Menu</h4>"
                + "<h5>Book Selected: " + bookSelected + "</h5>"
                + "<ol>"
                + // Selection 1
                "<li>Create new address book."
                + // Selection 2
                "<li>Retrieve existing address book.</li>"
                + // Selection 3
                "<li>Display current address book.</li>"
                + // Selection 4
                "<li>Search current address book by name.</li>"
                + // Selection 5
                "<li>Add contact to address book.</li>"
                + // Selection 6
                "<li>Delete existing contact.</li>"
                + // Selection 7
                "<li>Edit existing contact.</li>"
                + // Selection 8
                "<li>Exit address book system.</li>"
                + "</ol>"
                + "<p>Enter selection below (1-8):</p><br> "
                + "<p style='font-size:85%;'>or type 'help' below for more information</p>"
                + "</html>";

        return output;
    }
    /**
     * Provides details HTML text for presenting help message
     * 
     * @return help message in string form HTML format
     */
    public static String getHelpMessage() {
        String output = "<html>"
                + "<style>body {width:400px;margin:25px;} "
                + "p {font-size:100%;}"
                + "h2 {margin:10px 0px 5px 20px;}"
                + "p {margin-left: 20px;}</style>"
                + "<h2>Address Book Help Page</h2>" +
                "<p>Welcome to our address book application!</p><br><p>Here are a couple of useful tips to get started</p><br>" +
                "<p>File name:  First, you will need to either create a new address book file name or retrieve an existing address book.  If you are just getting started, it would be easiest to enter selection '2' and enter the file name 'address' when prompted.  This will make the demo address book available for you to experiment with.</p><br>" +
                "<p>Once you have selected an address book file option, you can add, delete, and edit contacts in the address book.  With each step, the address book contents will be displayed so that you can verify your work.</p><br>" +
                "<p>When you are done, simply exit the system normally through the main menu (selection 8).  Your file work will be saved automatically when you exit the system.</p><br>" +
                "<p>Enjoy!</p><br>";
        
        return output;
    }

    /**
     * Prompts user for existing address book file name
     * 
     * @return the file name in string form
     */
    public static String getAddressBookName() {
        String addressBookSelected = JOptionPane.showInputDialog(null, "Enter name for existing address book\n\nDemo address book name: 'address'\n\n");
        return addressBookSelected;
    }

    /**
     * Prompts the user for new address book file name
     * 
     * @return the file name in string form 
     */
    public static String getNewAddressBookName() {
        String addressBookSelected = JOptionPane.showInputDialog(null, "Enter name for new address book\n\nEight letters (a-z,A-Z):\n\n");
        return addressBookSelected;
    }

    /**
     * Creates a sample address book with one sample object
     * 
     * @param addressBook a TreeMap with key being name and values being Person objects
     * @param sample a person object for illustration
     * @return an address book as a TreeMap
     */
    public static TreeMap<String, Person> createNewAddressBook(TreeMap<String, Person> addressBook, Person sample) {
        addressBook.put(sample.getName(), sample);
        InputOutput.displayAddressBook(addressBook);
        return addressBook;
    }

    /**
     * Retrieves an address book in TreeMap form given the file name
     * 
     * @param addressBookSelected the file name in string form
     * @return an address book as a Java TreeMap
     * @throws java.io.FileNotFoundException
     */
    public static TreeMap<String, Person> getExistingAddressBook(String addressBookSelected) throws FileNotFoundException {
        TreeMap<String, Person> addressBook = new TreeMap<String, Person>();
        addressBook = InputOutput.getAddressObjects(addressBookSelected);
        InputOutput.displayAddressBook(addressBook);
        return addressBook;
    }

    /**
     * Displays the address book in list form
     * 
     * @param addressBook 
     */
    public static void displayAddressBook(TreeMap<String, Person> addressBook) {
        String output = "<html><style='width:1000px;margin-top:20px;'>"
                + "<h1 style='text-align:center;'>Address Book</h1>"
                + "<table style='margin:20px;min-width:800px;'>";
        output += displayHeading();
        Person person = null;

        for (Map.Entry entry : addressBook.entrySet()) {
            person = (Person) entry.getValue();
            output += displayContact(person);
        }
        output += "</table></html>";

        JOptionPane.showMessageDialog(null, output);
    }

    /**
     * Produces HTML text for use in displaying individual contact details
     * 
     * @param person a Person object
     * @return a string customized for each Person object
     */
    public static String displayContact(Person person) {
        String output = "";

        output += "<tr>";
        output += "<td style='border-top:1px solid black;border-right:1px solid black; border-left:1px solid black;padding: 5px;'>" + person.getName() + "</td>"
                + "<td style='border-top:1px solid black;border-right:1px solid black; padding: 5px;'>" + person.getStreetAddress() + "</td>"
                + "<td style='border-top:1px solid black;border-right:1px solid black; padding: 5px;'>" + person.getCity() + "</td>"
                + "<td style='border-top:1px solid black;border-right:1px solid black; padding: 5px;'>" + person.getState() + "</td>"
                + "<td style='border-top:1px solid black;border-right:1px solid black; padding: 5px;'>" + person.getZip() + "</td>"
                + "<td style='border-top:1px solid black;border-right:1px solid black; padding: 5px'>" + person.getPhoneString() + "</td>"
                + "<td style='border-top:1px solid black;border-right:1px solid black; padding: 5px;'>" + person.getEmailAddress() + "</td>"
                + "<td style='border-top:1px solid black;border-right:1px solid black; padding: 5px;'>" + person.getWebsite() + "</td>";
        output += "</tr>";

        return output;
    }

    /**
     * Produces HTML text for heading of the contact information display
     * 
     * @return a string HTML table heading
     */
    public static String displayHeading() {
        String output = "";
        output += "<tr>";
        output += "<th>Name</th>"
                + "<th>Street</th>"
                + "<th>City</th>"
                + "<th>State</th>"
                + "<th>Zip Code</th"
                + "<th>Phone</th>"
                + "<th>Email</th>"
                + "<th>Website</th>";
        output += "</tr>";

        return output;
    }
    
    /**
     * Prompts user for search criteria and displays results
     * 
     * @param addressBook a Java TreeMap object of form TreeMap<String,Person>
     */
    public static Person searchAddressBook(TreeMap<String, Person> addressBook) {
        String input = "";
        Person person = null;
        Object result = null;
        input = JOptionPane.showInputDialog("Enter name of person to search for: \n\n");
        String output = "<html><style='width:1000px;margin-top:20px;'>"
                + "<h1 style='text-align:center;'>Address Book</h1>"
                + "<table style='margin:20px;min-width:800px;'>";
        if(input != null) {
            result = addressBook.get(input);
            person = (Person) result;
        } else {
            person = null;
        }
                
        if (person != null) {
            output += displayHeading();
            output += displayContact(person);
            output += "</table></html>";
            JOptionPane.showMessageDialog(null, output);
        } else {
            JOptionPane.showMessageDialog(null, "Name not found.\n\n");
        }
        
        return person;
    }
    
    /**
     * Provides an interactive user interface for adding a new contact
     * 
     * @param addressBook the Java TreeMap<String,Person> address book
     * @return the revised Java TreeMap<String,Person> address book with added contact
     */
    public static TreeMap<String, Person> addNewContact(TreeMap<String, Person> addressBook) {
        String name = JOptionPane.showInputDialog("Enter name of new contact:\n\n");
        String street = JOptionPane.showInputDialog("Enter street address:\n\n");
        String city = JOptionPane.showInputDialog("Enter city:\n\n");
        String state = JOptionPane.showInputDialog("Enter state:\n\n");
        String zipString = JOptionPane.showInputDialog("Enter 5 digit zip code (e.g. 52404):\n\n");
        String phoneString = JOptionPane.showInputDialog("Enter phone number (numbers only, e.g. 3195551212):\n\n");
        String email = JOptionPane.showInputDialog("Enter email address:\n\n");
        String website = JOptionPane.showInputDialog("Enter website location:\n\n");
        
        int zip = 0;
        try {
            zip = Integer.parseInt(zipString);
        } catch(NumberFormatException e) {
           zip = 0;   
        }
        Long phone = 0L;
        try {
            phone = Long.parseLong(phoneString);
        } catch(NumberFormatException e) {
            phone = 0L;
        }
        Person newContact = new Person(name, street, city, state, zip, phone, email, website);
        addressBook.put(name, newContact);

        displayAddressBook(addressBook);

        return addressBook;
    }
    
    /**
     * An interactive interface for deleting a contact from an address book
     * 
     * @param addressBook an address book in Java TreeMap<String,Person> format
     * @return the revised address book in Java TreeMap<String,Person> format
     */
    public static TreeMap<String,Person> deleteContact(TreeMap<String,Person> addressBook) {
        String input = JOptionPane.showInputDialog("Enter name of contact to delete: \n\n");
        if(addressBook.get(input) != null) {
            addressBook.remove(input);
            JOptionPane.showMessageDialog(null,"Contact found and deleted.\n\nClick OK to view revised contact list.");
        } else {
            JOptionPane.showMessageDialog(null,"Contact could not be found.\n\nClick OK to view contact list.");
        }
        displayAddressBook(addressBook);
        
        return addressBook;
    }
    
    /**
     * Provides the user with an interface for editing each element of an existing contact
     * in the address book
     * 
     * @param addressBook a Java TreeMap<String,Person> address book
     * @return the revised Java TreeMap<String,Person> address book
     */
    public static TreeMap<String,Person> editContact(TreeMap<String,Person> addressBook) {
        String name = JOptionPane.showInputDialog("Enter name of contact to edit: \n\n");
        Person person = (Person)addressBook.get(name);
        String input = "";
        Long phone=0L;
        int zip=0;
        if(person != null) {
            input = JOptionPane.showInputDialog("Contact Found.\n\nExisting Name: " +person.getName() + "\n\n" +
                                        "Enter new name below:\n\n(leave blank if no change)");
            if(input.equals("")) {
                //  No action necessary
            } else {
                person.setName(input);
                input = "";
            }
            input = JOptionPane.showInputDialog("Existing street address: " +person.getStreetAddress()+ "\n\n" +
                                        "Enter new address below:\n\n(leave blank if no change)");
            if(input.equals("")) {
                //  No action necessary
            } else {
                person.setStreetAddress(input);
                input = "";
            }
            input = JOptionPane.showInputDialog("Existing city: " +person.getCity() + "\n\n" +
                                        "Enter new city below:\n\n(leave blank if no change)");
            if(input.equals("")) {
                //  No action necessary
            } else {
                person.setCity(input);
                input = "";
            }
            input = JOptionPane.showInputDialog("Existing state: " +person.getState() + "\n\n" +
                                        "Enter new state below:\n\n(leave blank if no change)");
            if(input.equals("")) {
                //  No action necessary
            } else {
                person.setState(input);
                input = "";
            }
            input = JOptionPane.showInputDialog("Existing zip code: " +person.getZip() + "\n\n" +
                                        "Enter new state below:\n\n(leave blank if no change)");
            if(input.equals("")) {
                //  No action necessary
            } else {
                try {
                    zip = Integer.parseInt(input);
                    person.setZip(zip);
                } catch (NumberFormatException e) {
                    // Do nothing - bad input
                }
                input = "";
            }
            input = JOptionPane.showInputDialog("Existing phone number: " +person.getPhoneString() + "\n\n" +
                                        "Enter new phone below:\n\n(only numbers, e.g. 3195551212)");
            if(input.equals("")) {
                //  No action necessary
            } else {
                try {
                    phone = Long.parseLong(input);
                    person.setPhoneNumber(phone);
                } catch (NumberFormatException e) {
                    // Do nothing - bad input                    
                }
                input = "";
            }
            input = JOptionPane.showInputDialog("Existing email address: " +person.getEmailAddress() + "\n\n" +
                                        "Enter new email address below:\n\n(leave blank if no change)");
            if(input.equals("")) {
                //  No action necessary
            } else {
                person.setEmailAddress(input);
                input = "";
            }
            input = JOptionPane.showInputDialog("Existing website: " +person.getWebsite() + "\n\n" +
                                        "Enter new website below:\n\n(leave blank if no change)");
            if(input.equals("")) {
                //  No action necessary
            } else {
                person.setWebsite(input);
                input = "";
            }
            addressBook.remove(name);
            addressBook.put(name, person);
            JOptionPane.showMessageDialog(null,"Contact edit complete.\n\nClick OK to see revised contact list.\n\n");
            displayAddressBook(addressBook);
        } else {
            JOptionPane.showMessageDialog(null,"Contact not found.");
        }

        return addressBook;
    }
    
    /**
     * Retrieves address books as Java TreeMap<String,Person> form given the name of the file
     * containing the Person objects
     * 
     * @param addressBookSelected the address book file name in string form
     * @return an address book in Java TreeMap<String,Person> form
     * @throws java.io.FileNotFoundException
     */
    public static TreeMap<String, Person> getAddressObjects(String addressBookSelected) throws FileNotFoundException {
        TreeMap<String, Person> addressObjects = new TreeMap<>();
        boolean goodFileIsFound = false;
        boolean isDoneReading = false;
        String filePath = "src/books/" + addressBookSelected + ".bin";

        ObjectInputStream objectInputStream = null;

        while (!goodFileIsFound) {
            try {
                objectInputStream = new ObjectInputStream(new FileInputStream(filePath));
                goodFileIsFound = true;
            } catch (FileNotFoundException e) {
                throw e;
            } catch (IOException e) {
                System.out.println("Error in file name location.  Check InputOutput getAddressObects() and try again");
                System.out.println(e);
                System.exit(1);
            }
        }

        Person personRead = new Person("Person");
        String nameKey = null;
        while (!isDoneReading) {
            try {
                personRead = (Person) objectInputStream.readObject();
                nameKey = personRead.getName();
                addressObjects.put(nameKey, personRead);

            } catch (EOFException e) {
                isDoneReading = true;
            } catch (InvalidClassException e) {
                System.out.println(e);
            } catch (IOException e) {
                System.out.println("Error in reading objects from file in InputOutput.getAddressObjects()");
                System.out.println(e);
                System.exit(1);
            } catch (ClassNotFoundException e) {
                System.out.println("Error objects from class specified in InputOutput.getAddressObjects()");
                System.out.println(e);
                System.exit(1);
            }

        }

        try {
            objectInputStream.close();
        } catch (IOException e) {
            System.out.println("Error closing object input stream in getAddressObjects()");
            System.out.println(e);
            System.exit(1);
        }

        return addressObjects;
    }

    /**
     * Used to write the address book to a file every time the application is shut down
     * 
     * @param addressObjects an address book as a Java TreeMap<String,Person>
     * @param addressBookSelected the file name for saving the address book
     * 
     */
    public static void writeAddressObjects(TreeMap<String, Person> addressObjects, String addressBookSelected) {
        boolean isGoodFileName = false;
        boolean isWriteSuccess = false;
        String filePath = "src/books/" + addressBookSelected + ".bin";
        ObjectOutputStream objectOutputStream = null;

        while (!isGoodFileName) {
            try {
                objectOutputStream
                        = new ObjectOutputStream(new FileOutputStream(filePath));
                isGoodFileName = true;

            } catch (IOException e) {
                // File verified in original package, so error caught here.  Should unexpected errors
                // occur, an error message will be printed and the program will be terminated.
                System.out.println("Error in file name location.  Check InputOutput writeAddressObects() and try again");
                System.out.println(e);
                System.exit(1);
            }
        }

        Object person = new Person("Placeholder");

        while (!isWriteSuccess) {
            try {
                for (Map.Entry entry : addressObjects.entrySet()) {
                    person = entry.getValue();
                    objectOutputStream.writeObject(person);
                }
                objectOutputStream.close();
                isWriteSuccess = true;
            } catch (IOException e) {
                System.out.println("Error in writing to file location.  Check InputOutput.writeAddressObjects() and try again");
                System.out.println(e);
                System.exit(1);
            }
        }
    }

    /**
     * The getAddressTextData() method was used to originally populate an address book.
     * It was not used in the application after the original import, but could be used
     * in future versions to import text in csv file format into the application
     *
     * @return the address book as a Java TreeMap<String,Person>
     */
    public static TreeMap<String, Person> getAddressTextData() {
        ArrayList<String> newStory = new ArrayList<String>();
        TreeMap<String, Person> addressBook = new TreeMap<>();
        File file = null;
        boolean isGoodFileName = false;
        String fileName = "";
        while (!isGoodFileName) {
            try {
                // Setting up new file chooser object
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Load which file?");
                int result = chooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    file = chooser.getSelectedFile();
                }

                // The following section uses a boolean for tracking file name status
                try {
                    fileName = file.getCanonicalPath();
                    isGoodFileName = true;
                } catch (FileNotFoundException e) {
                    // will keep trying here
                } catch (IOException e) {
                    // will keep trying to find file here too
                }

                isGoodFileName = true;
            } catch (NullPointerException e) {
                // Tryiing again until we can make isGoodFileName true: not yet
            }
        }

        boolean isGoodReader = false;
        BufferedReader myReader = null;
        while (!isGoodReader) {
            try {
                myReader = new BufferedReader(new FileReader(fileName));
                isGoodReader = true;
            } catch (FileNotFoundException e) {
                // Since fileName has been verified above - should not be an issue
            }
        }

        boolean isEndOfFile = false;
        String line = null;
        String[] dataPoints = new String[8];
        while (!isEndOfFile) {
            try {
                line = myReader.readLine();
                if (line != null) {
                    dataPoints = line.split(",");
                    String name = dataPoints[0];
                    String streetAddress = dataPoints[1];
                    String city = dataPoints[2];
                    String state = dataPoints[3];
                    int zip = Integer.parseInt(dataPoints[4]);
                    long phoneNumber = Long.parseLong(dataPoints[5]);
                    String email = dataPoints[6];
                    String website = dataPoints[7];
                    addressBook.put(name, new Person(name, streetAddress, city, state, zip, phoneNumber, email, website));
                    newStory.add(line);
                } else {
                    isEndOfFile = true;
                }
            } catch (IOException e) {
                isEndOfFile = true;
            }

        }

        return addressBook;
    }

}
