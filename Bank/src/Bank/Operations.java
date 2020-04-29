/*
	Student:  	Martin Dwyer
	Assignment: 	Unit 3 Application
	Class: 		ITEC 6130, Walden University
	Date: 		Week ending March 24, 2019
	Description: 	This application illustrates the use of abstract classes
 */
package Bank;

import accounts.BankAccount;
import accounts.CheckingAccount;
import accounts.SavingsAccount;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

/**
 * Operations class contains all of the tools necessary to perform banking operations
 * including writing a check, making a deposit, withdrawing funds, making a transfer
 * and other utilities necessary for banking like converting numbers to strings for
 * customer output.
 * 
 * @author Martin Dwyer
 */
public class Operations {

    /**
     * Method provides the menu text for demo application
     * @param checking a CheckingAccount object
     * @param savings a SavingsAccount object
     * @return String menu text
     */
    public static String getMainMenu(CheckingAccount checking, SavingsAccount savings) {
        return "Welcome to our banking portal for demo customer:\n\n"
                + "Demo Customer:  Barney Rubble\n"
                + "Checking balance: " + getDollarString(checking.balance()) + "\n"
                + "Savings balance:  " + getDollarString(savings.balance()) + "\n\n"
                + "Choose an activity for these accounts:\n\n"
                + "1.  Make a deposit\n"
                + "2.  Make a withdrawal\n"
                + "3.  Write a check from checking\n"
                + "4.  Transfer between accounts\n\n"
                + "5.  Exit system\n\n"
                + "Enter your selection below\n\n";
    }

    /**
     * Validates user input into the main menu
     * 
     * @param menuSelection the text entered by the user
     * @return the user choice to guide application
     */
    public static int validateInput(String menuSelection) {
        int userChoice = 0;
        try {
            userChoice = Integer.parseInt(menuSelection);
        } catch (NumberFormatException e) {
            // Do nothing if input improper - leaves userChoice = 0
        }
        if (userChoice > 5 || userChoice < 1) {
            userChoice = 0;
        }
        return userChoice;
    }

    /**
     * Method guides user through writing a check, obtaining amount and printing 
     * the check if funds are available in the account
     * 
     * @param checking a CheckingAccount object for the check to be drawn
     */
    public static void writeACheck(CheckingAccount checking) {
        int checkAmount = 0;
        String result = "";
        String input = JOptionPane.showInputDialog(null, "\nEnter check amount in dollars\n\n");
        checkAmount = getCentsValue(input);
        if (checkAmount != 999999999) {
            result = checking.writeCheck(checkAmount);
            if (result.equals("INSUFFICIENT FUNDS")
                    || result.equals("ITEM TOO LARGE FOR AUTOMATED PROCESSING (Over $1 Million)")
                    || result.equals("ITEM TOO SMALL (MUST BE OVER $0.09)")) {
                JOptionPane.showMessageDialog(null, "\nCheck not approved:  \n\n" + result);
            } else {
                JOptionPane.showMessageDialog(null, "\nYour check was completed and printed below:\n\n" + result);
            }
        }
    }

    /**
     * Method guides user through making a deposit into their account
     * 
     * @param checking a CheckingAccount object held by the user
     * @param savings a SavingsAccount object held by the user
     */
    public static void makeADeposit(CheckingAccount checking, SavingsAccount savings) {
        boolean validSelection = false;
        int accountChoice = 0;
        int depositAmount = 0;
        String input;
        String depositSelectionMenu = "Choose which account to receive funds:\n\n"
                + "1.  Checking account\n"
                + "2.  Savings account\n\n"
                + "Enter 1 for checking, 2 for savings.\n\n";
        while (!validSelection) {
            String accountSelection = JOptionPane.showInputDialog(null, depositSelectionMenu);
            try {
                accountChoice = Integer.parseInt(accountSelection);
            } catch (NumberFormatException e) {
                validSelection = false;
            }
            if (accountChoice == 1 || accountChoice == 2) {
                validSelection = true;
            }
        }
        if (accountChoice == 1) {
            input = JOptionPane.showInputDialog(null, "\nEnter deposit amount in dollars\n\n");
            depositAmount = getCentsValue(input);
            if (depositAmount != 999999999) {
                checking.deposit(depositAmount);
            } else {
                JOptionPane.showMessageDialog(null, "\nImproper input.  Returning to main menu.\n\n");
            }
        } else if (accountChoice == 2) {
            input = JOptionPane.showInputDialog(null, "\nEnter deposit amount in dollars\n\n");
            depositAmount = getCentsValue(input);
            if (depositAmount != 999999999) {
                savings.deposit(depositAmount);
            } else {
                JOptionPane.showMessageDialog(null, "\nImproper input.  Returning to main menu.\n\n");
            }
        }
    }

