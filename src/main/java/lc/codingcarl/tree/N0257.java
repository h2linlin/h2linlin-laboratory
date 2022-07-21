package lc.codingcarl.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 257. 二叉树的所有路径
 * @Author h2linlin
 */
public class N0257 {

    /**
     * 解法1：DFS，递归法。前序遍历，因为要先拿到父节点信息。
     * 隐含了回溯。
     * "1->2->5"
     */
    public List<String> binaryTreePaths1(TreeNode root) {
        List<String> result = new ArrayList<>();
        List<Integer> curPath = new ArrayList<>();

        if (root == null) {
            return result;
        }

        preOrder(root, result, curPath);

        return result;
    }

    private void preOrder(TreeNode node, List<String> result, List<Integer> curPath) {
        if (node.left == null && node.right == null) {
            curPath.add(node.val);
            result.add(parse(curPath));
            curPath.remove(curPath.size() - 1);
            return;
        }

        if (node.left != null) {
            curPath.add(node.val);
            preOrder(node.left, result, curPath);
            curPath.remove(curPath.size() - 1);
        }

        if (node.right != null) {
            curPath.add(node.val);
            preOrder(node.right, result, curPath);
            curPath.remove(curPath.size() - 1);
        }
    }

    private String parse(List<Integer> curPath) {
        StringBuilder sb = new StringBuilder(curPath.get(0) + "");

        for (int i = 1; i < curPath.size(); i++) {
            sb.append("->" + curPath.get(i));
        }

        return sb.toString();
    }

    /**
     * 解法2：DFS，迭代法。中序遍历。
     */
    public List<String> binaryTreePaths2(TreeNode root) {
        // 暂时没思路。。
        List<String> result = new ArrayList<>();
//        List<Integer> curPath = new ArrayList<>();
//
//        if (root == null) {
//            return result;
//        }
//
//        Deque<TreeNode> st = new LinkedList<>();
//        st.push(root);
//        curPath.add(root.val);
//        while (!st.isEmpty()) {
//            TreeNode pop = st.pop();
//            if (curPath.size() > 0) {
//                curPath.remove(curPath.size() - 1);
//            }
//
//
//            if (pop.left == null && pop.right == null) {
//                curPath.add(pop.val);
//                result.add(parse(curPath));
//                curPath.remove(curPath.size() - 1);
//                continue;
//            }
//
//            if (pop.right != null) {
//                st.push(pop.right);
//                curPath.add(pop.right.val);
//            }
//
//            if (pop.left != null) {
//                st.push(pop.left);
//                curPath.add(pop.left.val);
//            }
//        }
//
        return result;
    }
}
