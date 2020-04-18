package common;

import java.util.HashMap;

/**
 * @File    :   Node.java
 * @Time    :   2020/04/18 22:38:01
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node left, Node right, Node next) {
        this.val = val;
        this.left = left;
        this.right = right;
        this.next = next;
    }

    public static Node mkTree(int[] pre, int[] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>(in.length);
        for (int i = 0; i < in.length; i++) {
            map.put(in[i], i);
        }
        return mkTree(0, pre, 0, pre.length - 1, map);
    }

    private static Node mkTree(int si, int[] pre, int sp, int ep, HashMap<Integer, Integer> map) {
        if (sp > ep) {
            return null;
        }
        Node root = new Node(pre[sp], null, null, null);
        int idx = map.get(root.val);
        int leftLen = idx - si;
        root.left = mkTree(si, pre, sp + 1, sp + leftLen, map);
        root.right = mkTree(idx + 1, pre, sp + leftLen + 1, ep, map);
        return root;
    }
}