    /**
     * Method guides user through making a withdrawal from one of their accounts
     * 
     * @param checking a CheckingAccount object held by the user
     * @param savings a SavingsAccount object held by the user
     */
    public static void makeAWithdrawal(CheckingAccount checking, SavingsAccount savings) {
        boolean validSelection = false;
        boolean withdrawalComplete = false;
        int accountChoice = 0;
        int withdrawalAmount = 0;
        String input;
        String withdrawalSelectionMenu = "Choose which account to  withdraw funds:\n\n"
                + "1.  Checking account\n"
                + "2.  Savings account\n\n"
                + "Enter 1 for checking, 2 for savings.\n\n";
        while (!validSelection) {
            String accountSelection = JOptionPane.showInputDialog(null, withdrawalSelectionMenu);
            try {
                accountChoice = Integer.parseInt(accountSelection);
            } catch (NumberFormatException e) {
                validSelection = false;
            }
            if (accountChoice == 1 || accountChoice == 2) {
                validSelection = true;
            }
        }
        if (accountChoice == 1) {
            input = JOptionPane.showInputDialog(null, "\nEnter withdrawal amount in dollars\n\n");
            withdrawalAmount = getCentsValue(input);
            if (withdrawalAmount != 999999999) {
                withdrawalComplete = checking.withdraw(withdrawalAmount);
                if (withdrawalComplete) {
                    JOptionPane.showMessageDialog(null, "\nWithdrawal approved.  Click OK to see new balances.\n\n");
                } else {
                    JOptionPane.showMessageDialog(null, "\nWithdrawal denied.  Click OK to review available balances.\n\n");
                }
            } else {
                JOptionPane.showMessageDialog(null, "\nImproper input.  Returning to main menu.\n\n");
            }
        } else if (accountChoice == 2) {
            input = JOptionPane.showInputDialog(null, "\nEnter withdrawal amount in dollars\n\n");
            withdrawalAmount = getCentsValue(input);
            if (withdrawalAmount != 999999999) {
                withdrawalComplete = savings.withdraw(withdrawalAmount);
                if (withdrawalComplete) {
                    JOptionPane.showMessageDialog(null, "\nWithdrawal approved.  Click OK to see new balances.\n\n");
                } else {
                    JOptionPane.showMessageDialog(null, "\nWithdrawal denied.  Click OK to review available balances.\n\n");
                }

            } else {
                JOptionPane.showMessageDialog(null, "\nImproper input.  Returning to main menu.\n\n");
            }
        }
    }

