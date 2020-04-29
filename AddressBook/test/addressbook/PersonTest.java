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

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * PersonTest provides unit testing for the Person class
 * 
 * @author Martin Dwyer
 */
public class PersonTest {
    
    /**
     * Setting up a testing Person object named fredJones
     * 
     * @return a Person object for testing
     * 
     */   
    public Person getFredJones() {
        Person fredJones = new Person("Fred Jones","100 Main Street","Miami","FL",33301,3095551212L,"fred@jones.com","jones.com");
        
        return fredJones;
    }
    
    
    /**
     * Test of getName method, of class Person.
     */
    @Test
    public void testGetName() {
        Person instance = getFredJones();
        System.out.println("getName");
        String expResult = "Fred Jones";
        String result = instance.getName();
        assertEquals("getName() method fails",expResult, result);        
    }

    /**
     * Test of getStreetAddress method, of class Person.
     */
    @Test
    public void testGetStreetAddress() {
        Person instance = getFredJones();
        System.out.println("getStreetAddress");
        String expResult = "100 Main Street";
        String result = instance.getStreetAddress();
        assertEquals("getStreetAddress() fails",expResult, result);     
    }

    /**
     * Test of getCity method, of class Person.
     */
    @Test
    public void testGetCity() {
        System.out.println("getCity");
        Person instance = getFredJones();
        String expResult = "Miami";
        String result = instance.getCity();
        assertEquals("getCity() fails",expResult, result);      
    }

    /**
     * Test of getState method, of class Person.
     */
    @Test
    public void testGetState() {
        System.out.println("getState");
        Person instance = getFredJones();
        String expResult = "FL";
        String result = instance.getState();
        assertEquals("getState() fails",expResult, result);
    }

    /**
     * Test of getZip method, of class Person.
     */
    @Test
    public void testGetZip() {
        System.out.println("getZip");
        Person instance = getFredJones();
        int expResult = 33301;
        int result = instance.getZip();
        assertEquals("getZip() fails",expResult, result);
    }

    /**
     * Test of getPhoneNumber method, of class Person.
     */
    @Test
    public void testGetPhoneNumber() {
        System.out.println("getPhoneNumber");
        Person instance = getFredJones();
        long expResult = 3095551212L;
        long result = instance.getPhoneNumber();
        assertEquals("getPhoneNumber() fails",expResult, result);
    }

    /**
     * Test of getPhoneString method, of class Person.
     */
    @Test
    public void testGetPhoneString() {
        System.out.println("getPhoneString");
        Person instance = getFredJones();
        String expResult = "(309) 555 - 1212";
        String result = instance.getPhoneString();
        assertEquals("getPhoneString() fails",expResult, result);
    }

    /**
     * Test of getEmailAddress method, of class Person.
     */
    @Test
    public void testGetEmailAddress() {
        System.out.println("getEmailAddress");
        Person instance = getFredJones();
        String expResult = "fred@jones.com";
        String result = instance.getEmailAddress();
        assertEquals("getEmailAddress() fails",expResult, result);
    }

    /**
     * Test of getWebsite method, of class Person.
     */
    @Test
    public void testGetWebsite() {
        System.out.println("getWebsite");
        Person instance = getFredJones();
        String expResult = "jones.com";
        String result = instance.getWebsite();
        assertEquals("getWebsite() fails",expResult, result);
    }

    /**
     * Test of setName method, of class Person.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Sam Jones";
        Person instance = getFredJones();
        instance.setName(name);
        String expResult = "Sam Jones";
        String result = instance.getName();
        assertEquals("setName() fails",expResult,result);
    }

    /**
     * Test of setStreetAddress method, of class Person.
     */
    @Test
    public void testSetStreetAddress() {
        System.out.println("setStreetAddress");
        String streetAddress = "101 Holiday Road";
        Person instance = getFredJones();
        instance.setStreetAddress(streetAddress);
        String expResult = "101 Holiday Road";
        String result = instance.getStreetAddress();
        assertEquals("setStreetAddress() fails",expResult,result);     
    }

    /**
     * Test of setCity method, of class Person.
     */
    @Test
    public void testSetCity() {
        System.out.println("setCity");
        String city = "West Palm Beach";
        Person instance = getFredJones();
        instance.setCity(city);
        String expResult = "West Palm Beach";
        String result = instance.getCity();
        assertEquals("setCity() fails",expResult,result);
    }

    /**
     * Test of setState method, of class Person.
     */
    @Test
    public void testSetState() {
        System.out.println("setState");
        String state = "Arizona";
        Person instance = getFredJones();
        instance.setState(state);
        String expResult = "Arizona";
        String result = instance.getState();
        assertEquals("setCity() fails",expResult,result);
    }

    /**
     * Test of setZip method, of class Person.
     */
    @Test
    public void testSetZip() {
        System.out.println("setZip");
        int zip = 0;
        Person instance = getFredJones();
        instance.setZip(zip);
        int expResult = 0;
        int result = instance.getZip();
        assertEquals("setZip() fails",expResult,result);
    }

    /**
     * Test of setPhoneNumber method, of class Person.
     */
    @Test
    public void testSetPhoneNumber() {
        System.out.println("setPhoneNumber");
        long phoneNumber = 0L;
        Person instance = getFredJones();
        instance.setPhoneNumber(phoneNumber);
        Long expResult = 0L;
        Long result = instance.getPhoneNumber();
        assertEquals("setPhoneNumber() fails",expResult,result);
    }

    /**
     * Test of setEmailAddress method, of class Person.
     */
    @Test
    public void testSetEmailAddress() {
        System.out.println("setEmailAddress");
        String emailAddress = "";
        Person instance = getFredJones();
        instance.setEmailAddress(emailAddress);
        String expResult = "";
        String result = instance.getEmailAddress();
        assertEquals("setEmailAddress() fails",expResult,result);
    }

    /**
     * Test of setWebsite method, of class Person.
     */
    @Test
    public void testSetWebsite() {
        System.out.println("setWebsite");
        String website = "";
        Person instance = getFredJones();
        instance.setWebsite(website); 
        String expResult = "";
        String result = instance.getWebsite();
        assertEquals("setWebsite() fails",expResult,result);
    }

    /**
     * Test of toString method, of class Person.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Person instance = getFredJones();
        String expResult = "Person{name=Fred Jones, streetAddress=100 Main Street, city=Miami, state=FL, zip=33301, phoneNumber=3095551212, emailAddress=fred@jones.com, website=jones.com}";
        String result = instance.toString();
        assertEquals("toString() fails",expResult, result);
    }
    
}
