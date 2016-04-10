package assignment2;

import java.text.NumberFormat;

/**
 * Student loans account. Contains info and operations for a student loans
 * account. Is a form of savings account.
 * 
 * @author Kassandra Smith KSS2474
 */
public class StudentLoans extends SavingsAccount {
   /*
    * Method: StudentLoans Constructor
    *@param the balance to set 
    *@param the account number to set
    */
   public StudentLoans(int accountNum, double initialBalance) {
      super(accountNum, initialBalance); //calls the Savings account constructor with this account number and balance
   }

   /*
    * Method: StudentLoans Constructor
    *@param the balance to set 
    */
   public StudentLoans(double initialBalance) {
      super(initialBalance); //calls the Savings account constructor with this balance
   }

   /*
    * Method: toString Purpose: returns a string that can be printed containing
    * each balance of the account
    */
   public String toString() {
      NumberFormat formatter = NumberFormat.getCurrencyInstance();
      String moneyString = "Student Loan Account Balance is " + formatter.format(balance);
      return moneyString;
   }
}
