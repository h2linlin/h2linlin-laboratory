package lc.datastruct.linkedlist;

/**
 * @Desc
 * @Author wuzh
 * @Date 2021/4/19
 */
public class N0142 {
    public static void main(String[] args) {
        // 输入
        ListNode headNode = ShowLinkedList.createLinkedList(new int[]{1,1,2,2,1,6});
        ShowLinkedList.show(headNode);

        // 计算
        int val = 2;
        ListNode result = solution1(headNode);

        // 输出
        System.out.println();
        ShowLinkedList.show(result);
    }

    // 解法1：双指针法
    // 1.找出相遇点
    // 2.由相遇点和出发点同时发出两个指针，相遇点必为入口点
    public static ListNode solution1(ListNode head) {
        // 1.寻找相遇点
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast != slow) {
                continue;
            }
            ListNode meet = fast;

            // 2.寻找入口点
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return fast;
        }

        return null;
    }
}
