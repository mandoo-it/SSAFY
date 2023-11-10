//package tree;
//
//import java.io.BufferedReader;
//import java.io.InputStreamReader;
//import java.util.Scanner;
//
//class Treein{
//	class Node{
//        int data;
//        Node left;
//        Node right;
//    }
//     
//    Node root;
//     
//    public void makeTree(int d1, int d2) {
//        if(root==null) {
//            root=new Node();
//            root.data=d1;
//        }
//        makeTree(root, d1, d2);
//    }
//    public Node makeTree(Node root, int d1, int d2) {
//        if(root==null) {
//            root=new Node();
//            root.data=d2;
//            return root;
//        }
//        if(root.data==d1) {
//            if(root.left==null)       root.left =makeTree(root.left, d1,d2);
//            else if(root.right==null) root.right=makeTree(root.right,d1,d2);
//            return root;
//        }
//        makeTree(root.left,d1,d2);
//        makeTree(root.right,d1,d2);
//        return root;
//    }
//    public void inorder(Node node) {
//        if(node!=null) {
//            inorder(node.left);
//            System.out.print(Solution_D4_중위순회_서울8반_윤규희.data[node.data]);
//            inorder(node.right);
//        }
//    }
//}
//public class 중의순회_teacher {
//    public static char[] data;
//    public static void main(String[] main) throws Exception {
//    	Scanner sc = new Scanner(System.in);
//    	
//    	a[i] = sa[1].charAt(0)
//    }
//}
