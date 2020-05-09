/**
 * @file        AmusementParkTester.java
 * @author      Martin Dwyer
 * @version     1.0
 * @date        2019-02-28
 * @description This file provides menu-driven testing for the AmusementPark class
 */
package wk8projdwyerm;

import java.io.File;
import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;

/**
 * AmusementParkTester class provides the home for testing the AmusementPark class,
 * which also utilizes the Merchandise and Ticket classes.  Within this class, an
 * AmusementPark object is created, and all methods of the AmusementPark class are 
 * utilized and tested.
 * 
 * @author Martin Dwyer
 * @version 1.0
 * 
 */
public class AmusementParkTester {

    /**
     * Main method controls the flow of the program including menu-based testing loop
     * @param args : Control code for the class
     * @throws IOException : inventory items are imported from text files
     */
    public static void main(String[] args) throws IOException {
        Scanner kb = new Scanner(System.in);    // Scanner object created for main method
        String input;                           // String object to be used with scanner and JOptionPane
        int menuSelection = 0;                  // Integer object for menu-driven testing

        boolean validInput = false;             // Boolean tracks whether valid input has been received
        boolean endProgram = false;             // Boolean tracks when user decides to end program

        // Welcome user to testing program and offer outline for material to be covered
        JOptionPane.showMessageDialog(null, getWelcomeMessage());

        // Create amusement park and import tickets and merchandise inventory
        AmusementPark Walden = new AmusementPark("Walden Amusement Park");
        addTicketInventory(Walden);
        addMerchandiseInventory(Walden);

        // While loop controls how long to display method testing menu
        while (!endProgram) {
            // Get valid input from user for method testing selection 
            // See getMenuText() below for details on menu text
            while (!validInput) {
                // Get input from user
                input = JOptionPane.showInputDialog(null, getMenuText(Walden));
                // Try to parse input to an integer, doing nothing for improper input
                try {
                    menuSelection = Integer.parseInt(input);
                } catch (NumberFormatException e) {
                    // menuSelection remains equal to zero and menu will do nothing
                }
                // Proceeding only if the integer entered matches an available response
                if (menuSelection >= 1 && menuSelection <= 11) {
                    validInput = true;
                }
            }
            validInput = false;     // Resetting boolean for next iteration 
            switch (menuSelection) {
                case 1:
                    // Testing for Walden.getMerchandise()
                    testGetMerchandise(Walden);
                    break;

                case 2:
                    // Testing for Walden.getMerchandise(String category)
                    testGetMerchandiseString(Walden);
                    break;

                case 3:
                    // Testing for Walden.getMerchandise(long id)
                    testGetMerchandiseLong(Walden);
                    break;

                case 4:
                    // Testing for Walden.getName()
                    testGetName(Walden);
                    break;

                case 5:
                    // Testing Walden.getTickets()
                    testGetTicketsArray(Walden);
                    break;
                    
                case 6:
                    // Testing Walden.getTicketDates()
                    testGetTicketDates(Walden);
                    break;
                case 7:
                    // Testing Walden.getTickets(Date date)
                    testGetTickets(Walden);
                    break;
                case 8:
                    // Testing Walden.getTicket(long id)
                    testGetTicketLong(Walden);
                    break;
                case 9:
                    // Testing buyMerchandise(String id)
                    testBuyMerchandise(Walden);
                    break;
                case 10:
                    // Testing buyTicket(long id)
                    testBuyTicket(Walden);
                    break;
                case 11:
                    // End the program
                    endProgram = true;
                    break;
            }   // End of switch(menuSelection)
        } // End of while loop for method testing menu display
    } // End of main

    
    /**
     * Provide an initial welcome text with outline of program flow
     * @return text to be displayed in the program welcome message
     */
    public static String getWelcomeMessage() {
        return "Testing program for the AmusementPark class. The program proceeds as follows;\n \n"
                + "     1.  AmusementPark object named 'Walden Amusement Park' is created.\n"
                + "     2.  Ticket inventory is added.\n"
                + "     3.  Merchandise inventory is added.\n"
                + "     4.  Menu driven testing of class methods.\n\n"
                + "Click 'OK' to proceed.";
    }

