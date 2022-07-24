package lc.codingcarl.linkedlist;

public class N0206A {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) { return head; }

        /**
         * 双指针
         */
        ListNode i = null;
        ListNode j = head;
        ListNode temp = null;

        while (j != null) {
            temp = j.next;
            j.next = i;
            i = j;
            j = temp;
        }

        return i;
    }

    // 递归法
    private ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) { return pre;}

        ListNode temp = cur.next;
        cur.next = pre;
        pre = cur;

        return reverse(cur, temp);
    }
}
