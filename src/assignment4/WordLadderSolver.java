/*
    Solver for the Word Ladder Assignment
    Team # 33:
    SMITH, KASSANDRA kss2474 (16180)
    HADIMOHD, AFTAB ah35368 (16180)
 */

package assignment4;

import java.util.*;

// do not change class name or interface it implements
public class WordLadderSolver implements Assignment4Interface {
    // declare class members here.
    private final Dictionary dictionary;
    private final ArrayList<String> ladder = new ArrayList<>();
    private List<Integer> finalLadder = new LinkedList<>();

    public WordLadderSolver(Dictionary dictionary) {
        this.dictionary = dictionary;
    }
    // do not change signature of the method implemented from the interface

    /*
    METHOD:     computeLadder
    PURPOSE:    creates a ladder
    PARAMS:     @param the start word of the ladder
                @param the end word of the ladder
    RETURNS:    A list that contains the words in the ladder between the start and end word
    */
    @Override
    public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException {
        finalLadder.clear();
        try {
            if (startWord.length() != 5 | endWord.length() != 5) {
                throw new WordDoesNotExistException("Both words must be exactly 5 letters long");
            }
            if(dictionary.wordToIndex(startWord) == -1 || dictionary.wordToIndex(endWord) == -1){
                throw new WordDoesNotExistException("Not a real word");
            }
        } catch (WordDoesNotExistException e) {
            System.out.println("Both words must be exactly 5 letters long and in the dictionary");
            return ladder;
        }
        //check to see if the pair is the same word
        if (startWord.equals(endWord)) {
            ladder.add(0, startWord);
            return ladder;
        }
        //check whether or not the pair is already a ladder
        if (isOneAway(startWord, endWord)) {
            ladder.add(0, startWord);
            ladder.add(1, endWord);
            return ladder;
        }
        //create an adjacency matrix
        AdjacencyMatrix wordGraph = new AdjacencyMatrix(dictionary.getWordSet());
        try {
            if (dictionary.wordToIndex(startWord) == -1 || dictionary.wordToIndex(endWord) == -1) {
                throw new WordDoesNotExistException("not a real word");
            } else {
                finalLadder = wordGraph.bfs(dictionary.wordToIndex(startWord), dictionary.wordToIndex(endWord));
            }
        } catch (WordDoesNotExistException e) {
            System.out.println("not a real word");
        }
        try {
            if (finalLadder == null | finalLadder.size() == 1) {
                throw new NoSuchLadderException("No ladder exists between these two words");
            } else {
                for (Integer o : finalLadder) {
                    ladder.add(dictionary.indexToWord(o));
                }
            }
        } catch (NoSuchLadderException e) {
            System.out.println("No ladder exists between these two words");
        }

        Collections.reverse(ladder); //put start word first and end word last
        return ladder;

        //throw new UnsupportedOperationException("Not implemented yet!");
    }

    /*
    METHOD:     isOneAway
    PURPOSE:    checks to see if two Strings are different by one letter
    PARAMS:     @param the first word (String)
                @param the word to be checked against (String)
    RETURNS:    A true or false depending on whether or not the words are one away
    */
    private boolean isOneAway(String first, String second) {
        int counter = 0;
        for (int j = 0; j < 5; j++) {
            if (first.charAt(j) == second.charAt(j)) {
                counter++;
            }
        }
        return counter == 4;
    }

    @Override
    public boolean validateResult(String startWord, String endWord, List<String> wordLadder) {
        String prevWord = startWord;
        for (String aWordLadder : wordLadder) {
            if (!isOneAway(prevWord, aWordLadder) && !startWord.equals(wordLadder.get(0))) {
                return false;
            }
            prevWord = aWordLadder;
        }
        return true;
    }
}
