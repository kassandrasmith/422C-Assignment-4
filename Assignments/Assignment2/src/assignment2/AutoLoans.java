package assignment2;

import java.text.NumberFormat;


/**
 * Auto loans account. Contains info and operations for an auto loans
 * account. Is a form of savings account.
 * 
 * @author Kassandra Smith KSS2474
 */
public class AutoLoans extends SavingsAccount{
   
   /*
    * Method: Auto Loan Account constructor
    *@param balance to initialize with
    *@param account number to initialize
    */
   public AutoLoans(int accountNumber, double balance)
   {
      super(accountNumber, balance);
   }
   /*
    * Method: Auto Loan Account constructor
    *@param balance to initialize with
    */
   public AutoLoans(double balance) 
   {
      super(balance);
   }

   /*
    * Method: toString
    * Purpose: returns a string that can be printed containing the balance of the account
    */
    public String toString()
    {
      NumberFormat formatter = NumberFormat.getCurrencyInstance();
      String moneyString = "Auto Loan Account Balance: " + formatter.format(balance) + "\n";
      return moneyString;
    } 
}
