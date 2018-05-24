package DataStructures.LinkedList.DoublyLinkedList;

/**
 * This class will take care of the basic functions for the
 * doubly linked list. This class also implements the interface
 * for the linked list package.
 * Created by ag877r on 10/12/2017.
 */
public class BaseDoubleLinkedList{

    public DoubleNode head;

    public BaseDoubleLinkedList (DoubleNode head){
        this.head = head;
    }

    public BaseDoubleLinkedList() {

    }

    public Boolean addNode(DoubleNode newNode){
        Boolean wasAdded = false;
        //check if this is an instance of DoubleNode
        if(newNode instanceof DoubleNode == false){
            return false;
        }
        // if there is no head, esablish one
        if(head == null){
            head = (DoubleNode) newNode;
            return true;
        }else{
            DoubleNode temp = head;
            DoubleNode trail = null;
            // get to the end of the list
            while(temp.getNext() != null){
                trail = temp;
                temp = temp.getNext();
            }
            temp.setNext(newNode);
            temp.setPrev(trail);
            wasAdded = true;
        }
        return wasAdded;
    }

    public int numberOfNodes(){
        DoubleNode temp = head;
        int nodeCount = 0;
        if(temp == null){
            return 0;
        }

        while(temp.getNext() != null){
            nodeCount++;
            temp = temp.getNext();
        }

        //incriment for last nide
        nodeCount++;

        return nodeCount;
    }

    public DoubleNode getNodeByIndex(int index){
        DoubleNode returnNode = new DoubleNode(null, null, "Node1");

        return returnNode;
    }

    public DoubleNode getNodeByValue(Object value){
        DoubleNode returnNode = new DoubleNode(null, null, "Node1");

        return returnNode;
    }


    public Boolean removeNodeByIndex(int index) {
        return null;
    }


    public Boolean removeNodeByValue(Object value) {
        return null;
    }

    public void removeAll() {

    }

    public void printLinkedList() {

    }
}
