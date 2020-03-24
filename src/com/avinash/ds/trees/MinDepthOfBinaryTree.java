package com.avinash.ds.trees;

public class MinDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(6);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(5);
//        root.right.right = new TreeNode(6);
//        root.left.left.left = new TreeNode(7);

        System.out.println(minDepth(root));
    }

    public static int minDepth(TreeNode A) {
        return Math.min(checkHeight(A.left), checkHeight(A.right));
    }

    private static int checkHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(checkHeight(root.left), checkHeight(root.right));
    }

}
