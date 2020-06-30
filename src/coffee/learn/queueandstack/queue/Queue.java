package coffee.learn.queueandstack.queue;

/**
 * @File    :   Queue.java
 * @Time    :   2020/04/20 23:25:20
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class Queue<E> {
    int size = 0;

    /**
     * Pointer to first node.
     */
    Node<E> first;

    /**
     * Pointer to last node.
     */
    Node<E> last;

    /**
     * Constructs an empty list.
     */
    public Queue() {}

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements int this list
     */
    public int size() {
        return size;
    }

    /**
     * Adds the specified element as the tail (last element) of this list.
     *
     * @param e the element to add
     * @return true
     */
    public boolean offer(E e) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(e, null);
        last = newNode;
        if (l == null) {
            first = newNode;
        } else {
            l.next = newNode;
        }
        size++;
        return true;
    }

    /**
     * Retrieves and removes the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public E poll() {
        final Node<E> f = first;
        if (f == null) {
            return null;
        }
        final E element = f.item;
        final Node<E> next = f.next;
        // help GC
        f.item = null;
        f.next = null;
        first = next;
        if (next == null) {
            last = null;
        }
        size--;
        return element;
    }

    /**
     * Retrieves, but does not remove, the head (first element) of this list.
     *
     * @return the head of this list, or null if this list is empty
     */
    public E peek() {
        final Node<E> f = first;
        return f == null ? null : f.item;
    }

    /**
     * Removes all of the elements from this list.
     * The list will be empty after this call returns.
     */
    public void clear() {
        // Clearing all of the links between nodes is "unnecessary", but:
        // - helps a generational GC if the discarded nodes inhabit
        //   more than one generation
        // - is sure to free memory even if there is a reachable Iterator
        for (Node<E> x = first; x != null;) {
            Node<E> next = x.next;
            x.item = null;
            x.next = null;
            x = next;
        }
        first = last = null;
        size = 0;
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        for (int i = 0; i < 3; i++) {
            queue.offer(i);
        }
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        queue.clear();
        for (int i = 3; i < 6; i++) {
            queue.offer(i);
        }
        while (queue.size() > 0) {
            System.out.print(String.valueOf(queue.poll()) + ' ');
        }
    }
}