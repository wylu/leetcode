package learn.binarytree.traverse;

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
 * @File    :   InorderTraversal.java
 * @Time    :   2020/03/26 13:43:00
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   (C)Copyright 2020, wylu-CHINA-SHENZHEN
 * @Desc    :
 */
public class InorderTraversal {
    private static void recursive(TreeNode root, List<Integer> res) {
        if (root == null) return;
        // 遍历左子树
        recursive(root.left, res);
        // 访问当前树的根结点
        res.add(root.val);
        // 遍历右子树
        recursive(root.right, res);
    }

    /**
     * 创建一个辅助栈：
     * 1.当前结点置为根结点
     * 2.如果当前结点不为空，则将最左路径的所有结点压入栈中
     * 3.弹出栈顶结点作为当前结点，将结点值追加到结果序列的尾部
     * 4.然后将当前结点置为当前结点的右子结点
     * 5.重复步骤2、3、4，直至当前结点为空且栈空
     *
     * @param root 树的根结点
     * @return 中序遍历结果
     */
    private static List<Integer> iterate(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            res.add(root.val);
            root = root.right;
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
        List<Integer> res = InorderTraversal.iterateTraversal(TreeNode.mkTreeFromPreAndIn(pre, in));
        System.out.println(res);
        res = InorderTraversal.recursiveTraversal(TreeNode.mkTreeFromPreAndIn(pre, in));
        System.out.println(res);
    }
}
