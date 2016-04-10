package assignment2;

/**
 * model for all bank accounts which allows for withdrawals and other operations
 * while tracking data tied to accounts
 * 
 * @author Kassandra Smith KSS2474
 */
public abstract class BankAccount {

   protected int accountNumber;
   protected double balance;

   /*
    * Method: Bank Account constructor
    * 
    * @param balance to initialize with
    */
   public BankAccount(double initialBalance) {
      balance = initialBalance;
   }

   /*
    * Method: Bank Account constructor
    * 
    * @param balance to initialize with
    * 
    * @param account number to initialize
    */
   public BankAccount(int accountNum, double initBalance) {
      accountNumber = accountNum;
      balance = initBalance;
   }

   /*
    * Method: deposit Purpose: puts the amount into the given account
    * 
    * @param amount to add
    */
   public void deposit(double amount) {
      balance = balance + amount;
   }

   /*
    * Method: withdraw Purpose: takes the amount out of the given account
    * 
    * @param amount to withdraw returns whether or not the withdrawal could be
    * made
    */
   public boolean withdraw(double amount) {
      if (balance >= amount) {
         balance = balance - amount;
         return true;
      } else {
         return false;
      }
   }

   /*
    * Method: getBalance Purpose: return the balance of this instance of bank
    * account
    */
   public double getBalance() {
      return balance;
   }

   /*
    * Method: getAccountNumber Purpose: return the account number of the bank
    * account
    */
   public int getAccountNumber() {
      return accountNumber;
   }

   /*
    * Method: setBalance Purpose: set the balance for this instance of bank
    * account
    * 
    * @param new balance value
    */
   public void setBalance(double newBalance) {
      balance = newBalance;
   }

   /*
    * Method: setAccountNumber Purpose: set a new account number of a bank
    * account
    * 
    * @param new integer account number
    */
   public void setAccountNumber(int newAcctNumber) {
      accountNumber = newAcctNumber;
   }

   /*
    * Method: toString Purpose: returns a string that can be printed containing
    * the balance of the account
    */
   public String toString() {
      return "Balance is " + balance;
   }

   public abstract boolean calculateInterest();
}