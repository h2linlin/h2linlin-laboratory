package lc.codingcarl.tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class N0102A {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {return new ArrayList<>();}

        Deque<TreeNode> q = new LinkedList<>();
        List<List<Integer>> list = new ArrayList();

        q.addLast(root);
        int curL = 1;
        int nextL = 0;

        while (curL > 0) {
            List<Integer> listL = new ArrayList();

            while (curL > 0) {
                TreeNode node = q.removeFirst();
                curL--;
                listL.add(node.val);

                if (node.left != null) { q.addLast(node.left); nextL++;}
                if (node.right != null) { q.addLast(node.right); nextL++;}
            }
            list.add(listL);

            curL = nextL;
            nextL = 0;
        }
        return list;
    }
}
