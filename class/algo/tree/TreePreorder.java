package tree;

import java.util.Scanner;

class Tree22{
	class Node{
		char data;
		Node left, right;
	}
	Node root;
	
	public void makeTree(char d1, char d2) {
		if(root == null) {
			root = new Node();
			root.data = d1;
		}
		makeTree(root,d1,d2);
	}
	
	public Node makeTree(Node root, char d1, char d2) {
		if(root == null) {
			root = new Node();
			root.data = d2;
			return root;
		}
		if(root.data == d1) {
			if(root.left == null) root.left = makeTree(root.left, d1, d2);
			else if(root.right == null) root.right = makeTree(root.right, d1, d2);
			return root;
		}
		makeTree(root.left, d1, d2);
		makeTree(root.right, d1, d2);
		return root;
		
	}
	
	public void preorder(Node node) {
		if(node != null) {
			System.out.print(node.data + " ");
			preorder(node.left);
			preorder(node.right);
		}
	}
}


public class TreePreorder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N =sc.nextInt();
		
		Tree22 t = new Tree22();
		for(int i=0; i<N-1; i++){
			char d1 = sc.next().charAt(0); // 내 자신  a
			char d2 = sc.next().charAt(0); // 자식  b
			t.makeTree(d1, d2);
		}
		t.preorder(t.root);

	}

}
