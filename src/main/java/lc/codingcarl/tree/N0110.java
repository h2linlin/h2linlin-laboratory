package lc.codingcarl.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 110. 平衡二叉树
 * @Author h2linlin
 */
public class N0110 {

    /**
     * 本题要注意高度和深度的区别。以根节点举例，其深度是1，高度是N。两个是刚好反过来的。
     * 前面的题，求深度是由根节点往后数，所以是前序遍历。
     * 本题，求高度是由子节点向根节点数，所以是后序遍历。
     *
     * 由于是后序遍历，迭代法时，我们没法用层序遍历。只能由前往后，一个一个节点判断，效率比较低。
     *
     * 解法1：DFS，后序遍历。递归法。
     */
    public boolean isBalanced1(TreeNode root) {
        return postOrder(root) != -1;
    }

    private int postOrder(TreeNode node) {
        // 什么时候终止递归
        if (node == null) {
            return 0;
        }

        // 单层递归逻辑
        int leftH = postOrder(node.left);
        if (leftH == -1) {
            return -1;
        }

        int rightH = postOrder(node.right);
        if (rightH == -1) {
            return -1;
        }

        if (Math.abs(leftH - rightH) > 1) {
            return -1;
        }

        return Math.max(leftH, rightH) + 1;
    }

    /**
     * 解法2：DFS，迭代法。模拟递归。
     * 1.定义一个函数，后序遍历，专门求某节点高度（通过求最大深度模拟）
     * 2.用DFS，前序遍历，依次判断每一个节点是否符合要求。
     */
    public boolean isBalanced2(TreeNode root) {
        if (root == null) {
            return true;
        }

        Deque<TreeNode> st = new LinkedList<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode cur = st.pop();

            int leftH = hight(cur.left);
            int rightH = hight(cur.right);

            if (Math.abs(leftH - rightH) > 1) {
                return false;
            }

            if (cur.right != null) {
                st.push(cur.right);
            }

            if (cur.left != null) {
                st.push(cur.left);
            }
        }

        return true;
    }

    private int hight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int hight = 0;
        int result = 0;

        Deque<TreeNode> st = new LinkedList<>();

        // 标记法，后序遍历节点
        st.push(node);
        while (!st.isEmpty()) {
            TreeNode peek = st.peek();

            if (peek != null) {
                st.push(null);
                hight ++;

                if (peek.right != null) {
                    st.push(peek.right);
                }

                if (peek.left != null) {
                    st.push(peek.left);
                }
            } else {
                st.pop();
                st.pop();

                hight--;
            }
            result = Math.max(result, hight);
        }
        return result;
    }
}
