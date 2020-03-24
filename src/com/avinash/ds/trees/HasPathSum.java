package com.avinash.ds.trees;

public class HasPathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        System.out.println(hasPathSum(root, 220));
    }

    public static int hasPathSum(TreeNode A, int B) {
        return calculatePathSums(A, B) ? 1 : 0;
    }

    private static boolean calculatePathSums(TreeNode root, int B) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return root.val == B;
        }

        return (calculatePathSums(root.left, B - root.val) || calculatePathSums(root.right, B - root.val));

    }
}
