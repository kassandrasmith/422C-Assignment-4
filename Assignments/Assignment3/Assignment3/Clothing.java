package Assignment3;

public class Clothing extends Item {
    private double salesTax = 1.1;

    /*CONSTRUCTORS*/
    public Clothing() {
        super();
    }

    public Clothing(String itemName) {
        super(itemName);
    }

    public Clothing(String itemName, double itemPrice, int itemQuantity, double itemWeight) {
        super(itemName, itemPrice, itemQuantity, itemWeight);
    }

    /*
    METHOD: calculate Price
    PURPOSE: calculates the price of a given grocery item based on input attributes
    PARAMS: NONE
    RETURNS: double value of the calculated price
    */
    double calculatePrice() {
        double finalPrice; // Why did we break convention here?
        double tax;
        tax = price * salesTax * quantity;
        shipping = WEIGHT_MULTIPLIER * weight * quantity;
        finalPrice = ((price * quantity) + shipping + tax);
        return finalPrice;
    }

    /*GETTERS*/
    public double getSalesTax() {
        return salesTax;
    }

    /*SETTERS*/
    public void setSalesTax(double newTax) {
        salesTax = newTax;
    }

}
