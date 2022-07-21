package lc.codingcarl.linkedlist;

/**
 * @Desc
 *  * Your MyLinkedList object will be instantiated and called as such:
 *  * MyLinkedList obj = new MyLinkedList();
 *  * int param_1 = obj.get(index);
 *  * obj.addAtHead(val);
 *  * obj.addAtTail(val);
 *  * obj.addAtIndex(index,val);
 *  * obj.deleteAtIndex(index);
 * @Author h2linlin
 * @Date 2021/4/19
 *
 * ["MyLinkedList","addAtHead","addAtHead","addAtHead",
 * "addAtIndex","deleteAtIndex","addAtHead","addAtTail",
 * "get","addAtHead","addAtIndex","addAtHead"]
 * [[],[7],[2],[1],[3,0],[2],[6],[4],[4],[4],[5,0],[6]]
 */
public class N0707 {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(7);
        list.addAtHead(2);
        list.addAtHead(1);
        list.addAtIndex(3,0);
        list.deleteAtIndex(2);
        list.addAtHead(6);
        list.addAtTail(4);
        list.get(4);
        list.addAtHead(4);
        list.addAtIndex(5,0);
        list.addAtHead(6);
    }

    public static class Node {
        int val;
        Node next;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class MyLinkedList {
        Node virtualHead;
        int size;

        /** Initialize your data structure here. */
        public MyLinkedList() {
            virtualHead = new Node();
            size = 0;
        }

        /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
        public int get(int index) {
            // 校验
            if (index < 0 || index >= size) {
                return -1;
            }

            // 取值
            // 找到第index个元素
            Node flag = virtualHead.next;
            for (int i = 0; i < index; i++) {
                flag = flag.next;
            }

            return flag.val;
        }

        /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
        public void addAtHead(int val) {
            Node head = new Node(val, virtualHead.next);

            virtualHead.next = head;
            size++;
        }

        /** Append a node of value val to the last element of the linked list. */
        public void addAtTail(int val) {
            Node tail = new Node(val);

            Node flag = virtualHead;
            for (int i = 0; i < size; i++) {
                flag = flag.next;
            }
            flag.next = tail;
            size++;
        }

        /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
        public void addAtIndex(int index, int val) {
            if (index > size || index < 0) {
                return;
            }

            if (index == size) {
                addAtTail(val);
                return;
            }

            Node insert = new Node(val);

            Node flag = virtualHead;
            for (int i = 0; i < index; i++) {
                flag = flag.next;
            }

            insert.next = flag.next;
            flag.next = insert;
            size++;
        }

        /** Delete the index-th node in the linked list, if the index is valid. */
        public void deleteAtIndex(int index) {
            if (index >= size || index < 0) {
                return;
            }

            Node flag = virtualHead;
            for (int i = 0; i < index; i++) {
                flag = flag.next;
            }

            flag.next = flag.next.next;
            size--;
        }
    }
}
