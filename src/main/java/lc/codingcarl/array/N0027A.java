package lc.codingcarl.array;

public class N0027A {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0 || (nums.length == 1 && nums[0] == val)) {
            return 0;
        }

        int L, R;
        for (L = 0, R = 0; R < nums.length;) {
            if (nums[R] == val) {
                R ++;
            } else {
                nums[L++] = nums[R++];
            }
        }

        return L;
    }
}
