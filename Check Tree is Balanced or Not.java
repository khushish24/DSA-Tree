class Tree
{

    boolean isBalanced(Node root)
    {
	if(root==null)
	    return true;
	return (Math.abs(height(root.left)-height(root.right))<=1) && isBalanced(root.left)&& isBalanced(root.right);
    }
    int height(Node root){
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
}
