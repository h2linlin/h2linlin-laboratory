package lc.codingcarl.tree;

/**
 * @Desc 236. 二叉树的最近公共祖先
 * @Author h2linlin
 */
public class N0236 {

    /**
     * 解法：BFS，递归法。后序遍历。
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }

        // 左
        TreeNode left = lowestCommonAncestor(root.left, p, q);

        // 右
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 中。
        // p和q都在树中
        // 所有节点都不相等，且p != q，所以不用考虑pq是在左子树还是右子树的问题
        if (left == null && right != null) {
            return right;
        }
        if (left != null && right == null) {
            return left;
        }
        if (left == null && right == null) {
            return null;
        }

        return root;
    }
}
