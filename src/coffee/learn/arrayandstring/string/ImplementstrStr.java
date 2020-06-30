package coffee.learn.arrayandstring.string;

/**
 * @File    :   ImplementstrStr.java
 * @Time    :   2020/05/22 22:45:36
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class ImplementstrStr {
    /**
     * KMP Algorithm
     * https://wylu.me/posts/2da0528d/
     * 
     * @param haystack Text string
     * @param needle Pattern string
     * @return the index of the first occurrence of needle in haystack,
     *         or -1 if needle is not part of haystack.
     */
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        char[] s = haystack.toCharArray(), p = needle.toCharArray();
        int[] next = getNextArray(p);
        int i = 0, j = 0;
        while (i < s.length && j < p.length) {
            if (j == -1 || s[i] == p[j]) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        return j == p.length ? i - j : -1;
    }

    public int[] getNextArray(char[] p) {
        int[] next = new int[p.length];
        int k = -1, j = 0;
        next[0] = -1;
        while (j < p.length - 1) {
            if (k == -1 || p[k] == p[j]) {
                k++;
                j++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    public static void main(String[] args) {
        String s = "BBC ABCDAB ABCDABCDABDE";
        String p = "ABCDABD";
        System.out.println(new ImplementstrStr().strStr(s, p));
    }
}