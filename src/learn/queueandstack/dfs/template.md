# DFS

As we mentioned in the chapter's description, in most cases, we can also use DFS when using BFS. But there is an important difference: the traversal order.

Different from BFS, the nodes you visit earlier might not be the nodes which are closer to the root node. As a result, the first path you found in DFS might not be the shortest path.

In this article, we will provide you a recursion template of DFS and show you how the stack helps with this process. And then we provide some exercise after this article for you to practice.

## Template I

There are two ways to implement DFS. The first one is to do recursion which you might already be familiar with. Here we provide a template as reference:

```java
/*
 * Return true if there is a path from cur to target.
 */
boolean DFS(Node cur, Node target, Set<Node> visited) {
    return true if cur is target;
    for (next : each neighbor of cur) {
        if (next is not in visited) {
            add next to visted;
            return true if DFS(next, target, visited) == true;
        }
    }
    return false;
}
```

It seems like we don't have to use any stacks when we implement DFS recursively. But actually, we are using the implicit stack provided by the system, also known as the [Call Stack](https://en.wikipedia.org/wiki/Call_stack).

## Template II

The advantage of the recursion solution is that it is easier to implement. However, there is a huge disadvantage: if the depth of recursion is too high, you will suffer from `stack overflow`. In that case, you might want to use BFS instead or implement DFS using an explicit stack.

Here we provide a template using an explicit stack:

```java
/*
 * Return true if there is a path from cur to target.
 */
boolean DFS(int root, int target) {
    Set<Node> visited;
    Stack<Node> stack;
    add root to stack;
    while (s is not empty) {
        Node cur = the top element in stack;
        remove the cur from the stack;
        return true if cur is target;
        for (Node next : the neighbors of cur) {
            if (next is not in visited) {
                add next to visited;
                add next to stack;
            }
        }
    }
    return false;
}
```

The logic is exactly the same with the recursion solution. But we use `while` loop and `stack` to simulate the `system call stack` during recursion. Running through several examples manually will definitely help you understand it better.

## References

[https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1384/](https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1384/)

[https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1385/](https://leetcode.com/explore/learn/card/queue-stack/232/practical-application-stack/1385/)
