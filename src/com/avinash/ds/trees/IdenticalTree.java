package com.avinash.ds.trees;

public class IdenticalTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(4);

        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(4);
        root1.right.left = new TreeNode(5);

        System.out.println(isSameTree(root, root1));
    }

    public static int isSameTree(TreeNode A, TreeNode B) {
        return isIdentical(A, B) ? 1 : 0;
    }

    private static boolean isIdentical(TreeNode A, TreeNode B) {
        if ((A == null && B != null) || (A != null && B == null)) {
            return false;
        } else if (A != null && B != null) {
            return A.val == B.val && isIdentical(A.left, B.left) && isIdentical(A.right, B.right);
        } else {
            return true;
        }
    }

}
