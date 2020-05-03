package learn.queueandstack.queue;

import java.util.ArrayList;
import java.util.List;

class MyQueue {
    /**
     * store elements
     */
    private List<Integer> data;
    /**
     * a pointer to indicate the start position
     */
    private int start;

    public MyQueue() {
        data = new ArrayList<>();
        start = 0;
    }

    /**
     * Insert an element into the queue. Return true if the operation is successful.
     * @param x the element to push
     * @return push successfully or not
     */
    public boolean enQueue(int x) {
        data.add(x);
        return true;
    }

    /**
     * Delete an element from the queue. Return true if the operation is successful.
     * @return remove first element successfully or not
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        start++;
        return true;
    }

    /**
     * Get the front item from the queue.
     * @return the front element
     */
    public int front() {
        return data.get(start);
    }

    /**
     * Checks whether the queue is empty or not.
     * @return true or false
     */
    public boolean isEmpty() {
        return start >= data.size();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.enQueue(5);
        q.enQueue(3);
        if (!q.isEmpty()) {
            System.out.println(q.front());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.front());
        }
        q.deQueue();
        if (!q.isEmpty()) {
            System.out.println(q.front());
        }
    }
}