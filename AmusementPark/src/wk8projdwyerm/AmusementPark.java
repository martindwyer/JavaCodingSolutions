/**
 * @file        AmusementPark.java
 * @author      Martin Dwyer
 * @version     1.0
 * @date        2019-02-28
 * @description This file provides the framework for AmusementPark class, which
 *              incorporates Ticket and Merchandise objects.
 */
package wk8projdwyerm;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * The AmusementPark class is used to create a framework for amusement parks, with
 * objects comprised of three attributes.  The first attribute, a String, is the 
 * amusement park name.  The other two attributes are ArrayList objects; (1) a 
 * collection of ticket objects for park entry, and (2) a collection of 
 * merchandise objects for sale at the gift shop.
 * 
 * Class       AmusementPark
 * @author      Martin Dwyer
 * @version     1.0
 */
public class AmusementPark {

    private ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    private ArrayList<Merchandise> merchandise = new ArrayList<Merchandise>();
    private String name;

    /**
     * The park name is the sole required parameter for the class constructor
     * @param name park name : String
     */
    public AmusementPark(String name) {
        this.name = name;
    }

    /**
     * Method returns the name of the park
     * @return name : a String
     */
    public String getName() {
        return name;
    }

    /**
     * Method provides a list of dates on which tickets are available
     * @return list of dates : ArrayList of Date objects
     */
    public ArrayList<Date> getTicketDates() {
        
        ArrayList<Date> dates = new ArrayList<Date>();
        ArrayList<Date> tempList = new ArrayList<Date>();
        Set<Date> dateSet = new LinkedHashSet<>();
        
        for (Ticket ticket : tickets) {
            if(!ticket.isPurchaseStatus()) {
                tempList.add(ticket.getDate());
            }
        }
        
        dateSet.addAll(tempList);
        dates.addAll(dateSet);
        
        return dates;
    }

    /**
     * Method provides a list of all tickets 
     * @return a list of tickets : ArrayList of Ticket objects
     */
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
    
    /**
     * Method provides the number of tickets available for specified date
     * @param date : Date ticket provides access to the park
     * @return number of tickets available : int
     */
    public int getTickets(Date date) {
        ArrayList<Ticket> ticketsAvailable = new ArrayList<Ticket>();
        for (Ticket ticket : tickets) {
            if (ticket.getDate().equals(date) && !ticket.isPurchaseStatus()) {
                ticketsAvailable.add(ticket);
            }
        }
        return ticketsAvailable.size();
    }

    /**
     * Method returns ticket information for a specified ticket id
     * @param id : unique identifier for ticket (long)
     * @return ticket : Ticket object
     */
    public Ticket getTicket(long id) {
        
        Ticket t = null;
        for (Ticket ticket : tickets) {
            if (ticket.getNumber() == id) {
                t = ticket;
            }
        }
        return t;
    }

    /**
     * Method provides a list of all merchandise items
     * @return a list of merchandise items : ArrayList of Merchandise objects
     */
    public ArrayList<Merchandise> getMerchandise() {
        return this.merchandise;
    }

    /**
     * Method provides a list of all merchandise items for specified category
     * 
     * @param category : category of inventory to be selected
     * @return a list of merchandise items : ArrayList of Merchandise objects
     */
    public ArrayList<Merchandise> getMerchandise(String category) {
        ArrayList<Merchandise> categoryItems = new ArrayList<Merchandise>();
        for (Merchandise item : this.merchandise) {
            if (item.getCategory().equalsIgnoreCase(category)) {
                categoryItems.add(item);
            }
        }
        return categoryItems;
    }

    /**
     * Method provides a merchandise item for specified id
     * 
     * @param id : unique identifier for merchandise object (long)
     * @return a list of merchandise items : ArrayList of Merchandise objects
     */
    public Merchandise getMerchandise(long id) {
        Merchandise search = null;
        for (Merchandise item : this.merchandise) {
            if (item.getId() == id) {
                search = item;
            }
        }
        return search;
    }

    /**
     * Method adds ticket to ArrayList of AmusementPark object tickets
     * @param ticket : Ticket object
     */
    public void addTicket(Ticket ticket) {
        this.tickets.add(ticket);
    }

    /**
     * Method adds merchandise item to ArrayList of AmusementPark object merchandise
     * @param item : Merchandise object
     */
    public void addMerchandise(Merchandise item) {
        this.merchandise.add(item);
    }

    /**
     * Method changes the in stock status for item, if item available for sale
     * @param id : unique merchandise identifier (String)
     */
    public void buyMerchandise(long id) {
        for(Merchandise item: this.getMerchandise()) {
            if(item.getId()==id && item.isInStock()) {
                item.setInStock(false);
            }
        }
    }

    /**
     * Method changes the purchase status for ticket, if ticket available for sale
     * @param id : unique ticket identifier (long)
     */
    public void buyTicket(long id) {
        for(Ticket t: this.getTickets()) {
            if(t.getNumber()==id && !t.isPurchaseStatus()) {
                t.changePurchaseStatus(true);
            }
        }
    }    

    
}
