package lc.codingcarl.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Desc 145. 二叉树的后序遍历
 * @Author h2linlin
 */
public class N0145PostOrder {

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
        traversal(list, node.right);
        list.add(node.val);
    }


    /**
     * 解法2A：迭代遍历。
     * 调整前序遍历顺序，中左右 改为 中右左，然后翻转result即可。
     * 或者用两个栈，通过压栈顺序调整即可。
     *
     * 解法2B：普通的迭代遍历。
     *
     */
    public List<Integer> solution2A(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> st = new LinkedList<>();

        if (root == null) {
            return list;
        }

        st.push(root);
        while (!st.isEmpty()) {
            TreeNode cur = st.pop();
            list.add(cur.val);  // 1.中

            if (cur.left != null) {
                st.push(cur.left);  // 3.左
            }

            if (cur.right != null) {
                st.push(cur.right);  // 2.右
            }
        }

        List<Integer> list2 = new ArrayList<>(list.size());
        for (int i = list.size() - 1; i >= 0; i--) {
            list2.add(list.get(i));
        }

        return list2;
    }

    public List<Integer> solution2B(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> st = new LinkedList<>();

        if (root == null) {
            return list;
        }

        /*用一个指针cur标记当前处理的节点是什么。
        后序遍历的过程中在遍历完左子树跟右子树cur都会回到根结点。
        所以当前不管是从左子树还是右子树回到根结点都不应该再操作了，应该退回上层。
        如果是从右边再返回根结点，应该回到上层。*/
        st.push(root);
        TreeNode pre = root;   // 上次处理的节点
        while (!st.isEmpty()) {
            TreeNode peek = st.peek();
            if (peek.left != null && peek.left != pre && peek.right != pre) {   // cur会指向右节点，所以要排除右节点
                st.push(peek.left);
            } else if (peek.right != null && peek.right != pre) {
                st.push(peek.right);
            } else {
                list.add(st.pop().val);
                pre = peek;
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

                st.push(peek);
                st.push(null);

                if (peek.right != null) {
                    st.push(peek.right);
                }

                if (peek.left != null) {
                    st.push(peek.left);
                }
            }
        }

        return list;
    }
}
