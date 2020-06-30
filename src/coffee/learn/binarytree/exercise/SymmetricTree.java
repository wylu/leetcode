package coffee.learn.binarytree.exercise;

import coffee.common.TreeNode;
import coffee.common.TreePrinter;

import java.util.LinkedList;

/**
 * @File    :   SymmetricTree.java
 * @Time    :   2020/04/16 11:53:39
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   (C)Copyright 2020, wylu-CHINA-SHENZHEN
 * @Desc    :
 */
public class SymmetricTree {
    private boolean isMirrorRecursive(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.val == t2.val) && isMirrorRecursive(t1.left, t2.right)
                && isMirrorRecursive(t1.right, t2.left);
    }

    private boolean isMirrorIterate(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode t1 = queue.poll(), t2 = queue.poll();
            if (t1 == null && t2 == null) continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            queue.offer(t1.left);
            queue.offer(t2.right);
            queue.offer(t1.right);
            queue.offer(t2.left);
        }
        return true;
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isMirrorRecursive(root.left, root.right);
    }

    public static void main(String[] args) {
        int[] pre = new int[] {1, 2, 3, 4, 2, 4, 3};
        int[] in = new int[] {3, 2, 4, 1, 4, 2, 3};
        TreeNode tree = TreeNode.buildFromPreAndIn(pre, in);
        TreePrinter.prtHorizontalStyle(tree);
        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric(tree));
        System.out.println(symmetricTree.isMirrorIterate(tree));
    }
}