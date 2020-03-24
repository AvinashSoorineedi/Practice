package com.avinash.ds.trees;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {

	public static void main(String[] args) {
		
		Tree node = new Tree(1);
		node.left = new Tree(2);
		node.right = new Tree(3);
		
		node.left.left = new Tree(4);
		node.left.right = new Tree(5);
		
		printTree(node);
		
	}

	private static void printTree(Tree node) {
		
		Queue<Tree> treeQueue = new LinkedList<>();
		
		treeQueue.offer(node);
		
		while(!treeQueue.isEmpty()) {
			Tree temp = treeQueue.poll();
			
			if(temp!=null) {
				System.out.println("Data is "+temp.data);
			if(temp.left!=null) {
				treeQueue.offer(temp.left);
			}
			
			if(temp.right!=null) {
				treeQueue.offer(temp.right);
			}
			}
		}
		
	}
}

class Tree {
	int data;
	Tree left;
	Tree right;
	
	public Tree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	
}
