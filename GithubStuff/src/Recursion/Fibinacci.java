package Recursion;

/**
 * Created by ag877r on 2/2/2018.
 */
public class Fibinacci {


    private int solve(int num){


        if(num == 0){
            return 0;
        }
        if(num == 1){
            return 1;
        }

        return solve(num - 1) + solve(num - 2);
    }

    public static void main(String[] args){
        Fibinacci fb = new Fibinacci();
        int num = 7;
        System.out.println("Printing Fibinacci sequence for " + num);

        System.out.println(fb.solve(num));
    }
}
