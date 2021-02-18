import java.util.Random;

/**
 * This file has only 17 lines of essential code.  Most of the file consists of expanatory comments.
 * Proper shuffling without repeating entries is hard to find but not that hard to accomplish.  The
 * critical part is repetitive usage of array replacement (lines 35 through 50).
 */
public class Shuffle {

    public static void main(String[] args) {

        // Shuffling an array of chars
        char[] charArray = {'A','B','C','D'};
        char[] shuffledChars = new char[4];
        Random r = new Random();

        char[] tempChars = charArray;
        int randomInt;
        int k = 0;

        //Shuffle the array
        for(int q=0; q< shuffledChars.length; q++) {

            // Get a random number based on length of tempChars
            randomInt = r.nextInt(tempChars.length);

            // Set the next shuffled char based on a random selection from tempChars
            shuffledChars[q] = tempChars[randomInt];

            // The next several lines we are going to remove the randomInt item from tempChars and
            // actually 'shrink' tempChars by one.  This is called 'array replacement'.  You will use this
            // a lot later in this class.

            // Array replacement part one:  create a temp to hold our desired result
            char[] temp = new char[tempChars.length - 1];

            // k is just an index to assign successive elements to the right spot in the temp array
            k = 0;

            // Going through tempChars, putting those we want to keep in the temp array
            for(int s=0; s< tempChars.length; s++) {
                if(s != randomInt) {
                    temp[k] = tempChars[s];
                    k++;
                }
            }

            // Now we reassign the array tempChars to the newly constructed temp (which is actually one
            // item shorter than the original tempChars.
            tempChars = temp;
        }

        // These lines just print and confirm the results

        for(int v=0; v < charArray.length; v++) {
            System.out.println(charArray[v]);
        }

        for(int z=0; z < shuffledChars.length; z++) {
            System.out.println(shuffledChars[z]);
        }

    }


}
