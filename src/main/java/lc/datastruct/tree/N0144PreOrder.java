package lc.datastruct.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Desc 144. 二叉树的前序遍历
 * @Author h2linlin
 */
public class N0144PreOrder {

    /**
     * 解法1：递归遍历
     */
    public List<Integer> solution1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(list, root);
        return list;
    }

    private void traversal(List<Integer> list, TreeNode node) {
        // 结束条件
        if (node == null) {
            return;
        }

        // 正常逻辑
        list.add(node.val);
        traversal(list, node.left);
        traversal(list, node.right);
    }


    /**
     * 解法2：迭代遍历
     * 用栈模拟递归。注意要先压右节点再压左节点，因为栈弹出的方向是相反的。
     */
    public List<Integer> solution2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> st = new LinkedList<>();

        if (root == null) {
            return list;
        }

        st.push(root);
        TreeNode curNode;
        while (!st.isEmpty()) {
            curNode = st.pop();
            list.add(curNode.val);
            if (curNode.right != null) {
                st.push(curNode.right);
            }
            if (curNode.left != null) {
                st.push(curNode.left);
            }
        }

        return list;
    }

    /**
     * 解法3：统一风格的迭代遍历
     * 标记法：遍历树，需要处理的节点前面加Null。然后遇到Null时，才加入结果集。
     *
     * 解法4(略)：Morris解法，左子树的最右节点直接指向根，就可以遍历。
     */
    public List<Integer> solution3(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> st = new LinkedList<>();

        if (root == null) {
            return list;
        }

        st.push(root);
        while (!st.isEmpty()) {
            TreeNode peek = st.peek();
            if (peek == null) {         // 处理
                st.pop();
                list.add(st.pop().val);
            } else {                    // 访问
                st.pop();

                if (peek.right != null) {   // 3.右
                    st.push(peek.right);
                }
                if (peek.left != null) {    // 2.左
                    st.push(peek.left);
                }

                st.push(peek);              // 1.中
                st.push(null);
            }
        }

        return list;
    }
}
