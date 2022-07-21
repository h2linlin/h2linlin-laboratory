package lc.codingcarl.tree;

/**
 * @Desc 235. 二叉搜索树的最近公共祖先
 * @Author h2linlin
 */
public class N0235 {
    /**
     * 解法1：DFS。递归法，前序遍历。
     * 因为二叉树是有序的，从上往下遍历，第一个唯一[p,q]区间的节点就是最近的公共祖先。
     */
    public TreeNode lowestCommonAncestor1(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val) {
            TreeNode temp = p;
            p = q;
            q = temp;
        }
        return preorder(root, p, q);
    }

    private TreeNode preorder(TreeNode root, TreeNode p, TreeNode q) {
        // 中
        if (root == null || (p.val <= root.val && root.val <= q.val)) {
            return root;
        }

        // 左
        TreeNode left = preorder(root.left, p, q);
        if (left != null) {
            return left;
        }

        // 右
        return preorder(root.right, p, q);
    }

    /**
     * 解法2：迭代法
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (p.val < root.val && q.val < root.val) {
                root = root.left;
                continue;
            }

            if (p.val > root.val && q.val > root.val) {
                root = root.right;
                continue;
            }

            return root;
        }

        return null;
    }
}
