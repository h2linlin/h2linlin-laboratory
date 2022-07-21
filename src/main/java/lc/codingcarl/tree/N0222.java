package lc.codingcarl.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 222. 完全二叉树的节点个数
 * @Author h2linlin
 */
public class N0222 {
    /**
     * DFS，递归法，后续遍历。
     */
    public int countNodes1(TreeNode root) {
        return postOrder(root);
    }

    public int postOrder(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int leftNum = postOrder(node.left);
        int rightNum = postOrder(node.right);

        return leftNum + rightNum + 1;
    }


    /**
     * BFS，迭代法，层序遍历。
     */
    public int countNodes2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> que = new LinkedList<>();
        que.offerLast(root);
        int sum = 0;

        while (!que.isEmpty()) {
            int levelSize = que.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.pollFirst();

                if (poll.left != null) {
                    que.offerLast(poll.left);
                }
                if (poll.right != null) {
                    que.offerLast(poll.right);
                }
            }
            sum += levelSize;
        }

        return sum;
    }

    /**
     * DFS，O(logn)的算法
     * 比较左子树和右子树高度，相等则左子树是满的。不相等则左子树不满。
     */
    public int countNodes3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftH = hight(root.left);
        int rightH = hight(root.right);

        if (leftH == rightH) {
            return countNodes3(root.right) + (1 << leftH) - 1 + 1;
        } else {
            return countNodes3(root.left) + (1 << rightH) - 1 + 1;
        }
    }

    // 完全二叉树高度
    private int hight(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int depth = 0;
        if (node.left != null) {
            depth = hight(node.left);
        }

        return depth + 1;
    }


}
