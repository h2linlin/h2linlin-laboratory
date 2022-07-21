package lc.codingcarl.tree;

/**
 * @Desc 100. 相同的树
 * @Author h2linlin
 */
public class N0100 {
    /**
     * DFS，递归法
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compare(p, q);
    }

    private boolean compare(TreeNode a, TreeNode b) {
        if (a == null && b == null) {
            return true;
        }
        if (a != null && b == null) {
            return false;
        }
        if (a == null && b != null) {
            return false;
        }

        boolean left = compare(a.left, b.left);
        boolean right = compare(a.right, b.right);

        return left && right && (a.val == b.val);
    }
}
