package com.avinash.ds.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class TreePaths {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        printPathToLeafs(root);
    }

    public static void printPathToLeafs(TreeNode root) {
        Deque<Integer> queue = new ArrayDeque<>();
        printPathToLeafs(root, queue);
    }

    private static void printPathToLeafs(TreeNode root, Deque<Integer> queue) {

        if (root == null) {
            return;
        }

        queue.offerFirst(root.val);
        if (root.left == null && root.right == null) {
            System.out.println(queue);
        }

        printPathToLeafs(root.left, queue);

        printPathToLeafs(root.right, queue);

        queue.removeFirst();

    }

}
