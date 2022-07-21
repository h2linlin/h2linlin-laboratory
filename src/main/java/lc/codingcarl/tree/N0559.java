package lc.codingcarl.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @Desc 559. N 叉树的最大深度
 * @Author h2linlin
 */
public class N0559 {
    /**
     * 解法1：DFS，递归法。后续遍历。
     */
    public int maxDepth1(Node root) {
        return postOrder(root);
    }

    public int postOrder(Node node) {
        if (node == null) {
            return 0;
        }

        List<Node> children = node.children;
        int deepest = 0;
        if (children != null && children.size() > 0) {
            for (int i = 0; i < children.size(); i++) {
                deepest = Math.max(deepest, postOrder(children.get(i)));
            }
        }

        return deepest + 1;
    }

    /**
     * 解法2：BFS，迭代法。
     */
    public int maxDepth2(Node root) {
        int depth = 0;
        Deque<Node> que = new LinkedList<>();
        if (root == null) {
            return depth;
        }

        que.offerLast(root);

        while (!que.isEmpty()) {
            int levelSize = que.size();

            for (int i = 0; i < levelSize; i++) {
                Node node = que.pollFirst();

                List<Node> children = node.children;

                if (children != null && children.size() > 0) {
                    for (Node child : children) {
                        que.offerLast(child);
                    }
                }
            }
            depth ++;
        }

        return depth;
    }
}

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
