package lc.datastruct.tree;

/**
 * @Desc
 * @Author h2linlin
 */
public class N0098 {
    /**
     * 解法1：中序遍历，遍历过程中进行比较。
     * 或者直接中序遍历成一个数组，看数组是否递增即可，这种方法最直观。
     *
     * 陷阱1：不能单纯比较左节点比根节点小，而是要比较所有左子树的点比跟节点小。右节点同理。
     * 陷阱2：最小值可能是元素值。
     */
    public boolean isValidBST(TreeNode root) {


        return false;
    }
}
