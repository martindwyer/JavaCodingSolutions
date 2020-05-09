
package animalstuff;


import org.junit.Test;
import static org.junit.Assert.*;

/**
 * MammalTest class for testing Mammal class constructor and methods
 * 
 * @author Martin Dwyer
 * 
 * Prepared for ITEC 6130, Walden University, March 15, 2019
 */
public class MammalTest {
    
    /**
     * Test of movement method
     */
    @Test
    public void testMovement() {
        //  Testing movement() method
        Mammal instance = new Mammal("Lion");
        String fastMovement = "I run fast on four legs";
        String slowMovement = "I walk slow on four legs";
        assertEquals("movement() method fails testing for fast movement", fastMovement, instance.movement(true));
        assertEquals("movement() method fails testing for slow movement", slowMovement, instance.movement(false));
        
    }
    
    /**
     * Test of sound method
     */
    @Test
    public void testSound() {
        // Testing sound() method
        Mammal instance = new Mammal("Lion");
        String expResult = "Roar";
        String result = instance.sound();
        assertEquals("sound() method fails testing", expResult, result);
        
    }

    /**
     * Test of equals method
     */
    @Test
    public void testEquals() {
        Object obj = null;
        Mammal instance = new Mammal("Lion");

        // Testing not equal to null object
        boolean testResult = instance.equals(obj);
        assertFalse("equals() fails null test", testResult);

        // Testing for known equal objects...
        Mammal instanceEqual = new Mammal("Lion");
        testResult = instance.equals(instanceEqual);
        assertTrue("equals() fails for known equal object...", testResult);

        // Testing for known not-equal objects...
        Bird instanceNotEqual = new Bird("Canary");
        testResult = instance.equals(instanceNotEqual);
        assertFalse("equals() fails for known equal object...", testResult);

        // Testing for impersonator: new Animal(Finch,Feathers)
        Animal faker = new Animal("Lion", "Hair");
        testResult = instance.equals(faker);
        assertFalse("equals() fails the impersonator test", testResult);

    }

    
}
