import java.util.*;
class main {
	static class Node {
		int key;
		Node left, right;
	}
	static Node newNode(int item){
		Node temp = new Node();
		temp.key = item;
		temp.left = temp.right = null;
		return temp;
	}
	static void inorder(Node root){
		if(root != null){
			inorder(root.left);
			System.out.print(root.key+" ");
			inorder(root.right);
		}
	}
	static Node insert(Node node, int key){
		if(node == null)
			return newNode(key);
		if(key < node.key)
			node.left = insert(node.left, key);
		else 
			node.right = insert(node.right, key);
		return node;
	}
	public static void smallnum(Node root){
		Node newNode = root;
		while(newNode.left!=null)
			newNode = newNode.left;
		System.out.println("\nSmallest number in the order is "+newNode.key);
	}
	
	
	public static void main(String[] args){
		Node root = null;
		root = insert(root, 6);
		root = insert(root, 9);
		root = insert(root, 5);
		root = insert(root, 2);
		root = insert(root, 8);
		root = insert(root, 15);
		root = insert(root, 24);
		root = insert(root, 14);
		root = insert(root, 7);
		root = insert(root, 8);
		root = insert(root, 5);
		root = insert(root, 2);
		System.out.println("Inorder traversal of the given tree");
		inorder(root);
		smallnum(root);
	}
}