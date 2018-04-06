package DataStructures.BinaryTree;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/inorder-tree-traversal-without-recursion/
 * Created by ag877r on 1/31/2018.
 */
public class InorderTraversal {
    private Stack<Node> s;
    private Node root;

    public InorderTraversal (){
        root = null;
    }

    private void traverse (){
        s = new Stack();
        Node node = root;
        //Push the root into the stack
        s.push(node);

        // Push everything that is in the left most branch
        while(node.left != null) {
            s.push(node.left);
            node = node.left;
        }

        // Go right until the stack is empty
        while(!s.empty()){
            //pop the left most element
            node = s.pop();
            System.out.println(node.data);
            // Check if there is anything to the left
            if(node.right != null){
                node = node.right;
                // Explore to the left again
                while(node != null){
                    // Push the curr onto stack and try to go left
                    s.push(node);
                    node = node.left;
                }
            }
        }

    }

    public static void main(String[] args){
        InorderTraversal it = new InorderTraversal();
        Node root = new Node(1);
        it.root = root;
        it.root.left = new Node(2);
        it.root.right = new Node(3);
        it.root.left.left = new Node(4);
        it.root.left.right = new Node(5);

        it.traverse();
    }

}
