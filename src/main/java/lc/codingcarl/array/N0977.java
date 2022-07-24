package lc.codingcarl.array;

public class N0977 {
    public int[] sortedSquares(int[] nums) {
        if (nums == null || nums.length == 0) {
            return nums;
        }

        int[] arr = new int[nums.length];

        for (int i = 0, j = nums.length - 1, k = j; i <= j;) {
            int i2 = nums[i] * nums[i];
            int j2 = nums[j] * nums[j];

            if (i2 > j2) {
                arr[k--] = i2;
                i++;
            } else {
                arr[k--] = j2;
                j--;
            }
        }

        return arr;
    }
}
