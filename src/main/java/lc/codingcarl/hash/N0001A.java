package lc.codingcarl.hash;

import java.util.HashMap;
import java.util.Map;

public class N0001A {
    public int[] twoSum(int[] nums, int target) {
        // 入参校验。略。

        Map<Integer, Integer> map = new HashMap();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            arr[0] = i;
            Integer idx = -1;
            if ((idx = map.get(target - nums[i])) != null && idx != i) {
                arr[1] = idx;
                return arr;
            }
        }

        return null;
    }
}
