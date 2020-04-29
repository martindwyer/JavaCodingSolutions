/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package addressbook;

import java.util.TreeMap;
import javax.swing.JOptionPane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author marti
 */
public class InputOutputTest {
    
    Person fred,sally,grace,billy,johnny,eddy,joan,jane,simple;
    TreeMap<String,Person> addressBook = new TreeMap<>();
    
    @Before
    public void setUp() {
        fred = new Person("Fred Jones","100 Main Street","Miami","FL",33301,3095551212L,"fred@jones.com","jones.com");
        sally = new Person("Sally Jones","100 Main Street","Miami","FL",33301,3095551212L,"sally@jones.com","jones.com");
        grace = new Person("Grace Jones","100 Main Street","Miami","FL",33301,3095551212L,"grace@jones.com","jones.com");
        billy = new Person("Billy Jones","100 Main Street","Miami","FL",33301,3095551212L,"billy@jones.com","jones.com");
        johnny = new Person("Johnny Jones","100 Main Street","Miami","FL",33301,3095551212L,"johnny@jones.com","jones.com");
        eddy = new Person("Eddy Jones","100 Main Street","Miami","FL",33301,3095551212L,"eddy@jones.com","jones.com");
        joan = new Person("Joan Jones","100 Main Street","Miami","FL",33301,3095551212L,"joan@jones.com","jones.com");
        jane = new Person("Jane Jones","100 Main Street","Miami","FL",33301,3095551212L,"jane@jones.com","jones.com");
        simple = new Person("Simple","","","",0,0L,"","");
        
        addressBook.put(fred.getName(),fred);
        addressBook.put(sally.getName(),sally);
        addressBook.put(grace.getName(),grace);
        addressBook.put(billy.getName(),billy);
        addressBook.put(johnny.getName(),johnny);
        
        
    }

    
    /**
     * Test of searchAddressBook method, of class InputOutput.
     */
    @Test
    public void testSearchAddressBook() {
        JOptionPane.showMessageDialog(null,"Enter 'Fred Jones' for search");
        setUp();
        System.out.println("searchAddressBook");
        Person result = InputOutput.searchAddressBook(addressBook);
        Person expResult = fred;
        assertEquals("searchAddressBook() fails",expResult,result);
    }

    /**
     * Test of addNewContact method, of class InputOutput.
     */
    @Test
    public void testAddNewContact() {
        setUp();
        System.out.println("addNewContact");
        JOptionPane.showMessageDialog(null,"Enter 'Simple' for name and enter or cancel other fields");
        TreeMap<String,Person> testBook = addressBook;
        TreeMap<String, Person> result = InputOutput.addNewContact(addressBook);
        testBook.put(simple.getName(), simple);
        TreeMap<String,Person> expResult = testBook;
        assertEquals("addNewContact() fails",expResult, result);
    }

    /**
     * Test of deleteContact method, of class InputOutput.
     */
    @Test
    public void testDeleteContact() {
        System.out.println("deleteContact");
        JOptionPane.showMessageDialog(null,"Enter 'Fred Jones' for name to be deleted");
        TreeMap<String,Person> testBook = addressBook;
        TreeMap<String, Person> result = InputOutput.deleteContact(addressBook);
        testBook.remove(fred.getName());
        TreeMap<String,Person> expResult = testBook;
        assertEquals("addNewContact() fails",expResult, result);
    }

    /**
     * Test of editContact method, of class InputOutput.
     */
    @Test
    public void testEditContact() {
        setUp();
        System.out.println("editContact");
        JOptionPane.showMessageDialog(null,"Enter 'Fred Jones' for name to edit\n\nChange only 'city' to 'Chicago'\n");
        TreeMap<String,Person> testBook = addressBook;
        TreeMap<String, Person> result = InputOutput.editContact(addressBook);
        Person editFred = (Person)addressBook.get("Fred Jones");
        testBook.remove("Fred Jones");
        editFred.setCity("Chicago");
        testBook.put(editFred.getName(),editFred);
        assertEquals("editContact() fails",testBook
                , result);
    }


    
}
