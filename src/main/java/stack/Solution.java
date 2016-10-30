package stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution solution = new Solution();
        List<Boolean> results = solution.execute(sc);
        for (Boolean result : results) {
            System.out.println(result.booleanValue());
        }
    }

    public List<Boolean> execute(Scanner sc) {

        List<Boolean> results = new ArrayList<Boolean>();

        while (sc.hasNext()) {
            String input = sc.next();
            if (input.equals("EXIT")) {
                break;
            }
            results.add(
                    isBalanced(input)
            );
        }

        return results;
    }

    private boolean isBalanced(String input) {

        if (input.length() % 2 != 0) {
            return false;
        }

        Stack<String> parenthesis = new Stack<String>();

        for (int i = 0; i < input.length(); i++) {
            String paren = input.substring(i, i + 1);
            if (isOpeningParan(paren)) {
                parenthesis.push(paren);
            } else if (isClosingParen(paren)) {
                if(parenthesis.empty()) {
                    return false;
                }
                String openingParen = parenthesis.pop();
                if (!parenMatches(openingParen, paren)) {
                    return false;
                }
            }
        }

        if (!parenthesis.empty()) {
            return false;
        }

        return true;
    }

    private boolean parenMatches(String openingParen, String closingParen) {
        if (openingParen.equals("(")) {
            return ")".equals(closingParen);
        } else if (openingParen.equals("{")) {
            return "}".equals(closingParen);
        } else if (openingParen.equals("[")) {
            return "]".equals(closingParen);
        }
        return false;
    }

    private boolean isClosingParen(String paren) {
        if (paren.equals(")") ||
                paren.equals("}") ||
                paren.equals("]")) {
            return true;
        }
        return false;
    }

    private boolean isOpeningParan(String paren) {
        if (paren.equals("(") ||
                paren.equals("{") ||
                paren.equals("[")) {
            return true;
        }
        return false;
    }
}
