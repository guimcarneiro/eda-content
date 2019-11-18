package data_structures;

import java.util.Deque;
import java.util.LinkedList;

public class BinarySearchTree {

	private BSTNode root;
	
	public boolean isEmpty() {
		return root == null;
	}
	
	public void insert(int value) {
		
		if(this.isEmpty()) {
			this.root = new BSTNode(value);
		}else {
			if(value > this.root.getValue()) {
				if(this.root.getRight() == null) {
					BSTNode newNode = new BSTNode(value);
					newNode.setParent(this.root);
					this.root.setRight(newNode);
				}else {
					insert(this.root.getRight(), value);
				}
			}else if(value < this.root.getValue()) {
				if(this.root.getLeft() == null) {
					BSTNode newNode = new BSTNode(value);
					newNode.setParent(this.root);
					this.root.setLeft(newNode);
				}else {
					insert(this.root.getLeft(), value);
				}
			}
		}
	}
	
	private void insert(BSTNode node, int value) {
		if(value > node.getValue()) {
			if(node.getRight() == null) {
				BSTNode newNode = new BSTNode(value);
				newNode.setParent(node);
				node.setRight(newNode);
			}else {
				insert(node.getRight(), value);
			}
		}else {
			if(node.getLeft() == null) {
				BSTNode newNode = new BSTNode(value);
				newNode.setParent(node);
				node.setLeft(newNode);
			}else {
				insert(node.getLeft(), value);
			}
		}
	}
	
	public BSTNode search(int value) {
		return search(this.root, value);
	}
	
	private BSTNode search(BSTNode node, int value) {
		if(node == null)
			return null;
		else if(node.getValue() == value)
			return node;
		else if(node.getValue() < value)
			return search(node.getRight(), value);
		else
			return search(node.getLeft(), value);
	}
	
	public BSTNode max() {
		if(isEmpty())
			return null;
		return max(this.root);
	}
	
	private BSTNode max(BSTNode node) {
		if(node.getRight() == null)
			return node;
		return max(node.getRight());
	}
	
	public BSTNode min() {
		if(isEmpty())
			return null;
		return min(this.root);
	}
	
	private BSTNode min(BSTNode node) {
		if(node.getLeft() == null)
			return node;
		return min(node.getLeft());
	}
	
	public BSTNode predecessor(int value) {
		BSTNode node = search(value);
		
		if(node == null)
			return null;
		
		if(node.getLeft() == null)
			return predecessor(node.getParent(), value);
		return max(node.getLeft());
	}
	
	private BSTNode predecessor(BSTNode node, int value) {
		if(node == null) {
			return null;
		}
		if(node.getValue() < value)
			return node;
		return predecessor(node.getParent(), value);
	}
	
	public BSTNode sucessor(int value) {
		BSTNode node = search(value);
		
		if(node == null)
			return null;
		
		if(node.getRight() == null)
			return sucessor(node.getParent(), value);
		return min(node.getRight());
	}
	
	private BSTNode sucessor(BSTNode node, int value) {
		if(node == null)
			return null;
		if(node.getValue() > value)
			return node;
		return sucessor(node.getParent(), value);
	}
	
	private BSTNode sucessor(BSTNode node) {
		if(node == null)
			return null;
		return sucessor(node, node.getValue());
	}
	
	public int height() {
		return height(this.root);
	}
	
	private int height(BSTNode node) {
		if(node == null)
			return -1;
		else
			return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
	}
	
	public void remove(int value) {
		if(isEmpty())
			return;
		
		BSTNode node = search(value);
		if(node == null)
			return;
		
		remove(node);
	}
	
	public void remove(BSTNode node) {
		 if(node.isLeaf()) {
			 if(node.getValue() < node.getParent().getValue()) {
				 node.getParent().setLeft(null);
			 }else {
				 node.getParent().setRight(null);
			 }
		 }else if(node.hasOnlyLeftChild()) {
			 node.getLeft().setParent(node.getParent());
			 if(node.getValue() < node.getParent().getValue()) 
				 node.getParent().setLeft(node.getLeft());
			 else 
				 node.getParent().setRight(node.getLeft());
			 
		 }else if(node.hasOnlyRightChild()) {
			 node.getRight().setParent(node.getParent());
			 if(node.getValue() < node.getParent().getValue())
				 node.getParent().setLeft(node.getRight());
			 else
				 node.getParent().setRight(node.getRight());
		 }else {
			 BSTNode sucessor = sucessor(node);
			 node.setValue(sucessor.getValue());
			 remove(sucessor);
		 }
		 
		 
	}
	
	public void preOrder() {
		preOrder(this.root);
	}
	
	private void preOrder(BSTNode node) {
		if(node != null) {
			System.out.println(node);
			preOrder(node.getLeft());
			preOrder(node.getRight());
		}
	}
	
	public void inOrder() {
		inOrder(this.root);
	}
	
	private void inOrder(BSTNode node) {
		if(node != null) {
			inOrder(node.getLeft());
			System.out.println(node.getValue());
			inOrder(node.getRight());
		}
	}
	
	public void posOrder() {
		posOrder(this.root);
	}
	
	private void posOrder(BSTNode node) {
		if(node != null) {
			posOrder(node.getLeft());
			posOrder(node.getRight());
			System.out.println(node.getValue());
		}
	}
	
	public void printBFS() {
		Deque<BSTNode> queue = new LinkedList<BSTNode>();
		
		if(!this.isEmpty()) {
			queue.addLast(this.root);
			while(!queue.isEmpty()) {
				BSTNode atual = queue.removeFirst();
				
				System.out.println(atual.getValue());
				
				if(atual.getLeft() != null)
					queue.addLast(atual.getLeft());
				if(atual.getRight() != null)
					queue.addLast(atual.getRight());
			}
		}
	}
	
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		System.out.println("adding nodes: ");
		int[] array = new int[] {5,10,12,3,6,84,76,8,2};
		
		for(int element: array) {
			System.out.println("insert: " + element);
			bst.insert(element);
		}
		
		for(int element: array) {
			System.out.println("Search " + element + ": " + bst.search(element).getValue());
		}
		
		System.out.println("Min: " + bst.min().getValue());
		System.out.println("Max: " + bst.max().getValue());
		
		for(int element: array) {
			if(bst.predecessor(element) == null) {
				System.out.println("Predecessor of " + element + ": " + null);
			}else {				
				System.out.println("Predecessor of " + element + ": " + bst.predecessor(element).getValue());
			}
		}
		
		for(int element: array) {
			if(bst.sucessor(element) == null) {
				System.out.println("Sucessor of " + element + ": " + null);
			}else {	
				System.out.println("Sucessor of " + element + ": " + bst.sucessor(element).getValue());
			}
		}
		
		System.out.println("Height of bst: " + bst.height());
		
		
	}
	
}

class BSTNode {
	
	private int value;
	private BSTNode left;
	private BSTNode right;
	private BSTNode parent;
	
	public BSTNode(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public BSTNode getLeft() {
		return left;
	}

	public void setLeft(BSTNode left) {
		this.left = left;
	}

	public BSTNode getRight() {
		return right;
	}

	public void setRight(BSTNode right) {
		this.right = right;
	}

	public BSTNode getParent() {
		return parent;
	}

	public void setParent(BSTNode parent) {
		this.parent = parent;
	}
	
	public boolean isLeaf() {
		return (this.right == null && this.left == null);
	}
	
	public boolean hasOnlyLeftChild() {
		return (this.left != null && this.right == null);
	}
	
	public boolean hasOnlyRightChild() {
		return (this.left == null && this.right != null);
	}
	
}
