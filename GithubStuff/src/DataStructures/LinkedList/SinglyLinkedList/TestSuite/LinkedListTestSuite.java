package DataStructures.LinkedList.SinglyLinkedList.TestSuite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * This is a suite that will run all the test cases for all linked list classes.
 * Created by ag877r on 8/8/2017.
 */
@RunWith(Suite.class)

@Suite.SuiteClasses({
        BaseLinkedListTests.class,
        AdvancedLinkedListTests.class
})
public class LinkedListTestSuite {

}
