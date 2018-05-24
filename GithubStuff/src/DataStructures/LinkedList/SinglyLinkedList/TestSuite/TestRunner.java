package DataStructures.LinkedList.SinglyLinkedList.TestSuite;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

/**
 * Created by ag877r on 8/8/2017.
 */
public class TestRunner {
    public static void main(String[] args){
        Result result = JUnitCore.runClasses(LinkedListTestSuite.class);

        System.out.println("Number of tests run: " + result.getRunCount());


        for(Failure failure : result.getFailures()){
            System.out.println("This test case has failed: " + failure.getDescription());
        }

        System.out.println("The linked list test suite was successful: " + result.wasSuccessful());
    }
}
