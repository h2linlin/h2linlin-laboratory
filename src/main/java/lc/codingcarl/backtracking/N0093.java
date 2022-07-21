package lc.codingcarl.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc 93. 复原 IP 地址
 * @Author h2linlin
 */
public class N0093 {
    // 低效率版
    public List<String> restoreIpAddresses(String s) {
        if (s == null || "".equals(s)) {
            return new ArrayList<>();
        }

        char[] chars = s.toCharArray();

        backtracking(chars, 0);

        return results;
    }


    List<String> results = new ArrayList<>();
    List<String> path = new ArrayList<>();

    private void backtracking(char[] chars, int startIndex) {
        // 收集结果
        if (startIndex > chars.length - 1) {
            if (path.size() < 4) {
                return;
            }
            results.add(String.join(".", path));
        }

        for (int i = startIndex; i < chars.length; i ++) {
            // 处理
            if (path.size() > 3 || !isIp(chars, startIndex, i)) {
                return;
            }
            path.add(new String(chars, startIndex, i - startIndex + 1));

            // 递归
            backtracking(chars, i + 1);

            // 回溯
            path.remove(path.size() - 1);
        }
    }

    /**
     * 判断字符串是否合法
     */
    private boolean isIp(char[] chars, int startIndex, int endIndex) {
        int len = endIndex - startIndex + 1;

        // 1至3位数才合法
        if (len < 1 || len > 3) {
            return false;
        }

        // 2位数以上，以0开头，不合法
        if (len > 1 && chars[startIndex] == '0') {
            return false;
        }

        // 1至3 位数，必须位于0-255之间
        int sum = 0;
        for (int i = startIndex; i <= endIndex; i ++) {
            sum = sum * 10 + Integer.valueOf(chars[i]+"");
        }
        return sum <= 255;
    }


//    // 改进版：有Bug
//    public List<String> restoreIpAddresses(String s) {
//        if (s == null || "".equals(s)) {
//            return new ArrayList<>();
//        }
//
//        char[] chars = s.toCharArray();
//
//        backtracking(chars, 0);
//
//        return results;
//    }
//
//
//    List<String> results = new ArrayList<>();
//    StringBuffer path = new StringBuffer();
//    int spotNum = 0;    // “.”的数量
//
//    private void backtracking(char[] chars, int startIndex) {
//        // 收集结果
//        if (startIndex > chars.length - 1) {
//            if (spotNum < 3) {
//                return;
//            }
//            results.add(path.toString());
//        }
//
//        for (int i = startIndex; i < chars.length; i ++) {
//            // 处理
//            if (spotNum > 2 || !isIp(chars, startIndex, i)) {
//                return;
//            }
//
//            // 加入IP子字段
//            for (int j = startIndex; j <= i; j++) {
//                path.append(chars[j]);
//            }
//            path.append(".");
//            spotNum ++;
//
//            // 递归
//            backtracking(chars, i + 1);
//
//            // 回溯
//            for (int k = startIndex; k <= i; k++) {
//                path.deleteCharAt(path.length() - 1);
//            }
//            path.deleteCharAt(path.length() - 1);
//            spotNum --;
//        }
//    }
//
//    /**
//     * 判断字符串是否合法
//     */
//    private boolean isIp(char[] chars, int startIndex, int endIndex) {
//        int len = endIndex - startIndex + 1;
//
//        // 1至3位数才合法
//        if (len < 1 || len > 3) {
//            return false;
//        }
//
//        // 2位数以上，以0开头，不合法
//        if (len > 1 && chars[startIndex] == '0') {
//            return false;
//        }
//
//        // 1至3 位数，必须位于0-255之间
//        int sum = 0;
//        for (int i = startIndex; i <= endIndex; i ++) {
//            sum = sum * 10 + Integer.valueOf(chars[i]+"");
//        }
//        return sum <= 255;
//    }
}
