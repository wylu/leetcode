package coffee.learn.binarytree.exercise;

import coffee.common.TreeNode;
import coffee.common.TreePrinter;

import java.util.HashMap;

/**
 * @File    :   ConstructFromInorderAndPostorder.java
 * @Time    :   2020/04/18 21:22:38
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class ConstructFromInorderAndPostorder {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null || inorder.length != postorder.length) {
            return null;
        }
        HashMap<Integer, Integer> map = new HashMap<>(inorder.length);
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, postorder, 0, postorder.length - 1, map);
    }

    private TreeNode build(int si, int[] post, int sp, int ep, HashMap<Integer, Integer> map) {
        if (sp > ep) {
            return null;
        }
        TreeNode root = new TreeNode(post[ep]);
        int idx = map.get(root.val);
        int leftLen = idx - si;
        root.left = build(si, post, sp, sp + leftLen - 1, map);
        root.right = build(idx + 1, post, sp + leftLen, ep - 1, map);
        return root;
    }

    public static void main(String[] args) {
        int[] in = new int[] {9, 3, 15, 20, 7};
        int[] post = new int[] {9, 15, 7, 20, 3};
        ConstructFromInorderAndPostorder construct = new ConstructFromInorderAndPostorder();
        TreeNode tree = construct.buildTree(in, post);
        TreePrinter.prtHorizontalStyle(tree);
    }
}