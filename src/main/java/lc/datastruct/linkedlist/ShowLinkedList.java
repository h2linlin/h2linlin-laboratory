package lc.datastruct.linkedlist;

/**
 * @Desc
 * @Author wuzh
 * @Date 2021/4/17
 */
public class ShowLinkedList {
    public static ListNode createLinkedList(int[] array) {
        ListNode headNode = new ListNode(array[0]);

        ListNode tailNode = headNode;
        for (int i = 1; i < array.length; i++) {
            tailNode.next = new ListNode(array[i]);
            tailNode = tailNode.next;
        }

        return headNode;
    }

    public static void show(ListNode headNode) {
        System.out.print(headNode.val + ", ");
        if (headNode.next != null) {
            show(headNode.next);
        }
    }
}
