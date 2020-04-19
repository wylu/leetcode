package learn.binary_tree.traverse;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * @File    :   PostorderTraversal.java
 * @Time    :   2020/03/26 14:13:08
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   (C)Copyright 2020, wylu-CHINA-SHENZHEN
 * @Desc    :
 */
public class PostorderTraversal {
    private static void recursive(TreeNode root, List<Integer> res) {
        if (root == null) return;
        // 遍历左子树
        recursive(root.left, res);
        // 遍历右子树
        recursive(root.right, res);
        // 访问当前树的根结点
        res.add(root.val);
    }

    private static List<Integer> iterate(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;

        // 借助栈实现迭代后序遍历二叉树
        LinkedList<TreeNode> stack = new LinkedList<>();
        // 记录上一个访问的结点，用于判断“访问根结点之前，右子树是否已访问过”
        TreeNode last = null;
        while (root != null || !stack.isEmpty()) {
            // 确保先遍历未曾访问过的最左结点
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.peek();
            if (root.right == null || root.right == last) {
                root = stack.pop();
                res.add(root.val);
                last = root;
                // 表示当前root下已经没有未曾访问的结点了
                root = null;
            } else {
                root = root.right;
            }
        }
        return res;
    }

    public static List<Integer> recursiveTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        recursive(root, res);
        return res;
    }

    public static List<Integer> iterateTraversal(TreeNode root) {
        return iterate(root);
    }

    public static void main(String[] args) {
        int[] pre = new int[] {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 16, 15};
        int[] in = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        List<Integer> res = PostorderTraversal.iterateTraversal(TreeNode.mkTreeFromPreAndIn(pre, in));
        System.out.println(res);
        res = PostorderTraversal.recursiveTraversal(TreeNode.mkTreeFromPreAndIn(pre, in));
        System.out.println(res);
    }
}
