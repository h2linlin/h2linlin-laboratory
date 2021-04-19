package lc.datastruct.linkedlist;

/**
 * @Desc
 * @Author h2linlin
 * @Date 2021/4/17
 */
public class N0203 {
    public static void main(String[] args) {
        // 输入
        ListNode headNode = ShowLinkedList.createLinkedList(new int[]{1,1,2,2,1,6});
        ShowLinkedList.show(headNode);

        // 计算
        int val = 2;
        ListNode result = solution4(headNode, val);

        // 输出
        System.out.println();
        ShowLinkedList.show(result);

    }

    // 解法1
    // 直接删除，递归写法
    public static ListNode solution1(ListNode head, int val) {
        // 删除头结点
        head = removeHead(head, val);
        // 删除普通节点
        remove(head, val);

        return head;
    }

    // 解法2
    // 虚拟头结点，递归写法
    public static ListNode solution2(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode virtualHeadNode = new ListNode(Integer.MAX_VALUE, head);

        remove(virtualHeadNode, val);
        return virtualHeadNode.next;
    }

    // 解法3
    // 更优雅的递归写法
    public static ListNode solution3(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        head.next = solution3(head.next, val);

        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }

    // 解法4
    // 暴力法，非递归
    public static ListNode solution4(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode virtualHead = new ListNode(val, head);

        ListNode flag = virtualHead;
        while (flag.next != null) {
            if (flag.next.val == val) {
                flag.next = flag.next.next;
            } else {
                flag = flag.next;
            }
        }

        return virtualHead.next;
    }

    public static ListNode remove(ListNode node, int val) {
        if (node == null || node.next == null) {
            return node;
        }
        if (node.next.val == val) {
            node.next = node.next.next;
            return remove(node, val);
        }
        return remove(node.next, val);
    }

    public static ListNode removeHead(ListNode node, int val) {
        if (node == null) {
            return node;
        }
        if (node.val == val) {
            node = node.next;
            return removeHead(node, val);
        }
        return node;
    }

}
