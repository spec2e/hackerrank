import org.junit.Test;
import test.BaseTest;

public class Test2 extends BaseTest {

    @Test
    public void nothing() {

        String res = LookAndSay("11", 2);
        assertEquals("1211", res);
    }

    @Test
    public void test2() {

        String res = LookAndSay("2", 2);
        assertEquals("1112", res);
    }

    @Test
    public void test3() {
        String res = LookAndSay("22", 2);
        assertEquals("22", res);
    }

    @Test
    public void test4() {
        String res = LookAndSay("221", 2);
        assertEquals("2211", res);
    }

    @Test
    public void test5() {
        String res = LookAndSay("11", 2);
        assertEquals("2211", res);
    }

    static String LookAndSay(String input, int n) {

        String result = "";

        for(int i = 0; i < n; i ++) {
            input = lookAndSay(input);
            result = input;
        }

        return result;
    }

    private static String lookAndSay(String start) {
        String result = "";

        String currentGroup = "";
        boolean prevWasOne = false;

        for (int i = 0; i < start.length(); i++) {
            String current = start.substring(i, i + 1);
            if (current.equals("1")) {
                if (prevWasOne) {
                    currentGroup += current;
                } else {
                    if (currentGroup.length() > 0) {
                        result += calculateResultOfTwos(currentGroup);
                    }
                    currentGroup = "";
                    currentGroup += current;
                    prevWasOne = true;
                }
            }
            if (current.equals("2")) {
                if (!prevWasOne) {
                    currentGroup += current;
                } else {
                    prevWasOne = false;
                    if (currentGroup.length() > 0) {
                        result += calculateResultOfOnes(currentGroup);
                    }
                    currentGroup = "";
                    currentGroup += current;
                }
            }
        }

        if(prevWasOne) {
            result += calculateResultOfOnes(currentGroup);
        } else {
            result += calculateResultOfTwos(currentGroup);
        }

        return result;
    }

    private static String calculateResultOfTwos(String currentGroupOfTwo) {
        int lengthOfOnes = currentGroupOfTwo.length();
        return lengthOfOnes + "2";
    }

    private static String calculateResultOfOnes(String currentGroupOfOne) {
        int lengthOfOnes = currentGroupOfOne.length();
        return lengthOfOnes + "1";
    }

}
