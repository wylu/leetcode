package coffee.learn.binarytree.traverse;

import coffee.common.TreeNode;

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
 * @File    :   PreorderTraversal.java
 * @Time    :   2020/03/23 17:39:43
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   (C)Copyright 2020, wylu-CHINA-SHENZHEN
 * @Desc    :
 */
class PreorderTraversal {
    private static void recursive(TreeNode root, List<Integer> res) {
        if (root == null) return;
        // 访问当前树的根结点
        res.add(root.val);
        // 遍历左子树
        recursive(root.left, res);
        // 遍历右子树
        recursive(root.right, res);
    }

    /**
     * 创建一个辅助栈：
     * 1.将根结点压入栈
     * 2.弹出栈顶结点，将结点值追加到结果序列的尾部
     * 3.然后先将右子结点压入栈中（如果有）
     * 4.再将左子结点压入栈中（如果有）
     * 5.重复步骤2、3、4，直至栈空
     *
     * @param root 树的根结点
     * @return 前序遍历结果
     */
    private static List<Integer> iterate(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) return res;
        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            res.add(root.val);
            if (root.right != null) stack.push(root.right);
            if (root.left != null) stack.push(root.left);
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
        List<Integer> res = PreorderTraversal.iterateTraversal(TreeNode.mkTreeFromPreAndIn(pre, in));
        System.out.println(res);
        res = PreorderTraversal.recursiveTraversal(TreeNode.mkTreeFromPreAndIn(pre, in));
        System.out.println(res);
    }
}