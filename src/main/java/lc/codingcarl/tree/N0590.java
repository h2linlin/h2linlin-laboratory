package lc.codingcarl.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Desc 590. N 叉树的后序遍历
 * @Author h2linlin
 */
public class N0590 {
    /**
     * 解法1：递归
     * 解法2：迭代，标准，后序遍历
     * 解法3：迭代，标准，前序遍历，然后在reverse。
     * 解法4：迭代，标记法，后序遍历
     *
     * 这里采用解法2，因为它实现起来最麻烦囧，其他解法略。
     */
    public List<Integer> preorder3(Node root) {
        List<Integer> list = new ArrayList<>();
        Deque<Node> st = new LinkedList<>();

        if (root == null) {
            return list;
        }

        st.push(root);
        Node cur = null;
        while (!st.isEmpty()) {
            Node peek = st.peek();

            List<Node> children = peek.children;
            if (children != null && children.size() != 0 && !isChild(peek, cur)) {
                for (int i = children.size() - 1; i >= 0; i--) {
                    st.push(children.get(i));
                }
                continue;
            }

            cur = st.pop();
            list.add(cur.val);
        }
        return list;
    }

    private boolean isChild (Node parent, Node child) {
        List<Node> children = parent.children;
        if (children == null || children.size() == 0 || child == null) {
            return false;
        }
        for (Node node : children) {
            if (node == child) {
                return true;
            }
        }
        return false;
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
