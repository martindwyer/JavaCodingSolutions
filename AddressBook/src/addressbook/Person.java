/**
 * Student:     Martin Dwyer
 * School:      Walden University
 * Course:      ITEC 6130: Spring 2019
 * Assignment:  Software application, Week 6.
 *
 * Description: The application herein uses the Java TreeMap to construct a contact
 * list, add entries to the list, look up entries, edit entries, delete entries
 * and save the address book.  All address books created in this program are written
 * to files in the src/books package.
 *
 */
package addressbook;

import java.io.Serializable;

/**
 * Person class provides the framework for contact information to be included in
 * the address book application
 *
 * @author Martin Dwyer
 */
public class Person implements Serializable {

    private String name = "";
    private String streetAddress = "";
    private String city = "";
    private String state = "";
    private int zip = 0;
    private long phoneNumber = 0;
    private String emailAddress = "";
    private String website = "";

    /**
     * Simple constructor with name only
     *
     * @param name the name of the person in string form
     */
    public Person(String name) {
        this.name = name;
    }

    /**
     * Comprehensive constructor when detailed information available.
     *
     * @param name the name of the person in string form
     * @param streetAddress the street address in string form
     * @param city the city in string form
     * @param state the state in string form
     * @param zip the zip code, an integer
     * @param phoneNumber the phone number, a long
     * @param emailAddress the email address, a string
     * @param website the website, a string
     */
    public Person(String name, String streetAddress, String city, String state, int zip, long phoneNumber, String emailAddress, String website) {
        this.name = name;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.website = website;
    }

    /**
     * Instance method for returning object name
     *
     * @return name of the person in string form
     */
    public String getName() {
        return name;
    }

    /**
     * Instance method for returning street address
     *
     * @return the person's street address in string form
     */
    public String getStreetAddress() {
        return streetAddress;
    }

    /**
     * Instance method for returning city of residence
     *
     * @return the city of residence in string form
     */
    public String getCity() {
        return city;
    }

    /**
     * Instance method for returning state of residence
     *
     * @return the state of residence in string form
     */
    public String getState() {
        return state;
    }

    /**
     * Instance method for returning zip code
     *
     * @return the object's zip code in int form
     */
    public int getZip() {
        return zip;
    }

    /**
     * Instance method for returning phone number
     *
     * @return the phone number as a long data type
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Instance method for returning phone number as a formatted string
     *
     * @return the phone number formatted as (xxx) xxx - xxxx
     */
    public String getPhoneString() {
        String number = Long.toString(this.phoneNumber);
        String output = "";
        if(number.length() == 10) {
            output = "(" + number.substring(0, 3) + ") " + number.substring(3, 6) + " - " + number.substring(6, 10);
        } else {
            output = "(000) 000 - 0000";
        }
        return output;
    }

    /**
     * Instance method for returning Person object email address
     *
     * @return the object's email address, a string
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Instance method for returning Person object website
     *
     * @return the website as a string
     */
    public String getWebsite() {
        return website;
    }

    /**
     * Sets the name of the Person object
     *
     * @param name the name of the Person object, a string
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the street address of the Person object
     *
     * @param streetAddress the street address of the Person object, a string
     */
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    /**
     * Sets the city of residence for the Person object
     *
     * @param city the city of residence in string form
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * Sets the state for the person object
     *
     * @param state the person's state in string form
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * Sets the zip code for the person object
     *
     * @param zip the person's zip code as an integer
     */
    public void setZip(int zip) {
        this.zip = zip;
    }

    /**
     * Sets the phone number for the person object
     *
     * @param phoneNumber the person's phone number as a Long
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Sets email address for person object
     *
     * @param emailAddress the email address in string form
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * Sets website information for person object
     *
     * @param website the web address for the person
     */
    public void setWebsite(String website) {
        this.website = website;
    }

    /**
     * String override used in development
     *
     * @return string format for person object
     */
    @Override
    public String toString() {
        return "Person{" + "name=" + name + ", streetAddress=" + streetAddress + ", city=" + city + ", state=" + state + ", zip=" + zip + ", phoneNumber=" + phoneNumber + ", emailAddress=" + emailAddress + ", website=" + website + '}';
    }
    

}
