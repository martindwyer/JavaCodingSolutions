package animalstuff;

import java.io.OutputStream;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * AnimalTest class for testing Animal class constructor and methods
 * 
 * @author Martin Dwyer
 * 
 * Prepared for ITEC 6130, Walden University, March 15, 2019
 */
public class AnimalTest {

    /**
     * Test of movement method, of class Animal.
     */
    @Test
    public void testMovement() {
        //  Testing movement() method
        Animal instance = new Animal("Fish", "Scales");
        String fastMovement = "I run on four legs.";
        String slowMovement = "I walk on four legs.";
        assertEquals("movement() method fails testing for fast movement", fastMovement, instance.movement(true));
        assertEquals("movement() method fails testing for slow movement", slowMovement, instance.movement(false));
        
    }

    /**
     * Test of sound method, of class Animal.
     */
    @Test
    public void testSound() {
        // Testing sound() method
        Animal instance = new Animal("Fish", "Scales");
        String expResult = "";
        String result = instance.sound();
        assertEquals("sound() method fails testing", expResult, result);
        
    }

    /**
     * Test of newInstance method, of class Animal.
     */
    @Test
    public void testNewInstance() {
        // Testing newInstance() method for duck object
        Object aDuck = Animal.newInstance("duck");
        Duck duck = new Duck();
        assertEquals("newInstance() method failed duck test", aDuck, duck);
        
        // Testing newInstance() method for cow
        Object aCow = Animal.newInstance("cow");
        Cow cow = new Cow();
        assertEquals("newInstance() method failed cow test", aCow, cow);

        // Testing newInstance() method for horse
        Object aHorse = Animal.newInstance("horse");
        Horse horse = new Horse();
        assertEquals("newInstance() method failed horse test", aHorse, horse);

        // Testing newInstance() method for human
        Object aHuman = Animal.newInstance("human");
        Human human = new Human();
        assertEquals("newInstance() method failed human test", aHuman, human);
        
        // Testing newInstance() method for ostrich
        Object aOstrich = Animal.newInstance("ostrich");
        Ostrich ostrich = new Ostrich();
        assertEquals("newInstance() method failed ostrich test", aOstrich, ostrich);
        
        // Testing newInstance() method for pig
        Object aPig = Animal.newInstance("pig");
        Pig pig = new Pig();
        assertEquals("newInstance() method failed pig test", aPig, pig);
        
        // Testing newInstance() method for rooster
        Object aRooster = Animal.newInstance("rooster");
        Rooster rooster = new Rooster();
        assertEquals("newInstance() method failed rooster test", aRooster, rooster);
        
        // Testing newInstance() method for turkey
        Object aTurkey = Animal.newInstance("turkey");
        Turkey turkey = new Turkey();
        assertEquals("newInstance() method failed turkey test", aTurkey, turkey);
        
        // Testing that objects are equal when equals() method called from sub-class
        boolean testResult = turkey.equals(aTurkey);
        assertTrue("newIntance() fails sub-class equals() method call", testResult);

    }

    /**
     * Test of print method, of class Animal.
     */
    @Test
    public void testPrint() throws Exception {

        // Testing print() method

        Object instance = Animal.newInstance("duck");
        String result = instance.toString();
        String expResult = "I am a Zebra\n";
        expResult += "\tI have Stripes\n";
        expResult += "\tWhen I go slowly, I walk on four legs.\n";
        expResult += "\tWhen I go fast, I run on four legs.\n";
        expResult += "\tThe sound I make is ''.";
        
        //Prepare to redirect output
        OutputStream os = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(os);
        System.setOut(ps);

        Animal.print("duck");
        
        //Restore normal output
        PrintStream originalOut = System.out;
        System.setOut(originalOut);
        
        assertEquals(instance.toString(), os.toString());

    }

    /**
     * Test of toString method, of class Animal.
     */
    @Test
    public void testToString() {
        Animal instance = new Animal("TestName", "TestCovering");
        String expResult = "I am a TestName\n";
        expResult += "\tI have TestCovering\n";
        expResult += "\tWhen I go slowly, I walk on four legs.\n";
        expResult += "\tWhen I go fast, I run on four legs.\n";
        expResult += "\tThe sound I make is ''.";
        String result = instance.toString();
        assertEquals("toString() method fails", expResult, result);
        System.out.println("toString() method testing passed");

    }

    /**
     * Test of equals method, of class Animal.
     */
    @Test
    public void testEquals() {
        Object obj = null;
        Animal instance = new Animal("Fish", "Scales");

        // Testing not equal to null object
        boolean testResult = instance.equals(obj);
        assertFalse("equals() fails null test", testResult);

        // Testing for known equal objects...
        Animal instanceEqual = new Animal("Fish", "Scales");
        testResult = instance.equals(instanceEqual);
        assertTrue("equals() fails for known equal object...", testResult);

        // Testing for known not-equal objects...
        Animal instanceNotEqual = new Animal("Snake", "Skin");
        testResult = instance.equals(instanceNotEqual);
        assertFalse("equals() fails for known equal object...", testResult);

        // Testing for impersonator: new Animal(Cow,Hair)")
        Animal fakeCow = new Animal("Cow", "Hair");
        Cow cow = new Cow();
        testResult = fakeCow.equals(cow);
        assertFalse("equals() fails the impersonator test", testResult);

    }

}
