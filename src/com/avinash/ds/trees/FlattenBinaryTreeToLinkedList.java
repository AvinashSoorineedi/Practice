package com.avinash.ds.trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class FlattenBinaryTreeToLinkedList {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);

        Queue<TreeNode> queue = new ArrayDeque<>();
        printRoot(flatten(root), queue);

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

    public static TreeNode flatten(TreeNode a) {
        if (a == null) {
            return null;
        }

        TreeNode left = flatten(a.left);
        TreeNode right = flatten(a.right);

        if (left != null && right != null) {
            TreeNode rightTemp = a.right;
            a.right = left;
            TreeNode leftTemp = left;
            a.left = null;
            while (leftTemp.right != null) {
                leftTemp = leftTemp.right;
            }
            leftTemp.right = rightTemp;
        } else if (left != null) {
            a.right = left;
            a.left = null;
        }

        return a;
    }

}
