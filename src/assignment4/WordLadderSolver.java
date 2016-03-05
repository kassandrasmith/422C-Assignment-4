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

    // add a constructor for this object. HINT: it would be a good idea to set up the dictionary there
    public WordLadderSolver(Dictionary dictionary) {
        this.dictionary = dictionary;
    }

    // do not change signature of the method implemented from the interface
    @Override
    public List<String> computeLadder(String startWord, String endWord) throws NoSuchLadderException {
        if (isOneAway(startWord, endWord)) {
            ladder.add(0, startWord);
            ladder.add(1, endWord);
            return ladder;
        }
        AdjacencyMatrix wordGraph = new AdjacencyMatrix(dictionary.getWordSet());
        //DepthFirstSearch newLadder = new DepthFirstSearch(wordGraph, 0);
        if (dictionary.wordToIndex(startWord) == -1 || dictionary.wordToIndex(endWord) == -1) {
            System.out.println("not a real word");
        } else {
            finalLadder = wordGraph.bfs(dictionary.wordToIndex(startWord), dictionary.wordToIndex(endWord));
        }
        if (finalLadder == null) {
            throw new NoSuchLadderException("No ladder exists between these two words");
        } else {
            for (Integer o : finalLadder) {
                ladder.add(dictionary.indexToWord(o));
            }
            ladder.add(startWord);
        }
        Collections.reverse(ladder); //put start word first and end word last
        return ladder;
        //throw new UnsupportedOperationException("Not implemented yet!");
    }


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
    public boolean validateResult() {
        throw new UnsupportedOperationException("Not implemented yet!");
    }
    // add additional methods here


}
