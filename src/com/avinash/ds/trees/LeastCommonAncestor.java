package com.avinash.ds.trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class LeastCommonAncestor {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(lca(root, 2, 3));
    }

    public static int lca(TreeNode A, int B, int C) {

        List<Integer> firstNodePath = getNodePathFromRoot(A, B);
        List<Integer> secondNodePath = getNodePathFromRoot(A, C);
        int minSizeInTwoLists = Math.min(firstNodePath.size(), secondNodePath.size());

        int leastCommonAncestor = -1;

        for (int k = 0; k < minSizeInTwoLists; k++) {
            if (firstNodePath.get(k).equals(secondNodePath.get(k))) {
                leastCommonAncestor = firstNodePath.get(k);
            }
        }
        return leastCommonAncestor;
    }

    private static List<Integer> getNodePathFromRoot(TreeNode root, int i) {

        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        getNodePathFromRoot(root, i, deque, list);
        return list;
    }

    private static void getNodePathFromRoot(TreeNode root, int i, Deque<Integer> deque, List<Integer> list) {
        if (root == null) {
            return;
        }
        deque.offerLast(root.val);
        if (root.val == i) {
            Iterator<Integer> itr = deque.iterator();
            while (itr.hasNext()) {
                list.add(itr.next());
            }
        }
        getNodePathFromRoot(root.left, i, deque, list);
        getNodePathFromRoot(root.right, i, deque, list);
        deque.removeLast();
    }
}