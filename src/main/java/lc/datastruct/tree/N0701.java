package lc.datastruct.tree;

/**
 * @Desc 701. 二叉搜索树中的插入操作
 * @Author h2linlin
 */
public class N0701 {
    /**
     * 解法1：递归法。
     * 根本不用重构二叉搜索树。直接按二叉树规律搜索，遇到空节点的时候插进去就行了。
     * 新值和原来树中任何节点都不同。
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        preorder(root, val);
        return root;
    }

    private void preorder(TreeNode node, int val) {
        if (val < node.val) {
            if (node.left == null) {
                node.left = new TreeNode(val);
                return;
            }
            preorder(node.left, val);
        } else {
            if (node.right == null) {
                node.right = new TreeNode(val);
                return;
            }
            preorder(node.right, val);
        }
    }

    /**
     * 解法2：迭代法。
     */
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode next = root;
        while (true) {
            if (val < next.val) {
                if (next.left == null) {
                    next.left = new TreeNode(val);
                    return root;
                }
                next = next.left;
            } else {
                if (next.right == null) {
                    next.right = new TreeNode(val);
                    return root;
                }
                next = next.right;
            }
        }
    }
}
