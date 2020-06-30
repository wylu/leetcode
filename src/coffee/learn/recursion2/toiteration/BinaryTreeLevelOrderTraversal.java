package coffee.learn.recursion2.toiteration;

import coffee.common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @File    :   BinaryTreeLevelOrderTraversal.java
 * @Time    :   2020/05/13 22:04:38
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> level = new ArrayList<>();
        TreeNode curTail = root, nextTail = null;
        while (!queue.isEmpty()) {
            root = queue.poll();
            level.add(root.val);
            if (root.left != null) {
                queue.offer(root.left);
                nextTail = root.left;
            }
            if (root.right != null) {
                queue.offer(root.right);
                nextTail = root.right;
            }
            if (root == curTail) {
                res.add(level);
                level = new ArrayList<>();
                curTail = nextTail;
            }
        }
        return res;
    }
}