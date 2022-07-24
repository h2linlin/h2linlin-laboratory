package lc.codingcarl.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class N0094A {
    public List<Integer> inorderTraversal(TreeNode root) {
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
    // nextIn是要继续深入的节点
    public List<Integer> inorderTraversal0(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();

        TreeNode nextIn = root;
        while (q.peekFirst() != null || nextIn != null) {
            if (nextIn != null) {
                q.addFirst(nextIn);
                nextIn = nextIn.left;
            } else {
                // 中
                TreeNode cur = q.removeFirst();
                list.add(cur.val);

                // 右
                if (cur.right != null) {
                    nextIn = cur.right;
                } else {
                    nextIn = null;
                }
            }
        }
        return list;
    }

}
