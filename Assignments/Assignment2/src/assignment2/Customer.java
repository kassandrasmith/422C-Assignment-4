package assignment2;

/**
 * Model for a customer (someone who controls (a) bank account(s))
 * tracks their name, id, and address
 * 
 * @author Kassandra Smith KSS2474
 */

public class Customer {
   private String name;
   private int customerID;
   private String address;
   /*
    * Method: Customer constructor
    *@param customer name
    *@param customer ID
    */
   public Customer(String name, int id) {
      this.name = name;
      this.customerID = id;
   }
   /*
    * Method: Customer constructor
    *@param customer name
    *@param customer ID
    *@param customer address
    */
   public Customer(String name, int id, String address) {
      this.name = name;
      this.customerID = id;
      this.address = address;
   }
   /*
    * Method: setAddress
    *@param name to set
    */
   public void setName(String name) {
      this.name = name;
   }
   /*
    * Method: getName
    *purpose: returns the name 
    */
   public String getName() {
      return name;
   }

   /*
    * Method: setAddress
    *@param ID to set
    */
   public void setID(int id) {
      this.customerID = id;
   }

   /*
    * Method: getID
    *purpose: returns the customer's ID 
    */
   public int getID() {
      return customerID;
   }

   /*
    * Method: setAddress
    *@param address to set
    */
   public void setAddress(String address) {
      this.address = address;
   }

   /*
    * Method: getAddress
    *purpose: returns the address 
    */
   public String getAddress() {
      return address;
   }

   /*
    * Method: toString
    * Purpose: returns a string that can be printed containing the customer's information
    */
   public String toString() {
      return "Customer Name: " + name + "\n" + "Customers ID: " + customerID + "\n" + "Customer Address: " + address;
   }

}
