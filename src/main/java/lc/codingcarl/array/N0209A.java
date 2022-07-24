package lc.codingcarl.array;

public class N0209A {
    public int minSubArrayLen(int target, int[] nums) {
        // 边界判定。省略。

        int len = 0;    // 总长度
        int sum = 0;    // 总和
        int result = Integer.MAX_VALUE;

        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            len ++;

            while (sum >= target) {
                result = result < len ? result : len;
                sum -= nums[i++];
                len --;
            }
        }

        return result < Integer.MAX_VALUE ? result : 0;
    }
}
