package tree;

class Tree{
	class Node{ //중첩클래스
		char data;
		Node left, right;
	}
	Node root;

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	public Node makeTree(Node left, char data, Node right) {
		Node node = new Node();
		node.data = data;
		node.left = left;
		node.right = right;
		return node;
	}
	public void preorder(Node node) {
		if(node != null) {
			System.out.print(node.data + " ");
			preorder(node.left);
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
		/*Tree o = new Tree();
		Tree.Node n1 = o.new Node();
		n1.data = 'A';
		n1.left = null;
		n1.right = null;
		
		Tree.Node n2 = new Tree().new Node();
		n2.data = 'B';
		n2.left = null;
		n2.right = null;*/
		
		Tree t = new Tree();
		
		/*Tree.Node d = t.makeTree(null, 'D', null); //Tree.Node 중첩클래스의 타입. or import 해주면 됨
		Tree.Node h = t.makeTree(null, 'H', null);
		Tree.Node i = t.makeTree(null, 'I', null);
		Tree.Node f = t.makeTree(null, 'F', null);
		Tree.Node g = t.makeTree(null, 'G', null);
		
		Tree.Node e = t.makeTree(h, 'E', i);
		Tree.Node b = t.makeTree(d, 'B', e);
		Tree.Node c = t.makeTree(f, 'C', g);*/
		
		//Tree.Node a = t.makeTree(b, 'A', c);
		
		//t.setRoot(a);
		
		Tree.Node r = t.getRoot();
		t.preorder(r);
		System.out.println();
		t.inorder(r);
		System.out.println();
		t.postorder(r);

	}
}
