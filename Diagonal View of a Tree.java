import java.util.*;
public class solution
{

static class Node {
	int data;
	Node left, right;
}
static Node newNode(int data)
{
	Node node = new Node();
	node.data = data;
	node.left = node.right = null;
	return (node);
}
static void diagonalPrint(Node root)
{

	if (root == null)
		return;

	Queue<Node> q= new LinkedList<Node>();

	q.add(root);
	q.add(null);

	while (q.size()>0) {
		Node temp = q.peek();
		q.remove();
		if (temp == null) {
			if (q.size()==0)
				return;
			System.out.println();

			q.add(null);
		}
		else {
			while (temp!=null) {
				System.out.print( temp.data + " ");

				if (temp.left!=null)
					q.add(temp.left);

				temp = temp.right;
			}
		}
	}
}

public static void main(String args[])
{
	Node root = new Node(100);
		root.left = new Node(200);
		root.right = new Node(300);
		root.left.left = new Node(1);
		root.left.right = new Node(60);
		root.right.right = new Node(160);
		root.left.right.left = new Node(2);
		root.left.right.right = new Node(99);
   diagonalPrint(root);
}
}
