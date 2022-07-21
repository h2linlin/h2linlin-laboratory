package lc.codingcarl.linkedlist;

/**
 * @Desc
 * @Author wuzh
 * @Date 2021/4/19
 */
public class N0206 {
    public static void main(String[] args) {
        // 输入
        ListNode headNode = ShowLinkedList.createLinkedList(new int[]{1,1,2,2,1,6});
        ShowLinkedList.show(headNode);

        // 计算
        int val = 2;
        ListNode result = solution3(headNode);

        // 输出
        System.out.println();
        ShowLinkedList.show(result);
    }

    // 解法1：暴力法。
    // 新建一个链表，每次找到尾节点后返回，尾节点置为空。
    // 或者用栈、数组临时存储都可以
    // 时间和空间性能都太差。略。
    public static ListNode solution1(ListNode head) {
        return null;
    }

    // 解法2：双指针，依次翻转，迭代
    public static ListNode solution2(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode after = cur.next;
            cur.next = pre;
            pre = cur;
            cur = after;
        }

        return pre;
    }

    // 解法3：双指针，依次翻转，递归
    public static ListNode solution3(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;

        return reverse(pre, node);
    }

    public static ListNode reverse(ListNode pre, ListNode cur) {
        if (cur == null) {
            return pre;
        }

        ListNode temp = cur.next;
        cur.next = pre;

        return reverse(cur, temp);
    }
}
