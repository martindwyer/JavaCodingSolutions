package DataBuilder;

import java.util.ArrayList;

/**
 * Class constructs data object for go( ) method testing
 * @author marti
 */
public class GoTestData {
    
    
    public static ArrayList<String[]> goTestData() {
        ArrayList<String[]> goData = new ArrayList<String[]>();
     
        goData.add(go0Data());
        goData.add(go1Data());
        goData.add(go2Data());
        goData.add(go3Data());
        goData.add(go4Data());
        goData.add(go5Data());
        goData.add(go6Data());
        goData.add(go7Data());
        
        return goData;
    }
    
    private static String[] go0Data() {
        
        String[] goData = new String[4];
        
        goData[0] = "Testing for entering 0 in main menu";
        goData[1] = "System should exit";
        goData[2] = "0\n";
        goData[3] = "Enter an option:\n" +
"0: Quit.\n" +
"1: Break the string into substrings (words) using a character as separator.\n" +
"2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
"3: Invert the String.\n" +
"4: Count the unique occurences of each word using punctuation and a character as separators.\n" +
"5: Convert vowels to uppercase and consonants to lowercase.\n" +
"6: Convert to lowercase.";
        
        return goData;
    }
    
    private static String[] go1Data() {
        
        String[] goData = new String[4];
        
        goData[0] = "Testing for entering 1 in main menu";
        goData[1] = "System should prompt user for string for processing";
        goData[2] = "1\n \n \n0\n";
        goData[3] = "Enter an option:\n" +
"0: Quit.\n" +
"1: Break the string into substrings (words) using a character as separator.\n" +
"2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
"3: Invert the String.\n" +
"4: Count the unique occurences of each word using punctuation and a character as separators.\n" +
"5: Convert vowels to uppercase and consonants to lowercase.\n" +
"6: Convert to lowercase.\n" +
"\n" +
"Enter a string up to 1000 characters:\n" +
" \n" +
"Enter the character that will separate words:\n" +
" \n" +
"\n" +
"\n" +
"Enter an option:\n" +
"0: Quit.\n" +
"1: Break the string into substrings (words) using a character as separator.\n" +
"2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
"3: Invert the String.\n" +
"4: Count the unique occurences of each word using punctuation and a character as separators.\n" +
"5: Convert vowels to uppercase and consonants to lowercase.\n" +
"6: Convert to lowercase.";
        
        return goData;
    }
    
    private static String[] go2Data() {
        
        String[] goData = new String[4];
        
        goData[0] = "Testing for entering 2 in main menu";
        goData[1] = "System should prompt user for string for processing";
        goData[2] = "2\n\n0\n";
        goData[3] = "Enter an option:\n" +
"0: Quit.\n" +
"1: Break the string into substrings (words) using a character as separator.\n" +
"2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
"3: Invert the String.\n" +
"4: Count the unique occurences of each word using punctuation and a character as separators.\n" +
"5: Convert vowels to uppercase and consonants to lowercase.\n" +
"6: Convert to lowercase.\n" +
"\n" +
"Enter a string up to 1000 characters:\n" +
"\n" +
"Alphabetic: 0\n" +
"Numeric: 0\n" +
"Other: 0\n" +
"\n" +
"Enter an option:\n" +
"0: Quit.\n" +
"1: Break the string into substrings (words) using a character as separator.\n" +
"2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
"3: Invert the String.\n" +
"4: Count the unique occurences of each word using punctuation and a character as separators.\n" +
"5: Convert vowels to uppercase and consonants to lowercase.\n" +
"6: Convert to lowercase.";
        
        return goData;
    }
    
    private static String[] go3Data() {
        
        String[] goData = new String[4];
        
        goData[0] = "Testing for entering 2 in main menu";
        goData[1] = "System should prompt user for string for processing";
        goData[2] = "3\n\n0\n";
        goData[3] = "Enter an option:\n" +
"0: Quit.\n" +
"1: Break the string into substrings (words) using a character as separator.\n" +
"2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
"3: Invert the String.\n" +
"4: Count the unique occurences of each word using punctuation and a character as separators.\n" +
"5: Convert vowels to uppercase and consonants to lowercase.\n" +
"6: Convert to lowercase.\n" +
"\n" +
"Enter a string up to 1000 characters:\n" +
" \n" +
" \n" +
"Enter an option:\n" +
"0: Quit.\n" +
"1: Break the string into substrings (words) using a character as separator.\n" +
"2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
"3: Invert the String.\n" +
"4: Count the unique occurences of each word using punctuation and a character as separators.\n" +
"5: Convert vowels to uppercase and consonants to lowercase.\n" +
"6: Convert to lowercase.";
        
        return goData;
    }

