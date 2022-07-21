package lc.codingcarl.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 404. 左叶子之和
 * @Author h2linlin
 */
public class N0404 {
    /**
     * 解法1：DFS。递归法，后序遍历。因为需要统计左右子树的左叶子节点信息，做为返回值返回。
     * 平时我们解二叉树的题目时，已经习惯了通过节点的左右孩子判断本节点的属性，而本题我们要通过节点的父节点判断本节点的属性。
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return postOrder(root);
    }

    private int postOrder(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftSum = postOrder(node.left);
        int rightSum = postOrder(node.right);

        int midValue = 0;
        TreeNode leftNode = node.left;
        if (leftNode != null && leftNode.left == null && leftNode.right == null) {
            midValue = leftNode.val;
        }

        return midValue + leftSum + rightSum;
    }

    /**
     * 解法2：DFS。迭代法，后序遍历。
     */
    public int sumOfLeftLeaves2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Deque<TreeNode> st = new LinkedList<>();
        st.push(root);
        TreeNode cur = root;
        while (!st.isEmpty()) {
            TreeNode peek = st.peek();

            if (peek.left != null && peek.left != cur && peek.right != cur) {
                st.push(peek.left);
                continue;
            }
            if (peek.right != null && peek.right != cur) {
                st.push(peek.right);
                continue;
            }

            TreeNode pop = st.pop();
            cur = pop;
            if (pop.left != null && pop.left.left == null && pop.left.right == null) {
                sum += pop.left.val;
            }
        }

        return sum;
    }

    /**
     * 解法2：DFS。迭代法，前序遍历。
     */
    public int sumOfLeftLeaves3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int sum = 0;
        Deque<TreeNode> st = new LinkedList<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode pop = st.pop();

            if (pop.left != null && pop.left.left == null && pop.left.right == null) {
                sum += pop.left.val;
            }

            if (pop.right != null) {
                st.push(pop.right);
            }

            if (pop.left != null) {
                st.push(pop.left);
            }
        }

        return sum;
    }


}
