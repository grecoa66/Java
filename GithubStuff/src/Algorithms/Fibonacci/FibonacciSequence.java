package Algorithms.Fibonacci;

/**
 * Created by ag877r on 9/13/2017.
 */
public class FibonacciSequence {

    public static void main(String[] args){
        FibonacciSequence fibSeq = new FibonacciSequence();

        System.out.println("fib Seq 0: " + fibSeq.fibonacciSequence(0));

        System.out.println("fib Seq 1: " + fibSeq.fibonacciSequence(1));

        System.out.println("fib Seq 2: " + fibSeq.fibonacciSequence(2));

        System.out.println("fib Seq 3: " + fibSeq.fibonacciSequence(3));

        System.out.println("fib Seq 4: " + fibSeq.fibonacciSequence(4));

        System.out.println("fib Seq 5: " + fibSeq.fibonacciSequence(5));

        System.out.println("fib Seq 6: " + fibSeq.fibonacciSequence(6));

        System.out.println("fib Seq 7: " + fibSeq.fibonacciSequence(7));

        System.out.println("fib Seq 10: " + fibSeq.fibonacciSequence(10));




    }

    private int fibonacciSequence(int n){
        //base cases
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        // x is for the leading digit
        int x = 1;
        // y is for the trailing digit
        int y = 0;
        // z is the temp variable I use to find the new x value
        int z = 0;
        // Iterate until you hit the fib number you want
        for (int i = 2; i < n; i++){
            //base case
            if(x == 1){
                x = 2;
                y = 1;
            }else{
                // Get the next fib number
                z = x + y;
                // Slide the leading number to the trailing
                y = x;
                // Make x the newly clculated leading number
                x = z;
            }
        }
        return x;

    }
}
