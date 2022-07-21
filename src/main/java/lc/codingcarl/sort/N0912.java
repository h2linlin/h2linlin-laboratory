package lc.codingcarl.sort;

// 排序：给你一个整数数组 nums，请你将该数组升序排列。
public class N0912 {

    public int[] sortArray(int[] nums) {
        // 边界处理
        if (nums == null || nums.length <= 1) {
            return nums;
        }
        sort(nums, 0,1,nums.length - 1);

        return nums;
    }

    // 递归
    public void sort(int[] nums, int start, int i, int j) {
        if (i >= j) {
            return;
        }

        int head = i;
        int tail = j;

            while (i != j) {
            while (nums[j] > nums[start] && j >= head) j--;  // 一定是j先开始，最后才能和start换。
            while (nums[i] < nums[start] && i <= tail) i++;

            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

        }

        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;

        sort(nums, start, start+1, i-1);
        sort(nums, i+1, i+2, tail);
    }


    public static void main(String[] args) {
        System.out.println(2&1);
        System.out.println(method111());
        System.out.println(method111());
    }

    public static String method111() {
        String ret = "hello";
        try {
            return ret;
        } finally {
            ret = "world";
        }
    }
}
