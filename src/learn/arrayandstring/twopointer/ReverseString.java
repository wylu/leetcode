package learn.arrayandstring.twopointer;

/**
 * @File    :   ReverseString.java
 * @Time    :   2020/05/23 11:59:23
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class ReverseString {
    public void reverseString(char[] s) {
        for (int i = 0, j = s.length - 1; i < j; i++, j--) {
            char ch = s[i];
            s[i] = s[j];
            s[j] = ch;
        }
    }
}