package lc.codingcarl.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;


/**
 * @Desc 101. 对称二叉树
 * @Author h2linlin
 */
public class N0101 {
    /**
     * 解法1：BFS，最后判断数组是否对称即可。空位需要用特殊字段填补。
     */
    public boolean isSymmetric1(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return true;
        }

        if (root.left == null && root.right != null) {
            return false;
        }

        if (root.left != null && root.right == null) {
            return false;
        }

        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        Deque<TreeNode> que = new LinkedList<>();


        // 左子树数组
        TreeNode flag = new TreeNode(1); // 为null时的占位符
        que.offerLast(root.left);
        while (!que.isEmpty()) {
            int levelSize = que.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.pollFirst();
                list1.add(poll.val);

                if (poll == flag) {
                    continue;
                }

                if (poll.left != null) {
                    que.offerLast(poll.left);
                } else { // 注意，为null时也要放入0占位
                    que.offerLast(flag);
                }

                if (poll.right != null) {
                    que.offerLast(poll.right);
                } else {
                    que.offerLast(flag);
                }
            }
        }

        // 右子树数组
        que.offerLast(root.right);
        while (!que.isEmpty()) {
            int levelSize = que.size();

            for (int i = 0; i < levelSize; i++) {
                TreeNode poll = que.pollFirst();
                list2.add(poll.val);

                if (poll == flag) {
                    continue;
                }

                if (poll.right != null) {
                    que.offerLast(poll.right);
                } else {
                    que.offerLast(flag);
                }

                if (poll.left != null) {
                    que.offerLast(poll.left);
                } else {
                    que.offerLast(flag);
                }
            }
        }

        // 比较两数组
        if (list1.size() != list2.size()) {
            return false;
        }

        for (int i = 0; i < list1.size(); i++) {
            if (list1.get(i) != list2.get(i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * 解法2：DFS，递归。
     */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return false;
        }

        return compare(root.left, root.right);
    }

    private boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right == null) {
            return false;
        }
        if (left == null && right != null) {
            return false;
        }

        if (left.val == right.val) {
            return compare(left.left, right.right) && compare(left.right, right.left);
        }

        return false;
    }

    /**
     * 解法3：DFS，迭代
     */
    public boolean isSymmetric3(TreeNode root) {
        if (root == null) {
            return false;
        }

        if (!equal(root.left, root.right)) {
            return false;
        }

        Deque<TreeNode> st = new LinkedList<>();

        st.push(root.right);
        st.push(root.left);

        TreeNode curR = root.right;
        TreeNode curL = root.left;

        while (!st.isEmpty()) {
            curL = st.pop();
            curR = st.pop();

            // 前序，处理
            if (!equal(curL, curR)) {
                return false;
            }

            if (curR != null && curL != null) {
                st.push(curL.right);
                st.push(curR.left);
                st.push(curR.right);
                st.push(curL.left);
            }
        }

        return true;
    }

    private boolean equal(TreeNode l, TreeNode r) {
        if (l == null && r == null) {
            return true;
        }
        if (l != null && r == null) {
            return false;
        }
        if (l == null && r != null) {
            return false;
        }
        if (l.val == r.val) {
            return true;
        }
        return false;
    }

    /**
     * 解法4：DFS。中序遍历，判断数组是否对称。同样的，注意空位需要用0填补。
     */
}
