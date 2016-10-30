package test1;

import org.junit.Test;
import test.BaseTest;

public class SolutionTest extends BaseTest {


    @Test
    public void test1() {

        Solution.LinkedListNode list1 = new Solution.LinkedListNode("1");
        Solution.LinkedListNode list1_2 = new Solution.LinkedListNode("2");
        list1.next = list1_2;
        list1_2.next = new Solution.LinkedListNode("3");

        Solution.LinkedListNode list2 = new Solution.LinkedListNode("2");
        list2.next = new Solution.LinkedListNode("3");

        int index = Solution.find(list1, list2);

        assertEquals(1, index);

    }


    @Test
    public void test1_1() {

        Solution.LinkedListNode list1 = new Solution.LinkedListNode("1");
        Solution.LinkedListNode list1_2 = new Solution.LinkedListNode("2");
        list1.next = list1_2;
        list1_2.next = new Solution.LinkedListNode("3");

        Solution.LinkedListNode list2 = new Solution.LinkedListNode("1");
        Solution.LinkedListNode list2_2 = new Solution.LinkedListNode("2");
        list2.next = list2_2;

        int index = Solution.find(list1, list2);

        assertEquals(0, index);

    }

    @Test
    public void test1_2() {

        Solution.LinkedListNode list1 = new Solution.LinkedListNode("1");
        Solution.LinkedListNode list1_2 = new Solution.LinkedListNode("2");
        list1.next = list1_2;
        list1_2.next = new Solution.LinkedListNode("3");

        Solution.LinkedListNode list2 = new Solution.LinkedListNode("1");
        Solution.LinkedListNode list2_2 = new Solution.LinkedListNode("2");
        list2.next = list2_2;
        Solution.LinkedListNode list2_3 = new Solution.LinkedListNode("3");
        list2_2.next = list2_3;
        Solution.LinkedListNode list2_4 = new Solution.LinkedListNode("4");
        list2_3.next = list2_4;

        int index = Solution.find(list1, list2);

        assertEquals(-1, index);

    }

    @Test
    public void test2_negative() {

        Solution.LinkedListNode list1 = new Solution.LinkedListNode("1");
        list1.next = new Solution.LinkedListNode("2")
                .next = new Solution.LinkedListNode("3");

        Solution.LinkedListNode list2 = new Solution.LinkedListNode("3");
        list2.next = new Solution.LinkedListNode("2");

        int index = Solution.find(list1, list2);

        assertEquals(-1, index);

    }
}
