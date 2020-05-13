package learn.recursion2.toiteration;

import common.TreeNode;

import java.util.LinkedList;

/**
 * @File    :   SameTree.java
 * @Time    :   2020/05/13 21:28:13
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;

        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(p);
        queue.offer(q);
        while (!queue.isEmpty()) {
            p = queue.poll();
            q = queue.poll();
            if (!check(p.left, q.left)) return false;
            if (p.left != null) {
                queue.offer(p.left);
                queue.offer(q.left);
            }

            if (!check(p.right, q.right)) return false;
            if (p.right != null) {
                queue.offer(p.right);
                queue.offer(q.right);
            }
        }
        return true;
    }

    private boolean check(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return true;
    }
}