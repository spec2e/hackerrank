package test1;

public class Solution {


    public static int find(LinkedListNode list1, LinkedListNode list2) {
        String list2Start = list2.val;

        int index = 0;
        while(list1.next != null) {
            String val = list1.val;
            if(val.equals(list2Start)) {
                if(isMatching(list1, list2)) {
                    return index;
                }
            }
            index ++;
            list1 = list1.next;
        }
        return -1;
    }

    private static boolean isMatching(LinkedListNode list1, LinkedListNode list2) {
        while(list2 != null) {
            if(list1.val.equals(list2.val)) {
                list1 = list1.next;
                list2 = list2.next;
            } else {
                return false;
            }

            if(list1 == null && list2 != null) {
                return false;
            }
        }

        return true;
    }

    public static class LinkedListNode{
        String val;
        LinkedListNode next;

        LinkedListNode(String node_value) {
            val = node_value;
            next = null;
        }
    };
}
