package assignment2;

import java.text.NumberFormat;

/**
 * Savings account. Contains info and operations for a checkings account. Is a
 * form of bank account with no fees, no min. balance, no interest
 * 
 * @author Kassandra Smith KSS2474
 */
public class CheckingAccount extends BankAccount {

   /*
    * Method: Checking Account constructor
    * 
    * @param balance to initialize with
    * 
    * @param account number to initialize
    */
   public CheckingAccount(int accountNum, double initBalance) {
      super(accountNum, initBalance);
   }

   /*
    * Method: Checking Account constructor
    * 
    * @param balance to initialize with
    */
   public CheckingAccount(double initBalance) {
      super(initBalance);
   }

   /*
    * Method: calculateInterest Purpose: returns false since a checking's
    * account cannot have interest
    */
   public boolean calculateInterest() {
      return false;
   }

   /*
    * Method: toString Purpose: returns a string that can be printed containing
    * the balance of the account
    */
   public String toString() {
      NumberFormat formatter = NumberFormat.getCurrencyInstance();
      String moneyString = "Checking Account Balance: " + formatter.format(balance);
      return moneyString;
   }

}
