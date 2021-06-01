package lc.datastruct.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 538. 把二叉搜索树转换为累加树
 * @Author h2linlin
 */
public class N0538 {
    /**
     * 解法1：DFS，递归法，反中序遍历：右左中
     */
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        inorder(root);

        return root;
    }

    // 遍历整棵树，不需要返回值
    TreeNode pre = new TreeNode(0);
    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        // 右
        inorder(node.right);

        // 中
        node.val += pre.val;
        pre = node;

        // 左
        inorder(node.left);
    }

    /**
     * 解法2：迭代法。
     */
    public TreeNode convertBST2(TreeNode root) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode> st = new LinkedList<>();

        TreeNode next = root;
        int pre = 0;
        while (!st.isEmpty() || next != null) {
            if (next != null) {
                // 右
                st.push(next);
                next = next.right;
            } else {
                // 中
                next = st.pop();
                next.val += pre;
                pre = next.val;

                // 左
                next = next.left;
            }
        }

        return root;
    }
}
