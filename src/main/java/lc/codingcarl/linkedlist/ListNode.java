package lc.codingcarl.linkedlist;

/**
 * @Desc
 * @Author wuzh
 * @Date 2021/4/17
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }

    ListNode(ListNode next) {
        this.next = next;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
