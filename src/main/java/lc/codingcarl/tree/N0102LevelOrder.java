package lc.codingcarl.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Desc 102. 二叉树的层序遍历
 * @Author h2linlin
 */
public class N0102LevelOrder {

    /**
     * 解法1：队列，迭代。
     * 层序遍历是先入先出，用递归/栈都不好模拟。
     */
    public List<List<Integer>> solution1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();

        if (root == null) {
            return list;
        }

        que.offerLast(root);
        while (!que.isEmpty()) {
            int levelSize = que.size();   // 一定要用固定大小的size。que.size()是不断变化的。

            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.pollFirst();
                levelList.add(poll.val);
                if (poll.left != null) {
                    que.offerLast(poll.left);
                }

                if (poll.right != null) {
                    que.offerLast(poll.right);
                }
            }
            list.add(levelList);
        }

        return list;
    }

}
