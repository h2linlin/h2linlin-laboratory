package lc.datastruct.tree;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 513. 找树左下角的值
 * @Author h2linlin
 */
public class N0513 {

    /**
     * 解法1：BFS。不断更新入队的第一个元素即可。
     */
    public int findBottomLeftValue1(TreeNode root) {
        // 根节点肯定不为null，无需判断。

        Deque<TreeNode> que = new LinkedList<>();
        que.offerLast(root);
        int deepestLeft = root.val;

        while (!que.isEmpty()) {
            int levelSize = que.size();
            deepestLeft = que.peekFirst().val;

            for (int i = 0; i < levelSize; i ++) {
                TreeNode poll = que.pollFirst();

                if (poll.left != null) {
                    que.offerLast(poll.left);
                }
                if (poll.right != null) {
                    que.offerLast(poll.right);
                }
            }
        }

        return deepestLeft;
    }

    /**
     * 解法2：DFS。递归法，需要记录最大深度。需要回溯，更新当前深度。
     * 注意：最深一层，最左边的节点。不一定是最左叶子节点。
     *
     */
    int maxLeftDepth = -1;
    int maxLeftDepthVal = Integer.MIN_VALUE;
    public int findBottomLeftValue2(TreeNode root) {
        maxLeftDepth = 1;
        maxLeftDepthVal = root.val;

        preOrder(root, 1);
        return maxLeftDepthVal;
    }

    private void preOrder(TreeNode node, int curDepth) {
        // 前序遍历
        // 处理本节点，本节点是叶子节点，且深度最大，则更新左节点值
        if (node.left == null && node.right == null) {
            if (curDepth > maxLeftDepth) {  // 不是等于。保证只取到第一个突破的节点，即最左边的节点。
                maxLeftDepthVal = node.val;
                maxLeftDepth = curDepth;
            }
        }

        // 处理左子树，右子树
        curDepth ++;
        // 左节点在前面，能保证节点总是最左侧的。左边没有才检查右边，此时右边就是最左边的节点。
        if (node.left != null) {
            preOrder(node.left, curDepth);
        }

        if (node.right != null) {
            preOrder(node.right, curDepth);
        }
    }

    /**
     * 解法3：DFS。迭代法。略。
     */
    public int findBottomLeftValue3(TreeNode root) {
        return 0;
    }
}
