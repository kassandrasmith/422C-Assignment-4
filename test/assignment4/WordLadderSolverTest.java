package assignment4;
/*
    Test for WordLadderSolver for the Word Ladder Assignment
    Team # 33:
    SMITH, KASSANDRA kss2474 (16180)
    HADIMOHD, AFTAB ah35368 (16180)
 */
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

public class WordLadderSolverTest {
    Assignment4Interface tester;
    @Before


    public void setUp() throws Exception{
        String[] dictionaryStrings = {"dears", "fears", "stone", "money","smart","heads","tails", "atlas","zebra" };
        Dictionary dictionary = new Dictionary(dictionaryStrings);
        tester = new WordLadderSolver(dictionary);
    }

    @Test
    public void testComputeLadder() throws Exception {
        List<String> case1 = tester.computeLadder("dears", "fears");
        List<String> case2 = tester.computeLadder("stone", "money");
        List<String> case3 = tester.computeLadder("smart", "money");
        List<String> case4 = tester.computeLadder("heads", "tails");


        try {
            List<String> case5 = tester.computeLadder("joe", "shmo");
            fail("invalid");
        } catch (Exception ignored) {
        }
        try {
            List<String> case6 = tester.computeLadder("atlas", "zebra");
        } catch (Exception ignored) {
        }

        assert (tester.validateResult("dears", "fears", case1));
        assert (tester.validateResult("stone", "money", case2));
        assert (tester.validateResult("smart", "money", case3));
        assert (tester.validateResult("heads", "tails", case4));
    }

    @Test
    public void testValidateResult() throws Exception {
        //same words
        assert (tester.validateResult("honey", "honey", asList("honey", "honey")));
        assert (tester.validateResult("money", "money", asList("money", "money")));
        //empty
        assert (tester.validateResult("", "", asList("", "")));
        //different words
        assert (tester.validateResult("money", "honey", asList("money", "honey")));

        //assertEquals(false, tester.validateResult("say","boy", asList("say","boy")));

    }
}