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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;

/**
 * Class Story provides the methods for retrieving the original story template
 * 
 * @author Martin Dwyer
 */
public class Story {

    /**
     * The getStory() method retrieves a text file and places the file in an
     * ArrayList object
     * 
     * @return the story as read in by line in ArrayList format
     * 
     */
    public static ArrayList<String> getStory() {
        ArrayList<String> newStory = new ArrayList<String>();
        File file = null;
        boolean isGoodFileName = false;
        String fileName = "";
        while (!isGoodFileName) {
            try {
                // Setting up new file chooser object
                JFileChooser chooser = new JFileChooser();
                chooser.setDialogTitle("Load which file?");
                int result = chooser.showOpenDialog(null);
                if (result == JFileChooser.APPROVE_OPTION) {
                    file = chooser.getSelectedFile();
                }

                // The following section uses a boolean for tracking file name status
                try {
                    fileName = file.getCanonicalPath();
                    isGoodFileName = true;
                } catch (FileNotFoundException e) {
                    // will keep trying here
                } catch (IOException e) {
                    // will keep trying to find file here too
                }

                isGoodFileName = true;
            } catch (NullPointerException e) {
                // Tryiing again until we can make isGoodFileName true: not yet
            }
        }

            boolean isGoodReader = false;
            BufferedReader myReader = null;
            while (!isGoodReader) {
                try {
                    myReader = new BufferedReader(new FileReader(fileName));
                    isGoodReader = true;
                } catch (FileNotFoundException e) {
                    // Since fileName has been verified above - should not be an issue
                }
            }

            boolean isEndOfFile = false;
            String line = null;
            while (!isEndOfFile) {
                try {
                    line = myReader.readLine();
                    if (line != null) {
                        newStory.add(line);
                    } else {
                        isEndOfFile = true;
                    }
                } catch (IOException e) {
                    isEndOfFile = true;
                }

            }
            
            return newStory;
        }

    }
