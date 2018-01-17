import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class YahtzeeTester {

    //Determines if a Yahtzee is valid.
    @Test
    public void testYahtzee() {
        YahtzeeScorer firstSet = new YahtzeeScorer(new int[]{1, 1, 1, 1, 1});
        YahtzeeScorer secondSet = new YahtzeeScorer((new int[]{1,1,1,2,3}));
        assertTrue(firstSet.isYahtzee());
        assertFalse(secondSet.isYahtzee());
    }

    //Determines if a second yahtzee is rolled in same tester.
    @Test
    public void testSetYahtzee() {
        YahtzeeScorer firstSet = new YahtzeeScorer(new int[]{1, 1, 1, 1, 1});
        firstSet.setYahtzee();
        System.out.println(firstSet.returnScore());
        assertFalse(firstSet.isYahtzee());
    }

    //Checks if yahtzee score is added correctly
    @Test
    public void test_added_score_yahtzee(){
        YahtzeeScorer firstSet = new YahtzeeScorer(new int[]{1, 1, 1, 1, 1});
        firstSet.setYahtzee();
        assertEquals(firstSet.returnScore(), 50);
    }

    //Determines if a valid and invalid long straight can be identified
    @Test
    public void testLongStraight() {
        YahtzeeScorer firstSet = new YahtzeeScorer(new int[]{1, 2, 3, 4, 5});
        YahtzeeScorer secondSet = new YahtzeeScorer(new int[]{2, 3, 4, 5, 6});
        YahtzeeScorer thirdSet = new YahtzeeScorer(new int[]{3, 3, 4, 5, 6});
        assertTrue(firstSet.isLongStraight());
        assertTrue(secondSet.isLongStraight());
        assertFalse(thirdSet.isLongStraight());
    }

    //Determines if a long straight cannot be valid if already set
    @Test
    public void test_setLongStraight(){
        YahtzeeScorer firstSet = new YahtzeeScorer(new int[]{2, 3, 4, 5, 6});
        firstSet.setLongStraight();
        assertFalse(firstSet.isLongStraight());
    }

    //Determines if the correct score is added with a valid long straight
    @Test
    public void test_added_score_longStraight(){
        YahtzeeScorer firstSet = new YahtzeeScorer(new int[]{2, 3, 4, 5, 6});
        firstSet.setLongStraight();
        assertEquals(firstSet.returnScore(), 35);
    }

    //Determines a valid vs an invalid three of a kind
    @Test
    public void test_isThreeOfAKind(){
        YahtzeeScorer firstSet = new YahtzeeScorer(new int[]{1, 1, 4, 1, 6});
        YahtzeeScorer secondSet = new YahtzeeScorer(new int[]{2, 3, 4, 5, 6});
        assertTrue(firstSet.isThreeOfAKind());
        assertFalse(secondSet.isThreeOfAKind());
    }

    //Checks that the score for a three of a kind is properly added
    @Test
    public void test_sum_setThreeOfAKind(){
        YahtzeeScorer firstSet = new YahtzeeScorer(new int[]{1, 1, 4, 1, 6});
        firstSet.setThreeOfAKind();
        assertEquals(firstSet.returnScore(), 13);
    }

    //Checks that a three of a kind is invalid if one has already been set.
    @Test
    public void test_setThreeOfAKind(){
        YahtzeeScorer firstSet = new YahtzeeScorer(new int[]{1, 1, 4, 1, 6});
        firstSet.setThreeOfAKind();
        assertFalse(firstSet.isThreeOfAKind());
    }

    //Checks whether the program correctly determins a valid or invalid full house
    @Test
    public void test_isFullHouse(){
        YahtzeeScorer firstSet = new YahtzeeScorer(new int[]{1, 1, 4, 1, 6});
        YahtzeeScorer secondSet = new YahtzeeScorer(new int[]{1, 1, 4, 1, 4});
        assertFalse(firstSet.isFullHouse());
        assertTrue(secondSet.isFullHouse());
    }

    //Checks to see if a full house is incorrect when one is already set
    @Test
    public void test_setFullHouse(){
        YahtzeeScorer firstSet = new YahtzeeScorer(new int[]{1, 1, 4, 1, 4});
        firstSet.setFullHouse();
        assertFalse(firstSet.isFullHouse());
    }

    //Tests the added sum for a full house
    @Test
    public void test_sum_setFullHouse(){
        YahtzeeScorer firstSet = new YahtzeeScorer(new int[]{1, 1, 4, 1, 4});
        firstSet.setFullHouse();
        assertEquals(firstSet.returnScore(), 25);
    }

    //Tests if multiple scores add up for a total correctly.
    public void test_add_multiple_scores(){
        YahtzeeScorer firstSet = new YahtzeeScorer(new int[]{1, 1, 4, 1, 4});
        firstSet.setFullHouse();
        firstSet.setYahtzee();
        assertEquals(firstSet.returnScore(), 85);
    }
}
