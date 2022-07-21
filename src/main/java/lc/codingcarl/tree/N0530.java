package lc.codingcarl.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

/**
 * @Desc 530. 二叉搜索树的最小绝对差
 * @Author h2linlin
 */
public class N0530 {

    /**
     * 解法1：递归法。BFS，中序遍历。转换为数组后比较。
     */
    List<Integer> resultList = new ArrayList<>();
    public int getMinimumDifference1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        inorder1(root);

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < resultList.size() - 1; i++) {
            int minus = resultList.get(i + 1) - resultList.get(i);
            if ( minus < result) {
                result = minus;
            }
        }

        return result;
    }


    public void inorder1(TreeNode node) {
        if (node == null) {
            return;
        }

        // 左
        if (node.left != null) {
            inorder(node.left);
        }

        // 中
        resultList.add(node.val);

        // 右
        if (node.right != null) {
            inorder(node.right);
        }
    }

    /**
     * 解法2：递归法。BFS，中序遍历。遍历过程中直接比较。
     */
    int result = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference2(TreeNode root) {
        inorder(root);
        return result;
    }

    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        // 左
        if (node.left != null) {
            inorder(node.left);
        }

        // 中
        if (pre == null) {
            pre = node;
        } else {
            int minus = node.val - pre.val;

            if (minus < result) {
                result = minus;
            }
            pre = node;
        }

        // 右
        if (node.right != null) {
            inorder(node.right);
        }
    }

    /**
     * 解法3：迭代法。BFS，中序遍历。遍历过程中直接比较。
     */
    public int getMinimumDifference3(TreeNode root) {
        if (root == null) {
            return 0;
        }

        Deque<TreeNode> st = new LinkedList<>();
        int result = Integer.MAX_VALUE;

        TreeNode pre = null;
        TreeNode cur = root;
        while (!st.isEmpty() || cur != null) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left; // 左
            } else {
                cur = st.pop();

                if (pre != null) {
                    int minus = cur.val - pre.val;
                    result = Math.min(result, minus);
                }

                pre = cur;
                cur = cur.right;
            }

        }

        return result;
    }
}