    /**
     * Method to provide text to be inserted in testing for AmusementPark object
     * @param park : AmusementPark object
     * @return String with customized menu text for AmusementPark object
     */
    public static String getMenuText(AmusementPark park) {
        String menuText
                = "AmusementPark object created:  " + park.getName() + "\n"
                + "COMPLETE: Ticket inventory added for " + park.getName() + "\n"
                + "COMPLETE: Merchandise inventory added for " + park.getName() + "\n\n"
                + "Class Methods For Testing:\n"
                + "1.   getMerchandise(): ArrayList<Merchandise>\n"
                + "2.   getMerchandise(String category): ArrayList<Merchandise>\n"
                + "3.   getMerchandise(long id) : Merchandise\n"
                + "4.   getName() : String  \n"
                + "5.   getTickets() : ArrayList<Ticket>  \n"
                + "6.   getTicketDates() : ArrayList<Date>  \n"
                + "7.   getTickets(Date date)\n"
                + "8.   getTicket(long id)   \n"
                + "9.   buyMerchandise(String id) \n"
                + "10.   buyTicket(long id)    \n"
                + "11.  End program \n\n"
                + "Enter 1 through 9 to test a method.\nEnter 11 to exit\n\n";

        return menuText;

    }

    /**
     * The addTicketInventory(AmusementPark park) method imports tickets from a csv text file
     * provided for testing purposes.  All tickets are added to the AmusementPark object
     * using the addTicket() instance method from the AmusementPark class.  The ticket
     * holder name is set to "Walden Amusement Park" and the purchaseStatus attribute is 
     * set to false for all new items.
     * @param park : AmusementPark object
     * @throws IOException : Text file import for inventory
     */
    public static void addTicketInventory(AmusementPark park) throws IOException {
        // Open the file with line item detail
        File file = new File("src/wk8projdwyerm/tickets.csv");
        Scanner inputFile = new Scanner(file);
        // Set up lineCounter to track input
        String input;               // object to hold line input
        String[] lineInput;         // object to hold file line input split into array
        long newID = 0;             // object to hold unique identifier for each ticket
        String newCategory = "";    // object to hold each tickets category
        String newHolder = "";      // object to hold the ticket holder name
        int newYear = 0;            // objects to hold data information
        int newMonth = 0;
        int newDay = 0;
        double newPrice = 0.0;      // object to hold ticket price
        int placeHolder = 0;        // object for tracking items out of text file
        int ticketCounter = 0;      // object to track number of tickets added
        // Read line items from the file as long as file has lines
        while (inputFile.hasNextLine()) {
            input = inputFile.nextLine();
            lineInput = input.split(",");
            // After each line item has been gathered from file and split into array
            // Each item on row is assigned to object accordingly
            for (int i = 0; i < 7; i++) {
                switch (i) {
                    case 0:
                        newID = Integer.parseInt(lineInput[i]);
                        break;
                    case 1:
                        newCategory = lineInput[i];
                        break;
                    case 2:
                        newHolder = lineInput[i];
                        break;
                    case 3:
                        newYear = Integer.parseInt(lineInput[i]) - 1900;
                        break;
                    case 4:
                        newMonth = Integer.parseInt(lineInput[i]);
                        break;
                    case 5:
                        newDay = Integer.parseInt(lineInput[i]);
                        break;
                    case 6:
                        newPrice = Double.parseDouble(lineInput[i]);
                } // end of switch
            } // end of each row in csv file  
            // Creating ticket object and adding to AmusementPark objct ArrayList
            Date d = new Date(newYear, newMonth, newDay);
            Ticket t = new Ticket(newID, newCategory, newHolder, d, newPrice);
            park.addTicket(t);
        } // end of csv file processing
        
        // Close the line item detail file.
        inputFile.close();
        
    } // end of addTicketInventory()

