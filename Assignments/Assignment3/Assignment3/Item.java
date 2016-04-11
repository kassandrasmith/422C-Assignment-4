package Assignment3;

import java.text.DecimalFormat;

/*
* General item class for input in a shopping cart
* @author Kassandra Smith KSS2474 (16180)
* @author Caroline Yao CHY253 (16185)
*/
abstract public class Item implements Comparable {
    // Declare variables for this class. Think about its type: public, protected
    // or private?
    protected String name;
    protected int quantity;
    protected double price;
    protected double weight;
    protected double shipping;
    protected static final double WEIGHT_MULTIPLIER = 20;

    /*CONSTRUCTORS*/
    public Item() {
        name = "void";
        quantity = 0;
        price = 0;
        weight = 0;
    }

    public Item(String itemName) {
        name = itemName;
        quantity = 0;
        price = 0;
        weight = 0;
    }

    public Item(String itemName, double itemPrice, int itemQuantity, double itemWeight) {
        name = itemName;
        quantity = itemQuantity;
        price = itemPrice;
        weight = itemWeight;
    }

    /*
    METHOD: calculate price
    PURPOSE: made abstract to allow different outputs for different price calculations
    PARAMS: NONE
    RETURNS: price of the item
    */
    abstract double calculatePrice();

    /*
   METHOD: print Item Price
   PURPOSE: prints the information associated with an every in the cart
   PARAMS: NONE
   RETURNS: NONE
   */
    public void printItemAttributes() {
        double newPrice = calculatePrice();
        System.out.println(name + "  |  " + "Item quantity: " + quantity + "  |  " + "Price per 1 item (before shipping or tax): " + price + " | "
                +  " | " + "price for all of this item (including shipping and tax): " + makeCurrency(newPrice) + "\n");
    }

    /*
    METHOD: make Currency
    PURPOSE: converts a input number into the 0.00 format
    PARAMS: @param double to make into currency
    RETURNS: formatted string
    */
    public String makeCurrency(double newPrice) {
        // double currency = Math.round(newPrice * 100.00) / 100.00;
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(newPrice);

    }


    /*
    METHOD: print Item Price
    PURPOSE: prints the information associated with an item in the cart
    PARAMS: NONE
    RETURNS: NONE
    */
    public void printItemPrice() {
        System.out.println("There are " + quantity + " " + name + "s priced at: $" + makeCurrency(price) + " each");
    }

    /*
    METHOD: compareTo
    PURPOSE: compares the two object names
    PARAMS: @param the item object to compare against
    RETURNS: integer which tells whether the compared object was before or after the current item
    */
    //compare method for comparator
    public int compareTo(Object item) {
        if (item instanceof Item) {
            Item newItem = (Item) item;
            return this.getName().compareTo(newItem.getName());
        } else {
            return 0;
        }

    }


    /* GETTERS */
    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    /* SETTERS */
    public void setName(String itemName) {
        name = itemName;
    }

    public void setQuantity(int itemQuantity) {
        quantity = itemQuantity;
    }

    public void setPrice(double itemPrice) {
        price = itemPrice;
    }

    public void setWeight(double itemWeight) {
        weight = itemWeight;
    }

}
