package DataStructures.LinkedList.SinglyLinkedList.TestSuite;

import DataStructures.LinkedList.SinglyLinkedList.AdvanceLinkedList;
import DataStructures.LinkedList.SinglyLinkedList.SingleNode;
import org.junit.Before;
import org.junit.Test;


import static org.junit.Assert.assertEquals;

/**
 * This test class will run a few tests to ensure that the AdvancedLinkList class is
 * working properly. This test will be part of the LinkedListTestSuite.
 * Created by ag877r on 8/9/2017.
 */
public class AdvancedLinkedListTests {
    private SingleNode n0;
    private AdvanceLinkedList all;

    @Before
    public void initalize(){
        n0 = new SingleNode(null, "SingleNode 0");
        all = new AdvanceLinkedList(n0);
    }

    @Test
    public void testFindMidElement(){
        SingleNode tempNode;
        SingleNode n1 = new SingleNode(null, "SingleNode 1");
        SingleNode n2 = new SingleNode(null, "SingleNode 2");

        all.addNode(n1);
        all.addNode(n2);

        tempNode = all.getMiddleNode();
        assertEquals(tempNode, n1);

        SingleNode n3 = new SingleNode(null, "SingleNode 3");
        all.addNode(n3);

        tempNode = all.getMiddleNode();
        assertEquals(tempNode, n1);

        SingleNode n4 = new SingleNode(null, "SingleNode 4");
        all.addNode(n4);

        tempNode = all.getMiddleNode();
        assertEquals(tempNode, n2);

        all.removeAll();
        tempNode = all.getMiddleNode();
        assertEquals(tempNode, null);
    }

    @Test
    public void getTailNodeTest(){
        SingleNode tempNode;
        SingleNode n1 = new SingleNode(null, "SingleNode 1");

        all.addNode(n1);
        tempNode = all.getTailNode();
        assertEquals(tempNode, n1);

        SingleNode n2 = new SingleNode(null, "SingleNode 2");
        SingleNode n3 = new SingleNode(null, "SingleNode 3");

        all.addNode(n2);
        all.addNode(n3);

        tempNode = all.getTailNode();

        assertEquals(tempNode, n3);
    }

    @Test
    public void removeTailTest(){
        SingleNode tempNode;
        SingleNode n1 = new SingleNode(null, "SingleNode 1");

        all.addNode(n1);
        tempNode = all.removeTailNode();
        assertEquals(tempNode, n1);

        SingleNode n2 = new SingleNode(null, "SingleNode 2");
        all.addNode(n1);
        all.addNode(n2);
        tempNode = all.removeTailNode();
        assertEquals(tempNode, n2);

        all.removeAll();
        tempNode = all.removeTailNode();
        assertEquals(tempNode, null);
    }

    @Test
    public void getNodeCountTest(){
        int resultCount = 0;

        resultCount = all.getNodeCount();
        assertEquals(resultCount, 1);

        SingleNode n1 = new SingleNode(null, "SingleNode 1");
        all.addNode(n1);
        resultCount = all.getNodeCount();
        assertEquals(resultCount, 2);

        all.removeTailNode();
        resultCount = all.getNodeCount();
        assertEquals(resultCount, 1);

        all.addNode(n1);
        SingleNode n2 = new SingleNode(null, "SingleNode 2");
        SingleNode n3 = new SingleNode(null, "SingleNode 3");
        all.addNode(n2);
        all.addNode(n3);

        resultCount = all.getNodeCount();
        assertEquals(resultCount, 4);

        all.removeAll();
        resultCount = all.getNodeCount();
        assertEquals(resultCount, 0);
    }

    @Test
    public void reverseLinkedListTest(){
        SingleNode n1 = new SingleNode(null, "SingleNode 1");
        SingleNode n2 = new SingleNode(null, "SingleNode 2");
        SingleNode n3 = new SingleNode(null, "SingleNode 3");

        all.addNode(n1);
        all.addNode(n2);
        all.addNode(n3);

        AdvanceLinkedList testall = new AdvanceLinkedList(n3);

        n1 = new SingleNode(null, "SingleNode 1");
        n2 = new SingleNode(null, "SingleNode 2");

        testall.addNode(n2);
        testall.addNode(n1);
        testall.addNode(n0);

        all.reverseLinkedList();

        SingleNode temp = all.getNodeByIndex(0);
        assertEquals(temp.getValue(), "SingleNode 0");

        temp = all.getNodeByIndex(1);
        assertEquals(temp.getValue(), "SingleNode 1");

        temp = all.getNodeByIndex(2);
        assertEquals(temp.getValue(), "SingleNode 2");
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void addNodeByIndexTest_exception(){
        SingleNode n1 = new SingleNode(null, "SingleNode 1");
        SingleNode n2 = new SingleNode(null, "SingleNode 2");
        SingleNode n3 = new SingleNode(null, "SingleNode 3");
        SingleNode n4 = new SingleNode(null, "SingleNode 4");

        all.addNode(n1);
        all.addNode(n2);
        all.addNode(n3);

        // This should cause an exceotion
        all.addNodeByIndex(n4, 5);
    }

    @Test
    public void addNodeByIndex(){
        SingleNode n1 = new SingleNode(null, "SingleNode 1");
        SingleNode n2 = new SingleNode(null, "SingleNode 2");
        SingleNode n3 = new SingleNode(null, "SingleNode 3");
        SingleNode n4 = new SingleNode(null, "SingleNode 4");

        all.addNode(n1);
        all.addNode(n2);

        all.addNodeByIndex(n3, 1);

        SingleNode t1 = all.getNodeByIndex(1);

        assertEquals(t1.getValue(), n3.getValue());

        //add SingleNode to the end of the list
        all.addNodeByIndex(n4, 4);

        SingleNode t2 = all.getNodeByIndex(4);

        assertEquals(t2.getValue(), n4.getValue());
    }
}