    /**
     * The addMerchandiseInventory(AmusementPark park) method imports merchandise items from 
     * a csv text file provided for testing purposes.  All items are added to the 
     * AmusementPark object park using the addMerchandise(Merchandise m) instance method
     * from the AmusementPark class.  The inStock attribute is set to true for all new items.
     * @param park : AmusementPark object
     * @throws IOException : Text file imported for inventory
     */
    public static void addMerchandiseInventory(AmusementPark park) throws IOException {

        // Open the file with line item detail
        File file = new File("src/wk8projdwyerm/merchandise.csv");
        Scanner inputFile = new Scanner(file);

        // Set up lineCounter to track input
        String input;               // object to hold line input
        String[] lineInput;         // object to hold file line input split into array
        long newID = 0;
        String newCategory = "";
        String newDescription = "";
        double newPrice = 0.0;

        // Read line items from the file as long as file has lines
        while (inputFile.hasNextLine()) {

            input = inputFile.nextLine();
            lineInput = input.split(",");

            // After each line item has been gathered from file
            for (int i = 0; i < 3; i++) {
                switch (i) {

                    case 0:
                        newID = Integer.parseInt(lineInput[i]);
                        break;

                    case 1:
                        newCategory = lineInput[i];
                        break;

                    case 2:
                        newDescription = lineInput[i];
                        break;

                    case 3:
                        newPrice = Double.parseDouble(lineInput[i]);
                        break;
                }

            }

            Merchandise m = new Merchandise(newID, newCategory, newDescription, newPrice, true);
            park.addMerchandise(m);

        }

        // Close the line item detail file.
        inputFile.close();
    }

    /**
     * The testGetMerchandise(AmusementPark park) method produces an inventory listing
     * from the merchandise ArrayList attribute of an AmusementPark object park
     * @param park : AmusementPark object
     */
    public static void testGetMerchandise(AmusementPark park) {
        String output = "The getMerchandise() method produces an ArrayList of Merchandise class objects. \n\n"
                + "Testing successful: inventory listed from ArrayList below:\n\n";
        ArrayList<Merchandise> inventoryList = new ArrayList<Merchandise>();
        
        // The method getMerchandise() is tested in the following statement
        inventoryList = park.getMerchandise();

        // Inventory output is created
        for (Merchandise item : inventoryList) {
            output = output + item.toString() + "\n";
        }

        output = output + "\nClick 'OK' to return to menu.";

        JOptionPane.showMessageDialog(null, output);
    }  // End of testGetMerchandise()
    
    /**
     * The testGetMerchandiseString(AmusementPark park) method produces an inventory listing
     * from the merchandise ArrayList attribute of an AmusementPark object park using the 
     * selected category name and the instance method getMerchandise(String category)
     * @param park : AmusementPark object
     */
    public static void testGetMerchandiseString(AmusementPark park) {
        ArrayList<Merchandise> catList = new ArrayList<Merchandise>();
        String message = "To test this, type a merchandise category name \n"
                + "in the box below. A listing of inventory items \n"
                + "for that category will be produced.\n\n"
                + "Enter Category:\n T-Shirt, Sweatshirt,Stuffed Animal,UNKNOWN.\n\n";
        String catInput = JOptionPane.showInputDialog(message);
        String output = "List of inventory for category:    " + catInput + "\n\n";
        
        if(catInput.equalsIgnoreCase("T-Shirt") ||catInput.equalsIgnoreCase("Sweatshirt") ||
           catInput.equalsIgnoreCase("Stuffed Animal") ||catInput.equalsIgnoreCase("UNKNOWN") ) {
            
            // The following line tests the AmusementPark getMerchandise(String category) method
            catList = park.getMerchandise(catInput);
        } else {
            
            output = output + "\nInvalid category entered\n";
        }
        
        if (catList.size() != 0) {
            for (Merchandise item : catList) {
                output = output + item.toString() + "\n";
            }
        } else {
            output = output + "\nNo items match that category.\n";
        }
        
        JOptionPane.showMessageDialog(null, output);

    } // end of testGetMerchandiseString(AmusementPark park)

    /**
     * The testGetMerchandiseLong(long id) method produces an inventory item
     * from the merchandise ArrayList attribute of an AmusementPark object park using the 
     * selected item id and the instance method getMerchandise(long id)
     * @param park : AmusementPark object
     */
    public static void testGetMerchandiseLong(AmusementPark park) {
        long inputNumber = 0;
        String input = JOptionPane.showInputDialog("Enter merchandise item number below:\n"
                    + "Hint: 8054, 8071, 8083\n\n");
        String output = "Merchandise with that item number:\n";
        try {
            inputNumber = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            output = output + "\n\nInvalid item number entered\n\n";
            inputNumber = 99999999;
        }
        
        // The getMerchandise(long id) method is tested below by first creating a merchandise
        // object and then setting that object equal to the search result based on the id
        Merchandise m = park.getMerchandise(inputNumber);
        
        if(m != null) {
                output = output + "\n\nFound a match!\n\n" + m.toString() + "\n\n";
            } else {
                output = output + "\n\n Item not found.\n\n";
        }
        
        output = output + "\nClick 'OK' to return to menu.";

        JOptionPane.showMessageDialog(null, output);
    }

