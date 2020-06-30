package coffee.learn.queueandstack.stack;

import java.util.ArrayList;
import java.util.List;

class MyStack {
    /**
     * store elements
     */
    private List<Integer> data;

    public MyStack() {
        data = new ArrayList<>();
    }

    /**
     * Insert an element into the stack.
     * @param x the element to push
     */
    public void push(int x) {
        data.add(x);
    }

    /**
     * Checks whether the stack is empty or not.
     * @return true or false
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * Get the top item from the stack.
     * @return the top item of stack
     */
    public int top() {
        return data.get(data.size() - 1);
    }

    /**
     * Delete an element from the queue.
     * @return true if the operation is successful. Otherwise, false.
     */
    public boolean pop() {
        if (isEmpty()) {
            return false;
        }
        data.remove(data.size() - 1);
        return true;
    }

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        s.push(3);
        for (int i = 0; i < 4; ++i) {
            if (!s.isEmpty()) {
                System.out.println(s.top());
            }
            System.out.println(s.pop());
        }
    }
}