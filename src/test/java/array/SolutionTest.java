package array;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

    private Solution solution;

    @Before
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @Test(expected = Solution.IllegalNumberOfTests.class)
    public void testCasesIsMoreThanFiveThousand_thenIllegalNumberOfTests() {
        int[][] input = new int[1][];
        input[0] = new int[]{5001};
        solution.execute(input);
    }

    @Test(expected = Solution.IllegalNumberOfTests.class)
    public void testCasesIsLessThanOne_thenIllegalNumberOfTests() {
        int[][] input = new int[1][];
        input[0] = new int[]{0};
        solution.execute(input);
    }

    @Test(expected = Solution.IllegalArrayLength.class)
    public void arrayIsLessThanTwo_thenIllegalArrayLength() {
        int[][] input = new int[2][];
        input[0] = new int[]{1};
        input[1] = new int[]{1, 1};
        solution.execute(input);
    }

    @Test(expected = Solution.IllegalArrayLength.class)
    public void arrayIsMoreThan100_thenIllegalArrayLength() {
        int[][] input = new int[2][];
        input[0] = new int[]{1};
        input[1] = new int[]{101, 1};
        solution.execute(input);
    }

    @Test(expected = Solution.IllegalJumpLength.class)
    public void jumpIsLessThanZero_thenIllegalJumpLength() {
        int[][] input = new int[2][];
        input[0] = new int[]{1};
        input[1] = new int[]{2, -1};
        solution.execute(input);
    }

    @Test(expected = Solution.IllegalJumpLength.class)
    public void jumpIsMoreThan100_thenIllegalJumpLength() {
        int[][] input = new int[2][];
        input[0] = new int[]{1};
        input[1] = new int[]{2, 101};
        solution.execute(input);
    }

    @Test
    public void whenJumpIsGreaterThanArrayLength_thenResultIsYes() {
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{2, 3};
        input[2] = new int[]{0, 1};
        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES"}, result);
    }

    @Test
    public void whenArrayIs2_andJumpIsTwo_thenResultIsYes() {
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{2, 2};
        input[2] = new int[]{0, 1};
        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES"}, result);
    }

    @Test
    public void whenArrayIs2_andJumpIsOne_thenResultIsYes() {
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{2, 1};
        input[2] = new int[]{0, 1};
        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"NO"}, result);
    }

    @Test
    public void whenArrayIs3_andJumpIsOne_thenResultIsNo() {
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{2, 1};
        input[2] = new int[]{0, 1, 1};
        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"NO"}, result);
    }


    @Test
    public void whenArrayIs5_andJumpIs3_thenResultIsYes() {
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{5, 3};
        input[2] = new int[]{0, 0, 0, 0, 0};
        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES"}, result);
    }

    @Test
    public void whenArrayIs6_andJumpIs5_thenResultIsYes() {
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{6, 5};
        input[2] = new int[]{0, 0, 0, 1, 1, 1};
        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES"}, result);
    }

    @Test
    public void whenArrayIs6_andJumpIs3_thenResultIsNo() {
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{6, 3};
        input[2] = new int[]{0, 0, 1, 1, 1, 0};
        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"NO"}, result);
    }

    @Test
    public void whenArrayIs3_andJumpIs1_thenResultIsNo() {
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{3, 1};
        input[2] = new int[]{0, 1, 0};
        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"NO"}, result);
    }

    @Test
    public void whenArrayIs3_andJumpIs1_thenResultIsYes() {
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{3, 1};
        input[2] = new int[]{0, 0, 0};
        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES"}, result);
    }

    @Test
    public void whenArrayIs4_andJumpIs2_thenResultIsYes() {
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{4, 3};
        input[2] = new int[]{0, 1, 1, 0};
        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES"}, result);
    }

    @Test
    public void allTogether() {
        int[][] input = new int[9][];
        input[0] = new int[]{4};
        input[1] = new int[]{5, 3};
        input[2] = new int[]{0, 0, 0, 0, 0};
        input[3] = new int[]{6, 5};
        input[4] = new int[]{0, 0, 0, 1, 1, 1};
        input[5] = new int[]{6, 3};
        input[6] = new int[]{0, 0, 1, 1, 1, 0};
        input[7] = new int[]{3, 1};
        input[8] = new int[]{0, 1, 0};
        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES", "YES", "NO", "NO"}, result);
    }

    @Test
    public void testFirst() {
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{6, 2};
        input[2] = new int[]{0, 1, 0, 1, 0, 1};
        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES"}, result);
    }

    @Test
    public void testSecond() {
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{9, 4};
        input[2] = new int[]{0, 1, 1, 0, 0, 1, 1, 0, 1};
        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES"}, result);
    }


    @Test
    public void allTogetherTest1() {
        int[][] input = new int[7][];
        input[0] = new int[]{3};
        input[1] = new int[]{6, 2};
        input[2] = new int[]{0, 1, 0, 1, 0, 1};
        input[3] = new int[]{10, 6};
        input[4] = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 0, 0};
        input[5] = new int[]{10, 3};
        input[6] = new int[]{0, 0, 1, 1, 0, 0, 1, 1, 0, 0};

        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES", "NO", "YES"}, result);
    }

    @Test
    public void allTogetherTest6() {
        int[][] input = new int[11][];
        input[0] = new int[]{5};

        input[1] = new int[]{11, 5};
        input[2] = new int[]{0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1};
        input[3] = new int[]{11, 5};
        input[4] = new int[]{0, 1, 1, 1, 0, 0, 1, 1, 1, 0, 1};
        input[5] = new int[]{11, 5};
        input[6] = new int[]{0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1};

        input[7] = new int[]{15, 7};
        input[8] = new int[]{0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 1};

        input[9] = new int[]{15, 7};
        input[10] = new int[]{0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 0, 1, 1};

        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES", "YES", "NO", "YES", "NO"}, result);

    }

    @Test
    public void simple() {
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{84, 14};
        input[2] = new int[]{0,0,0,0,0,1,0,1,1,1,1,0,1,0,1,0,0,1,0,0,0,1,0,1,0,0,0,0,1,1,0,0,1,0,0,1,1,1,1,0,0,0,0,0,0,1,0,0,0,0,0,1,1,0,0,1,1,1,0,0,0,0,1,0,0,1,1,1,0,0,1,1,1,1,1,1,1,1,0,1,1,0,0,0};
                                                       //15                          //30                                  //49                  //60
        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES"}, result);

    }


    @Test
    public void when18and14_thenNO() {

        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{18, 14};
        input[2] = new int[]{0,1,1,0,1,1,1,1,1,1,1,1,1,0,1,1,1,1};

        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"NO"}, result);
    }

    @Test
    public void when19and4_thenSuccess() {

        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{19, 4};
        input[2] = new int[]{0,0,0,1,0,1,1,1,0,1,1,1,0,0,0,1,1,0,1};

        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES"}, result);
    }


    @Test
    public void when68and3_thenNo() {

        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{68, 3};
        input[2] = new int[]{0,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,0,0,1,1,1,1,1,0,0,1,0,1,1,1,1,1,1,1,0,1,1,1,1,0,0,1,1,1,1,1,0,1,1,1,1,1};

        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"NO"}, result);

    }

    @Test
    public void when36and9_thenNo() {

        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{36, 9};
        input[2] = new int[]{0,1,1,1,1,0,1,0,1,0,1,1,0,1,1,1,1,1,0,0,1,1,1,1,1,1,0,0,1,1,1,1,1,0,0,0};

        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES"}, result);

    }

    @Test
    public void when88and43_thenNo() {

        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{88, 43};
        input[2] = new int[]{0,1,0,1,1,0,0,1,1,1,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1,1,1,1,0,0,0,0,1,1,0,0,0,0,1,1,0,0,1,0,1,1,1,1,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,0,1,1,1,0,1,0,0,0,0,1,1,1,0};

        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"NO"}, result);

    }

    @Test
    public void when24and0_thenNo() {

        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{24, 0};
        input[2] = new int[]{0,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,0,1,1,0,1,1,1};

        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"NO"}, result);

    }

    @Test
    public void when89and1_thenNo() {
        //34
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{89, 1};
        input[2] = new int[]{0,0,0,1,0,1,1,1,1,1,1,0,1,1,1,1,1,1,1,1,0,0,1,1,1,0,1,1,1,0,1,1,0,1,1,1,0,1,1,1,1,1,1,0,1,1,0,1,1,0,1,1,0,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1,1,1,1,0,0,1,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1};

        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"NO"}, result);

    }

    @Test
    public void when73and29_thenYES() {
        //116
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{73, 29};
        input[2] = new int[]{0,0,0,1,1,0,1,1,1,1,1,0,1,0,1,1,1,1,1,1,0,1,1,1,1,1,0,0,1,0,1,0,0,1,0,1,1,1,1,0,1,1,1,1,0,0,0,1,1,0,1,1,1,1,0,0,0,1,1,1,1,0,0,0,1,0,1,1,1,1,0,1,1};

        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES"}, result);

    }

    @Test
    public void when2and0_thenYES() {
        //116
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{2, 0};
        input[2] = new int[]{0,0};

        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES"}, result);

    }

    @Test
    public void when83and15_thenYES() {
        //760
        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{83, 15};
        input[2] = new int[]{0,0,0,1,0,1,0,1,1,1,0,1,0,1,0,0,0,0,1,1,1,0,0,1,1,1,1,0,0,0,0,1,0,0,0,1,0,0,0,1,1,1,1,0,0,1,0,0,1,0,1,0,0,1,1,0,1,0,0,1,0,0,0,1,1,1,0,1,1,0,0,1,1,1,1,0,0,1,0,0,1,0,0};

        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES"}, result);

    }

    @Test
    public void when56and27_thenYES() {

        int[][] input = new int[3][];
        input[0] = new int[]{1};
        input[1] = new int[]{56, 27};
        input[2] = new int[]{0,0,0,0,0,1,1,1,0,1,1,1,0,1,1,0,0,0,1,0,1,1,1,1,0,1,1,0,0,1,0,1,1,1,1,1,0,1,0,1,1,0,0,1,1,0,0,0,1,1,1,0,1,0,1,1};

        String[] result = solution.execute(input);
        assertArrayEquals(new String[]{"YES"}, result);

    }

    @Test
    public void testcase3() throws Exception {

        InputStream is = SolutionTest.class.getResourceAsStream("/testcase3.txt");
        int[][] game = Solution.buildGameStructure(is);

        int[][] foundGame = getGameNumber(762, game);
        System.out.println("foundGame = " + foundGame);

        String[] gameResults = solution.execute(game);

        Scanner scanner = new Scanner(SolutionTest.class.getResourceAsStream("/testcase3.res.txt"));
        List<String> results = new ArrayList<String>();
        while (scanner.hasNext()) {
            results.add(scanner.nextLine());
        }

        assertArrayEquals(results.toArray(new String[5000]), gameResults);

    }


    @Test
    public void testcase4() throws Exception {

        InputStream is = SolutionTest.class.getResourceAsStream("/testcase4.txt");
        int[][] game = Solution.buildGameStructure(is);

        String[] gameResults = solution.execute(game);

        Scanner scanner = new Scanner(SolutionTest.class.getResourceAsStream("/testcase4.res.txt"));
        List<String> results = new ArrayList<String>();
        while (scanner.hasNext()) {
            results.add(scanner.nextLine());
        }

        assertArrayEquals(results.toArray(new String[5000]), gameResults);

    }


    @Test
    public void testcase7() throws Exception {

        InputStream is = SolutionTest.class.getResourceAsStream("/testcase7.txt");
        int[][] game = Solution.buildGameStructure(is);
        String[] calculatedResults = solution.execute(game);

        Scanner scanner = new Scanner(SolutionTest.class.getResourceAsStream("/testcase7.res.txt"));
        List<String> results = new ArrayList<String>();
        while (scanner.hasNext()) {
            results.add(scanner.nextLine());
        }

        assertArrayEquals(results.toArray(new String[5000]), calculatedResults);
    }

    @Test
    public void testcase8() throws Exception {

        InputStream is = SolutionTest.class.getResourceAsStream("/testcase8.txt");
        int[][] game = Solution.buildGameStructure(is);
        String[] calculatedResults = solution.execute(game);

        Scanner scanner = new Scanner(SolutionTest.class.getResourceAsStream("/testcase8.res.txt"));
        List<String> results = new ArrayList<String>();
        while (scanner.hasNext()) {
            results.add(scanner.nextLine());
        }

        assertArrayEquals(results.toArray(new String[5000]), calculatedResults);
    }


    private int[][] getGameNumber(int number, int[][] gameStructure) {
        int[][] foundGame = new int[2][];
        int gameNumber = 1;
        for(int i = 1; i < gameStructure.length; i ++) {

            int[] game = gameStructure[i++];
            int[] array = gameStructure[i];

            gameNumber ++;

            if(gameNumber == number) {
                foundGame[0] = game;
                foundGame[1] = array;
                return foundGame;
            }

        }
        return null;
    }
}
