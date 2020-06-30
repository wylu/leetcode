package coffee.learn.queueandstack.exercise;

import java.util.LinkedList;

/**
 * @File    :   EvaluateReversePolishNotation.java
 * @Time    :   2020/05/05 16:51:01
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (String s: tokens) {
            if ("+".equals(s)) stack.push(stack.pop() + stack.pop());
            else if ("-".equals(s)) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b - a);
            } else if ("*".equals(s)) stack.push(stack.pop() * stack.pop());
            else if ("/".equals(s)) {
                int a = stack.pop(), b = stack.pop();
                stack.push(b / a);
            } else stack.push(Integer.valueOf(s));
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        // (4 + (13 / 5)) = 6
        // String[] tokens = new String[]{"4", "13", "5", "/", "+"};

        // ((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = 22
        String[] tokens = new String[]{
                "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(new EvaluateReversePolishNotation().evalRPN(tokens));
    }
}