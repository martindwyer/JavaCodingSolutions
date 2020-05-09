/**
 * @project RetailTransaction
 * @class   LineItem
 * @version 1.0
 * @author  Martin Dwyer
 * @date    2019-02-10
 *
 *
 * Description: The LineItem class represents an individual line item of merchandise
 * that a customer is purchasing.
 * 
 * Testing for this class can be found in "LineItemTest.java"
 * 
 */

import java.text.NumberFormat;  // For formatting in toString() method

public class LineItem {

    // Instance variables as specified
    private String itemName;        // Product purchased
    private int quantity;           // quantity purchased
    private double price;           // price charged

    // Constructor as detailed in project specifications
    public LineItem(String itemName, int quantity, double price) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.price = price;
    }

    // Getter method to return itemName for LineItem instance
    public String getName() {
        return itemName;
    }

    // Getter method to return quantity for LineItem instance    
    public int getQuantity() {
        return quantity;
    }

    // Getter method to return price for LineItem instance    
    public double getPrice() {
        return price;
    }

    // Setter method to set quantity for LineItem instance
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Setter method to set price for LineItem instance
    public void setPrice(double price) {
        this.price = price;
    }

    // Method to determine total price for the purchased item and quantity
    public double getTotalPrice() {
        return this.quantity * this.price;
    }

    // Produce string text for LineItem object as detailed in project specifications
    @Override
    public String toString() {
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        NumberFormat nf = NumberFormat.getNumberInstance();

        double totalPrice = price * quantity;

        return String.format("%-25s", itemName) + String.format("qty %2s @ %6s", nf.format(quantity), cf.format(price)) + String.format("%10s", cf.format(totalPrice)) + "\n";
    }
}
