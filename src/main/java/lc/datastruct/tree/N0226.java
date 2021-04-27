package lc.datastruct.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Desc 226. 翻转二叉树
 * @Author h2linlin
 */
public class N0226 {

    /**
     * 前序遍历、后序遍历、层序遍历都可以。
     * 中序遍历不行，因为节点可能被翻转两次。
     *
     * 解法1：后序遍历。递归。
     */
    public TreeNode solution1(TreeNode root) {
        if (root == null) {
            return root;
        }

        operaNode(root);

        return root;
    }

    private void operaNode(TreeNode node) {
        if (node.left == null && node.right == null) {
            return;
        }

        if (node.left != null) {
            operaNode(node.left);
        }
        if (node.right != null) {
            operaNode(node.right);
        }
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    /**
     * 解法2：前序遍历。迭代标记法。
     */
    public TreeNode solution2(TreeNode root) {
        if (root == null) {
            return root;
        }

        Deque<TreeNode> st = new LinkedList<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode peek = st.peek();
            if (peek == null) {
                st.pop();
                peek = st.pop();

                TreeNode tempNode = peek.right;
                peek.right = peek.left;
                peek.left = tempNode;
            } else {
                st.pop();

                if (peek.right != null) {
                    st.push(peek.right);
                }

                if (peek.left != null) {
                    st.push(peek.left);
                }

                st.push(peek);
                st.push(null);
            }
        }

        return root;
    }

    /**
     * 解法4：层序遍历。迭代。
     * 层序遍历是用队列，而不是栈。所以不用递归。用迭代，自己维护数据结构。
     */
    public TreeNode solution3(TreeNode root) {
        if (root == null) {
            return root;
        }

        Deque<TreeNode> que = new LinkedList<>();
        que.offerLast(root);
        while (!que.isEmpty()) {
            TreeNode poll = que.pollFirst();

            TreeNode temp = poll.left;
            poll.left = poll.right;
            poll.right = temp;

            if (poll.left != null) {
                que.offerLast(poll.left);
            }

            if (poll.right != null) {
                que.offerLast(poll.right);
            }
        }

        return root;
    }
}
