package coffee.learn.queueandstack.exercise;

import java.util.LinkedList;

/**
 * @File    :   DecodeString.java
 * @Time    :   2020/05/06 08:01:17
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) return "";
        LinkedList<Integer> cnts = new LinkedList<>();
        LinkedList<StringBuilder> vals = new LinkedList<>();
        vals.push(new StringBuilder());
        int num = 0;
        for (char ch: s.toCharArray()) {
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            } else if (ch == '[') {
                vals.push(new StringBuilder());
                cnts.push(num);
                // reset for next nums
                num = 0;
            } else if (ch == ']') {
                String toCopy = vals.pop().toString();
                StringBuilder sb = vals.pop();
                for (int i = cnts.pop(); i > 0; i--) sb.append(toCopy);
                vals.push(sb);
            } else {
                vals.peek().append(ch);
            }
        }
        return vals.pop().toString();
    }
}