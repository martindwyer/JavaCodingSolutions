/**
 * Student:     Martin Dwyer
 * Class:       ITEC 6130, Walden University, Spring 2019
 * Week:        5
 *
 * Description: This week's application provides a Java project application to play
 * a "Fill in the Blanks" game.  The application reads in a story in text format, 
 * with items to be completed in brackets.  The user is prompted based on the info 
 * in the brackets, and the information is placed into a completed story.  The 
 * completed story is presented to the user on the screen. 
 * 
 */
package blanksstory;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Testing for the Story class
 * 
 * @author Martin Dwyer
 */
public class StoryTest {
    
    /**
     * Test of getStory method, of class Story.
     */
    @Test
    public void testGetStory() {
        
        // This test uses the abbreviated file tester.txt in the Test Package blanksstory
        System.out.println("getStory");
        ArrayList<String> expResult = new ArrayList();
        expResult.add("So, here I am working on [noun] even though the [large annual ");
        expResult.add("event] is getting to be really near and the weather so nice.  So,");
        JOptionPane.showMessageDialog(null,"\nFor testing, you will need to select tester.txt\n\nin the Test Package blanksstory");
        ArrayList<String> result = Story.getStory();
        assertEquals("First element not the same",expResult.get(0), result.get(0));
        assertEquals("Second element not the same",expResult.get(1), result.get(1));
        assertEquals("Size not the same",expResult.size(),result.size());
        assertEquals("Arrays not the same",expResult,result);
        
    }
    
}
