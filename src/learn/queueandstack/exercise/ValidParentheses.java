package learn.queueandstack.exercise;

import java.util.LinkedList;

/**
 * @File    :   ValidParentheses.java
 * @Time    :   2020/05/05 10:35:29
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char ch: s.toCharArray()){
            if (ch == '(') stack.push(')');
            else if (ch == '{') stack.push('}');
            else if (ch == '[') stack.push(']');
            else if (stack.isEmpty() || stack.poll() != ch) return false;
        }
        return stack.isEmpty();
    }
}