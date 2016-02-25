import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Driver for the Word Ladder Assignment
 * @author SMITH, KASSANDRA kss2474 E E422C(16180) Team 33
 * @author HADIMOHD, AFTAB ah35368 E E422C(16180) Team 33
 */
public class A4Driver {
    public static void main(String [ ] args){
    readFile(args);

    }


    /*
     METHOD: readFile
     PURPOSE: reads from a file
     PARAMS: @param the file
     @param the shopping cart arraylist
     RETURNS: NONE
    */
    private static void readFile(String[] args) {

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
            //TODO do something with the input
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



    private String[] createLadder(String startWord, String endWord) {
        //todo fill this in

        if(startWord != endWord){
            createLadder(startWord, endWord);
        }

        return new String[0];
    }
}