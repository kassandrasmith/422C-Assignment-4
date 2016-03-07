package assignment4;

import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/*
    Test for Dictionary for the Word Ladder Assignment
    Team # 33:
    SMITH, KASSANDRA kss2474 (16180)
    HADIMOHD, AFTAB ah35368 (16180)
 */
public class AdjacencyMatrixTest {

    String[] testDictionary = {"stone", "stole", "style", "stile", "shile", "while", "whilt", "guild"};
    Dictionary dictionary = new Dictionary(testDictionary);
    AdjacencyMatrix wordGraph = new AdjacencyMatrix(dictionary.getWordSet());


    @Test
    public void testBfs() throws Exception {

        int stone = dictionary.wordToIndex("stone");
        int whilew = dictionary.wordToIndex("while");
        List<Integer> testAgainst = new LinkedList<>();
        for (String word: testDictionary) {
            boolean add = testAgainst.add(dictionary.wordToIndex(word));
        }
        List<Integer> testingList = wordGraph.bfs(stone, whilew);
        assert (wordGraph.getNumVertices() == 7);
        assert (testingList == testAgainst);

    }

    @Test
    public void testGetNumVertices() throws Exception {
        assert (wordGraph.getNumVertices() == 7);
    }
}