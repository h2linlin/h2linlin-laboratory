package lc.datastruct.tree;

import java.util.*;

/**
 * @Desc 501. 二叉搜索树中的众数
 * @Author h2linlin
 */
public class N0501 {
    /**
     * 解法1：普通树的解法。BFS，前/中/后序遍历放到Map中，然后把Map根据value排序并统计。
     *
     */
    public int[] findMode1(TreeNode root) {
        if (root == null) {
            return null;
        }

        preorder(root);

        // 找到map中的value最大值
        int max = 0;
        for (Integer value : map.values()) {
            if (max < value) {
                max = value;
            }
        }
        // 整合众数
        List<Integer> results = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == max) {
                results.add(entry.getKey());
            }
        }

        // 整合结果
        int[] resultArray = new int[results.size()];
        int i = 0;
        for (Integer value : results) {
            resultArray[i] = value;
            i++;
        }

        return resultArray;
    }

    // map：key：值，value：频次
    HashMap<Integer, Integer> map = new HashMap<>();
    private void preorder(TreeNode node) {
        if (node == null) {
            return;
        }

        // 中
        if (map.get(node.val) == null) {
            map.put(node.val, 1);
        } else {
            map.put(node.val, map.get(node.val) + 1);
        }

        // 左
        if (node.left != null) {
            preorder(node.left);
        }

        // 右
        if (node.right != null) {
            preorder(node.right);
        }
    }

    /**
     * 解法2：二叉搜索树BFS，递归法，中序遍历。边遍历边统计，有更高频次的众数时，重置结果集。
     *
     */
    public int[] findMode2(TreeNode root) {
        if (root == null) {
            return null;
        }

        inorder(root);

        // 整合结果
        int[] resultArray = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            resultArray[i] = resultList.get(i);
        }

        return resultArray;
    }

    int maxHint = 0;    // 最大频次数
    int curHint = 0;    // 当前节点值的频次数
    List<Integer> resultList = new ArrayList<>();
    TreeNode pre = null;// 前一个处理的节点
    private void inorder(TreeNode node) {
        if (node == null) {
            return;
        }

        // 左
        if (node.left != null) {
            inorder(node.left);
        }

        // 中
        if (pre == null) {
            // 根节点
            maxHint = 1;
            curHint = 1;
            resultList.add(node.val);
        } else {
            if (node.val == pre.val) {
                // 和前面的值重复
                curHint ++;

                if (curHint == maxHint) {
                    resultList.add(node.val);
                } else if (curHint > maxHint) {
                    maxHint = curHint;
                    resultList = new ArrayList<>();
                    resultList.add(node.val);
                }
            } else {
                // 和前面的值不重复
                curHint = 1;
                if (maxHint == 1) {
                    resultList.add(node.val);
                }
            }
        }
        pre = node;

        // 右
        if (node.right != null) {
            inorder(node.right);
        }
    }

    /**
     * 解法3：二叉搜索树解法。BFS，迭代法，中序遍历。边遍历边统计，有更高频次的众数时，重置结果集。
     *
     */
    public int[] findMode3(TreeNode root) {
        if (root == null) {
            return null;
        }

        Deque<TreeNode> st = new LinkedList<>();

        int curCount = 0;
        int maxCount = 0;
        List<Integer> list = new ArrayList<>();
        TreeNode pre = null;

        TreeNode next = root;
        while (!st.isEmpty() || next != null) {
            if (next != null) {
                st.push(next);
                next = next.left;
            } else {
                // 中
                TreeNode pop = st.pop();
                if (pre == null) {
                    // 最左节点
                    curCount = 1;
                    maxCount = 1;
                    list.add(pop.val);
                } else {
                    if (pop.val == pre.val) {
                        curCount ++;
                    } else {
                        curCount = 1;
                    }

                    if (curCount == maxCount) {
                        list.add(pop.val);
                    }
                    if (curCount > maxCount) {
                        maxCount = curCount;
                        list = new ArrayList<>();
                        list.add(pop.val);
                    }
                }
                pre = pop;

                // 右
                next = pop.right;
            }
        }

        // 转换结果
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
}
