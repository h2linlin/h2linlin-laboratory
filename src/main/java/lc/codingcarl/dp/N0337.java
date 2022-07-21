package lc.codingcarl.dp;

import lc.codingcarl.tree.TreeNode;

public class N0337 {
    public int rob(TreeNode root) {
        int[] dp = robSub(root);
        return Math.max(dp[0],  dp[1]);
    }

    private int[] robSub(TreeNode node) {
        int[] dp = new int[2];
        if (node == null) {
            return dp;
        }

        int[] dpLeft = robSub(node.left);
        int[] dpRight = robSub(node.right);

        // 抢孩子
        dp[0] = Math.max(dpLeft[0], dpLeft[1]) + Math.max(dpRight[0], dpRight[1]);
        // 抢自己
        dp[1] = dpLeft[0] + dpRight[0] + node.val;

        return dp;
    }
}
