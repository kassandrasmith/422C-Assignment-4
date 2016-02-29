package assignment4;

import java.util.List;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class Assign4Driver
{
    public static void main(String[] args)
    {
        // Create a word ladder solver object
        Assignment4Interface wordLadderSolver = new WordLadderSolver();
        try 
        {
            List<String> result = wordLadderSolver.computeLadder("stone", "money");

            System.out.println(result); //todo formatting

            //todo add back in
            // boolean correct = wordLadderSolver.validateResult("money", "honey", result);
        }
        //todo add to end of printed line System.out.println("*********");
        catch (NoSuchLadderException e) 
        {
            e.printStackTrace();
        }
    }
}



