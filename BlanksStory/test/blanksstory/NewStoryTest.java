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
 * Testing for the NewStory class
 * 
 * @author Martin Dwyer
 */
public class NewStoryTest {
    
    /**
     * Test of makeStory method, of class NewStory.
     */
    @Test
    public void testMakeStory() {
        // Testing with test text used in tester.txt in the blanksstory Test Package
        System.out.println("makeStory");
        JOptionPane.showMessageDialog(null,"On the prompts ahead enter: \n\n'Math' for noun \n\n'Spring' for annual event\n\n");
        ArrayList<String> story = new ArrayList();
        story.add("So, here I am working on [noun] even though the [large annual ");
        story.add("event] is getting to be really near and the weather so nice.  So,");
        String expResult = "So, here I am working on Math even though the Spring is getting to be really near and the weather so nice.  So,";
        String result = NewStory.makeStory(story);
        assertEquals(expResult, result);        
    }

    /**
     * Test of changeBlankToWord method, of class NewStory.
     */
    @Test
    public void testChangeBlankToWord() {
        System.out.println("changeBlankToWord");
        String lineOfText = "So, here I am working on [noun] even though the [annual event] is getting to be really near and the weather so nice.  So,";
        JOptionPane.showMessageDialog(null,"On the prompts ahead enter: \n\n'Math' for noun \n\n'Spring' for annual event\n\n");
        String expResult = "So, here I am working on Math even though the Spring is getting to be really near and the weather so nice.  So,";
        String result = NewStory.changeBlankToWord(lineOfText);
        assertEquals(expResult, result);
        
    }
    
}
