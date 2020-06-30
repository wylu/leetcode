package coffee.common;

/**
 * @File : TreePrinter.java
 * @Time : 2020/03/23 17:47:57
 * @Author : wylu
 * @Version : 1.0
 * @Contact : 15wylu@gmail.com
 * @License : (C)Copyright 2020, wylu-CHINA-SHENZHEN
 * @Desc :
 */
public class TreePrinter {
    private static void linuxStyle(TreeNode root, StringBuilder sb, String prefix, String childPrefix) {
        if (root == null) {
            return;
        }
        sb.append(prefix);
        sb.append(root.val);
        sb.append("\n");
        linuxStyle(root.right, sb, childPrefix + "├── ", childPrefix + "│   ");
        linuxStyle(root.left, sb, childPrefix + "└── ", childPrefix + "    ");
    }

    public static StringBuilder getLinuxStyle(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        linuxStyle(root, sb, "", "");
        return sb;
    }

    /**
     * z
     * ├── c
     * │ ├── a
     * │ └── b
     * └── d
     *
     * @param root
     */
    public static void prtLinuxStyle(TreeNode root) {
        System.out.println(getLinuxStyle(root).toString());
    }

    public static StringBuilder horizontalStyle(TreeNode root, StringBuilder sb) {
        if (root.right != null) {
            horizontalStyle(root.right, sb, true, "");
        }
        sb.append(root.val).append("\n");
        if (root.left != null) {
            horizontalStyle(root.left, sb, false, "");
        }
        return sb;
    }

    private static void horizontalStyle(TreeNode root, StringBuilder sb, boolean isRight,
            String indent) {
        if (root.right != null) {
            horizontalStyle(root.right, sb, true, indent + (isRight ? "        " : " |      "));
        }
        sb.append(indent);
        sb.append(isRight ? " /" : " \\");
        sb.append("----- ");
        sb.append(root.val).append("\n");
        if (root.left != null) {
            horizontalStyle(root.left, sb, false, indent + (isRight ? " |      " : "        "));
        }
    }

    /**
     *                 /----- 20
     *                 |       \----- 15
     *         /----- 14
     *         |       \----- 13
     * /----- 12
     * |       |       /----- 11
     * |       \----- 10
     * |               \----- 9
     * 8
     * |              /----- 7
     * |      /----- 6
     * |      |       \----- 5
     * \----- 4
     *        |       /----- 3
     *        \----- 2
     *                \----- 1
     *
     * @param root
     */
    public static void prtHorizontalStyle(TreeNode root) {
        System.out.println(horizontalStyle(root, new StringBuilder()).toString());
    }

    public static void main(String[] args) {
        // Case 1
        System.out.println("Case 1: -------------------------------------------");
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode root = TreeNode.mkTreeFromPreAndIn(pre, in);
        TreePrinter.prtLinuxStyle(root);
        TreePrinter.prtHorizontalStyle(root);

        // Case 2
        System.out.println("Case 2: -------------------------------------------");
        int[] post = {7, 4, 2, 5, 8, 6, 3, 1};
        root = TreeNode.mkTreeFromInAndPost(in, post);
        TreePrinter.prtLinuxStyle(root);
        TreePrinter.prtHorizontalStyle(root);

        // Case 3
        System.out.println("Case 3: -------------------------------------------");
        pre = new int[] {8, 4, 2, 1, 3, 6, 5, 7, 12, 10, 9, 11, 14, 13, 20, 15};
        in = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 20};
        root = TreeNode.mkTreeFromPreAndIn(pre, in);
        TreePrinter.prtLinuxStyle(root);
        TreePrinter.prtHorizontalStyle(root);

        // Case 4
        System.out.println("Case 4: -------------------------------------------");
        post = new int[] {1, 3, 2, 5, 7, 6, 4, 9, 11, 10, 13, 15, 20, 14, 12, 8};
        root = TreeNode.mkTreeFromInAndPost(in, post);
        TreePrinter.prtLinuxStyle(root);
        TreePrinter.prtHorizontalStyle(root);
    }
}
