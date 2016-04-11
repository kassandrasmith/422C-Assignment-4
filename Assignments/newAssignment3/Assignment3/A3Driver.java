package Assignment3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

/*
* Driver for a shopping cart
* @author Kassandra Smith KSS2474 (16180)
* @author Caroline Yao CHY253 (16185)
*/

public class A3Driver {

    /*
    METHOD: main
    PURPOSE: driver
    PARAMS: @param a string array of the words in the string passed
    RETURNS: NONE
    */
    public static void main(String[] args) {
        ArrayList<Item> shoppingCart = new ArrayList<Item>();
        readFile(args, shoppingCart);
    }


    /*
     METHOD: readFile
     PURPOSE: reads from a file
     PARAMS: @param the file
     @param the shopping cart arraylist
     RETURNS: NONE
    */
    private static void readFile(String[] args, ArrayList<Item> shoppingCart) {

        // Open file; file name specified in args (command line)
        if (args.length != 1) {
            System.err.println("Error: Incorrect number of command line arguments");
            System.exit(-1);
        }

        // open reader
        String filename = args[0];
        try {
            FileReader freader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(freader);
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                processInput(s, shoppingCart);

            }
            // close reader
            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("Error: File not found. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {
            System.err.println("Error: IO exception. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        }


    }


    /*
    METHOD: processInput
    PURPOSE: takes an input and decides which command to carry out
    PARAMS:   @param the input string
    @param the shopping cart arraylist
    RETURNS: NONE
    */
    static void processInput(String s, ArrayList<Item> shoppingCart) {

        s = s.trim();
        String[] input = s.split("[\\s]+");

        switch (input[0].toLowerCase()) {
            case "insert":
                processInsert(input, shoppingCart);
                sortCart(shoppingCart);
                break;
            case "search":
                processSearch(input, shoppingCart);
                break;
            case "update":
                processUpdate(input, shoppingCart);
                break;
            case "delete":
                processDelete(input, shoppingCart);
                break;
            case "print":
                processPrint(input, shoppingCart);
                break;
            default:
                System.out.println("Detected an invalid command. Please try again.");
        }
    }

    /*
    METHOD: processPrint
    PURPOSE: prints the name and price of each item
    PARAMS: @param shopping cart arraylist
    RETURNS: NONE
    */
    private static void processPrint(String[] command, ArrayList<Item> shoppingCart) {
        float cartPrice = 0;

        DecimalFormat df = new DecimalFormat("0.00");
        if (command.length == 1) {
            Iterator<Item> i = shoppingCart.iterator();
            System.out.println("Printing the current cart:");
            while (i.hasNext()) {
                Item temp = i.next();
                cartPrice += temp.calculatePrice();
                temp.printItemAttributes();
            }
            System.out.println("Total cost of cart is $" + df.format(cartPrice));
        } else {
            System.out.println("Too many arguments. Please try again.");
        }
    }


    /*
    METHOD: processDelete
    PURPOSE: removes all instances of a specified item from the shopping cart
    PARAMS: @param the name of the item to delete
    @param the shopping cart
    RETURNS: NONE
    */
    private static void processDelete(String[] deleteme, ArrayList<Item> shoppingCart) {
        boolean wasRemoved = false;
        // delete <name>
        int numberDeleted = 0;
        if (deleteme.length == 2) {
            int shoppingCartSize = shoppingCart.size();
            for (int i = 0; i < shoppingCartSize; i++) {
                if (shoppingCart.get(i).getName().contentEquals(deleteme[1])) {
                    numberDeleted += shoppingCart.get(i).getQuantity();
                    shoppingCart.remove(i);
                    shoppingCartSize--;
                    wasRemoved = true;
                    i--;
                }

            }
            if (wasRemoved = false) {
                System.out.println("That item does not exist and was not removed.");
            } else {
                System.out.println("Successfully removed " + numberDeleted + " " + deleteme[1] + "s from the shopping cart.");
            }
        } else {
            System.out.println("Invalid number of arguments, please try again.");
        }
    }

    /*
    METHOD: process Update
    PURPOSE: updates the number of a specified item to a new number
    PARAMS: @param the line containing the command
    @param the shopping cart
    RETURNS: NONE
    */
    private static void processUpdate(String[] input, ArrayList<Item> cart) {
        if (input.length == 3) {
            for (Item temp : cart) {
                if (temp.getName().equals(input[1])) {
                    temp.setQuantity(Integer.parseInt(input[2]));//Removed addition to previous quantity
                    System.out.println("Updated number of " + input[1] + " is now " + temp.getQuantity());
                    return;
                }
            }
            System.out.println("That item does not exist. Please use insert to add it.");
        } else {
            System.out.println("Invalid number of arguments, please try again.");
        }
    }


    /*
    METHOD: processSearch
    PURPOSE: searches the shopping cart for an item and prints the total, collective number of the item
    PARAMS: @param the line containing the command
    @param the shopping cart
    RETURNS: NONE
    */
    private static void processSearch(String[] input, ArrayList<Item> shoppingCart) {
        int numberOfItem = 0;
        String itemName = input[1];
        if (input.length == 2) {
            for (Item temp : shoppingCart) {
                if (temp.getName().contentEquals(itemName)) {
                    numberOfItem += temp.getQuantity();
                }
            }

            if (numberOfItem == 1) {
                System.out.println("There is 1" + " " + itemName);
            } else {
                System.out.println("There are " + numberOfItem + " " + itemName + "s");
            }
        } else {
            System.out.println("Invalid number of arguments, please try again.");
        }
    }


    /*
    METHOD: processInsert
    PURPOSE: inserts a specified item into the cart
    PARAMS: @param the line containing the command
    @param the shopping cart
    RETURNS: NONE
    */
    private static void processInsert(String[] input, ArrayList<Item> cart) {

        switch (input[1].toLowerCase()) {
            case "clothing":
                if (input.length == 6) {
                    if (!input[3].matches("(\\d*\\.?\\d{1,2})")) {
                        System.out.println("Improperly formatted price");
                        break;
                    } else if (!input[4].matches("(\\d*\\.?0*)")) {
                        System.out.println("Improperly formatted quantity--must be a whole number");
                        break;
                    } else if (!input[5].matches("(\\d*\\.?0*)")) {
                        System.out.println("Improperly formatted weight--must be a whole number");
                        break;
                    } else {
                        Clothing cloth = new Clothing(input[2], Double.parseDouble(input[3]), (int) Double.parseDouble(input[4]), Double.parseDouble(input[5]));
                        cart.add(cloth);
                        System.out.println("Successfully added " + cloth.getQuantity() + " " + cloth.getName() + "(s)");
                    }
                } else {
                    System.out.println("Incorrect number of arguments. Please try again.");
                    break;
                }

                break;
            case "electronics":
                if (!input[3].matches("(\\d*\\.?\\d{1,2})")) {
                    System.out.println("Improperly formatted price");
                    break;
                } else if (!input[4].matches("(\\d*\\.?0*)")) {
                    System.out.println("Improperly formatted quantity--must be a whole number");
                    break;
                } else if (!input[5].matches("(\\d*\\.?0*)")) {
                    System.out.println("Improperly formatted weight--must be a whole number");
                    break;
                } else {
                    if (input.length == 8 && isAState(input[7]) && isFragileFlag(input[6])) {
                        Electronics elec = new Electronics(input[2], Double.parseDouble(input[3]), (int) Double.parseDouble(input[4]), Double.parseDouble(input[5]), input[6], input[7]);
                        cart.add(elec);
                        System.out.println("Successfully added " + elec.getQuantity() + " " + elec.getName() + "(s)");
                    } else {
                        System.out.println("Incorrect arguments. Please try again.");
                        break;
                    }
                }
                break;
            case "groceries":
                if (!input[3].matches("(\\d*\\.?\\d{1,2})")) {
                    System.out.println("Improperly formatted price");
                    break;
                } else if (!input[4].matches("(\\d*\\.?0*)")) {
                    System.out.println("Improperly formatted quantity--must be a whole number");
                    break;
                } else if (!input[5].matches("(\\d*\\.?0*)")) {
                    System.out.println("Improperly formatted weight--must be a whole number");
                    break;
                } else {
                    if (input.length == 7 && isPerishableFlag(input[6])) {
                        Grocery food = new Grocery(input[2], Double.parseDouble(input[3]), (int) Double.parseDouble(input[4]), Double.parseDouble(input[5]), input[6]);
                        cart.add(food);
                        System.out.println("Successfully added " + food.getQuantity() + " " + food.getName() + "(s)");
                    } else {
                        System.out.println("Incorrect number of arguments. Please try again.");
                        break;
                    }
                    break;
                }
            default:
                System.out.println("Detected an invalid command. Please try again.");
        }

    }

    /*
    METHOD: is it a fragile flag
    PURPOSE: checks if a string is a fragile flag
    PARAMS: @param the string to be checked
    RETURNS: whether or not the string is a fragile flag (boolean)
    */
    private static boolean isFragileFlag(String s) {

        s = s.toUpperCase();
        if (s.contentEquals("F") | s.contentEquals("NF")) {
            return true;
        } else {
            return false;
        }

    }

    /*
    METHOD: is it a perishable flag
    PURPOSE: checks if a string is a perishable flag
    PARAMS: @param the string to be checked
    RETURNS: whether or not the string is a perishable flag (boolean)
    */
    private static boolean isPerishableFlag(String s) {

        s = s.toUpperCase();
        if (s.contentEquals("P") | s.contentEquals("NP")) {
            return true;
        } else {
            return false;
        }

    }

    /*
    METHOD: sortCart
    PURPOSE: sorts the shopping cart in alphanumeric order with disregard for capitalization by item name
    PARAMS: @param the shopping cart
    RETURNS: NONE
    */
    public static void sortCart(ArrayList<Item> cart) {
        Collections.sort(cart);
    }


    /*
    METHOD: is a state
    PURPOSE: checks if a string is actually a state's postal code
    PARAMS: @param the string to be checked
    RETURNS: whether or not the string is a state's postal code (boolean)
    */
    static boolean isAState(String state) {
        state = state.toUpperCase();
        if (state.contentEquals("AL") | state.contentEquals("AK") | state.contentEquals("AS") | state.contentEquals("AZ") | state.contentEquals("AR") | state.contentEquals("CA") | state.contentEquals("CO") | state.contentEquals("CT") | state.contentEquals("DE") | state.contentEquals("DC") | state.contentEquals("FL") | state.contentEquals("GA") | state.contentEquals("GU") | state.contentEquals("HI") | state.contentEquals("ID") | state.contentEquals("IL") | state.contentEquals("IN") | state.contentEquals("IA") | state.contentEquals("KS") | state.contentEquals("KY") | state.contentEquals("LA") | state.contentEquals("ME") | state.contentEquals("MD") | state.contentEquals("MH") | state.contentEquals("MA") | state.contentEquals("MI") | state.contentEquals("FM") | state.contentEquals("MN") | state.contentEquals("MS") | state.contentEquals("MO") | state.contentEquals("MT") | state.contentEquals("NE") | state.contentEquals("NV") | state.contentEquals("NH") | state.contentEquals("NJ") | state.contentEquals("NM") | state.contentEquals("NY") | state.contentEquals("NC") | state.contentEquals("ND") | state.contentEquals("MP") | state.contentEquals("OH") | state.contentEquals("OK") | state.contentEquals("OR") | state.contentEquals("PW") | state.contentEquals("PA") | state.contentEquals("PR") | state.contentEquals("RI") | state.contentEquals("SC") | state.contentEquals("SD") | state.contentEquals("TN") | state.contentEquals("TX") | state.contentEquals("UT") | state.contentEquals("VT") | state.contentEquals("VA") | state.contentEquals("VI") | state.contentEquals("WA") | state.contentEquals("WV") | state.contentEquals("WI") | state.contentEquals("WY")) {
            return true;
        } else {
            return false;
        }
    }

}