package com.avinash.ds.trees;

import java.util.ArrayList;

public class InOrderTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        System.out.println(preorderTraversal(root));
    }

    public static ArrayList<Integer> preorderTraversal(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        performPreorderTraversal(A, result);
        return result;
    }

    private static void performPreorderTraversal(TreeNode root, ArrayList<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        performPreorderTraversal(root.left, result);
        performPreorderTraversal(root.right, result);
    }
}
