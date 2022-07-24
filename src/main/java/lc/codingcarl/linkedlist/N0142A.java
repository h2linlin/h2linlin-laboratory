package lc.codingcarl.linkedlist;

public class N0142A {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) { return null; }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                ListNode count = head;

                while (count != fast) {
                    count = count.next;
                    fast = fast.next;
                }
                return count;
            }
        }

        return null;
    }
}
