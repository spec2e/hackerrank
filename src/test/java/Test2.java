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
        assertEquals("2221", res);
    }

    static String LookAndSay(String input, int n) {

        String result = "";

        for (int i = 0; i < n; i++) {
            input = lookAndSay(input);
            result = input;
        }

        return result;
    }

    private static String lookAndSay(String start) {
        String result = "";
        String currentGroup = "";
        String current = null;

        for (int i = 0; i < start.length(); i++) {
            String digit = start.substring(i, i + 1);
            if (current != null && !current.equals(digit)) {
                result += flush(currentGroup);
                currentGroup = "";
            }
            currentGroup += digit;
            current = digit;
        }

        if(currentGroup.length() > 0) {
            result += flush(currentGroup);
        }

        return result;
    }

    private static String flush(String currentGroup) {
        int lengthOfOnes = currentGroup.length();
        String firstDigit = currentGroup.substring(0, 1);
        return lengthOfOnes + firstDigit;
    }

}
