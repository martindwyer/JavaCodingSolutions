
/**
 * @project RetailTransaction
 * @class   LineItemTest
 * @version 1.0
 * @author  Martin Dwyer
 * @date    2019-02-10
 * 
 * Description: The LineItemTest class provides a testing data for the LineItem class.
 * The file establishes LineItem objects, referred to as products purchased, and uses the 
 * various methods as detailed in the projects specifications and provided in the 
 * LineItem class. 
 */

public class LineItemTest {

    public static void main(String[] args) {
        // Creating LineItem objects as products purchased
        
        LineItem productOne = new LineItem("Colgate Toothpaste",2,2.99);
        LineItem productTwo = new LineItem("Bounty Paper Towels",1,1.49);
        LineItem productThree = new LineItem("Kleenex Tissue",1,2.49);
        
        System.out.println("Creating three new instance objects with: ");
        System.out.println("LineItem productOne = new LineItem(\"Colgate Toothpaste\",2,2.99);");
        System.out.println("LineItem productTwo = new LineItem(\"Bounty Paper Towels\",1,1.49);");
        System.out.println("LineItem productThree = new LineItem(\"Kleenex Tissue\",1,2.49);");
        
        // Testing getter and setter methods
        System.out.println("\nTesting Getter and Setter Methods on productOne:");
        System.out.println("\nOriginal quantity: " + productOne.getQuantity());
        productOne.setQuantity(4);
        System.out.println("Revised quantity: " + productOne.getQuantity());

        System.out.println("\nOriginal price: " + productOne.getPrice());
        productOne.setPrice(3.35);
        System.out.println("Revised price: " + productOne.getPrice());
        
        // Testing toString() and totalPrice() methods
        System.out.println("\nTesting toString() and totalPrice() methods:\n");
        System.out.print(productOne.toString());
        System.out.print(productTwo.toString());
        System.out.print(productThree.toString());
        
    }
    
}
