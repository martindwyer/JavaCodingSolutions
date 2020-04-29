/*
	Student:  	Martin Dwyer
	Assignment: 	Unit 3 Application
	Class: 		ITEC 6130, Walden University
	Date: 		Week ending March 24, 2019
	Description: 	This application illustrates the use of abstract classes
 */
package TestingSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import accounts.CheckingAccountTest;
import accounts.SavingsAccountTest;
import Bank.OperationsTest;

/**
 * Suite for running all JUnit tests at once
 * @author Martin Dwyer
 */
@RunWith(Suite.class)
@SuiteClasses({
    CheckingAccountTest.class,
    SavingsAccountTest.class,
    OperationsTest.class
})

/**
 * BankTestSuite is used to run project tests at the same time.  Right click and
 * select "Run File" to run project tests for CheckingAccount and SavingsAccount
 * 
 * BankAccount is an abstract class.  As such, objects cannot be created directly 
 * from this class.  Test of BankAccount methods appear in the concrete class
 * testing files: CheckingAccountTest and SavingsAccountTest
 * 
 * @author Martin Dwyer
 */
public class BankTestSuite {
}
