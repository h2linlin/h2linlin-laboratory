package lc.datastruct.tree;

/**
 * @Desc 105. 从前序与中序遍历序列构造二叉树
 * @Author h2linlin
 */
public class N0105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0 || inorder == null || inorder.length == 0) {
            return null;
        }

        return buildSubTree(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildSubTree(int[] preorder, int preorderStart, int preorderEnd,
                                  int[] inorder, int inorderStart, int inorderEnd) {
        // 差值判断
        if (inorderStart > inorderEnd || preorderStart > preorderEnd) {
            return null;
        }

        // 前序遍历

        TreeNode midNode = new TreeNode();
        // 0.判断叶子节点
        if (preorderStart == preorderEnd) {
            midNode.val = preorder[preorderStart];
            return midNode;
        }

        // 1.中序切割：前序切中序
        // 1.1查找切割点
        int divValue = preorder[preorderStart];
        int divFlag = -1;
        for (int i = inorderStart; i <= inorderEnd; i++) {
            if (inorder[i] == divValue) {
                divFlag = i;
                break;
            }
        }

        // 1.2 切割中序
        int leftInorderStart = inorderStart;
        int leftInorderEnd = divFlag - 1;

        int rightInorderStart = divFlag + 1;
        int rightInorderEnd = inorderEnd;


        // 2.前序切割
        // 2.1 左子树
        int leftInorderLen = leftInorderEnd - leftInorderStart + 1;
        int leftPreorderStart = preorderStart + 1;
        int leftPreorderEnd = leftPreorderStart + leftInorderLen - 1;

        // 2.2 右子树
        int rightInorderLen = rightInorderEnd - rightInorderStart + 1;
        int rightPreorderEnd = preorderEnd;
        int rightPreorderStart = rightPreorderEnd - rightInorderLen + 1;

        // 3.合并左右子节点返回
        midNode.val = divValue;
        midNode.left = buildSubTree(preorder, leftPreorderStart, leftPreorderEnd, inorder, leftInorderStart, leftInorderEnd);
        midNode.right = buildSubTree(preorder, rightPreorderStart, rightPreorderEnd, inorder, rightInorderStart, rightInorderEnd);

        return midNode;
    }
}
