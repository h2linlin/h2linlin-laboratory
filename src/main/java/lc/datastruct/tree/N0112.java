package lc.datastruct.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 112. 路径总和
 * @Author h2linlin
 */
public class N0112 {

    /**
     * 解法1：DFS，递归法。前中后序遍历都可以，因为本节点不处理逻辑。
     * 总和不用累加。已开始就设置为目标值，然后看减完是否等于0，这样代码就简单一点。
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        return preOrder(root, targetSum);
    }

    private boolean preOrder(TreeNode node, int targetSum) {
        if (node.left == null && node.right == null) {
            if (targetSum - node.val == 0) {
                return true;
            }
        }

        if (node.left != null) {
            boolean left = preOrder(node.left, targetSum - node.val);
            if (left) return left;
        }

        if (node.right != null) {
            boolean right = preOrder(node.right, targetSum - node.val);
            if (right) return right;
        }

        return false;
    }

    /**
     * 解法2：DFS，迭代法。前序遍历
     */
    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        Deque<TreeNode> st = new LinkedList<>();
        st.push(root);
        while (!st.isEmpty()) {
            TreeNode pop = st.pop();
            targetSum -= pop.val;

            if (pop.left == null && pop.right == null) {
                if (targetSum == 0) {
                    return true;
                }
            }

            if (pop.right != null) {
                st.push(pop.right);
            }

            if (pop.left != null) {
                st.push(pop.left);
            }
        }

        return false;
    }
}
