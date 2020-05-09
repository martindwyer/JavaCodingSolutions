/**
 * @project RetailTransaction
 * @class   TransactionTest
 * @version 1.0
 * @author  Martin Dwyer
 * @date    2019-02-10
 * 
 * Description: The TransactionTest class provides testing for the Transaction class.
 * The file establishes a transaction object, referred to as shoppingCart, adds several 
 * LineItem objects to the shoppingCart object, and displays the shopping cart.  After 
 * the shoppingCart object is established, the program updates line items and displays 
 * the revised shoppingCart object.
 */


import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class TransactionTest {

    public static void main(String[] args) throws IOException {
        /**
         * Getting customer name and ID set to constants for the present illustration utilizes 
         * the getCustomer() and getID() methods from the main class
         */
        String customerName = getCustomer();    // Customer name
        int customerID = getID();               // Customer ID

        //  Set up transaction shopping cart with constructor from the Transaction class
        Transaction shoppingCart = new Transaction(customerID, customerName);
        System.out.println("Created a new instance of Transaction class with: ");
        System.out.println("Transaction shoppingCart = new Transaction(customerID, customerName);");
        
        
        /**
         * The addLineItems() method opens a file with line item detail and adds the line 
         * items to the shopping cart using the Transaction class addLineItem(itemName,quantity,price) 
         * method as defined in projects specifications         * 
        */
        
        shoppingCart = addLineItems(shoppingCart);
        System.out.println("Successfully added 10 line items from lineitems.txt");
        System.out.println("The method addLineItem() was used to add each item.");
        
        // Display shopping cart utilizes the toString() and getTotalPrice() methods  
        System.out.println("\nORIGINAL SHOPPING CART\n");
        System.out.print(shoppingCart.toString());
        
        // Revise shopping cart with the class updateItem() method
        System.out.println("Successfully updated line items with the updateItem() method");
        System.out.println("shoppingCart.updateItem(\"Kleenex Tissue\",3,2.49);");
        System.out.println("shoppingCart.updateItem(\"Glad Garbage Bags\",1,6.48);");
        shoppingCart.updateItem("Kleenex Tissue",3,2.49);     // updated quantity
        shoppingCart.updateItem("Glad Garbage Bags",1,6.48);  // updated price
        
        System.out.println("\nKleenex Tissue quantity increased to 3");
        System.out.println("Glad Garbage Bags price changed to $6.48\n");
        
        // Display revised shopping cart
        System.out.println("\nREVISED SHOPPING CART\n");
        System.out.print(shoppingCart.toString());
        
        // Testing the getLineItem() method in the Transaction class
        System.out.println("\nTesting the getLineItem() method with: ");
        System.out.println("shoppingCart.getLineItem(\"Glad Garbage Bags\")\n");
        // Get information about a known LineItem object in shoppingCart
        System.out.println("Searching for 'Glad Garbage Bags' in shopping cart: ");
        System.out.print(shoppingCart.getLineItem("Glad Garbage Bags"));
        
        // Get standard response when search for line item is empty
        System.out.println("\nSearching for 'Pickles' in shopping cart: ");
        System.out.print(shoppingCart.getLineItem("Pickles"));
        
    }

    // The following method returns customer name
    public static String getCustomer() {
        return "Fred Flintstone";
    }
    // The following method returns customer ID
    public static int getID() {
        return 456123;
    }

    // The following method imports line items from a text file and adds them to the shopping cart object
    public static Transaction addLineItems(Transaction shoppingCart) throws IOException {
        
        // Open the file with line item detail
        File file = new File("src/lineitems.txt");
        Scanner inputFile = new Scanner(file);

        // Set up lineCounter to track input
        String input = "";          // object to hold file line input
        String productName = "";    // object used to hold item name
        int quantityPurchased = 0;  // object to hold quantity
        double priceCharged = 0.0;  // object to hold price for the item
        int lineCounter = 0;        // placeholder for line items
        
        // Read line items from the file as long as file has lines
        while (inputFile.hasNext()) {
            lineCounter++;
            input = inputFile.nextLine();
            
            // Depending on placeholder, assign value from input to line item
            switch (lineCounter) {
                case 1:
                    productName = input;
                    break;
                case 2:
                    quantityPurchased = Integer.parseInt(input);
                    break;
                case 3:
                    priceCharged = Double.parseDouble(input);
                    break;
            }
            
            // After each line item has been gathered from file
            if (lineCounter % 3 == 0) {
                
                // Add LineItem object to shoppingCart
                shoppingCart.addLineItem(productName,quantityPurchased,priceCharged);
                
                // reset the placeholder
                lineCounter = 0;
            }
            
        }
        // Close the line item detail file.
        inputFile.close();
        
        // return completed shoppingCart (a Transaction class object)
        return shoppingCart;
    }

}
