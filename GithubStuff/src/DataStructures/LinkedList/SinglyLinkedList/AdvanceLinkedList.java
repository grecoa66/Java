package DataStructures.LinkedList.SinglyLinkedList;

/**
 * This class adds some advanced functionality to the
 * base linked list. The methods in this class are a bit more advanced
 * and accomplish more interesting tasks(according to me).
 * Created by Alex Greco on 8/3/2017.
 */
public class AdvanceLinkedList extends BaseLinkedList{



    public AdvanceLinkedList(SingleNode head){
        super(head);
    }

    public SingleNode getTailNode(){
        if(head == null){
            //return null if there is nothing to delete
            return null;

        }else if(head.getNext() == null) {
            return head;
        }else{
            //this will be the SingleNode that finds the end of the LL
            SingleNode tempFront = head.getNext();

            while(tempFront.getNext() != null){
                tempFront = tempFront.getNext();

            }

            return tempFront;
        }
    }

    /**
     * Method to remove the last SingleNode from the linked list.
     * This method use a front and trail to SingleNode to move along the list
     * and find the last SingleNode. When the last SingleNode is found we remove the
     * referrence from the trailing SingleNode. We return the SingleNode that we
     * deleted.
     * @return the SingleNode we removed fromt he list
     */
    public SingleNode removeTailNode(){

        if(head == null){
            //return null if there is nothing to delete
            return null;

        }else{
            //this will be the SingleNode that finds the end of the LL
            SingleNode tempFront = head;
            //this SingleNode will be one behind so we can remove the next reference
            SingleNode tempTrail = head;

            //if we just have a head, remove it
            if(tempFront.getNext() == null){
                head = null;
                return tempFront;
            }else{
                //advance the front SingleNode once
                tempFront = tempFront.getNext();
                //if there are more nodes, keep advancing both pointers
                while(tempFront.getNext() != null){
                    tempTrail = tempFront;
                    tempFront = tempFront.getNext();
                }

                //when we find the end, remove the tempFront
                tempTrail.setNext(null);

                return tempFront;
            }
        }
    }

    /**
     * This function will find the middle SingleNode in a linked list.
     * If there is an even number of SingleNode, the lower SingleNode in the list will
     * be returned. For example ( 1 -> 2 -> 3 -> 4 ), 2 would be returned.
     * This algorithm works by having two nodes. A temp SingleNode and a trail
     * SingleNode. The temp SingleNode will be moved twice for every time the trailing
     * SingleNode is moved once. So by the time the temp SingleNode is at the end of
     * the list, the trailing SingleNode will haved moved half as many times
     * and be in the middle. This algorithm finds the mid element in
     * one pass of the list.
     * @return the middle SingleNode in the list
     */
    public SingleNode getMiddleNode(){
        SingleNode temp = head;
        SingleNode tempTrail = temp;
        SingleNode midNode;

        if(head == null){
            //base case with empty list
            return null;
        }else if(head.getNext() == null){
            //If there is one element, return it
            return head;
        }else{
            //while there are more nodes, keep advancing
            while(temp.getNext() != null){
                //move the temp forward once
                temp = temp.getNext();
                //if we can advance again
                if(temp.getNext() != null){
                    //move the trailing SingleNode once
                    tempTrail = tempTrail.getNext();
                    //move the temp forward again
                    temp = temp.getNext();
                }else{
                    return tempTrail;
                }
            }
        }

        return tempTrail;
    }

    /**
     * This function will count the number of nodes in the linked list.
     * @return the number of nodes in the linked list
     */
    public int getNodeCount(){
        SingleNode temp = head;
        int count = 0;

        if(head == null){
            return count;
        }else if(head.getNext() == null){
            return 1;
        }else{
            while(temp.getNext() != null){
                //count the current SingleNode and advance
                count++;
                temp = temp.getNext();
            }
            //count the last SingleNode
            count++;

            return count;
        }
    }

    /**
     * This function will reverse the linked list. So the tail will become
     * the head.
     */
    public void reverseLinkedList(){
        //This SingleNode will lead
        SingleNode next = null;
        //This SingleNode will continue to hold the current SingleNode that I will add to the end
        SingleNode curr = head;
        //This will hold the list reversed as we traverse
        SingleNode prev = null;

        //until the current SingleNode reaches the end, kepp going
        while(curr != null){
            //advance to the next ndoe
            next = curr.getNext();
            //set curr to the backward list
            curr.setNext(prev);
            //track the backward list with prev
            prev = curr;
            //grab the remaing part of the list
            curr = next;
        }
        //prev will be the reversed list
        head = prev;
    }

    public boolean addNodeByIndex (SingleNode newNode, int index) throws IndexOutOfBoundsException{
        //check if that index is out of bounds
        int numberOfNodes = this.getNodeCount();
        if(index > numberOfNodes){
            //if supplied index is too large, throw exception
            throw new IndexOutOfBoundsException();
        }


        //get the SingleNode in front of the location you want to insert new
        SingleNode backNode = this.getNodeByIndex(index - 1);
        //get the SingleNode in the location you want to insert new
        SingleNode frontNode = this.getNodeByIndex(index);

        //insert new SingleNode between the two SingleNode we have
        backNode.setNext(newNode);

        newNode.setNext(frontNode);

        return true;
    }

}
