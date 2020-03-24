package com.avinash.ds.trees;

public class BalancedBinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.left.left = new TreeNode(6);

        System.out.println(isBalanced(root));

    }

    public static int isBalanced(TreeNode A) {
        if (A == null) {
            return 1;
        }
        if (Math.abs(getHeight(A.left)-getHeight(A.right)) <= 1 && isBalanced(A.left) == 1 && isBalanced(A.right) == 1) {
            return 1;
        }
        return 0;
    }

    public static int getHeight(TreeNode A) {
        if (A == null) {
            return 0;
        }
        return 1 + Math.max(getHeight(A.left), getHeight(A.right));
    }

}
