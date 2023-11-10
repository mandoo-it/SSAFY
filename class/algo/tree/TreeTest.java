package tree;

class Tree {
	Node root;
	class Node{
		char data;
		Node left, right;
	}
	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	public Node makeTree(Node left, char data, Node right) {
		Node node = new Node();
		node.left = left;
		node.data = data;
		node.right = right;
		return node;
	}
	public void preorder(Node node) {
		if(node != null) {
			System.out.print(node.data + " ");
			System.out.print(node.left);
			preorder(node.left);
			System.out.print(node.right);
			preorder(node.right);
		}
	}
	public void inorder(Node node) {
		if(node != null) {
			inorder(node.left);
			System.out.print(node.data + " ");
			inorder(node.right);
		}
	}
	public void postorder(Node node) {
		if(node != null) {
			postorder(node.left);
			postorder(node.right);
			System.out.print(node.data + " ");
			
		}
	}
}
public class TreeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Tree o = new Tree();
		//Tree.Node n1 = o.new Node();
		//n1.data = '1';		
		Tree t = new Tree();
		//중첩 클래스
		Tree.Node d = t.makeTree(null, 'D', null);
		Tree.Node h = t.makeTree(null, 'H', null);
		Tree.Node i = t.makeTree(null, 'I', null);
		Tree.Node f = t.makeTree(null, 'F', null);
		Tree.Node g = t.makeTree(null, 'G', null);
		Tree.Node e = t.makeTree(h, 'E', i);
		Tree.Node b = t.makeTree(d, 'B', e);
		Tree.Node c = t.makeTree(f, 'C', g);
		Tree.Node a = t.makeTree(b, 'A', c);
		t.setRoot(a);
		t.preorder(t.getRoot());s
		System.out.println();
		t.inorder(t.getRoot());
		System.out.println();
		t.postorder(t.getRoot());
	}

}
