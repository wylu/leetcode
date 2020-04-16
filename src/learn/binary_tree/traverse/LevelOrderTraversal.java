package learn.binary_tree.traverse;

import common.Tree;
import common.TreeNode;
import common.TreePrinter;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @File    :   LevelOrderTraversal.java
 * @Time    :   2020/04/16 10:40:31
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   (C)Copyright 2020, wylu-CHINA-SHENZHEN
 * @Desc    :
 */
public class LevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        TreeNode cur = root;
        TreeNode next = null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            level.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                next = node.left;
            }
            if (node.right != null) {
                queue.offer(node.right);
                next = node.right;
            }
            if (node == cur) {
                res.add(level);
                level = new ArrayList<>();
                cur = next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] pre = new int[] {3, 9, 20, 15, 7};
        int[] in = new int[] {9, 3, 15, 20, 7};
        TreeNode tree = Tree.mkTree(pre, in);
        TreePrinter.prtHorizontalStyle(tree);
        List<List<Integer>> res = levelOrder(tree);
        System.out.println(res);
    }
}