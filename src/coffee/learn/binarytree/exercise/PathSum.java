package coffee.learn.binarytree.exercise;

import coffee.common.TreeNode;
import coffee.common.TreePrinter;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @File    :   PathSum.java
 * @Time    :   2020/04/16 13:11:33
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   (C)Copyright 2020, wylu-CHINA-SHENZHEN
 * @Desc    :
 */
public class PathSum {
    private boolean sumRecursive(TreeNode root, int cur, int sum) {
        if (root == null) return false;
        cur += root.val;
        if (root.left == null && root.right == null) return cur == sum;
        boolean flag = false;
        if (root.left != null) flag = sumRecursive(root.left, cur, sum);
        if (!flag && root.right != null) flag = sumRecursive(root.right, cur, sum);
        return flag;
    }

    private boolean sumIterate(TreeNode root, int sum) {
        if (root == null) return false;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        HashMap<TreeNode, Integer> depthMap = new HashMap<>();
        depthMap.put(root, root.val);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int cur = depthMap.get(node);
            if (node.left == null && node.right == null) {
                if (cur == sum) return true;
                else continue;
            }
            if (node.left != null) {
                queue.offer(node.left);
                depthMap.put(node.left, cur + node.left.val);
            }
            if (node.right != null) {
                queue.offer(node.right);
                depthMap.put(node.right, cur + node.right.val);
            }
        }
        return false;
    }

    public boolean hasPathSum(TreeNode root, int sum) {
        return sumRecursive(root, 0, sum);
    }

    public static void main(String[] args) {
        int[] pre = new int[] {5, 4, 11, 7, 2, 8, 13, 4, 1};
        int[] in = new int[] {7, 11, 2, 4, 5, 13, 8, 4, 1};
        TreeNode tree = TreeNode.buildFromPreAndIn(pre, in);
        TreePrinter.prtHorizontalStyle(tree);
        PathSum pathSum = new PathSum();
        System.out.println(pathSum.hasPathSum(tree, 21));
        System.out.println(pathSum.hasPathSum(tree, 22));
        System.out.println(pathSum.sumIterate(tree, 21));
        System.out.println(pathSum.sumIterate(tree, 22));
    }
}