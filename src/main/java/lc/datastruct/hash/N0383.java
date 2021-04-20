package lc.datastruct.hash;

/**
 * @Desc
 * @Author h2linlin
 */
public class N0383 {
    public static void main(String[] args) {
        String s1 = "nagaram";
        String s2 = "anagramdffgghhjj";

        System.out.println(solution2(s1, s2)+"");
    }

    // 解法1：暴力法：先排序再比较。注意某个字符用过后需要及时删除。
    // 暂时不实现
    public static boolean solution1(String ransomNote, String magazine) {
        return false;
    }

    // 解法2：哈希表
    // 暂时不实现
    public static boolean solution2(String ransomNote, String magazine) {
        // 1.构建字符库hash表，下标：字母。值：次数。
        int[] arr = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i)%25]++;
        }

        // 2.检测
        for (int i = 0; i < ransomNote.length(); i++) {
            arr[ransomNote.charAt(i)%25]--;
            if (arr[ransomNote.charAt(i)%25] < 0) {
                return false;
            }
        }

        return true;
    }
}
