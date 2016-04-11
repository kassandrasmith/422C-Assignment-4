package assignment4;
/*
    Test for Dictionary for the Word Ladder Assignment
    Team # 33:
    SMITH, KASSANDRA kss2474 (16180)
    HADIMOHD, AFTAB ah35368 (16180)
 */

import org.junit.Test;

import java.util.Objects;
import java.util.Set;

import static org.junit.Assert.*;


public class DictionaryTest {
    String[] smallDict = {"apple", "brute", "civil", "copic", "deals", "feels", "tears"};
    Set<String> testSmallDict;

    @Test
    public void testWordToIndex() throws Exception {
        Dictionary dictionary = new Dictionary(smallDict);
        int zero = dictionary.wordToIndex("apple");
        assert (zero == 0);
        int one = dictionary.wordToIndex("brute");
        assert (one == 1);
        int four = dictionary.wordToIndex("deals");
        assert (four == 4);
        int six = dictionary.wordToIndex("tears");
        assert (six == 6);
    }

    @Test
    public void testIndexToWord() throws Exception {
        Dictionary dictionary = new Dictionary(smallDict);
        String zero = dictionary.indexToWord(0);
        assert (Objects.equals(zero, "apple"));
        String one = dictionary.indexToWord(1);
        assert (Objects.equals(one, "brute"));
        String four = dictionary.indexToWord(4);
        assert (Objects.equals(four, "deals"));
        String six = dictionary.indexToWord(6);
        assert (Objects.equals(six, "tears"));


    }

    @Test
    public void testGetWordSet() throws Exception {
        Dictionary dictionary = new Dictionary(smallDict);
        Set dictSet = dictionary.getWordSet();
        assert (dictSet.size() == 7);

    }
}