    private static String[] go4Data() {
        
        String[] goData = new String[4];
        
        goData[0] = "Testing for entering 2 in main menu";
        goData[1] = "System should prompt user for string for processing";
        goData[2] = "4\n \n \n0\n";
        goData[3] = "Enter an option:\n" +
"0: Quit.\n" +
"1: Break the string into substrings (words) using a character as separator.\n" +
"2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
"3: Invert the String.\n" +
"4: Count the unique occurences of each word using punctuation and a character as separators.\n" +
"5: Convert vowels to uppercase and consonants to lowercase.\n" +
"6: Convert to lowercase.\n" +
"\n" +
"Enter a string up to 1000 characters:\n" +
" \n" +
"Enter the character that will separate words:\n" +
" \n" +
"1 \n" +
"\n" +
"Enter an option:\n" +
"0: Quit.\n" +
"1: Break the string into substrings (words) using a character as separator.\n" +
"2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
"3: Invert the String.\n" +
"4: Count the unique occurences of each word using punctuation and a character as separators.\n" +
"5: Convert vowels to uppercase and consonants to lowercase.\n" +
"6: Convert to lowercase.";
        
        return goData;
    }
    
    private static String[] go5Data() {
        
        String[] goData = new String[4];
        
        goData[0] = "Testing for entering 2 in main menu";
        goData[1] = "System should prompt user for string for processing";
        goData[2] = "5\n\n0\n";
        goData[3] = "Enter an option:\n" +
"0: Quit.\n" +
"1: Break the string into substrings (words) using a character as separator.\n" +
"2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
"3: Invert the String.\n" +
"4: Count the unique occurences of each word using punctuation and a character as separators.\n" +
"5: Convert vowels to uppercase and consonants to lowercase.\n" +
"6: Convert to lowercase.\n" +
"\n" +
"Enter a string up to 1000 characters:\n" +
" \n" +
" \n" +
"Enter an option:\n" +
"0: Quit.\n" +
"1: Break the string into substrings (words) using a character as separator.\n" +
"2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
"3: Invert the String.\n" +
"4: Count the unique occurences of each word using punctuation and a character as separators.\n" +
"5: Convert vowels to uppercase and consonants to lowercase.\n" +
"6: Convert to lowercase.";
        
        return goData;
    }
    
    private static String[] go6Data() {
        
        String[] goData = new String[4];
        
        goData[0] = "Testing for entering 2 in main menu";
        goData[1] = "System should prompt user for string for processing";
        goData[2] = "6\n \n0\n";
        goData[3] = "Enter an option:\n" +
"0: Quit.\n" +
"1: Break the string into substrings (words) using a character as separator.\n" +
"2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
"3: Invert the String.\n" +
"4: Count the unique occurences of each word using punctuation and a character as separators.\n" +
"5: Convert vowels to uppercase and consonants to lowercase.\n" +
"6: Convert to lowercase.\n" +
"\n" +
"Enter a string up to 1000 characters:\n" +
" \n" +
" \n" +
"Enter an option:\n" +
"0: Quit.\n" +
"1: Break the string into substrings (words) using a character as separator.\n" +
"2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
"3: Invert the String.\n" +
"4: Count the unique occurences of each word using punctuation and a character as separators.\n" +
"5: Convert vowels to uppercase and consonants to lowercase.\n" +
"6: Convert to lowercase.";
        
        return goData;
    }
    
    private static String[] go7Data() {
        
        String[] goData = new String[4];
        
        goData[0] = "Testing for entering 2 in main menu";
        goData[1] = "System should prompt user with main menu for proper input";
        goData[2] = "7\n0\n";
        goData[3] = "Enter an option:\n" +
"0: Quit.\n" +
"1: Break the string into substrings (words) using a character as separator.\n" +
"2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
"3: Invert the String.\n" +
"4: Count the unique occurences of each word using punctuation and a character as separators.\n" +
"5: Convert vowels to uppercase and consonants to lowercase.\n" +
"6: Convert to lowercase.\n" +
"\n" +
"Enter option 1-6, or 0 to quit.\n" +
"\n" +
"Enter an option:\n" +
"0: Quit.\n" +
"1: Break the string into substrings (words) using a character as separator.\n" +
"2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
"3: Invert the String.\n" +
"4: Count the unique occurences of each word using punctuation and a character as separators.\n" +
"5: Convert vowels to uppercase and consonants to lowercase.\n" +
"6: Convert to lowercase.";
        
        return goData;
    }
        
}
