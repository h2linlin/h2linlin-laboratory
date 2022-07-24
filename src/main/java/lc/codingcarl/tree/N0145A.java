package lc.codingcarl.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class N0145A {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        trav(root, list);
        return list;
    }

    // 递归法
    private void trav(TreeNode node, List<Integer> list) {
        if (node == null) { return; }
        trav(node.left, list);
        list.add(node.val);
        trav(node.right, list);
    }

    // 迭代法
    public List<Integer> postorderTraversal0(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        TreeNode nextIn = root;
        TreeNode last = new TreeNode();
        while (q.peekFirst() != null || nextIn != null) {
            if (nextIn != null) {
                q.addFirst(nextIn);
                nextIn = nextIn.left;
            } else {
                if (q.peekFirst().right != null && q.peekFirst().right != last) {
                    nextIn = q.peekFirst().right;
                } else {
                    TreeNode cur = q.removeFirst();
                    list.add(cur.val);
                    last = cur;
                    nextIn = null;
                }
            }
        }

        return list;
    }
}
