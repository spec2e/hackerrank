package array;


import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Solution {

    public static final String YES = "YES";
    public static final String NO = "NO";

    public static void main(String[] args) {

        int[][] game = buildGameStructure(System.in);

        Solution sol = new Solution();
        String[] results = sol.execute(game);

        for (String s : results) {
            System.out.println(s);
        }

    }

    static int[][] buildGameStructure(InputStream inputStream) {
        Scanner in = new Scanner(inputStream);
        int numberOfTests = in.nextInt();

        int[][] input = new int[(numberOfTests * 2) + 1][];
        input[0] = new int[]{numberOfTests};

        int gameNumber = 0;
        for (int i = 1; i < input.length; i++) {
            int gameArrayLength = in.nextInt();
            input[i++] = buildTestArray(in, gameArrayLength);
            input[i] = buildGameArray(in, gameArrayLength);
            gameNumber++;
            //printGameArray(input[i], gameNumber);
        }
        return input;
    }

    private static void printGameArray(int[] ints, int i) {
        System.err.println("Game array for game: " + i);
        for (int anInt : ints) {
            System.err.print(anInt + " ");
        }
        System.err.println();
    }

    private static int[] buildGameArray(Scanner in, int gameArrayLength) {
        int[] gameArray = new int[gameArrayLength];
        for (int j = 0; j < gameArrayLength; j++) {
            gameArray[j] = in.nextInt();
        }
        return gameArray;
    }

    private static int[] buildTestArray(Scanner in, int gameArrayLength) {
        return new int[]{gameArrayLength, in.nextInt()};
    }

    public String[] execute(int[][] input) {

        validate(input);

        List<String> gameResult = new ArrayList<String>();

        int gameNumber = 0;
        for (int i = 1; i < input.length; i++) {
            int[] lengthAndJump = input[i++];
            int[] gameArray = input[i];
            //System.out.println("gameNumber = " + gameNumber);
            gameResult.add(
                    playGame(lengthAndJump[1], gameArray)
            );
            gameNumber ++;
        }

        return gameResult.toArray(new String[gameResult.size()]);
    }

    List<Integer> jumpedFromPosition = new ArrayList<Integer>();

    private String playGame(int jump, int[] gameArray) {

        jumpedFromPosition.clear();

        boolean isBackTracking = false;
        Stack<Integer> jumpPositions = new Stack<Integer>();

        for (int i = 0; i < gameArray.length; ) {
            if (i + 1 > gameArray.length -1 || i + jump > gameArray.length - 1) {
                return YES;
            } else if (canJump(jump, i, gameArray)) {
                jumpPositions.push(i);
                i += jump;
                isBackTracking = false;
            } else if (!isBackTracking && canMoveForward(i, gameArray)) {
                i++;
            } else if (canBackTrack(i, gameArray)) {
                i--;
                isBackTracking = true;
            } else {
                if (jumpPositions.empty()) {
                    return NO;
                } else {
                    i = jumpPositions.pop();
                    isBackTracking = false;
                }
            }
        }

        return NO;
    }

    private boolean canBackTrack(int i, int[] gameArray) {
        if (i - 1 > 0 && gameArray[i - 1] == 0) {
            return true;
        }
        return false;
    }

    private boolean canMoveForward(int i, int[] gameArray) {
        if (i + 1 < gameArray.length &&  gameArray[i + 1] == 0) {
            return true;
        }
        return false;
    }

    private boolean canJump(int jump, int currentPos, int[] gameArray) {
        if (!alreadyJumpedFromHere(currentPos)
                && jump > 0
                && gameArray[currentPos + jump] == 0) {
            jumpedFromPosition.add(currentPos);
            return true;
        }
        return false;
    }

    private boolean alreadyJumpedFromHere(int currentPos) {
        for (Integer position : jumpedFromPosition) {
            if(currentPos == position) {
                return true;
            }
        }
        return false;
    }


    private void validate(int[][] input) {
        validateNumberOfTests(input[0][0]);

        int positionOfFirstArrayLength = 1;
        for (int i = positionOfFirstArrayLength; i < input.length; i += 2) {
            validateArrayLength(input[i][0]);
            validateJumpLength(input[i][1]);
        }
    }

    private void validateNumberOfTests(int i) {
        int numberOfTests = i;
        if (numberOfTests < 1 || numberOfTests > 5000) {
            throw new IllegalNumberOfTests();
        }
    }

    private void validateJumpLength(int i) {
        int jumpLength = i;
        if (jumpLength < 0 || jumpLength > 100) {
            throw new IllegalJumpLength();
        }
    }

    private void validateArrayLength(int i) {
        int lengthOfCurrentArray = i;
        if (lengthOfCurrentArray < 2 || lengthOfCurrentArray > 100) {
            throw new IllegalArrayLength();
        }
    }

    public class IllegalNumberOfTests extends RuntimeException {
    }

    public class IllegalArrayLength extends RuntimeException {
    }

    public class IllegalJumpLength extends RuntimeException {
    }

}
