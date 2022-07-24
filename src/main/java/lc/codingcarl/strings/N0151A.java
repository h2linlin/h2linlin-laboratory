package lc.codingcarl.strings;

public class N0151A {
    public static void main(String[] args) {
        System.out.println(new N0151A().reverseWords(" the sky is blue "));
    }

    public String reverseWords(String s) {
        // 去除空格
        char[] ch = removeSpace(s.toCharArray());

        // 整体翻转
        ch = reverseString(ch, 0, ch.length - 1);

        // 按单词翻转
        for (int i = 0; i < ch.length;) {
            int bgn = i;
            int end = i;

            while (i < ch.length - 1 && ch[i + 1] != ' ') {
                i++;
                end++;
            }
            reverseString(ch, bgn, end);
            i += 2;
        }

        return new String(ch);
    }

    private char[] reverseString(char[] ch, int bgn, int end) {
        while (bgn < end) {
            char tmp = ch[bgn];
            ch[bgn] = ch[end];
            ch[end] = tmp;

            bgn++;
            end--;
        }

        return ch;
    }

    // 去除头尾空格、中间空格
    private char[] removeSpace(char[] ch) {
        // 1.双指针去除空格
        // 去除头尾空格
        int head = 0;
        while (ch[head] == ' ') {
            head ++;
        }
        int tail = ch.length - 1;
        while (ch[tail] == ' ') {
            tail --;
        }

        // 去除中间空格
        int p1 = head;
        int p2 = head + 1;
        while (p2 <= tail) {
            if (ch[p2 -1] == ' ' && ch[p2] == ' ') {
                p2 ++;
                continue;
            }
            ch[p1 + 1] = ch[p2];
            p1 ++;
            p2 ++;
        }

        tail = p1;

        char[] cha = new char[tail - head + 1];
        for (int i = 0; i < cha.length; i++) {
            cha[i] = ch[head++];
        }

        return cha;
    }
}
