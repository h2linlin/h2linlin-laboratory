package lc.codingcarl.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N0015A {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return null;
        }

        List<List<Integer>> rst = new ArrayList<>();

        Arrays.sort(nums);

        for (int i = 0, L = 0, R = nums.length - 1; i <= nums.length-2; i++) {
            L = i + 1;
            R = nums.length - 1;

            // 剪枝
            if (nums[i] > 0) { return rst; }

            // 去重
            if (i > 0 && nums[i] == nums[i - 1]) { continue; }

            while (L < R) {
                if (nums[i] + nums[L] + nums[R] > 0) { R--; continue; }
                if (nums[i] + nums[L] + nums[R] < 0) { L++; continue; }

                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[L]);
                list.add(nums[R]);
                rst.add(list);

                // 去重
                while (L < R && nums[L] == nums[L+1]) { L++; }
                while (L < R && nums[R] == nums[R-1]) { R--; }

                L++;
                R--;
            }
        }

        return rst;
    }
}
