package DataStructures.LinkedList.SinglyLinkedList;


/**
 * Created by ag877r on 4/25/2017.
 */
public class SingleNode {

    SingleNode next = null;
    Object value;

    public SingleNode(SingleNode next, Object value){
        this.next = next;
        this.value = value;
    }

    public SingleNode getNext() {
        return next;
    }

    public void setNext(SingleNode SingleNode) {
        this.next = SingleNode;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
