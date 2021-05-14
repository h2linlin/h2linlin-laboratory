package lc.datastruct.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 113. 路径总和 II
 * @Author h2linlin
 */
public class N0113 {
    private List<List<Integer>> result;
    private List<Integer> curPath;

    /**
     * 解法：DFS，递归法。
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        result = new ArrayList<>();
        curPath = new ArrayList<>();

        if (root == null) {
            return result;
        }

        preOrder(root, targetSum);

        return result;
    }

    private void preOrder(TreeNode node, int curSum) {
        if (node == null) {
            return;
        }

        // 前序遍历
        curPath.add(node.val);
        curSum -= node.val;

        if (node.left == null && node.right == null) {
            if (curSum == 0) {
                result.add(new ArrayList<>(curPath));
            }
            curPath.remove(curPath.size() - 1);
            return;
        }

        if (node.left != null) {
            preOrder(node.left, curSum);
        }

        if (node.right != null) {
            preOrder(node.right, curSum);
        }

        curPath.remove(curPath.size() - 1);
    }

}
