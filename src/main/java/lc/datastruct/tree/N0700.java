package lc.datastruct.tree;

/**
 * @Desc 700. 二叉搜索树中的搜索
 * @Author h2linlin
 */
public class N0700 {
    /**
     * 解法1：递归法
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        if (val < root.val) {
            return searchBST(root.left, val);
        } else {
            return searchBST(root.right, val);
        }
    }

    /**
     * 解法2：迭代法
     * 二叉搜索树，节点是有序的。不需要用栈模拟递归。
     */
    public TreeNode searchBST2(TreeNode root, int val) {
        if (root == null || root.val == val) {
            return root;
        }

        while (root != null) {
            if (root.val == val) {
                return root;
            }
            if (val < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }

        return null;
    }
}
