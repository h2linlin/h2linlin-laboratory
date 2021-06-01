package lc.datastruct.tree;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @Desc 108. 将有序数组转换为二叉搜索树
 * @Author h2linlin
 */
public class N0108 {

    /**
     * 解法1：递归法。
     * 本质就是寻找分割点，分割点作为当前节点，然后递归左区间和右区间
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return construct(nums, 0, nums.length - 1);
    }

    private TreeNode construct(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        // 构造根节点
        int mid = start + (end - start) / 2;
        TreeNode midNode = new TreeNode(nums[mid]);

        // 构造左孩子
        midNode.left = construct(nums, start, mid - 1);

        // 构造右孩子
        midNode.right = construct(nums, mid + 1, end);

        return midNode;
    }

    /**
     * 解法2：迭代法
     * 可以通过三个队列来模拟，一个队列放遍历的节点，一个队列放左区间下标，一个队列放右区间下标。
     * 模拟的就是不断分割的过程
     */
    public TreeNode sortedArrayToBST2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        Deque<TreeNode> midNodeQue = new LinkedList<>();
        midNodeQue.offerLast(new TreeNode(Integer.MIN_VALUE));

        Deque<Integer> startIndexQue = new LinkedList<>();
        startIndexQue.offerLast(0);

        Deque<Integer> endIndexQue = new LinkedList<>();
        endIndexQue.offerLast(nums.length - 1);

        TreeNode root = midNodeQue.peekFirst();
        while (!midNodeQue.isEmpty()) {
            // 赋值
            int start = startIndexQue.pollFirst();
            int end = endIndexQue.pollFirst();
            int mid = start + (end - start) / 2;

            TreeNode poll = midNodeQue.pollFirst();
            poll.val = nums[mid];

            // 继续处理余下数值
            // 左孩子
            if (start < mid) {
                poll.left = new TreeNode(Integer.MIN_VALUE);
                midNodeQue.offerLast(poll.left);

                startIndexQue.offerLast(start);
                endIndexQue.offerLast(mid - 1);
            }
            // 右孩子
            if (mid < end) {
                poll.right = new TreeNode(Integer.MIN_VALUE);
                midNodeQue.offerLast(poll.right);

                startIndexQue.offerLast(mid + 1);
                endIndexQue.offerLast(end);
            }
        }

        return root;
    }
}
