/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package animalstuff;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * CowTest class for testing Cow class constructor and methods
 * 
 * @author Martin Dwyer
 * 
 * Prepared for ITEC 6130, Walden University, March 15, 2019
 */
public class CowTest {
    
    /**
     * Test of movement method
     */
    @Test
    public void testMovement() {
        //  Testing movement() method
        Cow instance = new Cow();
        String fastMovement = "I run real fast on four legs";
        String slowMovement = "I walk on four legs";
        assertEquals("movement() method fails testing for fast movement", fastMovement, instance.movement(true));
        assertEquals("movement() method fails testing for slow movement", slowMovement, instance.movement(false));
        
    }
    
    /**
     * Test of sound method
     */
    @Test
    public void testSound() {
        // Testing sound() method
        Cow instance = new Cow();
        String expResult = "Moo Moo Moo";
        String result = instance.sound();
        assertEquals("sound() method fails testing", expResult, result);
        
    }

    /**
     * Test of equals method
     */
    @Test
    public void testEquals() {
        Object obj = null;
        Cow instance = new Cow();

        // Testing not equal to null object
        boolean testResult = instance.equals(obj);
        assertFalse("equals() fails null test", testResult);

        // Testing for known equal objects...
        Cow instanceEqual = new Cow();
        testResult = instance.equals(instanceEqual);
        assertTrue("equals() fails for known equal object...", testResult);

        // Testing for known not-equal objects...
        Bird instanceNotEqual = new Bird("Canary");
        testResult = instance.equals(instanceNotEqual);
        assertFalse("equals() fails for known equal object...", testResult);

        // Testing for impersonator: new Animal(Finch,Feathers)
        Animal faker = new Animal("Cow", "Hair");
        testResult = instance.equals(faker);
        assertFalse("equals() fails the impersonator test", testResult);

    }
    
}
