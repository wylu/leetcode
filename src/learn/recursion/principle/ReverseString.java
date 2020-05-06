package learn.recursion.principle;

/**
 * @File    :   ReverseString.java
 * @Time    :   2020/05/06 22:30:05
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class ReverseString {
    public void reverseString(char[] s) {
        helper(s, 0, s.length - 1);
    }

    private void helper(char[] s, int left, int right) {
        if (left >= right) return;
        char tmp = s[left];
        s[left] = s[right];
        s[right] = tmp;
        helper(s, left + 1, right - 1);
    }
}