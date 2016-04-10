package exceptionTutorial;

public class VirtualCoffeeCup {
   String roast;
   int temperature;
   String size;
  
   VirtualCoffeeCup(){
      roast = "" ;
      temperature = 175;
     size = "small";
   }
   VirtualCoffeeCup( String string, int t, String s){
      roast = string;
      temperature = t;
      size = s;
   }
   
public String getRoast(){
   return roast;
}

public int getTemperature(){
   return temperature;
}

public String getSize(){
   return size;
}


}
