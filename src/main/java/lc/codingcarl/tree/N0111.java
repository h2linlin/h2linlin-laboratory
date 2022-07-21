package lc.codingcarl.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 111. 二叉树的最小深度
 * @Author h2linlin
 */
public class N0111 {
    /**
     * 解法1：DFS，递归法。后序遍历，因为需要处理递归的返回值。
     *
     * 这题的坑是：只有左、右孩子都为Null，才算是到底。假设左孩子为null，右孩子不为null，那么还要继续往下遍历，不能直接返回左孩子深度。
     * 后面的BFS解法，坑也是一样的。
     */
    public int minDepth1(TreeNode root) {
        return postOrder(root);
    }

    private int postOrder(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDepth = postOrder(node.left);
        int rightDepth = postOrder(node.right);

        if (node.left == null && node.right != null) {
            return rightDepth + 1;
        }

        if (node.left != null && node.right == null) {
            return leftDepth + 1;
        }

        return Math.min(leftDepth, rightDepth) + 1;
    }

    /**
     * 解法2：BFS，层序遍历，迭代法。
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Deque<TreeNode> que = new LinkedList<>();
        que.offerLast(root);

        while (!que.isEmpty()) {
            int levelSize = que.size();
            depth ++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.pollFirst();

                if (poll.left == null && poll.right == null) {
                    return depth;
                }

                if (poll.left != null) {
                    que.offerLast(poll.left);
                }
                if (poll.right != null) {
                    que.offerLast(poll.right);
                }
            }
        }

        return depth;
    }
}
