package lc.datastruct.tree;

/**
 * @Desc 669. 修剪二叉搜索树
 * @Author h2linlin
 */
public class N0669 {
    /**
     * 解法1：DFS，递归法。
     * 陷阱：左孩子小于左区间时，不能把整颗左子树砍掉，左子树的右子树可能是符合区间要求的。右孩子同理。
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }

        // 剪枝
        if (root.val < low) {
            return trimBST(root.left, low, high);
        }
        if (high < root.val) {
            return trimBST(root.right, low, high);
        }

        // 遍历后续节点
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }

    /**
     * 解法2：迭代法
     */
    public TreeNode trimBST2(TreeNode root, int low, int high) {
        if (root == null) {
            return root;
        }

        // 将root移到[L,R]内
        while (root != null && (root.val < low || high < root.val)) {
            if (root.val < low) {
                root = root.right;
            } else {
                root = root.left;
            }
        }

        // 剪枝左子树
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null && cur.left.val < low) {
                cur.left = cur.left.right;
                continue;
            }
            cur = cur.left;
        }

        // 剪枝右子树
        cur = root;
        while (cur != null) {
            if (cur.right != null && high < cur.right.val) {
                cur.right = cur.right.left;
                continue;
            }
            cur = cur.right;
        }

        return root;
    }
}
