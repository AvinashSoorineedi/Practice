package com.avinash.ds.trees;

public class SymmetricTree {

    /*
     * 1 1 2 2 2 2 4 4 4 4
     * 
     * 
     */
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(4);

        System.out.println(isSymmetric(root));
    }

    private static int isSymmetric(TreeNode A) {
        if (A == null) {
            return 1;
        }
        return isBoolSymmetric(A.left, A.right) ? 1 : 0;
    }

    private static boolean isBoolSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right==null) {
            return true;
        }
        return ((left != null && right != null && left.val == right.val)
            && isBoolSymmetric(left.left, right.right) && isBoolSymmetric(left.right, right.left));
    }

}
