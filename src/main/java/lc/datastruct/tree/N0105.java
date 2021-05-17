package lc.datastruct.tree;

/**
 * @Desc 105. 从前序与中序遍历序列构造二叉树
 * @Author h2linlin
 */
public class N0105 {
    /**
     * 解法：递归法。和105思路类似。后序切中序，中序切后序。
     *
     * 优化：用下标标记，不再新建数组。
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        return buildSubTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int[] preorder, int preorderStart, int preorderEnd,
                                  int[] inorder, int inorderStart, int inorderEnd) {
        TreeNode midNode = new TreeNode();

        // 1.切割中序数组
        int divValue = preorder[preorderStart];
        midNode.val = divValue;

        // 1.1 叶子节点，直接返回
        if (preorderStart == preorderEnd) {
            return midNode;
        }

        // 1.2寻找切割点下标
        int divFlag = -1;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (divValue == inorder[i]) {
                divFlag = i;
            }
        }

        // 1.3 切割中序左数组
        int leftInorderStart = inorderStart;
        int leftInorderEnd = divFlag - 1;

        // 1.4 切割中序右数组
        int rightInorderStart = divFlag + 1;
        int rightInorderEnd = inorderEnd;

        // 2.切割前序数组
        // 2.1 切割前序左数组
        int leftPreorderStart = preorderStart + 1;
        int leftPreorderEnd = leftPreorderStart + (leftInorderEnd - leftInorderStart + 1);

        // 2.2 切割前序右数组
        int rightPreorderStart = leftPreorderEnd + 1;
        int rightPreorderEnd = preorderEnd;

        // 3.整合结果返回
        if (leftPreorderStart > leftPreorderEnd || leftInorderStart > leftInorderEnd) {
            midNode.left = null;
        } else {
            midNode.left = buildSubTree(preorder, leftPreorderStart, leftPreorderEnd, inorder, leftInorderStart, leftInorderEnd);
        }

        if (rightPreorderStart > rightPreorderEnd || rightInorderStart > rightInorderEnd) {
            midNode.right = null;
        } else {
            midNode.right = buildSubTree(preorder, rightPreorderStart, rightPreorderEnd, inorder, rightInorderStart, rightInorderEnd);
        }

        return midNode;
    }
}
