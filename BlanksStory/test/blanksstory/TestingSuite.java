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

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * Suite for running all JUnit tests at once
 * @author Martin Dwyer
 */
@RunWith(Suite.class)
@SuiteClasses({
    NewStoryTest.class,
    StoryTest.class,
    
})

/**
 * TestingSuite is used to run project tests at the same time.  Right click and
 * select "Run File" to run all application unit tests
 * 
 * @author Martin Dwyer
 */
public class TestingSuite {
    
}
