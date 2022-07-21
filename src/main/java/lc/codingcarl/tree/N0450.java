package lc.codingcarl.tree;

/**
 * @Desc 450. 删除二叉搜索树中的节点
 * @Author h2linlin
 */
public class N0450 {

    /**
     * DFS。递归法。
     * 删除时：
     * 若没有找到节点，不删除。
     * 若左右孩子都为空，直接删除
     * 若左孩子为空，右孩子不为空，右孩子提为父亲
     * 若右孩子为空，做孩子不为空，左孩子提为父亲
     * 若该节点左右孩子都不为空，则把右孩子提为父亲，左孩子放到右孩子的最左则叶子节点下面。
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        return order(root, key);
    }

    private TreeNode order (TreeNode node, int key) {
        if (node == null) {
            return node;
        }

        // 相等
        if (node.val == key) {
            if (node.left == null && node.right == null) {
                return null;
            }
            if (node.left != null && node.right == null) {
                return node.left;
            }
            if (node.left == null && node.right != null) {
                return node.right;
            }
            // 右孩子的最左节点
            TreeNode rLeft = node.right;
            while (rLeft.left != null) {
                rLeft = rLeft.left;
            }
            rLeft.left = node.left;
            return node.right;
        }

        // 不相等
        if (key < node.val) {
            node.left = order(node.left, key);
        } else if (node.val < key) {
            node.right = order(node.right, key);
        }

        return node;
    }

    /**
     * 迭代法
     */
    public TreeNode deleteNode2(TreeNode root, int key) {
        if (root == null) {
            return root;
        }

        TreeNode next = root;
        TreeNode parent = null;
        while (next != null) {
            // 相等
            if (next.val == key) {
                // 获取新值
                TreeNode newNode = null;
                if (next.left == null && next.right == null) {
                    newNode = null;
                } else if (next.left != null && next.right == null) {
                    newNode = next.left;
                } else if (next.left == null && next.right != null) {
                    newNode = next.right;
                } else {
                    // 合并左右子树
                    newNode = next.right;

                    TreeNode rLeft = next.right;
                    while (rLeft.left != null) {
                        rLeft = rLeft.left;
                    }
                    rLeft.left = next.left;
                }

                // 赋值返回
                // 根节点
                if (parent == null) {
                    return newNode;
                }
                // 普通节点
                if (parent.left == next) {
                    parent.left = newNode;
                } else {
                    parent.right = newNode;
                }
                return root;
            }

            parent = next;
            // 不相等
            if (key < next.val) {
                next = next.left;
            } else {
                next = next.right;
            }
        }

        return root;
    }

}
