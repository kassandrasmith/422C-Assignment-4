package exceptionTutorial;

public class VirtualCafe {
   public static void main(String[] args) throws TemperatureException, WrongSizeException{
      VirtualCoffeeCup cup1 = new VirtualCoffeeCup("Italian", 180, "small");
      VirtualCoffeeCup cup2 = new VirtualCoffeeCup("French", 150, "medium");
      VirtualPerson customer = new VirtualPerson(175, 185, "large");
      VirtualCafe.serveCustomer(customer, cup1);
      VirtualCafe.serveCustomer(customer, cup2);
  }
   
 public static void serveCustomer(VirtualPerson customer, VirtualCoffeeCup cup) throws TemperatureException, WrongSizeException{
    try{
       customer.drinkCoffee(cup);
  // }// catch(TemperatureException te) {
       //System.out.println("I'm sorry. Here's a new cup of coffee.");
   } catch(TooHotException the) {
       System.out.println("I'm so sorry. Let me get you an ice pack anda new cup of coffee.");
   } catch(TooColdException tce) {
       System.out.println("I'm so sorry. Let me get you new cup of coffee.");
   }catch(WrongSizeException wse) {
      System.out.println("Size doesn't matter");
  }
    
 }
}

   

