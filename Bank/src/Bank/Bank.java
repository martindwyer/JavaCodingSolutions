/*
	Student:  	Martin Dwyer
	Assignment: 	Unit 3 Application
	Class: 		ITEC 6130, Walden University
	Date: 		Week ending March 24, 2019
	Description: 	This application illustrates the use of abstract classes
 */
package Bank;

import accounts.CheckingAccount;
import accounts.SavingsAccount;
import javax.swing.JOptionPane;

/**
 * Class Bank controls the demo application for the banking interface.  It consists
 * of only a main method to operate the user interface. The Operations class performs
 * the banking activities as required.
 * 
 * @author Marrtin Dwyer
 */
public class Bank {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        CheckingAccount checking = new CheckingAccount("Barney Rubble", 0);
        SavingsAccount savings = new SavingsAccount("Barney Rubble", 0);

        boolean stopNow = false;
        String menuSelection;
        int userChoice;

        while (!stopNow) {
            menuSelection = JOptionPane.showInputDialog(null, Operations.getMainMenu(checking, savings));
            userChoice = Operations.validateInput(menuSelection);
            switch (userChoice) {
                case 1:
                    // Make a deposit
                    Operations.makeADeposit(checking, savings);
                    break;

                case 2:
                    // Make a withdrawal
                    Operations.makeAWithdrawal(checking, savings);
                    break;

                case 3:
                    // Write a check from checking
                    Operations.writeACheck(checking);
                    break;

                case 4:
                    // Transfer between accounts
                    Operations.doATransfer(checking, savings);
                    break;

                case 5:
                    // Exit system
                    stopNow = true;
                    break;
            }
        }
    }
}
