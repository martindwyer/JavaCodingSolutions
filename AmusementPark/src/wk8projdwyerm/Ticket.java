/**
 * @file        Ticket.java
 * @author      Martin Dwyer
 * @version     1.0
 * @date        2019-02-28
 * @description This file provides the framework for ticket objects
 */
package wk8projdwyerm;

import java.util.Date;

/**
 * The Ticket class provides the framework for ticket objects, working with the 
 * ticket attributes of number, category, holder, date, price, and purchase status
 * 
 * Class        Ticket
 * @author      Martin Dwyer
 * @version     1.0
 */
public class Ticket {

    private long number;
    private String category;
    private String holder;
    private Date date;
    private double price;
    private boolean purchaseStatus;
    
    /**
     * Primary constructor for Ticket objects, specifying 
     * @param number: ticket number
     * @param Category: adult, senior, child
     * @param holder: holder of the ticket
     * @param date : date ticket good for
     * @param price : price to purchase ticket
     */
    public Ticket(long number, String Category, String holder, Date date, double price) {
        this.number=number;
        this.category = Category;
        this.holder = holder;
        this.date = date;
        this.price = price;
    }

    /**
     * Method gets ticket number
     * @return ticket number (long)
     */
    public long getNumber() {
        return number;
    }

    /**
     * Method gets category
     * @return ticket category (adult, senior, child): String
     */
    public String getCategory() {
        return category;
    }

    /**
     * Method gets ticket holder
     * @return ticket holder : String
     */
    public String getHolder() {
        return holder;
    }
    
    /**
     * Method gets ticket date
     * @return ticket date : Date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Method returns ticket price
     * @return ticket price : Double
     */
    public double getPrice() {
        return price;
    }

    /**
     * Method returns purchase status, which is false if the ticket is unsold 
     * and true if the ticket is sold
     * @return ticket status: true or false
     */
    public boolean isPurchaseStatus() {
        return purchaseStatus;
    }

    /**
     * Method sets ticket price
     * @param price : Double
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Method changes purchase status, true if sold, false if not sold
     * @param purchaseStatus : true or false
     */
    public void changePurchaseStatus(boolean purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    /**
     * Method returns String object to represent attributes of ticket object
     * @return String object listing attributes and values
     */
    @Override
    public String toString() {
        return "Ticket{" + "number=" + number + ", category=" + category + ", holder=" + holder + ", date=" + date + ", price=" + price + ", purchaseStatus=" + purchaseStatus + '}';
    }
    
}
