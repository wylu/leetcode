package coffee.learn.queueandstack.exercise;

import java.util.LinkedList;

/**
 * @File    :   MinStack.java
 * @Time    :   2020/05/05 10:19:46
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class MinStack {
    private LinkedList<Integer> stack = new LinkedList<>();
    private LinkedList<Integer> mins = new LinkedList<>();

    /** initialize your data structure here. */
    public MinStack() {}

    public void push(int x) {
        stack.push(x);
        if (mins.isEmpty()) mins.push(x);
        else mins.push(x < mins.peek() ? x : mins.peek());
    }

    public void pop() {
        stack.pop();
        mins.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return mins.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */