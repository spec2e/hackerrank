package loopii;


import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int numberOfQueries = in.nextInt();
        validateNumberOfQueries(numberOfQueries);

        int[][] queries = new int[numberOfQueries][];

        for (int i = 0; i < numberOfQueries; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            queries[i] = new int[]{a, b, n};
        }

        in.close();

        printQueries(queries);

    }

    private static void printQueries(int[][] queries) {

        Solution solution = new Solution();

        for(int j = 0; j < queries.length; j ++) {
            int[] query = solution.calculateQuery(queries[j]);
            solution.printArray(query);
        }
    }

    private void printArray(int[] ints) {

        for (int i = 0; i < ints.length; i++) {
            if (i < ints.length) {
                System.out.print(ints[i] + " ");
            } else {
                System.out.print(ints[i]);
            }
        }
        System.out.println();
    }


    private static void validateNumberOfQueries(int numberOfQueries) {
        if (numberOfQueries < 0 || numberOfQueries > 500) {
            throw new IllegalNumberOfQueries();
        }
    }

    int[] calculateQuery(int[] ints) {

        validateFactors(ints);

        int a = ints[0], b = ints[1], n = ints[2];
        int[] ret = new int[n];

        int prevSum = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0) {
                prevSum = ret[i - 1];
            } else {
                prevSum = a;
            }
            ret[i] = prevSum + (b * calcPowered(i));
        }

        return ret;
    }

    private void validateFactors(int[] ints) {
        int a = ints[0];
        if(a < 0 || a > 50) {
            throw new IllegalValue();
        }

        int b = ints[1];
        if(b < 0 || b > 50) {
            throw new IllegalValue();
        }

        int n = ints[2];
        if(n < 1 || n > 15) {
            throw new IllegalValue();
        }

    }

    private int calcPowered(int i) {
        double pow = Math.pow(2, i);
        return (int) pow;
    }



    public static class IllegalNumberOfQueries extends RuntimeException {
    }

    public static class IllegalValue extends RuntimeException {
    }
}
