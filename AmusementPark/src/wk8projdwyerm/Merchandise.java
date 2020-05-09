/**
 * @file        Merchandise.java
 * @author      Martin Dwyer
 * @version     1.0
 * @date        2019-02-28
 * @description This file provides the framework for merchandise items
 * 
 */
package wk8projdwyerm;

/**
 * The Merchandise class provides the framework for merchandise items, working with the 
 * item attributes of id, category, description, price, and whether the item is 
 * available
 * 
 * Class       Merchandise
 * @author      Martin Dwyer
 * @version     1.0
 */
public class Merchandise {
    
    private long id;
    private String category;
    private String description;
    private double price;
    private boolean inStock;
    
    /**
     * Primary constructor for Merchandise items, specifying attributes of the object
     * 
     * @param id : the merchandise id
     * @param category : the category (T-Shirt, Sweatshirt,Stuffed Animal, UNKNOWN)
     * @param description : the description of the item
     * @param price : the price the item sells for
     * @param inStock : whether or not the item is available for sale
     */
    public Merchandise(long id, String category, String description, double price, boolean inStock) {
        this.id = id;
        if(category.equals("T-Shirt") || category.equals("Sweatshirt") || category.equals("Stuffed Animal")) {
            this.category = category;
        } else {
            this.category = "UNKNOWN";
        }
        this.description = description;
        this.price = price;
        this.inStock = inStock;
    }

    /**
     * Method returns item id
     * @return id : long
     */
    public long getId() {
        return id;
    }

    /**
     * Method returns item category
     * @return category : String
     */
    public String getCategory() {
        return category;
    }

    /**
     * Method returns item description
     * @return description : String
     */
    public String getDescription() {
        return description;
    }

    /**
     * Method returns item price
     * @return price : double
     */
    public double getPrice() {
        return price;
    }
    
    /**
     * Method returns item's stock status (true or false)
     * @return true or false : in stock or not in stock
     */
    public boolean isInStock() {
        return inStock;
    }

    /**
     * Method used to set item price
     * @param price : double
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Method used to change item stock status
     * @param inStock : true or false
     */
    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

    /**
     * Method returns String object to represent attributes of item
     * @return String object listing attributes and values
     */
    @Override
    public String toString() {
        return "Merchandise{" + "id=" + id + ", category=" + category + ", description=" + description + ", price=" + price + ", inStock=" + inStock + '}';
    }
      
}
