/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bankingconcurrency;

/**
 *
 * @author marti
 */
public class Customer {
        
    public int customerNumber;
    public static int nextCustomerNumber = 1001;
    
    public Customer() {
        this.customerNumber = nextCustomerNumber;
        nextCustomerNumber ++;
    }
            
}
