package coffee.learn.recursion2.toiteration;

import java.util.ArrayList;
import java.util.List;

/**
 * @File    :   GenerateParentheses.java
 * @Time    :   2020/05/13 21:49:43
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        generate(res, new StringBuilder(), 0, 0, n);
        return res;
    }

    private void generate(List<String> res, StringBuilder sb, int open, int close, int n) {
        if (sb.length() == n * 2) {
            res.add(sb.toString());
            return;
        }
        if (open < n) {
            generate(res, sb.append('('), open + 1, close, n);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (close < open) {
            generate(res, sb.append(')'), open, close + 1, n);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}