 //Top-View
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;
 
class Node {
    int data;
    Node left, right;
 
    public Node(int data)
    {
        this.data = data;
        left = right = null;
    }
}
 
class BinaryTree {
    Node root;
 
    public BinaryTree() { root = null; }
 
    private void TopView(Node root)
    {
        class QueueObj {
            Node node;
            int hd;
 
            QueueObj(Node node, int hd)
            {
                this.node = node;
                this.hd = hd;
            }
        }
        Queue<QueueObj> q = new LinkedList<QueueObj>();
        Map<Integer, Node> topViewMap
            = new TreeMap<Integer, Node>();
 
        if (root == null) {
            return;
        }
        else {
            q.add(new QueueObj(root, 0));
        }
 
        System.out.println(
            "The top view of the tree is : ");
 
        while (!q.isEmpty()) {
            QueueObj tmpNode = q.poll();
            if (!topViewMap.containsKey(tmpNode.hd)) {
                topViewMap.put(tmpNode.hd, tmpNode.node);
            }
 
            if (tmpNode.node.left != null) {
                q.add(new QueueObj(tmpNode.node.left,
                                   tmpNode.hd - 1));
            }
            if (tmpNode.node.right != null) {
                q.add(new QueueObj(tmpNode.node.right,
                                   tmpNode.hd + 1));
            }
        }
        for (Entry<Integer, Node> entry :
             topViewMap.entrySet()) {
            System.out.print(entry.getValue().data);
        }
    }
 
    public static void main(String[] args)
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.right = new Node(4);
        tree.root.left.right.right = new Node(5);
        tree.root.left.right.right.right = new Node(6);
        System.out.println(
            "Following are nodes in top view of Binary Tree");
        tree.TopView(tree.root);
    }
}


//Bottom-View

import java.util.Queue;
import java.util.TreeMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
class NodeObj   
{
            Node node;
            int hd;  
            NodeObj(Node node, int hd)
            {
                this.node = node;
                this.hd = hd;
            }
    
}
public class Tree
{
    Node root;

    void bottomView(Node root)
    {
        if (root == null)
        return;  
        
        Queue<NodeObj> queue = new LinkedList<NodeObj>();
        Map<Integer,Integer> bottomView = new TreeMap<>();
        queue.add(new NodeObj(root, 0));
       
        while (!queue.isEmpty())
        {
            NodeObj curr = queue.poll();  
            Node tempNode=curr.node;     
            int hd=curr.hd;             
            bottomView.put(hd,tempNode.data);
            if (tempNode.left != null)
            {
                queue.add(new NodeObj(tempNode.left, hd - 1));
            }
            
            if (tempNode.right != null)
            {
                queue.add(new NodeObj(tempNode.right, hd + 1));
            }
        }
        for (Entry<Integer, Integer> entry : bottomView.entrySet())
        {
            System.out.print(entry.getValue()+" ");
        }
    }
    
    public static void main(String[] args)
    {
      
        Tree tree = new Tree();
        tree.root = new Node(20);
        tree.root.left = new Node(10);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(15);
        tree.root.right = new Node(30);
        tree.root.right.left = new Node(25);
        tree.root.right.right = new Node(35);
        
        System.out.println("The Bottom View of Binary Tree is: ");
        System.out.println();
        
        tree.bottomView(tree.root);
    }
    
}
