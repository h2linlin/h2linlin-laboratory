package lc.datastruct.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc
 * @Author h2linlin
 */
public class N0098 {
    /**
     * 陷阱1：不能单纯比较左节点比根节点小，而是要比较所有左子树的点比跟节点小。右节点同理。
     *
     * 解法1：中序遍历，遍历过程中进行比较。
     * 或者直接中序遍历成一个数组，看数组是否递增即可，这种方法最直观。
     *
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
           return false;
        }

        List<Integer> list = inorder(root, new ArrayList<>());

        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i) >= list.get(i + 1)) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> inorder(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }

        if (node.left != null) {
            inorder(node.left, list);
        }

        list.add(node.val);

        if (node.right != null) {
            inorder(node.right, list);
        }

        return list;
    }

    /**
     * 解法2：在遍历过程中比较即可，不用专门展开为数组
     *
     * 陷阱1：不能单纯比较左节点比根节点小，而是要比较所有左子树的点比跟节点小。右节点同理。中序遍历，没有问题。
     * 陷阱2：int最小值可能是元素值。所以用long
     */
    public boolean isValidBST2(TreeNode root) {
        if (root == null) {
            return true;
        }

        return inorder(root);
    }

    long pre = Long.MIN_VALUE;
    public boolean inorder(TreeNode node) {
        if (node == null) {
            return true;
        }

        if (!inorder(node.left)) {
            return false;
        }

        if (pre > node.val) {
            return false;
        } else {
            pre = node.val;
        }

        if (!inorder(node.right)) {
            return false;
        }

        return true;
    }
}
