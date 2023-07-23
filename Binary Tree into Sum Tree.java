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
	int toSumTree(Node node)
	{
		// Base case
		if (node == null)
			return 0;
		int old_val = node.data;
		node.data = toSumTree(node.left) + toSumTree(node.right);
		return node.data + old_val;
  }
	void printInorder(Node node)
	{
		if (node == null)
			return;
		printInorder(node.left);
		System.out.print(node.data + " ");
		printInorder(node.right);
	}
	public static void main(String args[])
	{
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(-1);
		tree.root.right = new Node(3);
		tree.root.left.left = new Node(4);
		tree.root.left.right = new Node(5);
		tree.root.right.left = new Node(-2);

		tree.toSumTree(tree.root);
		System.out.println("Required sum tree from the binary tree is:");
		tree.printInorder(tree.root);
	}
}
