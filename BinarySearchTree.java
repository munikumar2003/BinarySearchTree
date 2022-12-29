import java.util.*;
class BinarySearchTree {
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
		if(root == null)
			return;
			inorder(root.left);
			System.out.print(root.key+" ");
			inorder(root.right);
	}
	static void preorder(Node node){
        if (node == null)
            return;
        System.out.print(node.key + " ");
        preorder(node.left);
        preorder(node.right);
    }
	static void postorder(Node node){
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.key + " ");
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
	static void search(Node node, int value){
		try{
		if(node == null)
			System.out.println("Node not found");
		if(value < node.key)
			search(node.left, value);
		else if(value > node.key) 
			search(node.right, value);
		if(node.key == value)
			System.out.println("Node Found in Tree");
		}catch(NullPointerException e){}
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
		System.out.println("\nPreorder traversal of the given tree");
		preorder(root);
		System.out.println("\nPostorder traversal of the given tree");
		postorder(root);
		smallnum(root);
		search(root, 14);
		search(root, 16);
	}
}
