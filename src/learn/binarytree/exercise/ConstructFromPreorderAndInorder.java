package learn.binarytree.exercise;

import common.TreeNode;
import common.TreePrinter;

import java.util.HashMap;

/**
 * @File    :   ConstructFromPreorderAndInorder.java
 * @Time    :   2020/04/18 22:05:15
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class ConstructFromPreorderAndInorder {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, preorder, 0, preorder.length - 1, map);
    }

    private TreeNode build(int si, int[] pre, int sp, int ep, HashMap<Integer, Integer> map) {
        if (sp > ep) {
            return null;
        }
        TreeNode root = new TreeNode(pre[sp]);
        int idx = map.get(root.val);
        int leftLen = idx - si;
        root.left = build(si, pre, sp + 1, sp + leftLen, map);
        root.right = build(idx + 1, pre, sp + leftLen + 1, ep, map);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = new int[]{3, 9, 20, 15, 7};
        int[] in = new int[]{9, 3, 15, 20, 7};
        ConstructFromPreorderAndInorder construct = new ConstructFromPreorderAndInorder();
        TreeNode tree = construct.buildTree(pre, in);
        TreePrinter.prtHorizontalStyle(tree);
    }
}