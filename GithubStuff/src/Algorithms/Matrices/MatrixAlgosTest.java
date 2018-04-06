package Algorithms.Matrices;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
/**
 * Created by ag877r on 12/5/2017.
 */
public class MatrixAlgosTest {
    MatrixAlgos matrixAlgos = new MatrixAlgos();

    @Test
    public void testVerticalSum_1(){
        int[][] matrix = {
            {1, 2, 3, 4, 5, 6},
            {1, 2, 3, 4, 5, 6},
            {1, 2, 3, 4, 5, 6},
        };

        int result = matrixAlgos.verticalSum(matrix);

        assertEquals(18, result);
    }

    @Test
    public void testVerticalSum_2(){
        int[][] matrix = {
                {1, 2, 3, 3, 4, 2, 2, 4, 5, 6},
                {1, 2, 6},
                {1, 2, 3, 4, 5, 6},
        };

        int result = matrixAlgos.verticalSum(matrix);

        assertEquals(18, result);
    }
    @Test
    public void testVerticalSum_3(){
        int[][] matrix = {
                {1},
                {1}
        };

        int result = matrixAlgos.verticalSum(matrix);

        assertEquals(2, result);
    }

    @Test
    public void testVerticalSum_4(){
        int[][] matrix = {
                {1, 2, 33, 4, 5, 6},
                {1, 2, 3, 4, 33, 6},
                {33, 2, 3, 4, 5, 6},
        };

        int result = matrixAlgos.verticalSum(matrix);

        assertEquals(99, result);
    }
}
