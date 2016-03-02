package assignment4;

import java.io.*;
import java.util.HashMap;


public class Dictionary {
    private static String alphabet = "abcdefghijklmnopqrstuvwxyz";
    public HashMap dictionary = new HashMap();


    public Dictionary(String[] args) {

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
                if (!s.startsWith("*")) {
                    s = s.substring(0, 5);
                    dictionary.put(s, 0);
                }
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

    public boolean isOneAway(String first, String second) {
        int counter = 0;
        for (int j = 0; j < 5; j++) {
            if (first.charAt(j) == second.charAt(j)) {
                counter++;
            }
        }
        return counter == 4;
    }
}
