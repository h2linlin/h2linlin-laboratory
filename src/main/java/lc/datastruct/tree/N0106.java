package lc.datastruct.tree;

/**
 * @Desc 106. 从中序与后序遍历序列构造二叉树
 * @Author h2linlin
 */
public class N0106 {

    /**
     * 递归法。
     * 每层，用后序最后一个元素切中序数组，再用中序数组去切后续数组即可。
     * 不变量：切割时选择的是左开右闭、左闭右开、还是左闭右闭
     *
     * 切割后序数组时，直接选用已经切好的中序左右数组的长度即可，不用再计算。
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length == 0 || postorder.length == 0) {
            return null;
        }

        TreeNode midNode = new TreeNode();

        // 切割
        // 1.后序切中序
        int div = postorder[postorder.length - 1];
        midNode.val = div;

        // 1.0 叶子节点
        if (postorder.length == 1) {
            return midNode;
        }

        // 1.1 寻找切割下标
        int divFlag = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (div == inorder[i]) {
                divFlag = i;
            }
        }
        // 1.2 切割
        int[] leftInorder = new int[divFlag];
        for (int i = 0; i < divFlag; i ++) {
            leftInorder[i] = inorder[i];
        }

        int[] rightInorder = new int[inorder.length - divFlag - 1];
        for (int i = divFlag + 1; i < inorder.length; i ++) {
            rightInorder[i - divFlag - 1] = inorder[i];
        }

        // 2.中序切后序
        int leftPostorderLen = leftInorder.length;
        int[] leftPostorder = new int[leftPostorderLen];
        for (int i = 0; i < leftPostorderLen; i++) {
            leftPostorder[i] = postorder[i];
        }


        int rightPostorderLen = rightInorder.length;
        int[] rightPostorder = new int[rightPostorderLen];
        for (int i = leftPostorderLen; i < postorder.length - 1; i++) { // 注意，最后一个元素已经用掉了，要排除。
            rightPostorder[i - leftPostorderLen] = postorder[i];
        }

        midNode.left = buildTree(leftInorder, leftPostorder);
        midNode.right = buildTree(rightInorder, rightPostorder);

        return midNode;
    }


}
