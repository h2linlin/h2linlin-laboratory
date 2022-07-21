package lc.codingcarl.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Desc 94. 二叉树的中序遍历
 * @Author h2linlin
 */
public class N0094InOrder {

    /**
     * 解法1：递归遍历
     */
    public List<Integer> solution1(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(list, root);
        return list;
    }

    private void traversal(List<Integer> list, TreeNode node) {
        if (node == null) {
            return;
        }

        traversal(list, node.left);
        list.add(node.val);
        traversal(list, node.right);
    }


    /**
     * 解法2：迭代遍历。中序遍历。
     * 中序遍历的难点，在于“访问顺序和处理顺序不一致”。所以需要一个指针来指定。明确关键的两个东西：栈用来处理。指针用来访问。
     * 访问顺序：左子树、节点、右子树
     * 左/中：左子树一杆子捅到底，然后pop访问自己。
     * 右：然后指针指向右节点，访问右节点。右节点是树，做同样的处理。
     * 最后再pop完右节点，就自然的返回到了上一层。
     */
    public List<Integer> solution2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> st = new LinkedList<>();

        if (root == null) {
            return list;
        }

        TreeNode cur = root;
        while (!st.isEmpty() || cur != null) {
            if (cur != null) {
                st.push(cur);
                cur = cur.left;
            } else {
                cur = st.pop();
                list.add(cur.val);
                cur = cur.right;
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
            if (peek == null) {
                st.pop();
                list.add(st.pop().val);
            } else {
                st.pop();

                if (peek.right != null) {
                    st.push(peek.right);
                }

                st.push(peek);
                st.push(null);

                if (peek.left != null) {
                    st.push(peek.left);
                }
            }
        }

        return list;
    }
}
