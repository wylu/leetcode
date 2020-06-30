package coffee.learn.binarytree.traverse;

import coffee.common.TreeNode;
import coffee.common.TreePrinter;

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
    /**
     * 1.使用两个指针，curTail指向当前层的最右结点，nextTail指向下一层的最右结点；
     *   创建辅助队列，将根结点压入队列中
     * 2.如果当前结点的左子结点不为空，则左子结点入队列，并更新nextTail
     * 3.如果当前结点的右子结点不为空，则右子结点入队列，并更新nextTail
     * 4.如果当前结点已是当前层的最右结点，则将curTail更新为nextTail
     * 5.重复步骤2、3、4，直至队列空
     *
     * @param root 树的根结点
     * @return 层次遍历结果
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;

        TreeNode curTail = root, nextTail = null;
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        List<Integer> level = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            level.add(node.val);
            if (node.left != null) {
                queue.offer(node.left);
                nextTail = node.left;
            }
            if (node.right != null) {
                queue.offer(node.right);
                nextTail = node.right;
            }
            if (node == curTail) {
                res.add(level);
                level = new ArrayList<>();
                curTail = nextTail;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] pre = new int[] {3, 9, 20, 15, 7};
        int[] in = new int[] {9, 3, 15, 20, 7};
        TreeNode tree = TreeNode.mkTreeFromPreAndIn(pre, in);
        TreePrinter.prtHorizontalStyle(tree);
        List<List<Integer>> res = levelOrder(tree);
        System.out.println(res);
    }
}