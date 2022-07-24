package lc.codingcarl.sort;

public class N0704 {
    /**
     * 二分查找
     */
    public int search(int[] nums, int target) {
        return searchSub(nums, 0, nums.length - 1, target);
    }

    /**
     * 递归法
     */
    private int searchSub(int[] nums, int bgn, int end, int target) {
        if (bgn > end) {
            return -1;
        }

        int mid = (bgn + end) >> 1;

        if (nums[mid] == target) {
            return mid;
        } else if (target < nums[mid]) {
            return searchSub(nums, bgn, mid - 1, target);
        } else {
            return searchSub(nums, mid + 1, end, target);
        }
    }

    /**
     * 迭代法
     */
    private int searchSub(int[] nums, int target) {
        int bgn = 0;
        int end = nums.length - 1;

        while (bgn <= end) {
            int mid = (bgn + end) >> 1;

            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                end = mid - 1;
            } else {
                bgn = mid + 1;
            }
        }

        return -1;
    }

}
