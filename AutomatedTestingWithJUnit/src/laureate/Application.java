package laureate;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;

/**
 * Contains methods for string manipulation through the console
 *
 */
public class Application {
	
	/**
	 * Starts the console driven application.
	 */
	public void go() {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input;
		try {
			while(true) {
				System.out.println("Enter an option:\n" +
                                        "0: Quit.\n" +
                                        "1: Break the string into substrings (words) using a character as separator.\n" +
                                        "2: Count the number of characters, numeric digits, alphabetic characters, and other characters.\n" +
                                        "3: Invert the String.\n" +
                                        "4: Count the unique occurences of each word using punctuation and a character as separators.\n" +
                                        "5: Convert vowels to uppercase and consonants to lowercase.\n" +
                                        "6: Convert to lowercase.");
				input = br.readLine();
                                
				if(input.equals("0")) {
					break;
					
				} else if(input.equals("1")) {
					subString(askForString(br), askForWordDelimiter(br));
					
				} else if(input.equals("2")) {
					charCount(askForString(br));
					
				} else if(input.equals("3")) {
					invert(askForString(br));
					
				} else if(input.equals("4")) {
					uniqueOccurrences(askForString(br), askForWordDelimiter(br));
					
				} else if(input.equals("5")) {
					vowelCase(askForString(br));
					
				} else if(input.equals("6")) {
					toLowercase(askForString(br));
					
				} else {
					System.out.println("Enter option 1-6, or 0 to quit.");
				}
				System.out.println();
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		
		} 
	}
	
	/**
	 * Requests a String from the console.
	 * 
	 * @param br is the console's input.
	 * @return a string for what was entered.
	 */
	protected String askForString(BufferedReader br) {
		System.out.println("Enter a string up to 1000 characters:");
		String result = "";
		try {
			result = br.readLine();
			if(result.length() > 1000) {
				throw new Exception("String must be less than 1000 characters.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;		
	}
	
	/**
	 * Prompts the user for a character to use as a word delimiter.
	 * 
	 * @param br is the console's input.
	 * @return the char word delimiter.
	 */
	protected char askForWordDelimiter(BufferedReader br) {
		char result = ' ';
		String input = "";
		try {
			while(input.length() != 1) {
				System.out.println("Enter the character that will separate words:");
				input = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		result = input.charAt(0);
		return result;
	}
	
	/**
	 * Prints the input with a new line after each space.
	 * 
	 * @param val is the input String.
	 * @param wordDelimiter is the char word separator.
	 */
	protected void subString(String val, char wordDelimiter) {
            
                StringTools input = new StringTools(val);
		
		for(int i = 0; i < input.length(); i++) {
			 
			if(input.getCharAt(i) == wordDelimiter ){
                            System.out.print("\n");
				
			} else {
				System.out.print(input.getCharAt(i));
			}
                }
	}
	
	/**
	 * Prints the count of alphabetic, numeric and other characters.
	 * 
	 * @param val is the input String.
	 */
	protected void charCount(String val) {
		StringTools input = new StringTools(val); 
		
		int alphabeticCount = 0;
		int numericCount = 0;
		int otherCount = 0;
		
		for(int i = 0; i < input.length(); i++) {
			if(String.valueOf(input.getCharAt(i)).matches("\\d")) {
				numericCount++;
				
			} else if(String.valueOf(input.getCharAt(i)).matches("[a-z]")) {
				alphabeticCount++;
			
			} else if(String.valueOf(input.getCharAt(i)).matches("\\S")) {
				otherCount++;
			}
		}
		System.out.println("Alphabetic: " + alphabeticCount);
		System.out.println("Numeric: " + numericCount);
		System.out.println("Other: " + otherCount);
	}	
	
	/**
	 * Prints the input in reverse.
	 * 
	 * @param val  is the input String.
	 */
	protected void invert(String val) {
		StringTools input = new StringTools(val);
		
		for(int i = input.length() - 1; i >= 0; i--) {
			System.out.print(input.getCharAt(i));
		}
	}

	/**
	 * Prints every unique word in the input and the number of occurrences.
	 * 
	 * @param val is the input String.
	 */
	protected void uniqueOccurrences(String val, char delimiter) {

		LinkedHashMap<String, Integer> seen = new LinkedHashMap<String, Integer>();
                String word = "";
                val = val.replaceAll("[.,!?:;'\"-]", "");
                
                for(int i = 0; i < val.length(); i++) {
                    
                    if(val.substring(i, i + 1).matches("[\\"+delimiter+"]+")) {                        
                        checkAndAddWord(seen, word);
                        word = "";
                    
                    } else {
                        
                        word += val.charAt(i);
                        
                        if(i == val.length() - 1){
                            
                            checkAndAddWord(seen, word);
                        }
                    }
                }
                
		for(String w : seen.keySet()) {
			System.out.println(seen.get(w)+ " " + w);
		}
	}
        
        private void checkAndAddWord(LinkedHashMap<String, Integer> seen, String word){
                if(seen.containsKey(word)) {
                    seen.put(word, seen.get(word)+1);
				
                } else {
                    seen.put(word, 1);
                }
        }
        
        /**
         * Converts all vowels to uppercase and all consonants to lowercase.
         * 
         * @param val is the input String.
         */
        protected void vowelCase(String val) {
            StringTools input = new StringTools(val);
            
            for(int i = 0; i < input.length(); i++) {
                char letter = input.getCharAt(i);
                
                switch(letter) {
                    case ' ': 
                        System.out.print(' ');
                        break;
                    case 'A': 
                        System.out.print(letter);
                        break;
                    case 'E': 
                        System.out.print(letter);
                        break;
                    case 'I': 
                        System.out.print(letter);
                        break;
                    case 'O': 
                        System.out.print(letter);
                        break;
                    case 'U': 
                        System.out.print(letter); 
                        break;
                    case 'a': 
                        System.out.print((char) (letter - 32)); 
                        break;
                    case 'e': 
                        System.out.print((char) (letter - 32)); 
                        break;
                    case 'i': 
                        System.out.print((char) (letter - 32)); 
                        break;
                    case 'o': 
                        System.out.print((char) (letter - 32)); 
                        break;
                    case 'u': 
                        System.out.print((char) (letter - 32)); 
                        break;
                    
                    default: 
                        if(Character.isLowerCase(letter)) {
                            System.out.print(letter);
                             
                        } else {
                            System.out.print((char) (letter + 32));
                        }
                }
            }
        }
	
	/**
	 * Prints the input in lower case letters.
	 * 
	 * @param val is the input String.
	 */
	protected void toLowercase(String val) {
		StringTools input = new StringTools(val);
		
		for(int i = 0; i < input.length(); i++) {
			char letter = input.getCharAt(i);
			
			if(String.valueOf(letter).matches("[A-Z]")) {
				System.out.print((char) (letter + 32));
				
			} else {
				System.out.print(letter);
			}
		}
	}
}
