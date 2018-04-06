package Recursion;

/**
 * Created by ag877r on 2/2/2018.
 */
public class Factorial {

    private int solve(int n){
        if(n == 1)
            return 1;

        return n * solve(n - 1);
    }

    public static void main(String[] args){
        Factorial f = new Factorial();
        int n = 5;
        System.out.println(f.solve(4));
    }
}
