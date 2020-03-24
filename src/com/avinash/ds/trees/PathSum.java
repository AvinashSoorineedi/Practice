package com.avinash.ds.trees;

import java.util.ArrayDeque;
import java.util.Deque;

public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);

        System.out.println(pathSum(root, 6));
    }

    public static int pathSum(TreeNode root, int value) {
        Deque<Integer> deque = new ArrayDeque<>();

        return calculatePathSum(root, value, deque);

    }

    private static int calculatePathSum(TreeNode root, int value, Deque<Integer> deque) {

        if (root == null) {
            return 0;
        }

        deque.addFirst(root.val);

        if (root.val == value) {
            int result = 0;
            while (!deque.isEmpty()) {
                result = result + deque.poll();
            }
            return result;
        }

        int left = calculatePathSum(root.left, value, deque);
        int right = calculatePathSum(root.right, value, deque);
        if (!deque.isEmpty()) {
            deque.removeFirst();
        }

        return Math.max(left, right);
    }

}
