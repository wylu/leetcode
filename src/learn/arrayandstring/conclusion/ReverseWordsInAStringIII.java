package learn.arrayandstring.conclusion;

/**
 * @File    :   ReverseWordsInAStringIII.java
 * @Time    :   2020/05/24 22:18:25
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class ReverseWordsInAStringIII {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            } else {
                res.append(word.reverse()).append(" ");
                word.setLength(0);
            }
        }
        res.append(word.reverse());
        return res.toString();
    }
}