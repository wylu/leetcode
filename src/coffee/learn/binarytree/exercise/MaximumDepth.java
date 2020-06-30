package coffee.learn.binarytree.exercise;

import coffee.common.TreeNode;
import coffee.common.TreePrinter;

/**
 * @File    :   MaximumDepth.java
 * @Time    :   2020/04/16 11:33:03
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   (C)Copyright 2020, wylu-CHINA-SHENZHEN
 * @Desc    :
 */
public class MaximumDepth {

    private int depth = 0;

    private void topDown(TreeNode root, int cur) {
        if (root == null) {
            return;
        }

        cur++;
        if (root.left == null && root.right == null) {
            this.depth = cur > this.depth ? cur : this.depth;
            return;
        }
        this.topDown(root.left, cur);
        this.topDown(root.right, cur);
    }

    private int bottomUp(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = this.bottomUp(root.left);
        int right = this.bottomUp(root.right);
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};
        TreeNode tree = TreeNode.mkTreeFromPreAndIn(pre, in);
        TreePrinter.prtHorizontalStyle(tree);

        MaximumDepth maximumDepth = new MaximumDepth();
        maximumDepth.topDown(tree, 0);
        System.out.println(maximumDepth.depth);
        System.out.println(maximumDepth.bottomUp(tree));
    }
}