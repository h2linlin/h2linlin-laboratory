package lc.codingcarl.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class N0144A {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        trav(root, list);
        return list;
    }

    // 递归法
    private void trav(TreeNode node, List<Integer> list) {
        if (node == null) { return; }
        list.add(node.val);
        trav(node.left, list);
        trav(node.right, list);
    }

    // 迭代法
    public List<Integer> preorderTraversal0(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        Deque<TreeNode> q = new LinkedList<>();
        q.addFirst(root);

        TreeNode cur = null;
        while (q.peekFirst() != null) {
            // 中
            cur = q.removeFirst();
            list.add(cur.val);

            // 左、右
            if (cur.right != null) { q.addFirst(cur.right); }
            if (cur.left != null) { q.addFirst(cur.left); }
        }

        return list;
    }
}
