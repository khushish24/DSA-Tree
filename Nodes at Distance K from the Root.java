class Node
{
	int data;
	Node left, right;

	Node(int item)
	{
		data = item;
		left = right = null;
	}
}

class BinaryTree
{
	Node root;

	void printKDistant(Node node, int k)
	{
		if (node == null|| k < 0 )
			return;
		if (k == 0)
		{
			System.out.print(node.data + " ");
			return;
		}
			printKDistant(node.left, k - 1);
			printKDistant(node.right, k - 1);
		
	}
	
	public static void main(String args[]) {
		BinaryTree tree = new BinaryTree();
		
		tree.root = new Node(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(8);

		tree.printKDistant(tree.root, 2);
	}
}