    /**
     * The testGetName() method produces the output of invoking the AmusementPark 
     * method getName()
     * @param park : AmusementPark object
     */
    public static void testGetName(AmusementPark park) {
        String output = "Amusement Park name using getName() method:\n\n"; 
        
        // The getName() method is called on the next line
        output = output + park.getName() + "\n\n";
        
        output = output + "\nClick 'OK' to return to menu.";

        JOptionPane.showMessageDialog(null, output);
        
    } // end of testGetMerchandiseLong(AmusementPark park)
    
    
    /**
     * The testGetTicketsArray() method provides testing for the getTickets() method
     * in the AmusementPark class
     * @param park : AmusementPark object
     */
    public static void testGetTicketsArray(AmusementPark park) {
        
        String output = "The getTickets() method produces an ArrayList of Ticket class objects. \n\n"
                + "Testing successful: tickets listed from ArrayList below:\n\n";
        
        // The method getTickets() is tested in the following statement
        ArrayList<Ticket> t = park.getTickets();

        // Inventory output is created
        for (Ticket item : t) {
            output = output + item.toString() + "\n";
        }

        output = output + "\nClick 'OK' to return to menu.";

        JOptionPane.showMessageDialog(null, output);
    }
    
    /**
     * The testGetTicketDates(AmusementPark park) method produces an ArrayList of 
     * dates using the getTicketDates(Date date) method from the AmusementPark 
     * class
     * @param park : AmusementPark object
     */
    public static void testGetTicketDates(AmusementPark park) {
        String output = "This method compiles an ArrayList of dates\n"
                        + "when tickets are available.  \n \n"
                        + "Testing successful.\n"
                        + "Tickets available on theses days:\n\n";
        
        // Method getTicketDates() is tested with the following two lines
        ArrayList<Date> datesAvailable = new ArrayList<Date>();
        datesAvailable = park.getTicketDates();
        
        // Output of applying the method
        for (Date date : datesAvailable) {
            output = output + date.toString() + "\n";
        }
        
        output = output + "\nClick 'OK' to return to menu.";

        JOptionPane.showMessageDialog(null, output);
    }

    /**
     * The testGetTickets(AmusementPark park) method produces an integer of the 
     * number of tickets available on a specified date : getTickets(Date date)
     * 
     * @param park : AmusementPark object
    */ 
    public static void testGetTickets(AmusementPark park) {
        String output = "The following tickets are available for that date: \n\n";
        int daySelected = 0;
        boolean validInput = false;
        while (!validInput) {
            String input = JOptionPane.showInputDialog(null,
                    "The getTickets(Date date) method will produce a number \n"
                    + "of tickets available on a specified date. \n"
                    + "Tickets are available on June 25,26, or 27.\n\n"
                    + "Enter day only: 25,26 or 27: \n\n");
            try {
                daySelected = Integer.parseInt(input);
                validInput = true;
                
            } catch (NumberFormatException e) {
                daySelected = 25;
                output = output + "Invalid date entered, default tickets given for June 25, 2019:\n\n";
                validInput = true;
            }
            if(daySelected >=25 && daySelected <=27) {
                daySelected = daySelected;
            } else {
                output = output + "Invalid date entered, default tickets given for June 25, 2019:\n\n";
                daySelected = 25;
            }
        }
        Date dateSelected = new Date(119, 06, daySelected);
        
        // The AmusementPark getTickets() method is utilized on the following line
        int howManyTickets = park.getTickets(dateSelected);
        
        output = output + "There are " + howManyTickets + " for sale on " + dateSelected.toString() + "\n\n";

        output = output + "\nClick 'OK' to return to menu.\n";
        
        JOptionPane.showMessageDialog(null,output);

    } // end of testGetTickets()
    
