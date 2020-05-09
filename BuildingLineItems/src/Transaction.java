/**
 * @project RetailTransaction
 * @class   Transaction
 * @version 1.0
 * @author  Martin Dwyer
 * @date    2019-02-10
 * 
 * Description: The Transaction class combines several objects from the LineItem class 
 * and provides various methods to be used for the purchase transaction.  Methods include 
 * a calculation method for determining the total amount due for the purchase transaction, 
 * returning information about line items based on search terms, and for updating line
 * item detail where appropriate.
 * 
 * Testing for this class can be found in "TransactionTest.java"
 * 
 */

import java.util.ArrayList;     // For instance variable 
import java.text.NumberFormat;  // For formatting in toString() method


public class Transaction {
    
    // Creating instance variables
    private ArrayList<LineItem> lineItems = new ArrayList<LineItem>();  // collection of line items
    private int customerID = 0;                                         // customer ID number
    private String customerName = null;                                 // customer name

    // Constructor for class as detailed in project specifications
    public Transaction(int customerID, String customerName) {
        this.customerID = customerID;
        this.customerName = customerName;
    }

    // Method to add line items to the ArrayList collection
    public void addLineItem(String itemName,int quantity, double price)  {
        this.lineItems.add(new LineItem(itemName,quantity,price));
    }
    
    // Method to update existing line item in the Transaction instance
    public void updateItem(String itemName, int quantity, double price) {
        for(LineItem lineItem: this.lineItems) {
            if(lineItem.getName().equals(itemName)) {
                lineItem.setQuantity(quantity);
                lineItem.setPrice(price);
            }
            // No action taken if item name not found
        }
    }
    
    // Method to determine total due for the shopping transaction
    public double getTotalPrice() {
        double totalPrice = 0.0;
        for(LineItem lineItem: this.lineItems) {
            totalPrice += lineItem.getTotalPrice();
        }
        return totalPrice;
    }
    
    // Method to return line item detail based on name search
    public String getLineItem(String itemName) {
        
        // Default message for item not found
        String result = itemName + " not found" + "\n";
        
        for(LineItem lineItem: this.lineItems) {
            if(lineItem.getName().equals(itemName)) {
                
                // Changing result if line item found
                result = lineItem.toString();
            } 
        }
        return result;
    }
    
    @Override
    public String toString() {
        // Using NumberFormat class to format currency items
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        
        // String output for shopping card will be held in 'output' object
        String output = "SHOPPING CART" + "\n" + "\n";
        
        // Adding customer name and ID
        output += "Customer Name:\t" + this.customerName + "\n";
        output += "Customer ID:  \t" + this.customerID + "\n" + "\n";
        
        // Adding line item detail for transaction
        output += String.format("%-25s","Item Description") + String.format("    %2s   %6s","","") + String.format("%10s","Total") + "\n";
        
        // Utilzing the LineItem toString() method, produce output for each line item
        for(LineItem lineItem: lineItems) {
            output += lineItem.toString();
            }
        
        // Created formatted footer of output, including total price for transaction
        output += "\n";
        output += String.format("%-25s","Transaction Total") + String.format("    %2s   %6s","","")+ String.format("%10s",cf.format(this.getTotalPrice())) + "\n";
        output += "\n" + "\n";
        
        
        return output;
        
        
    }
    
    
    
    
    
    
}
