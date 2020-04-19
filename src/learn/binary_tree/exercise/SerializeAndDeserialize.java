package learn.binary_tree.exercise;

import common.TreeNode;
import common.TreePrinter;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @File    :   SerializeAndDeserialize.java
 * @Time    :   2020/04/19 23:05:54
 * @Author  :   wylu
 * @Version :   1.0
 * @Contact :   15wylu@gmail.com
 * @License :   Copyright © 2020, wylu-CHINA-SHENZHEN. All rights reserved.
 * @Desc    :
 */
public class SerializeAndDeserialize {
    // Your Codec object will be instantiated and called as such:
    // Codec codec = new Codec();
    // codec.deserialize(codec.serialize(root));

    private static final String DELIMITER = ",";
    private static final String PADDING = "$";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(PADDING).append(DELIMITER);
        } else {
            sb.append(root.val).append(DELIMITER);
            serialize(root.left, sb);
            serialize(root.right, sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split(DELIMITER)));
        return deserialize(queue);
    }

    private TreeNode deserialize(LinkedList<String> queue) {
        String val = queue.poll();
        if (PADDING.equals(val)) {
            return null;
        } else {
            TreeNode root = new TreeNode(Integer.valueOf(val));
            root.left = deserialize(queue);
            root.right = deserialize(queue);
            return root;
        }
    }

    public static void main(String[] args) {
        int[] pre = new int[]{1, 2, 3, 4, 5};
        int[] in = new int[]{2, 1, 4, 3, 5};
        TreeNode tree = TreeNode.buildFromPreAndIn(pre, in);
        TreePrinter.prtHorizontalStyle(tree);
        SerializeAndDeserialize serialAndDeserial = new SerializeAndDeserialize();
        tree = serialAndDeserial.deserialize(serialAndDeserial.serialize(tree));
        TreePrinter.prtHorizontalStyle(tree);
    }
}