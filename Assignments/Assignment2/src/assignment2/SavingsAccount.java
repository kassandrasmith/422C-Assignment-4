package assignment2;

import java.text.NumberFormat;


/**
 *Savings account. Contains info and operations for a student loans account. Is a form of bank account.
 * @author Kassandra Smith KSS2474
 */
public class SavingsAccount extends BankAccount {
   protected static final double MIN_INTEREST_BALANCE = 1000;
   protected double interestRate = .04;
   /*
    * Method: savingsAccount Constructor
    *@param the balance to set 
    */
   public SavingsAccount(double initialBalance) {
      super(initialBalance);
   }
   /*
    * Method: savingsAccount Constructor
    *@param the balance to set 
    *@param the account number to set
    */
   public SavingsAccount(int accountNum, double initialBalance) {
      super(accountNum, initialBalance);
   }

   /*
    * Method: calculateInterest
    *purpose: executes the calculation of interest and returns whether or not it could be calculated
    */
   public boolean calculateInterest() {

      if (balance >= MIN_INTEREST_BALANCE) {
         balance += balance * interestRate;
         return true;
      } else {
         return false;
      }
   }

   /*
    * Method: setInterestRate
    *@param the interest rate to set 
    */
   public void setInterestRate(double i) {
      interestRate = i;
   }

   /*
    * Method: getInterestRate
    *returns the interest rate 
    */
   public double getInterestRate() {
      return interestRate;
   }

   /*
    * Method: toString
    * Purpose: returns a string that can be printed containing each balance of the account
    */
   public String toString() {
      NumberFormat formatter = NumberFormat.getCurrencyInstance();
      String moneyString = "Savings Account Balance is" + formatter.format(balance);
      return moneyString;
   }
}
