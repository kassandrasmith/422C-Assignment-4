package exceptionTutorial;

public class VirtualPerson {
   int preferredTemperature;
   static String preferredSize = "";
   private static  int tooHot;
   private static int tooCold;

   VirtualPerson(){
      preferredTemperature = 80;
      preferredSize = ("size doesn't matter. ;p ");
   }

   VirtualPerson(int temp, String size){
      preferredTemperature = temp;
      preferredSize = size;
      }

   public VirtualPerson(int tooCold, int tooHot, String size) {
      VirtualPerson.tooHot = tooHot;
      VirtualPerson.tooCold = tooCold;
      VirtualPerson.preferredSize = ("large");
   }

public static void drinkCoffee(VirtualCoffeeCup cup) throws TemperatureException, WrongSizeException {
   if(cup.getTemperature() > tooHot)
      throw new TooHotException();
   else if(cup.getTemperature() < tooCold)
      throw new TooColdException();
   else   if(!cup.size.equals(preferredSize))
      throw new WrongSizeException();
   
   else
      System.out.println("Ahhh");
 
}

}
