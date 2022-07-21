package lc.codingcarl.hash;

/**
 * @Desc
 * @Author wuzh
 * @Date 2021/4/19
 */
public class N0242 {
    public static void main(String[] args) {
        String s1 = "nagaram";
        String s2 = "anagram";

        System.out.println(solution2(s1, s2));
    }

    // 解法1：暴力法：先排序再比较
    // 暂时不实现
    public static boolean solution1(String s, String t) {
        return false;
    }

    // 解法2：哈希表
    // 用哈希表存下s1每个字符出现的次数，哈希表大小为26。
    // 在用哈希表检查s2每个字符出现的次数，出现就减1。
    // 最后判断数组中，有不为0的数，则表示两个字符串不相等。
    public static boolean solution2(String s, String t) {
        int[] hash = new int[26];

        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)%25]++;
        }

        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)%25]--;
        }

        for (int i = 0; i < hash.length; i++) {
            if (hash[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
