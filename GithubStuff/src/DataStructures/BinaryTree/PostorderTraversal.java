package DataStructures.BinaryTree;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/iterative-postorder-traversal/
 * Created by ag877r on 2/2/2018.
 */
public class PostorderTraversal {
    Stack<Node> s1;
    Stack<Node> s2;
    Node root;

    public void traverse(){
        s1 = new Stack();
        s2 = new Stack();

        Node curr = root;

        s1.push(curr);

        // While there are still items pop an item off
        while(!s1.empty()){
            curr = s1.pop();
            //put that item into s2
            s2.push(curr);
            //If the currnet node has children, push them to s1
            if(curr.left != null){
                s1.push(curr.left);
            }
            if(curr.right != null){
                s1.push(curr.right);
            }
        }
        while(!s2.empty()){
            curr = s2.pop();
            System.out.println(curr.data);
        }

    }

    public static void main(String[] args){
        PostorderTraversal pot = new PostorderTraversal();
        Node root = new Node(1);
        pot.root = root;
        pot.root.left = new Node(2);
        pot.root.right = new Node(3);
        pot.root.left.left = new Node(4);
        pot.root.left.right = new Node(5);

        pot.traverse();

    }
}
