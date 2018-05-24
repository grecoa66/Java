package DataStructures.LinkedList.SinglyLinkedList.TestSuite;

import DataStructures.LinkedList.SinglyLinkedList.BaseLinkedList;
import DataStructures.LinkedList.SinglyLinkedList.SingleNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * This will be a test case for the base linked list class
 * Created by ag877r on 8/8/2017.
 */
public class BaseLinkedListTests {
    private SingleNode n0;
    private BaseLinkedList bll;

    @Before
    public void initalize() {
        n0 = new SingleNode(null, "SingleNode 0");
        bll = new BaseLinkedList(n0);
    }

    @Test
    public void testAdd(){
        SingleNode n1 = new SingleNode(null, "SingleNode 1");
        SingleNode n2 = new SingleNode(null, "SingleNode 2");
        bll.addNode(n1);
        assertEquals(n1, bll.getNodeByIndex(1));

        bll.addNode(n2);
        assertEquals(n1, bll.getNodeByIndex(1));
        assertEquals(n2, bll.getNodeByIndex(2));
    }

    @Test
    public void testGetByIndex(){

        SingleNode n1 = new SingleNode(null, "SingleNode 1");
        SingleNode testNode = bll.getNodeByIndex(0);

        assertEquals(testNode, n0);

        bll.addNode(n1);
        testNode = bll.getNodeByIndex(0);
        assertEquals(testNode, n0);

        testNode = bll.getNodeByIndex(1);
        assertEquals(testNode, n1);

        testNode = bll.getNodeByIndex(5);
        assertEquals(testNode, null);
    }

    @Test
    public void testGetByValue(){

        SingleNode n1 = new SingleNode(null, "SingleNode 1");
        SingleNode testNode = bll.getNodeByValue("Wrong Value");

        assertEquals(testNode, null);

        testNode = bll.getNodeByValue("SingleNode 0");
        assertEquals(testNode, n0);

        bll.addNode(n1);

        testNode = bll.getNodeByValue("More Wrong Values");
        assertEquals(testNode, null);

        testNode = bll.getNodeByValue("SingleNode 1");
        assertEquals(testNode, n1);
    }

    @Test
    public void testRemoveNodeByIndex(){
        SingleNode n1 = new SingleNode(null, "SingleNode 1");
        SingleNode testNode;
        bll.addNode(n1);

        Boolean nodeRemoved = bll.removeNodeByIndex(0);
        assertEquals(nodeRemoved, true);

        testNode = bll.getNodeByIndex(0);
        assertEquals(testNode, n1);

        nodeRemoved = bll.removeNodeByIndex(1);
        assertEquals(nodeRemoved, false);

    }

    @Test
    public void testRemoveByValue(){
        SingleNode n1 = new SingleNode(null, "SingleNode 1");
        SingleNode testNode;

        bll.addNode(n1);
        Boolean nodeRemoved = bll.removeNodeByValue("SingleNode 0");
        assertEquals(nodeRemoved, true);

        testNode = bll.getNodeByIndex(0);
        assertEquals(testNode, n1);

        nodeRemoved = bll.removeNodeByValue("Wrong Value");
        assertEquals(nodeRemoved, false);
    }

    @Test
    public void testRemoveAll(){
        SingleNode n1 = new SingleNode(null, "SingleNode 1");
        SingleNode n2 = new SingleNode(null, "SingleNode 2");
        SingleNode n3 = new SingleNode(null, "SingleNode 3");

        bll.addNode(n1);
        bll.addNode(n2);
        bll.addNode(n3);

        SingleNode getNode = bll.getNodeByIndex(1);
        assertEquals(getNode, n1);

        getNode = bll.getNodeByIndex(3);
        assertEquals(getNode, n3);

        getNode = bll.getNodeByIndex(0);
        assertEquals(getNode, n0);

        bll.removeAll();

        getNode = bll.getNodeByIndex(0);
        assertEquals(getNode, null);

    }

}
