package DataStructures.LinkedList.DoublyLinkedList.TestSuite;

import DataStructures.LinkedList.DoublyLinkedList.BaseDoubleLinkedList;
import DataStructures.LinkedList.DoublyLinkedList.DoubleNode;



/**
 * Created by ag877r on 10/18/2017.
 */
public class BaseDoubleLinkedListTests {

    private BaseDoubleLinkedList dll ;

    @Before
    public void initialize(){
        dll = new BaseDoubleLinkedList();
    }

    @Test
    public void addNode(){
        DoubleNode n1 = new DoubleNode(null, null, "DoubleNode 1");

        boolean wasAdded = dll.addNode(n1);

        assertEquals(wasAdded, true);

        //assertEquals(dll.head, );
    }

    @Test
    public void numberOfNodesTest(){
        DoubleNode n1 = new DoubleNode(null, null, "DoubleNode 1");
        DoubleNode n2 = new DoubleNode(null, null, "DoubleNode 2");
        DoubleNode n3 = new DoubleNode(null, null, "DoubleNode 3");

        dll.addNode(n1);
        dll.addNode(n2);

        int nodeCount = dll.numberOfNodes();

        assertEquals(2, nodeCount);

        dll.addNode(n3);
    }
}
