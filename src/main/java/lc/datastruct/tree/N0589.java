package lc.datastruct.tree;

import lc.datastruct.linkedlist.ListNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Desc 589. N 叉树的前序遍历
 * @Author h2linlin
 */
public class N0589 {
    /**
     * 解法1：递归法
     */
    public List<Integer> preorder1(Node root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        order(list, root);
        return list;
    }

    private void order(List<Integer> list, Node node) {
        list.add(node.val);

        List<Node> children = node.children;
        if (children == null || children.size() == 0) {
            return;
        }

        for (Node child : children) {
            order(list, child);
        }
    }

    /**
     * 解法2：迭代法。标记法。
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> list = new ArrayList<>();
        Deque<Node> st = new LinkedList<>();

        if (root == null) {
            return list;
        }

        st.push(root);
        while (!st.isEmpty()) {
            Node peek = st.peek();

            if (peek == null) {
                st.pop();
                list.add(st.pop().val);
            } else {
                Node pop = st.pop();

                List<Node> children = pop.children;
                if (children != null && children.size() > 0) {
                    for (int i = children.size() - 1; i >= 0; i--) {
                        st.push(children.get(i));
                    }
                }

                st.push(pop);
                st.push(null);
            }
        }

        return list;
    }

    /**
     * 解法3：迭代法。指针。
     */
    public List<Integer> preorder3(Node root) {
        List<Integer> list = new ArrayList<>();
        Deque<Node> st = new LinkedList<>();

        if (root == null) {
            return list;
        }

        st.push(root);
        while (!st.isEmpty()) {
            Node pop = st.pop();
            list.add(pop.val);

            List<Node> children = pop.children;
            if (children != null && children.size() > 0) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    st.push(children.get(i));
                }
            }
        }

        return list;
    }


    class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }
}
