package assignment4;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class Assign4Driver {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Error: Incorrect number of command line arguments");
            System.exit(-1);
        }

        String[] dictionaryStrings = fromFile(args[0]);
        Dictionary dictionary = new Dictionary(dictionaryStrings);
        // Create a word ladder solver object
        Assignment4Interface wordLadderSolver = new WordLadderSolver(dictionary);
        try {
            List<String> result = wordLadderSolver.computeLadder("stone", "money");

            System.out.println(result); //todo formatting

            //todo add back in
            // boolean correct = wordLadderSolver.validateResult("money", "honey", result);
        }
        //todo add to end of printed line System.out.println("*********");
        catch (NoSuchLadderException e) {
            e.printStackTrace();
        }
    }

    public static String[] fromFile(String filename) {

        List<String> array = new ArrayList<>();

        // open reader
        try {
            FileReader freader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(freader);
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                if (!s.startsWith("*")) {
                    s = s.substring(0, 5);
                    array.add(s);
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
        return (String[]) array.toArray(); //potential fixme
    }
}