    /**
     * The testGetTicketLong(AmusementPark park) method retrieves a Merchandise object
     * using the getTicket(long id) method from the AmusementPark class
     * @param park : AmusementPark object
    */ 
    public static void testGetTicketLong(AmusementPark park) {
        long ticketNumber = 0;
        String output = "Ticket results for search:  \n\n";
        String input = JOptionPane.showInputDialog("Enter ticket number:\n(Hint: 65001,65012,65031) \n\n");
        try {
            ticketNumber = Integer.parseInt(input);
        } catch(NumberFormatException e) {
            output = output + "Invalid ticket number\n\n";
            ticketNumber = 99999999;
        }
        
        // The getTicket(long id) is utilized on the following line
        Ticket t = park.getTicket(ticketNumber);
        if(t != null) {
                output = output + "Ticket Information:\n" + t.toString() + "\n";
        } else {
                output = output + "Ticket number not available.\n\n";
        }
        
        output = output + "\nClick 'OK' to return to menu.\n\n";

        JOptionPane.showMessageDialog(null, output);
        
    }
    
    /**
     * The testBuyMerchandise(AmusementPark park) method utilizes the buyMerchandise(long id) 
     * method of the AmusementPark class, changing the purchase status on the merchandise item
     * identified if it was available for sale.
     * @param park : AmusementPark object
    */ 
    public static void testBuyMerchandise(AmusementPark park) {
        boolean itemFound = false;
        long itemNumber = 0;
        String output = "buyMerchandise() testing result:\n\n";
        String message = "The buyMerchandise() method will allow customers to\n"
                        + "buy items in inventory.  If the item number is found,\n"
                        + "and available, the item is sold and the boolean inStock\n"
                        + " changed from true to false.\n\n"
                        + "Please enter item number here\n(HINT 8054, 8071, 8083) ";
        String input = JOptionPane.showInputDialog(message);
        try {
            itemNumber = Integer.parseInt(input);
        } catch(NumberFormatException e) {
            output = output + "Invalid item number entered.\n";
            itemNumber = 0;
        }
        for(Merchandise item: park.getMerchandise()) {
            if(item.getId()==itemNumber && item.isInStock()) {
                itemFound = true;
                break;
            }
        }
        
        // The buyMerchandise(long id) is utilized below after the item has been found in inventory
        if(itemFound) {
            output = output + "Merchandise found and available!\n\nListing before purchase:\n" + park.getMerchandise(itemNumber).toString() + "\n\n";
            park.buyMerchandise(itemNumber);
            output = output + "Updated for purchase as follows:\n" + park.getMerchandise(itemNumber).toString() + "\n\n";
        } else {
            output = output + "Item number not found.  Method does nothing.\n";
        }
        
        output = output + "\nClick 'OK' to return to menu.";

        JOptionPane.showMessageDialog(null, output);
        
        
    }

    /**
     * The testBuyTicket(AmusementPark park) method utilizes the buyTicket(long id) 
     * method of the AmusementPark class, changing the purchase status on the ticket
     * identified if it was available for sale.
     * @param park : AmusementPark object
    */ 
    public static void testBuyTicket(AmusementPark park) {
        boolean itemFound = false;
        long itemNumber = 0;
        String output = "buyTicket() testing result:\n\n";
        String message = "The buyTicket() method will allow customers to\n"
                        + "buy tickets in inventory.  If the ticket is found,\n"
                        + "and available, the item is sold and the boolean "
                        + "isPurchased is changed from false to true.\n\n"
                        + "Please enter ticket number here:\n"
                        + "Hint: 65001,65012,65031/n ";
        String input = JOptionPane.showInputDialog(message);
        try {
            itemNumber = Integer.parseInt(input);
        } catch(NumberFormatException e) {
            output = output + "Invalid item number entered.\n";
            itemNumber = 0;
        }
        for(Ticket t: park.getTickets()) {
            if(t.getNumber()==itemNumber && !t.isPurchaseStatus()) {
                itemFound = true;
                break;
            } else if(t.isPurchaseStatus()) {
                output = output + "Ticket has already been purchased\n\n";
                
            }
        }
        
        // the buyTicket(long id) method is utilized below after making sure the item is available
        if(itemFound) {
            output = output + "Ticket found and available!\n\nListing before purchase:\n" + park.getTicket(itemNumber).toString() + "\n\n";
            park.buyTicket(itemNumber);
            output = output + "Ticket sold and updated as follows:\n" + park.getTicket(itemNumber).toString() + "\n\n";
        } else {
            output = output + "Item number not found.  Method does nothing.\n";
        }
        
        output = output + "\nClick 'OK' to return to menu.";

        JOptionPane.showMessageDialog(null, output);
        
        
    }
}
