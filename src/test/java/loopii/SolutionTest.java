package loopii;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SolutionTest {

    private Solution sol;

    @Before
    public void setUp() throws Exception {
        sol = new Solution();
    }

    @Test(expected = Solution.IllegalValue.class)
    public void whenAIsBelowZero_thenIllegalValue() {
       sol.calculateQuery(new int[]{-1,5,5});
    }

    @Test(expected = Solution.IllegalValue.class)
    public void whenAIsAboveFifty_thenIllegalValue() {
       sol.calculateQuery(new int[]{51,5,5});
    }

    @Test(expected = Solution.IllegalValue.class)
    public void whenBIsBelowZero_thenIllegalValue() {
       sol.calculateQuery(new int[]{5,-1,5});
    }

    @Test(expected = Solution.IllegalValue.class)
    public void whenBIsAboveFifty_thenIllegalValue() {
       sol.calculateQuery(new int[]{5,51,5});
    }


    @Test(expected = Solution.IllegalValue.class)
    public void whenNIsBelowOne_thenIllegalValue() {
       sol.calculateQuery(new int[]{5,3,0});
    }

    @Test(expected = Solution.IllegalValue.class)
    public void whenNIsAboveFifteen_thenIllegalValue() {
       sol.calculateQuery(new int[]{5,3,16});
    }


    @Test
    public void whenInput2IsFull_thenOutputIsAsExpected() {
        int[] input = new int[]{5,3,5};
        int[] result = sol.calculateQuery(input);

        Assert.assertArrayEquals(new int[]{8, 14, 26, 50, 98}, result);
    }

    @Test
    public void whenInputIsFull_thenOutputIsAsExpected() {
        int[] input = new int[]{0,2,10};
        int[] result = sol.calculateQuery(input);

        Assert.assertArrayEquals(new int[]{2, 6, 14, 30, 62, 126, 254, 510, 1022, 2046}, result);
    }

    /*
    @Test
    public void whenTwoQueries_thenOutputIsAsExpected() {
        int[][] input = new int[2][];
        input[0] = new int[]{0,2,10};
        input[1] = new int[]{5,3,5};
        int[][] result = sol.calculateArray(
                2,
                input
        );

        Assert.assertArrayEquals(new int[]{2, 6, 14, 30, 62, 126, 254, 510, 1022, 2046}, result[0]);
        Assert.assertArrayEquals(new int[]{8, 14, 26, 50, 98}, result[1]);
    }
    */





}
