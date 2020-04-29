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
 * The NewStory class takes an original story with brackets to be replaced, prompts 
 * the user, and generates a new story based on user responses
 * 
 * @author Martn Dwyer
 */
public class NewStory {

    /**
     * The makeStory() method takes the story in ArrayList format and produces a 
     * completed story with user input, returning that story in text format 
     * 
     * @param story an ArrayList representation of the story.txt file 
     * @return a text string with a newly revised story
     */
    public static String makeStory(ArrayList<String> story) {
        // Create string object to hold the story, concatenating all lines of
        // the story to one text, and then replacing items in brackets
        String tempString = "";
        boolean isEndOfArray = false;
        int k = 0;
        while(!isEndOfArray) {
            try {
                if(story.get(k).equals("")) {
                    tempString += "<br><br>";
                    k++;
                } else {
                    tempString += story.get(k);
                    k++;
                }
            } catch (IndexOutOfBoundsException e) {
                isEndOfArray = true;
            }
        } 
        if(tempString.length()> 0) {
            tempString = changeBlankToWord(tempString);
        } else {
            System.out.println("Array has not read into tempString");
        }
        
        return tempString;
    }

    /**
     * The changeBlankToWord() method takes in a text string, finds the items in blanks
     * that need to be replaced, prompts the user for input, and returns the text
     * string with all blank items replaced
     * 
     * param lineOfText a text string with bracketed items for user input
     * @return a text string with no bracketed items remaining
     */
    public static String changeBlankToWord(String lineOfText) {
        int n1,n2;
        String subString, askingFor, input;
        String blanksGone = lineOfText;

        boolean doneWithBlanks = false;
        while (!doneWithBlanks) {
            try {
                n1 = blanksGone.indexOf("[");
                n2 = blanksGone.indexOf("]");
                subString = blanksGone.substring(n1, n2 + 1);
                askingFor = subString.substring(1, subString.length() - 1);
                if (askingFor.charAt(0) == 'a' || askingFor.charAt(0) == 'e' || askingFor.charAt(0) == 'i' || askingFor.charAt(0) == 'o' || askingFor.charAt(0) == 'u') {
                    askingFor = "an " + askingFor;
                } else {
                    askingFor = "a " + askingFor;
                }
                input = JOptionPane.showInputDialog(null, "Enter in " + askingFor);
                blanksGone = blanksGone.replace(subString, input);
                
            } catch (StringIndexOutOfBoundsException e) {
                doneWithBlanks = true;
            }
        }

        return blanksGone;

    }

}
