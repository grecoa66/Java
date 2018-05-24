package Algorithms.Matrices;

import java.util.Random;

/**
 * Created by ag877r on 11/6/2017.
 */
public class MatrixGenerator {

    int[][] matrix;

    public static void main(String[] args){
        MatrixGenerator matrixObj = new MatrixGenerator();
        //create new matrix
        matrixObj.matrix = new int[5][6];
        //fill matrix with random values
        matrixObj.matrix = matrixObj.fillMatrix(matrixObj.matrix);
        //print out the matrix
        matrixObj.printMatrix(matrixObj.matrix);
    }

    private int[][] fillMatrix(int[][] matrix){
        Random randomInt = new Random();

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                int value = randomInt.nextInt(99);
                matrix[i][j] = value;
            }
        }

        return matrix;
    }

    private void printMatrix(int[][] matrix){

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
