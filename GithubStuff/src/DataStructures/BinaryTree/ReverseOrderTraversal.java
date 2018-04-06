package DataStructures.BinaryTree;

import java.util.Stack;

/**
 * Created by ag877r on 2/2/2018.
 */
public class ReverseOrderTraversal {
    Stack<Node> s1 ;
    Stack<Node> s2 ;
    Node root;

    public void traverse(){
        s1 = new Stack();
        s2 = new Stack();

        // Do inorder traversal and put items into s1
        Node curr = root;
        s1.push(curr);

        // Put all left elements in s1
        while (curr.left != null) {
            s1.push(curr.left);
            curr = curr.left;
        }
        // Start popping node into s2 while doing inorder
        while(!s1.empty()){
            curr = s1.pop();
            s2.push(curr);

            // Check if curr has a right child
            if(curr.right != null){
                s1.push(curr.right);
                curr = curr.right;
            }
            // Try to go left again
            while(curr.left != null){
                s1.push(curr.left);
                curr = curr.left;
            }
        }

        //Now print all items in s2. Will come out as post-order
        while(!s2.empty()){
            curr = s2.pop();
            System.out.println(curr.data);
        }
    }


    public static void main(String[] args){
        ReverseOrderTraversal pot = new ReverseOrderTraversal();
        pot.root = new Node(1);
        pot.root.left = new Node(2);
        pot.root.right = new Node(3);
        pot.root.left.left = new Node(4);
        pot.root.left.right = new Node(5);

        pot.traverse();

    }
}
