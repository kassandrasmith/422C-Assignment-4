package assignment2;

import java.util.HashMap;
import java.util.Map;

/**
 * Model for general bank account object. This is an instance of a bank account
 * and allows for withdrawals and other operations
 * 
 * @author Kassandra Smith KSS2474
 */
public class GeneralBankAccount {
   protected int accountNumber;
  protected String ownersName;
   protected double balance;
   // create one of each so that we can edit it for this customer
   protected Customer customer;
   private CheckingAccount checkingsAccount;
   private SavingsAccount savingsAccount;
   private StudentLoans studentLoans;
   private AutoLoans autoLoans;

   private Map<String, BankAccount> bankAccounts;
   /*
    * Empty constructor to create a new instance of a bank account
    */
   public GeneralBankAccount() {
      checkingsAccount = new CheckingAccount(0);
      savingsAccount = new SavingsAccount(0);
      studentLoans = new StudentLoans(0);
      autoLoans = new AutoLoans(0);
      // hash the input specifiers so that we can easily check against them
      bankAccounts = new HashMap<String, BankAccount>();
      bankAccounts.put("C", checkingsAccount);
      bankAccounts.put("S", savingsAccount);
      bankAccounts.put("A", autoLoans);
      bankAccounts.put("L", studentLoans);

   }
   /*
    * constructor to create a new instance of a bank account with a specified owner
    * @param customer to create for
    */
   public GeneralBankAccount(Customer owner) {
      this();
      customer = owner;
   }
   /*
    * constructor to create a new instance of a bank account with a specified owner and account number
    * @param customer to create for
    * @param integer account number
    */
   public GeneralBankAccount(int accountNum, Customer owner) {
      this();
      accountNumber = accountNum;
      customer = owner;
   }

   /*
    * Method: setOwner
    * Purpose: set a new owner of a bank account
    * @param new customer 
    */
   public void setOwner(Customer newOwner) {
      customer = newOwner;
   }
   /*
    * Method: getOwner
    * Purpose: return the owner of a bank account
    */
   public Customer getOwner() {
      return customer;
   }
   /*
    * Method: setAccountNumber
    * Purpose: set a new account number of a bank account
    * @param new integer account number  
    */
   public void setAccountNumber(int accountNum) {
      accountNumber = accountNum;
   }
   
   /*
    * Method: getAccountNumber
    * Purpose: return the account number of this instance of bank account
    */
   public int getAccountNumber() {
      return accountNumber;
   }
   /*
    * Method: setBalance
    * Purpose: set the balance for this instance of bank account
    * @param new balance value
    */
      private void setBalance(int value) {
     balance = value;
   }
   
   /*
    * Method: getBalance 
    * Purpose: return the balance of this instance of bank account
    * @param string for which account
    */
   private void getBalance(String account) {
      System.out.println(this.customer);
      System.out.println(bankAccounts.get(account));
   }
   
   /*
    * Method: parseTransaction
    * Purpose: Figure out what type of transaction is being made and execute it
    * @param An array containing each word of the input as a String element 
    */
   public boolean parseTransaction(String[] transaction) {
      switch (transaction[1]) {
      case "D":
         deposit(Double.parseDouble(transaction[2]), transaction[3]);
         return true;
      case "W":
         return withdraw(Double.parseDouble(transaction[2]), transaction[3]);
      case "I":
         return calculateInterest(transaction[2]);
      case "T":
         return transferFunds(Double.parseDouble(transaction[2]), transaction[3], transaction[4]);
      case "G":
         getBalance(transaction[2]);
         return true;
      default:
         return false;
      }
   }
   /*
    * Method: transferFunds
    * Purpose: moves an amount of money from one account to another
    * @param the amount of money to move
    * @param the account to move it from
    * @param the account to move it to
    * returns whether or not the transfer went through
    */
   private boolean transferFunds(double amount, String sender, String receiver) {
      {
         BankAccount senderAccount = bankAccounts.get(sender);
         BankAccount receiverAccount = bankAccounts.get(receiver);
         if (!senderAccount.withdraw(amount)) {
            return false;
         }
         receiverAccount.deposit(amount);
         return true;
      }
   }

   /*
    * Method: calculateInterest
    * Purpose: calculates interest on a specified account
    * @param account to calculate
    * returns whether or not the account could have interest was calculated
    */
   private boolean calculateInterest(String account) {
      boolean result = bankAccounts.get(account).calculateInterest();

      return result;
   }

   /*
    * Method: withdraw
    * Purpose: takes the amount out of the given account
    * @param amount to withdraw
    * @param which account to withdraw from
    * returns whether or not the withdrawal could be made
    */
   private boolean withdraw(double amount, String account) {

      BankAccount genAccount = bankAccounts.get(account);

      if (genAccount instanceof CheckingAccount) {
         if (!checkingsAccount.withdraw(amount)) {
            return overdraftProtection(amount); 
         }
         return true;
      } else if (!genAccount.withdraw(amount)) {
         return false;
      }

      return true;
   }

   /*
    * Method: deposit
    * Purpose: puts the amount into the given account
    * @param amount to add
    * @param which account to add to
    */
   private void deposit(double amount, String account) {
      bankAccounts.get(account).deposit(amount);
   }

   /*
    * Method: overDraftProtection
    * Purpose: this is where the actual withdrawal math happens inside of a layer to prevent an overdraft
    * @param amount to withdraw
    * returns whether or not the withdrawal could be made
    */
   private boolean overdraftProtection(double amount) {

      double checkingAccountBalance = checkingsAccount.getBalance();
      double savingsAccountBalance = savingsAccount.getBalance();

      if (checkingAccountBalance + savingsAccountBalance >= amount + 20) {
         checkingsAccount.withdraw(checkingAccountBalance);
         amount -= checkingAccountBalance;

         savingsAccount.withdraw(amount + 20);
         return true;
      }

      return false;
   }

   /*
    * Method: toString
    * Purpose: returns a string that can be printed containing each of the elements of the bank account
    */
   public String toString() {
      String out = customer + "\n" + checkingsAccount + "\n" + savingsAccount + "\n";
      out += studentLoans + "\n" + autoLoans;
      return out;
   }
}