    /**
     * Method guides user through making a transfer between their accounts
     * 
     * @param checking a CheckingAccount object held by the user
     * @param savings a SavingsAccount object held by the user
     */
    public static void doATransfer(CheckingAccount checking, SavingsAccount savings) {
        boolean validSelection = false;
        boolean validAmount = false;
        boolean transferComplete = false;
        int accountChoice = 0;
        int transferAmount = 0;
        double transferDollars = 0.0;
        String dollarInput;
        String withdrawalSelectionMenu = "Choose which account to  withdraw funds:\n\n"
                + "1.  Checking account\n"
                + "2.  Savings account\n\n"
                + "Enter 1 for checking, 2 for savings.\n\n";
        while (!validSelection) {
            String accountSelection = JOptionPane.showInputDialog(null, withdrawalSelectionMenu);
            try {
                accountChoice = Integer.parseInt(accountSelection);
            } catch (NumberFormatException e) {
                validSelection = false;
            }
            if (accountChoice == 1 || accountChoice == 2) {
                validSelection = true;
            }
        }
        while (!validAmount) {
            dollarInput = JOptionPane.showInputDialog(null, "\nEnter amount to transfer below:  \n\n");
            try {
                transferAmount = getCentsValue(dollarInput);
                validAmount = true;

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "\nImproper input.  Try again. \n\n");
            }
        }
        if (accountChoice == 1) {
            transferComplete = BankAccount.transfer(transferAmount, checking, savings);
        } else if (accountChoice == 2) {
            transferComplete = BankAccount.transfer(transferAmount, savings, checking);
        }
        if (transferComplete) {
            JOptionPane.showMessageDialog(null, "\nTransfer complete.  Click OK to review new balances. \n\n");
        } else {
            JOptionPane.showMessageDialog(null, "\nTransfer could not be completed.  Review balances and try again. \n\n");
        }

    }

    /**
     * Method takes a dollar amount entered as a String, extracts any $ characters, and
     * returns the number as an integer, i.e. the cents value of the entry
     * 
     * @param stringNumber String representation of a dollar value
     * @return integer value to represents the cents equivalent of the dollar argument
     */
    public static int getCentsValue(String stringNumber) {
        double dollars;
        int amount = 0;
        stringNumber = stringNumber.replace("$", "");
        try {
            dollars = Double.parseDouble(stringNumber);
            amount = (int) (dollars * 100);
        } catch (NumberFormatException e) {
            amount = 999999999;
        }
        return amount;

    }
    
    /**
     * Takes the dollar value in cents and converts it to a standard text string for
     * numeric representation of currency in dollars
     * 
     * @param balance the dollar value (in cents) an integer
     * @return a String to represent the currency format in dollars
     */
    public static String getDollarString(int balance) {
        NumberFormat cf = NumberFormat.getCurrencyInstance();
        double dollarBalance = balance / 100.00;
        String dollarString = cf.format(dollarBalance);
        return dollarString;
        
    }

    /**
     * The balanceToString() method is designed to take in a number up $1 million
     * in cents, and convert that number to a String of text written in the form
     * of a check amount description. It is a private method used as part of the 
     * writeCheck() method
     * 
     * @param balance an integer to represent a dollar value in cents
     * @return a String to represent the dollar value written in words
     */
    public static String balanceToString(int balance) {
        // The program breaks the number into three portions; (1) thousands, 
        // (2) hundreds, and (3) cents.  The words to describe each part are obtained
        // and then combined together for return to the writeCheck() method
        String result = "";
        String dollarText = Integer.toString(balance);
        String thousandsText = "0";
        String hundredsText = "0";
        String centsText = "0";
        int textLength = dollarText.length();
        if (textLength <= 2) {
            centsText = dollarText.substring(0, 2);
        } else if (textLength <= 5) {
            centsText = dollarText.substring(textLength - 2, textLength);
            hundredsText = dollarText.substring(0, textLength - 2);
        } else if (textLength <= 8) {
            centsText = dollarText.substring(textLength - 2, textLength);
            hundredsText = dollarText.substring(textLength - 5, textLength - 2);
            thousandsText = dollarText.substring(0, textLength - 5);
        }
        int cents = Integer.parseInt(centsText);
        int hundreds = Integer.parseInt(hundredsText);
        int thousands = Integer.parseInt(thousandsText);
        if (thousands > 0) {
            result += getNumberString(thousands) + "THOUSAND ";
        }
        if (hundreds > 0) {
            result += getNumberString(hundreds);
        }
        result += "DOLLARS AND " + cents + " CENTS";
        return result;
    }

    /*
        The getNumberString() method takes in an integer up to three digits long, and 
        returns the integer in word form.  It is used as part of the writeCheck() method
        in the CheckingAccount class.
     */
    public static String getNumberString(int number) {
        String result = "";
        int[] numberArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        String[] numberWritten = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
        String[] teensWritten = {"TEN", "ELEVEN", "TWELVE", "THIRTEEN", "FOURTEEN", "FIFTEEN", "SIXTEEN", "SEVENTEEN", "EIGHTEEN", "NINETEEN"};
        String[] tensWritten = {"ZERO", "TEN", "TWENTY", "THIRTY", "FORTY", "FIFTY", "SIXTY", "SEVENTY", "EIGHTY", "NINETY"};
        int hundreds = number / 100;
        int tens = (number - hundreds * 100) / 10;
        int singles = number % 10;
        if (hundreds > 0) {
            result += numberWritten[hundreds] + " HUNDRED ";
        }
        if (tens > 0) {
            if (tens == 1) {
                result += teensWritten[number % 10] + " ";
            } else {
                result += tensWritten[tens] + " ";
            }
        }
        if (singles > 0 && tens != 1) {
            result += numberWritten[singles] + " ";
        }
        return result;
    }

}
