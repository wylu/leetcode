package common;

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
        if (root == null) return;
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
     * @param root
     */
    public static void prtHorizontalStyle(TreeNode root) {

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

    private static void horizontalStyle(TreeNode root, StringBuilder sb, boolean isRight, String indent) {
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
}