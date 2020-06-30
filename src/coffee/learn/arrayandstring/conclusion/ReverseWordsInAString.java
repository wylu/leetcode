package coffee.learn.arrayandstring.conclusion;

/**
 * @File    :   ReverseWordsInAString.java
 * @Time    :   2020/05/24 11:23:17
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        StringBuilder sb = new StringBuilder();
        for (int i = words.length - 1; i > 0; i--) {
            sb.append(words[i]).append(" ");
        }
        return sb.append(words[0]).toString();
    }
}