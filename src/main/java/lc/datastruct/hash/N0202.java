package lc.datastruct.hash;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import lc.DisplayUtil;

import java.util.HashSet;
import java.util.Set;

/**
 * @Desc 202. 快乐数
 * @Author wuzh
 * @Date 2021/4/20
 */
public class N0202 {

    public static void main(String[] args) {
        // 输入
        int n = 19;
        System.out.println(n);

        // 计算
        boolean result = solution2(n);

        // 输出
        System.out.println(result);
    }

    // 解法1：哈希表
    // 三种情况：1，循环，无限大。写出数据来分析，无限大是不可能的。比如，999最大，处理结果为243，还是3位数。
    // 判断数值在不在哈希表里就行。
    public static boolean solution1(int n) {
        Set<Integer> set = new HashSet<>();

        while (!set.contains(n)) {
            set.add(n);
            n = getNextNum(n);
        }

        return n == 1;
    }

    // 解法2：快慢指针，检测环
    public static boolean solution2(int n) {
        int n2 = n;

        do {
            n = getNextNum(n);

            n2 = getNextNum(n2);
            n2 = getNextNum(n2);
        } while (n != n2);

        return n == 1;
    }

    private static int getNextNum (int n) {
        int result = 0;

        while (n > 0) {
            int i = n % 10;
            result += i * i;
            n = n / 10;
        }

        return result;
    }
}
