package stack;

import org.junit.Before;
import org.junit.Test;
import test.BaseTest;

import java.util.List;

public class SolutionTest extends BaseTest {

    public static final String FIXED_PATH = "/stack/";
    private Solution cut;

    @Before
    public void setUp() throws Exception {
        cut = new Solution();
    }

    @Test
    public void test_1() {
        List<Boolean> results = cut.execute(getScannerFor(FIXED_PATH + "test_1.txt"));
        assertEquals(7, results.size());
        assertEquals(true, results.get(0));
        assertEquals(true, results.get(1));
        assertEquals(false, results.get(2));
        assertEquals(true, results.get(3));
        assertEquals(false, results.get(4));
        assertEquals(true, results.get(5));
        assertEquals(false, results.get(6));
    }

    @Test
    public void test_2() {
        List<Boolean> results = cut.execute(getScannerFor(FIXED_PATH + "test_2.txt"));
        assertEquals(10, results.size());
        assertEquals(true, results.get(0));
        assertEquals(false, results.get(1));
        assertEquals(true, results.get(2));
        assertEquals(false, results.get(3));
        assertEquals(false, results.get(4));
        assertEquals(false, results.get(5));
        assertEquals(false, results.get(6));
        assertEquals(false, results.get(7));
        assertEquals(true, results.get(8));
        assertEquals(true, results.get(9));
    }
}
