package lc.codingcarl.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 104. 二叉树的最大深度
 * @Author h2linlin
 */
public class N0104 {
    /**
     * 解法1：DFS，后序遍历。递归法。前中序遍历都可以，但是后续遍历可以直接将返回值作为高度。
     */
    public int maxDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        return postOrder1(root, 1);
    }

    private int postOrder1(TreeNode node, int level) {
        int left = level;
        int right = level;

        if (node.left != null) {
            left = postOrder1(node.left, left + 1);
        }

        if (node.right != null) {
            right = postOrder1(node.right, right + 1);
        }


        return Math.max(left, right);
    }

    /**
     * 解法2：DFS，后序遍历。递归法。更优雅一点，标准的后序遍历，减少1个入参。
     */
    public int maxDepth2(TreeNode root) {
        return postOrder2(root);
    }

    private int postOrder2(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftDeepth = postOrder2(node.left);      // 左
        int rightDeepth = postOrder2(node.right);    // 右

        return Math.max(leftDeepth, rightDeepth) + 1;// 中
    }

    /**
     * 解法3：BFS。迭代法。
     */
    public int maxDepth3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depth = 0;
        Deque<TreeNode> que = new LinkedList<>();

        que.push(root);
        while (!que.isEmpty()) {
            int levelSize = que.size();
            depth ++;

            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.pollFirst();

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
