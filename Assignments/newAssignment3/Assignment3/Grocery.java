package Assignment3;

public class Grocery extends Item {
    private double salesTax = 1; //multiplier
    private boolean fragile; // all grocery items require premium shipping
    protected static final double WEIGHT_MULTIPLIER = 20;

    /*CONSTRUCTORS*/
    public Grocery() {
        super();
        fragile = false;
    }

    public Grocery(String itemName) {
        super(itemName);
        fragile = false;
    }

    public Grocery(String itemName, double itemPrice, int itemQuantity, double itemWeight) {
        super(itemName, itemPrice, itemQuantity, itemWeight);
        fragile = false;
    }

    //this is the only constructor that should actually be used in assignment 3
    public Grocery(String itemName, double itemPrice, int itemQuantity, double itemWeight, String isPerishable) {
        super(itemName, itemPrice, itemQuantity, itemWeight);
        fragile = isPerishable.toUpperCase().equals("P");
    }


    /*
    METHOD: calculate Price
    PURPOSE: calculates the price of a given grocery item based on input attributes
    PARAMS: NONE
    RETURNS: double value of the calculated price
    */
    double calculatePrice() {
        double finalPrice;
        double tax;
        tax = (price * salesTax) * quantity;
        shipping = WEIGHT_MULTIPLIER * weight * quantity;
        if (fragile) {
            shipping = shipping * 1.2;
        }
        finalPrice = ((price * quantity) + shipping + tax);
        return finalPrice;
    }


    /*GETTERS*/
    private boolean getIsPerishable() {
        return fragile;
    }

    /*SETTERS*/
    private void setIsPerishable(boolean perishable) {
        fragile = perishable;
    }
}
