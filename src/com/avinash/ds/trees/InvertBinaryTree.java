package com.avinash.ds.trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class InvertBinaryTree {

    public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
            root.right.left = new TreeNode(6);
            root.right.right = new TreeNode(7);

        Queue<TreeNode> queue = new ArrayDeque<>();
        printRoot(invertTree(root), queue);
    }

    private static void printRoot(TreeNode root, Queue<TreeNode> queue) {

        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.println(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
    }

    public static TreeNode invertTree(TreeNode A) {

        if (A == null) {
            return null;
        }

        TreeNode left = invertTree(A.left);
        TreeNode right = invertTree(A.right);

        if (left != null && right != null) {
            A.right = left;
            A.left = right;
        }

        return A;

    }

}