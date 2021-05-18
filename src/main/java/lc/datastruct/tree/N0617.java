package lc.datastruct.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 617. 合并二叉树
 * @Author h2linlin
 */
public class N0617 {
    /**
     * 解法1：递归法，前序遍历。
     *
     * 中序遍历、后序遍历，仅仅改变语句顺序即可。
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        if (root1 == null) {
            return root2;
        }

        if (root2 == null) {
            return root1;
        }

        root1.val = root1.val + root2.val;
        root1.left = mergeTrees(root1.left, root2.left);
        root1.right = mergeTrees(root1.right, root2.right);

        return root1;
    }

    /**
     * 解法2：迭代法，层序遍历。
     */
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }

        Deque<TreeNode> que = new LinkedList<>();

        que.offerLast(root1);
        que.offerLast(root2);
        while (!que.isEmpty()) {
            TreeNode poll1 = que.pollFirst();
            TreeNode poll2 = que.pollFirst();
            poll1.val = poll1.val + poll2.val;

            if (poll1.left != null && poll2.left != null) {
                que.offerLast(poll1.left);
                que.offerLast(poll2.left);
            }

            if (poll1.left == null && poll2.left != null) {
                poll1.left = poll2.left;
            }


            if (poll1.right != null && poll2.right != null) {
                que.offerLast(poll1.right);
                que.offerLast(poll2.right);
            }

            if (poll1.right == null && poll2.right != null) {
                poll1.right = poll2.right;
            }
        }

        return root1;
    }
}
