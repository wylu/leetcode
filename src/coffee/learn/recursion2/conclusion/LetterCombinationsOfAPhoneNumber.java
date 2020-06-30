package coffee.learn.recursion2.conclusion;

import java.util.ArrayList;
import java.util.List;

/**
 * @File    :   LetterCombinationsOfAPhoneNumber.java
 * @Time    :   2020/05/14 23:31:27
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class LetterCombinationsOfAPhoneNumber {
    private String[] map = new String[]{"", "", "abc", "def",
            "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits == null || digits.length() == 0) return res;
        combinate(res, 0, digits.toCharArray(), new StringBuilder());
        return res;
    }

    private void combinate(List<String> res, int cur, char[] digits, StringBuilder sb) {
        if (cur == digits.length) {
            res.add(sb.toString());
            return;
        }
        for (char ch: map[digits[cur] - '0'].toCharArray()) {
            sb.append(ch);
            combinate(res, cur + 1, digits, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}