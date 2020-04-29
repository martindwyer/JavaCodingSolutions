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

/**
 *
 * @author marti
 */
public class BlanksStory {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        // ArrayList story instantiated to hold original story
        ArrayList<String> story = Story.getStory();
        
        // Original story is sent to NewStory, where it is transformed into a string
        // and all items in brackets are replaced appropriately
        String revisedStory = NewStory.makeStory(story);
        
        // Output new story to the user
        JOptionPane.showMessageDialog(null, "<html><body><p style='width: 400px;'>" + revisedStory + "</p></body></html>");

    }

    

}
