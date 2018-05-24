package DataStructures.BinaryTree;

import java.util.ArrayList;

/**
 * https://www.geeksforgeeks.org/given-a-binary-tree-print-all-root-to-leaf-paths/
 * Print a path from the root to all leafs
 *
 * Created by ag877r on 2/2/2018.
 */
public class RootToLeaf {
    Node root;

    private boolean findPaths(ArrayList<Node> path, Node curr){
        //Base case to print
        if(curr == null){
            return false;
        }
        else if(curr.left == null && curr.right == null){
            path.add(curr);
            printPath(path);
            path.remove(curr);
            return false;
        }

        //put the curr node in the path
        path.add(curr);

        // Go left
        if(findPaths(path, curr.left))
            return true;
        // Go right
        if(findPaths(path, curr.right))
            return true;

        path.remove(curr);
        return false;
    }

    static void printPath(ArrayList<Node> path){
        for(Node n : path){
            System.out.print(n.data + " -> ");
        }
        System.out.print("NULL");
        System.out.println(" ");
    }


    public static void main(String[] args){
        RootToLeaf rtl = new RootToLeaf();
        rtl.root = new Node(1);
        rtl.root.left = new Node(2);
        rtl.root.right = new Node(3);

        rtl.root.left.left = new Node(4);
        rtl.root.left.right = new Node(5);

        rtl.root.left.right.right = new Node(6);
        rtl.root.left.right.right.left = new Node(7);
        rtl.root.left.right.right.right = new Node(8);
        ArrayList<Node> path = new ArrayList();
        rtl.findPaths(path, rtl.root);
    }
}
