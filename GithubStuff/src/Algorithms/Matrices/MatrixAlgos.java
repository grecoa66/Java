package Algorithms.Matrices;

/**
 * Created by ag877r on 12/5/2017.
 */
public class MatrixAlgos {

    /**
     * This function will find the largest sum of integers going from
     * the top row of the matrix down. Each row can only contribute one value.
     * @param matrix
     * @return
     */
    public int verticalSum(int[][] matrix){
        if(matrix == null){
            return -1;
        }
        // Keep track of the vertical sum
        int sum = 0;

        // Loop through all rows
        for(int i = 0; i < matrix.length ; i++){
            // Track the current largest
            int largest = matrix[i][0];
            // Loop through all columns in the current row
            for(int j = 0; j < matrix[i].length ; j++){
                if(matrix[i][j] > largest){
                    largest = matrix[i][j];
                }
            }
            sum += largest;
        }

        return sum;

    }


}
