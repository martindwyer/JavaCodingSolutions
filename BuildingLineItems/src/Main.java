/**
 * @project RetailTransaction
 * @class   Main
 * @version 1.0
 * @author  Martin Dwyer
 * @date    2019-02-10
 * 
 * Description: The Main class in the RetailTransaction project is designed for 
 * testing the LineItem and Transaction classes.  The testing can be performed 
 * separately by compiling and running the test class for each.  
 * 
 * The LineItemTest class provides a testing data for the LineItem class.
 * The file establishes LineItem objects, referred to as products purchased, and uses the 
 * various methods as detailed in the projects specifications and provided in the 
 * LineItem class. 
 * 
 * The TransactionTest class provides testing for the Transaction class.
 * The file establishes a transaction object, referred to as shoppingCart, adds several 
 * LineItem objects to the shoppingCart object, and displays the shopping cart.  After 
 * the shoppingCart object is established, the program updates line items and displays 
 * the revised shoppingCart object.
 * 
 * While the combined files can be run and viewed from Main, comments and source 
 * code exist in the individual classes.  
 * 
 */

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        
        // Testing LineItem class
        System.out.println("------------------------------");
        System.out.println("Testing the LineItem Class:  ");
        LineItemTest.main(args);
        
        // Testing Transaction class
        System.out.println("\n\n------------------------------");
        System.out.println("Testing the Transaction Class:  ");
        TransactionTest.main(args);
       
    }
    
}
