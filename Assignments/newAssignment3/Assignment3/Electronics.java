package Assignment3;

public class Electronics extends Item {
    private double salesTax = 1.1; //default is that there is sales tax
    private String state; // specified states do not have sales tax
    private boolean fragile = false; // fragile items require premium shipping
    protected static final double WEIGHT_MULTIPLIER = 20;

    /* CONSTRUCTORS */
    public Electronics() {
        super();
    }

    public Electronics(String itemName) {
        super(itemName);
    }

    public Electronics(String itemName, double itemPrice, int itemQuantity, double itemWeight) {
        super(itemName, itemPrice, itemQuantity, itemWeight);
    }


    public Electronics(String itemName, double itemPrice, int itemQuantity, double itemWeight, String inputState
    ) {
        super(itemName, itemPrice, itemQuantity, itemWeight);
        state = inputState;
        fragile = false;

        salesTax = calculateSalesTax(inputState);

    }

    //this is the only constructor that should be used for assignment 3
    public Electronics(String itemName, double itemPrice, int itemQuantity, double itemWeight, String inputState,
                       String isItemFragile) {
        super(itemName, itemPrice, itemQuantity, itemWeight);
        state = inputState;
        fragile = isItemFragile.toUpperCase().equals("F");
        salesTax = calculateSalesTax(inputState);

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
        shipping = (WEIGHT_MULTIPLIER * weight) * quantity;
        if (fragile) {
            shipping = shipping * 1.2;
        }
        finalPrice = ((price * quantity) + shipping + (tax));
        return finalPrice;
    }

    /*
    METHOD: calculate sales tax
    PURPOSE: determines the sales tax multiplier by state
    PARAMS: @param string input state abbreviation
    RETURNS: double value of the calculated tax multiplier
    */
    private double calculateSalesTax(String state) {
        switch (state) {
            case "TX":
            case "NM":
            case "VA":
            case "AZ":
            case "AK":
                return 1;
            default:
                return 1.1;
        }
    }

    /*GETTERS*/
    public double getSalesTax() {
        return salesTax;
    }

    public String getState() {
        return state;
    }

    public boolean getFragile() {
        return fragile;
    }

    /*SETTERS*/
    public void setSalesTax(double newTax) {
        salesTax = newTax;
    }

    public void setState(String newState) {
        state = newState;
    }

    public void setFragile(boolean newFragile) {
        fragile = newFragile;
    }


}
