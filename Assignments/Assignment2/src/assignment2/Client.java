package assignment2;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/**
 * Driver for client-side operation. The purpose is to translate the input and
 * carry out the proper operations
 * 
 * @author Kassandra Smith KSS2474
 */
public class Client {
   // regexes to make sure input is one of the following:
   static final String WITHDRAWAL_REGEX = ("(\\d [DW] \\d+(\\.\\d\\d)? [CSLA])");
   static final String TRANSFER_REGEX = ("(\\d [T] \\d+(\\.\\d\\d)? [CSLA])");
   static final String INTEREST_REGEX = ("(\\d [I] [SLA])");
   static final String BALANCE_REGEX = ("(\\d [G] [CSLA])");
   // store our bank accounts keep track of transactions in array lists
   static ArrayList<GeneralBankAccount> accounts = new ArrayList<GeneralBankAccount>();
   static ArrayList<String> transactions = new ArrayList<String>();
   // random names to initialize to (English royalty)
   static String[] initialNames = { "George", "Anne", "Victoria", "Edward", "Henry", "William", "Richard", "John",
         "Mary", "Elizabeth" };
   static String[] initialAddress = { "830 Summit Street", "Cocoa, FL 32927", "157 Dogwood Lane", "952 Route 32 ",
         "45 Woodland Drive", "840 Park Street ", "480 Magnolia Avenue", "262 9th Street West ", "974 B Street",
         "991 Prospect Avenue", "998 Woodland Road" };

   /*
    * Main method: Sets up new bank accounts, then processes input handles
    * accordingly, finally printing a goodbye message
    * 
    * @param input string
    */
   public static void main(String[] args) {
      int userChoice = 0;
      for (int index = 0; index < 10; index++) {
         Customer newCustomer = new Customer(initialNames[index], index, initialAddress[index]);
         accounts.add(new GeneralBankAccount(newCustomer));
      }
      // if the user chooses to continue, process the input
      while (userChoice == 0) {
         String input = JOptionPane.showInputDialog("Please input your transaction.");
         if (input != null) {
            input = input.toUpperCase(); // make uppercase to deal with
                                         // incorrect case inputs
            String[] transaction = (input).trim().split(" ");
            if (checkInput(input) && accounts.get(Integer.parseInt(transaction[0])).parseTransaction(transaction)) {
               currentTransaction(accounts, transactions, transaction);
            } else {// reached if an invalid transaction has been attempted
               JOptionPane.showMessageDialog(null, "Invalid transaction.", "ERROR!", JOptionPane.INFORMATION_MESSAGE);
            }
         } else { // reached if the user attempts to continue without input
            JOptionPane.showMessageDialog(null, "Cannot process an empty transaction.", "ERROR!",
                  JOptionPane.INFORMATION_MESSAGE);
         }
         userChoice = JOptionPane.showConfirmDialog(null, "Would you like to continue?");
      }
      // print the end results to the console
      for (int i = 0; i < accounts.size(); i++) {
         System.out.println(accounts.get(i));
      }
      // shows a goodbye message
      JOptionPane.showMessageDialog(null, "Goodbye", "Thank you.", JOptionPane.INFORMATION_MESSAGE);
   }

   /*
    * Method: checkInput Checks to see that the given string is an acceptable
    * input
    * 
    * @param string to be checked
    */
   private static boolean checkInput(String input) {
      return input.matches(WITHDRAWAL_REGEX) | input.matches(TRANSFER_REGEX) | input.matches(INTEREST_REGEX)
            | input.matches(BALANCE_REGEX);
   }

   /*
    * Method: currentTransactio runs through the transaction, does what math
    * needs to be done input
    * 
    * @param string to be checked
    */
   public static void currentTransaction(ArrayList<GeneralBankAccount> accounts, ArrayList<String> output,
         String[] transaction) {
      output.add(accounts.get(0).toString());
      output.add(accounts.get(1).toString());
      JOptionPane.showMessageDialog(null, accounts.get(Integer.parseInt(transaction[0])), " Transaction",
            JOptionPane.INFORMATION_MESSAGE);
   }

}
