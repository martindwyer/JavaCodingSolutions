import java.util.*;

public class UtilLab1 {
    public static void main(String [] args) {

        // This program includes testing algorithms for five methods
        // which were originally the solutions to coding bat exercises.
        // Each of the methods are described fully below.

        // Each of the testing functions offers random testing and manual
        // testing to be completed by the user.
        testingComboString();
        testingConCat();
        testingAtFirst();
        testingHasBad();
        testingTheEnd();

        System.out.println("Method testing is complete.");
        System.out.println("Program terminated.");

    }

    /**
     * Given a string, return a string length 1 from its front, 
     * unless front is false, in which case return a string 
     * length 1 from its back. The string will be non-empty.
     * Examples:
     *  theEnd("Hello", true) â†’ "H"
     *  theEnd("Hello", false) â†’ "o"
     *  theEnd("oh", true) â†’ "o"
     */
    public static String theEnd(String str, boolean front) {
        if(front==true) {
            str = str.substring(0,1);
            return str;
        } else {
            str = str.substring(str.length()-1,str.length());
            return str;
        }
    }

    /**
     * Given a string, return true if "bad" appears starting at 
     * index 0 or 1 in the string, such as with "badxxx" or 
     * "xbadxx" but not "xxbadxx". The string may be any length,
     * including 0. Note: use .equals() to compare 2 strings.
     * Examples:
     *  hasBad("badxx") â†’ true
     *  hasBad("xbadxx") â†’ true
     *  hasBad("xxbadxx") â†’ false
     */
    public static boolean hasBad(String str) {
        if(str.length() < 3) {
            return false;
        } else if(str.substring(0,3).equals("bad")) {
            return true;
        } else if(str.length() == 3){
            return false;
        } else if(str.substring(1,4).equals("bad")) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Given a string, return a string length 2 made of its 
     * first 2 chars. If the string length is less than 2, 
     * use '@' for the missing chars.
     * Examples:
     *  atFirst("hello") â†’ "he"
     *  atFirst("hi") â†’ "hi"
     *  atFirst("h") â†’ "h@"
     */
    public static String atFirst(String str) {
        if (str.length() >= 2)
            return str.substring(0,2);
        else if (str.length() == 1)
            return str + "@";
        else
            return "@@";
    }

    /**
     * Given 2 strings, a and b, return a string of the form 
     * short+long+short, with the shorter string on the outside
     * and the longer string on the inside. The strings will 
     * not be the same length, but they may be empty (length 0).
     * Examples:
     *  comboString("Hello", "hi") â†’ "hiHellohi"
     *  comboString("hi", "Hello") â†’ "hiHellohi"
     *  comboString("aaa", "b") â†’ "baaab"
     */
    public static String comboString(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();

        if (lenA > lenB)
            return b+a+b;
        else
            return a+b+a;
    }

    /**
     * Given two strings, append them together (known as "concatenation")
     * and return the result. However, if the concatenation creates
     * a double-char, then omit one of the chars, so "abc" and "cat"
     * yields "abcat".
     * Examples:
     *  conCat("abc", "cat") â†’ "abcat"
     *  conCat("dog", "cat") â†’ "dogcat"
     *  conCat("abc", "") â†’ "abc"
     */
    public static String conCat(String a, String b) {
        if (a.length() == 0 || b.length() == 0) {
            return a+b;
        } else if ((a.substring(a.length() - 1, a.length())).equals(b.substring(0,1))) {
            return a + b.substring(1,b.length());
        } else {
            return a+b;
        }
    }

    public static String randomString(int length) {
        String LETTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        int numChars = LETTERS.length();
        StringBuilder buildString = new StringBuilder();
        Random rg = new Random();
        while (buildString.length() < length) { // length of the random string.
            int index = rg.nextInt(numChars);
            buildString.append(LETTERS.charAt(index));
        }
        String lastStr = buildString.toString();
        return lastStr;
    }

    public static void testingTheEnd() {

        Scanner kb = new Scanner(System.in);
        Random rg = new Random();
        Boolean runRandom = true;
        Boolean runManual = false;
        String a;
        Boolean b;
        String c;
        String d;

        // Below represents testing for the method comboString
        System.out.println("Testing method: theEnd()");
        while (runRandom) {
            System.out.println("Results of ten random tests;");
            for (int i=0; i < 10; i++) {
                int i1 = rg.nextInt(7) + 1;
                int i2 = rg.nextInt(2);

                a = randomString(i1);

                if (i2 == 1) {
                    b = true;
                } else {
                    b = false;
                }

                c = theEnd(a,b);

                if(b==true) {
                    d = a.substring(0,1);
                } else {
                    d = a.substring(a.length()-1,a.length());
                }

                System.out.println("String Input:"+a+" Front="+b+" Output Expected:"+d+" Returned:"+c);
                if (c.equals(d)) {
                    System.out.println("SUCCESS! METHOD OUTPUT IS VALIDATED!");
                } else {
                    System.out.println("DANGER WILL ROBINSON!  THIS MISSION HAS FAILED!");
                }
            }
            System.out.println("Do you wish to continue (y/n)?");

            String input = kb.nextLine();
            if (input.equalsIgnoreCase("n")) {
                runRandom = false;
            }
        }
        System.out.println("Random testing of method hasBad() has been completed");
        System.out.println("Do you wish to test this method manually? (y/n)");
        String input = kb.nextLine();
        if (input.equalsIgnoreCase("n")) {
            runManual = false;
        } else { 
            runManual = true;
        }
        while (runManual) {

            System.out.println("We will need a string to start manual testing.");
            System.out.println("Enter a string below:");
            a = kb.nextLine();
            System.out.println("Now enter 'true' or 'false' for the first letter.");
            b = kb.nextBoolean();
            System.out.println("What is the outcome you expect?");
            d = kb.nextLine();

            c = theEnd(a,b);

            System.out.println("String Input:"+a+" Front="+ b +" Output Expected:"+d+" Returned:"+c);
            if (b.equals(c)) {
                System.out.println("SUCCESS! METHOD OUTPUT IS VALIDATED!");
            } else {
                System.out.println("DANGER WILL ROBINSON!  THIS MISSION HAS FAILED!");
            }
            System.out.println("Do you want to do another manual test? (y/n)");
            String keepGoing = kb.nextLine();
            if (keepGoing.equalsIgnoreCase("n")) {
                runManual = false;
            } else { 
                runManual = true;
            }

        }
        System.out.println("Testing of method theEnd() has been completed");

    }

    public static void testingHasBad() {

        Scanner kb = new Scanner(System.in);
        Random rg = new Random();
        Boolean runRandom = true;
        Boolean runManual = false;
        String a;
        Boolean b;
        Boolean c;

        // Below represents testing for the method comboString
        System.out.println("Testing method: hasBad()");
        while (runRandom) {
            System.out.println("Results of ten random tests;");
            for (int i=0; i < 10; i++) {
                int i1 = rg.nextInt(3) + 1;
                a = randomString(i1);
                b = hasBad(a);

                // Expected result computation
                if(a.length() < 3) {
                    c = false;
                } else if(a.substring(0,3).equals("bad")) {
                    c = true;
                } else if(a.length() == 3){
                    c = false;
                } else if(a.substring(1,4).equals("bad")) {
                    c = true;
                } else {
                    c = false;
                }

                System.out.println("String Input:"+a+" String Expected:"+c+" Returned:"+b);
                if (c.equals(b)) {
                    System.out.println("SUCCESS! METHOD OUTPUT IS VALIDATED!");
                } else {
                    System.out.println("DANGER WILL ROBINSON!  THIS MISSION HAS FAILED!");
                }
            }
            System.out.println("Do you wish to continue (y/n)?");

            String input = kb.nextLine();
            if (input.equalsIgnoreCase("n")) {
                runRandom = false;
            }
        }
        System.out.println("Random testing of method hasBad() has been completed");
        System.out.println("Do you wish to test this method manually? (y/n)");
        String input = kb.nextLine();
        if (input.equalsIgnoreCase("n")) {
            runManual = false;
        } else { 
            runManual = true;
        }
        while (runManual) {

            System.out.println("We will need a string to start manual testing.");
            System.out.println("Enter a string below:");
            a = kb.nextLine();
            System.out.println("Enter 'true' or 'false' for the expected outcome:");
            b = kb.nextBoolean();
            kb.nextLine();
            c = hasBad(a);

            System.out.println("String Input:"+a+" String Expected:"+b+" Returned:"+c);
            if (b.equals(c)) {
                System.out.println("SUCCESS! METHOD OUTPUT IS VALIDATED!");
            } else {
                System.out.println("DANGER WILL ROBINSON!  THIS MISSION HAS FAILED!");
            }

            System.out.println("Do you want to do another manual test? (y/n)");
            String keepGoing = kb.nextLine();
            if (keepGoing.equalsIgnoreCase("n")) {
                runManual = false;
            } else { 
                runManual = true;
            }

        }
        System.out.println("Testing of method hasBad() has been completed");
    }

    public static void testingAtFirst() {
        Scanner kb = new Scanner(System.in);
        Random rg = new Random();
        Boolean runRandom = true;
        Boolean runManual = false;

        // Below represents testing for the method comboString
        System.out.println("Testing method: atFirst()");
        while (runRandom) {
            System.out.println("Results of ten random tests;");
            for (int i=0; i < 10; i++) {
                int i1 = rg.nextInt(7) + 1;
                int i2 = rg.nextInt(7) + 1;

                String a = randomString(i1);
                String b = atFirst(a);
                String c;

                // Expected result computation
                if (a.length() >= 2)
                    c = a.substring(0,2);
                else if (a.length() == 1)
                    c = a + "@";
                else
                    c ="@@";

                System.out.println("String Input:"+a+" String Expected:"+c+" Returned:"+b);
                if (c.equals(b)) {
                    System.out.println("SUCCESS! METHOD OUTPUT IS VALIDATED!");
                } else {
                    System.out.println("DANGER WILL ROBINSON!  THIS MISSION HAS FAILED!");
                }
            }
            System.out.println("Do you wish to continue (y/n)?");

            String input = kb.nextLine();
            if (input.equalsIgnoreCase("n")) {
                runRandom = false;
            }
        }
        System.out.println("Random testing of method atFirst() has been completed");
        System.out.println("Do you wish to test this method manually? (y/n)");
        String input = kb.nextLine();
        if (input.equalsIgnoreCase("n")) {
            runManual = false;
        } else { 
            runManual = true;
        }
        while (runManual) {
            String a;
            String b;
            String c;
            String d;
            System.out.println("We will need a string to start manual testing.");
            System.out.println("Enter a string below:");
            a = kb.nextLine();
            System.out.println("What do you expect the answer to be?");
            b = kb.nextLine();
            c = atFirst(a);

            System.out.println("String Input:"+a+" String Expected:"+b+" Returned:"+c);
            if (b.equals(c)) {
                System.out.println("SUCCESS! METHOD OUTPUT IS VALIDATED!");
            } else {
                System.out.println("DANGER WILL ROBINSON!  THIS MISSION HAS FAILED!");
            }
            System.out.println("Do you want to do another manual test? (y/n)");
            String manualChoice = kb.nextLine();
            if (manualChoice.equalsIgnoreCase("n")) {
                runManual = false;
            } else { 
                runManual = true;
            }
            System.out.println("Testing of method atFirst() has been completed");
        }

    }

    public static void testingComboString() {
        Scanner kb = new Scanner(System.in);
        Random rg = new Random();
        Boolean runRandom = true;
        Boolean runManual = false;

        // Below represents testing for the method comboString
        System.out.println("Testing method: comboString()");
        while (runRandom) {
            System.out.println("Results of ten random tests;");
            for (int i=0; i < 10; i++) {
                int i1 = rg.nextInt(7) + 1;
                int i2 = rg.nextInt(7) + 1;

                String a = randomString(i1);
                String b = randomString(i2);
                String c = comboString(a,b);
                String d;

                // Expected result computation
                int lenA = a.length();
                int lenB = b.length();

                if (lenA > lenB)
                    d = b+a+b;
                else
                    d = a+b+a;

                System.out.println("String a:"+a+" String b:"+b+" Expected:"+d+" Returned:"+c);
                if (d.equals(c)) {
                    System.out.println("SUCCESS! METHOD OUTPUT IS VALIDATED!");
                } else {
                    System.out.println("DANGER WILL ROBINSON!  THIS MISSION HAS FAILED!");
                }
            }
            System.out.println("Do you wish to continue (y/n)?");

            String input = kb.nextLine();
            if (input.equalsIgnoreCase("n")) {
                runRandom = false;
            }
        }
        System.out.println("Random testing of method comboString has been completed");
        System.out.println("Do you wish to test this method manually? (y/n)");
        String input = kb.nextLine();
        if (input.equalsIgnoreCase("n")) {
            runManual = false;
        } else { 
            runManual = true;
        }
        while (runManual) {
            String a;
            String b;
            String c;
            String d;
            System.out.println("We will need two strings to start manual testing.");
            System.out.println("Enter the first string below:");
            a = kb.nextLine();
            System.out.println("Now enter your second string:");
            b = kb.nextLine();
            System.out.println("What do you expect the answer to be?");
            d = kb.nextLine();
            c = comboString(a,b);

            System.out.println("String a:"+a+" String b:"+b+" Expected:"+d+" Returned:"+c);
            if (d.equals(c)) {
                System.out.println("SUCCESS! METHOD OUTPUT IS VALIDATED!");
            } else {
                System.out.println("DANGER WILL ROBINSON!  THIS MISSION HAS FAILED!");
            }
            System.out.println("Do you want to do another manual test? (y/n)");
            String manualChoice = kb.nextLine();
            if (manualChoice.equalsIgnoreCase("n")) {
                runManual = false;
            } else { 
                runManual = true;
            }
            System.out.println("Testing method comboString() has been completed");
        }

    }

    public static void testingConCat() {
        Scanner kb = new Scanner(System.in);
        Random rg = new Random();
        Boolean runRandom = true;
        Boolean runManual = false;

        System.out.println("Testing method: conCat()");
        while (runRandom) {
            System.out.println("Results of ten random tests;");
            for (int i=0; i < 10; i++) {
                int i1 = rg.nextInt(7) + 1;
                int i2 = rg.nextInt(7) + 1;

                String a = randomString(i1);
                String b = randomString(i2);
                String c = conCat(a,b);
                String d;

                // Expected result computation
                if (a.length() == 0 || b.length() == 0) {
                    d = a+b;
                } else if ((a.substring(a.length() - 1, a.length())).equals(b.substring(0,1))) {
                    d = a + b.substring(1,b.length());
                } else {
                    d = a+b;  
                }

                System.out.println("String a:"+a+" String b:"+b+" Expected:"+d+" Returned:"+c);
                if (d.equals(c)) {
                    System.out.println("SUCCESS! METHOD OUTPUT IS VALIDATED!");
                } else {
                    System.out.println("DANGER WILL ROBINSON!  THIS MISSION HAS FAILED!");
                }
            }
            System.out.println("Do you wish to continue (y/n)?");

            String input = kb.nextLine();
            if (input.equalsIgnoreCase("n")) {
                runRandom = false;
            }
        }
        System.out.println("Random testing of method conCat has been completed");
        System.out.println("Do you wish to test this method manually? (y/n)");
        String input = kb.nextLine();
        if (input.equalsIgnoreCase("n")) {
            runManual = false;
        } else { 
            runManual = true;
        }
        while (runManual) {
            String a;
            String b;
            String c;
            String d;
            System.out.println("We will need two strings to start manual testing.");
            System.out.println("Enter the first string below:");
            a = kb.nextLine();
            System.out.println("Now enter your second string:");
            b = kb.nextLine();
            System.out.println("What do you expect the answer to be?");
            d = kb.nextLine();
            c = comboString(a,b);

            System.out.println("String a:"+a+" String b:"+b+" Expected:"+d+" Returned:"+c);
            if (d.equals(c)) {
                System.out.println("SUCCESS! METHOD OUTPUT IS VALIDATED!");
            } else {
                System.out.println("DANGER WILL ROBINSON!  THIS MISSION HAS FAILED!");
            }
            System.out.println("Do you want to do another manual test? (y/n)");
            String manualChoice = kb.nextLine();
            if (manualChoice.equalsIgnoreCase("n")) {
                runManual = false;
            } else { 
                runManual = true;
            }
            System.out.println("Testing of method conCat() has been completed");
        }

    }

}
