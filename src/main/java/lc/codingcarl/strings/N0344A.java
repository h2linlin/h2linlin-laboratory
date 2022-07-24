package lc.codingcarl.strings;

public class N0344A {
    public void reverseString(char[] s) {
        if (s == null && s.length <= 1) {
            return;
        }

        int i = 0;
        int j = s.length - 1;

        while (i < j) {
            char tmp = s[j];
            s[j] = s[i];
            s[i] = tmp;

            i++;
            j--;
        }
    }
}
