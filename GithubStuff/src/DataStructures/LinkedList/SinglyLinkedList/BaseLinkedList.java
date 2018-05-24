package DataStructures.LinkedList.SinglyLinkedList;

/**
 * This is a base linked list class that implements the LinkedList.
 * This is the base class (super) for all other singlely linked lists in
 * the package.
 * Created by ag877r on 4/25/2017.
 */
public class BaseLinkedList {

    protected SingleNode head;

    public BaseLinkedList (SingleNode head){
        this.head = head;
    }

    /**
     * Simple method to add a SingleNode to the end of a linked list
     * @param node - the SingleNode to be added
     # @return Boolean - return true if the SingleNode was added, false if not
     */
    public void addNode(SingleNode node){
        //if the head is not set, make this SingleNode the head
        if(head == null){
            head = node;

        }else{
            //use a temp to advance throught the list
            SingleNode temp = head;
            //advance to the end of the linked list
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            //when you get to the end of the LL, add the new SingleNode
            temp.setNext(node);
        }
    }

    /**
     * This method will run through the linked list and find
     * the SingleNode that is 'index' - 1 hops from the head.
     * The indexes in the linked list start (head) at 0.
     * If there are no elements, null will be returned.
     * @param index
     * @return
     */
    public SingleNode getNodeByIndex(int index){
        SingleNode returnSingleNode = head;
        //base case
        if(index == 0){
            return head;
        }
        //hop down the list until you get to the index
        for(int i = 0; i < index; i++){
            //if we hit the end of the list before the index
            if(returnSingleNode.getNext() == null){
                return null;
            }else{
                returnSingleNode = returnSingleNode.getNext();
            }
        }

        return returnSingleNode;
    }

    public SingleNode getNodeByValue(Object value){
        SingleNode returnSingleNode = head;

        //base case
        if(returnSingleNode.getValue() == value){
            return returnSingleNode;
        }
        //test all but first and alst SingleNode
        while(returnSingleNode.getNext() != null){
            if(returnSingleNode.getValue() == value){
                return returnSingleNode;
            }else{
                returnSingleNode = returnSingleNode.getNext();
            }
        }
        //check last SingleNode
        if(returnSingleNode.getValue() == value){
            return returnSingleNode;
        }

        return null;
    }

    /**
     * This method will remove a SingleNode at the index passed into the function.
     * If there is no SingleNode at the index passed as a paramter, no SingleNode will be removed.
     * If the head SingleNode is removed, the next SingleNode will become the head SingleNode.
     * Indexes for the linked list start at zero.
     * @param index - the index of the SingleNode that we want to remove
     * @return the SingleNode that is removed
     */
    public Boolean removeNodeByIndex(int index){

        if(head == null){
            //return null if there is nothing to remove
            return false;

        }else {
            //have a temp SingleNode to keep track of where we are
            SingleNode temp = head;
            boolean SingleNodeRemoved = false;

            if(index == 0 ){
                head = temp.getNext();
                return true;
            }

            //advance temp to the SingleNode before the one we want to remove
            for(int i = 0; temp != null && i < index - 1; i ++){
                temp = temp.getNext();
            }
            //temp is now at the SingleNode before the one we want to remove
            if(temp == null || temp.getNext() == null){
                //if the SingleNode at our index is null, return
                SingleNodeRemoved = false;
            }else{
                SingleNodeRemoved = true;
                //grab the SingleNode after the one we will delete
                SingleNode next = temp.getNext().getNext();
                //overwrite reference to SingleNode we want to delete
                temp.setNext(next);
            }

            return SingleNodeRemoved;
        }

    }

    /**
     * This method will remove the first item it finds with
     * a matching  value. If there are multiple matching values, it
     * will only remove the first one and return it. If none
     * are found, null will be returned.
     * @param value - the object we want to find
     * @return the SingleNode that is removed
     */
    public Boolean removeNodeByValue(Object value){
        SingleNode toReturn;
        SingleNode temp = head;
        SingleNode tempTrail = head;

        //check the head and adjust if it needs to be removed
        if(head.getValue() == value){
            head = head.getNext();
        }else{
            //advance to the second SingleNode
            tempTrail = temp;
            temp = temp.getNext();
        }

        if(temp != null) {
            while (temp.getNext() != null) {
                if (temp.getValue() == value) {
                    tempTrail.setNext(temp.getNext());
                    return true;
                } else {
                    tempTrail = temp;
                    temp = temp.getNext();
                }
            }
        }

        return false;
    }

    public void removeAll(){
        head = null;
    }

    public void printLinkedList(){
        if(head == null){
            System.out.println("The Linked List is empty.");
        }else{
            System.out.print(head.getValue());
            SingleNode temp = head;

            while(temp.getNext() != null){
                temp = temp.getNext();
                System.out.print(" -> " + temp.getValue());
            }
        }
        System.out.println();
    }

}
