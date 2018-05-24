package DataStructures.LinkedList.DoublyLinkedList;

/**
 * This node is for a doubly linked list. It keeps a
 * reference to the node in front of it and behind.
 * It also stores a value that is a generic object,
 * so it can be filled with whatever the user wants
 * to use
 * Created by ag877r on 4/25/2017.
 */
public class DoubleNode {

    DoubleNode next = null;
    DoubleNode prev = null;
    Object value;



    public DoubleNode(DoubleNode next, DoubleNode prev, Object value){
        this.next = next;
        this.prev = prev;
        this.value = value;
    }

    public DoubleNode getNext() {
        return next;
    }

    public void setNext(DoubleNode node) {
        this.next = node;
    }

    public DoubleNode getPrev() {
        return prev;
    }

    public void setPrev(DoubleNode prev) {
        this.prev = prev;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
