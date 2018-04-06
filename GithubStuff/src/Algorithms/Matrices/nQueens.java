package Algorithms.Matrices;

import java.util.ArrayList;

/**
 * Created by ag877r on 12/7/2017.
 */
public class nQueens {

    public static int solvedBoardCount = 0;

    public static void main(String[] args) {

        nQueens queens = new nQueens();

        int[][] board = queens.buildQueenMatrix(6);

        queens.placeQueens(board);

    }

    private int[][] buildQueenMatrix(int n) {
        int[][] matrix = new int[n][n];
        return matrix;
    }

    public void placeQueens(int[][] board) {
        int queensPlaced = 0;
        int boardSize = board.length;
        ArrayList<QueenLocation> queensLocation = new ArrayList<>(boardSize);
        for (int y = 0; y < boardSize; y++) {
            for (int x = 0; x < boardSize; x++) {
                //check if you can place a queen here
                if (canPlaceQueen(board, y, x)) {
                    board[y][x] = 1;
                    QueenLocation q = new QueenLocation(y, x);
                    queensLocation.add(q);
                    queensPlaced++;
                    if(queensPlaced == boardSize){
                        solvedBoardCount++;
                        printBoard(board);
                        //pop the last queen and keep trying
                        QueenLocation poppedQueen = queensLocation.get(queensPlaced - 1);
                        queensLocation.remove(queensPlaced - 1);
                        queensPlaced--;
                        //adjust loops to start back where the popped queen was
                        y = poppedQueen.getY();
                        x = poppedQueen.getX();
                        board[y][x] = 0;
                    }
                }
                //check if we are at the end of the matrix and all queens are not placed
                else if( x == boardSize -1 && queensPlaced < y + 1){
                    //We need to back track
                    // Pop the last placed queen
                    QueenLocation poppedQueen = queensLocation.get(queensPlaced - 1);
                    queensLocation.remove(queensPlaced - 1);
                    queensPlaced--;
                    //adjust loops to start back where the popped queen was
                    y = poppedQueen.getY();
                    x = poppedQueen.getX();
                    //turn 1 for queen off
                    board[y][x] = 0;
                }

            }

        }

    }

    private boolean canPlaceQueen(int[][] board, int y, int x) {
        // Check the row for other queens
        for (int i = 0; i < board.length; i++) {
            if (board[y][i] == 1) {
                return false;
            }
        }

        // Check the column for other queens
        for (int i = 0; i < board.length; i++) {
            if (board[i][x] == 1) {
                return false;
            }
        }

        // Check diagonals
        if (!(checkDiagonals(board, y, x))) {
            return false;
        }


        return true;
    }

    private boolean checkDiagonals(int[][] board, int y, int x) {
        // Down and right
        for (int j = y, k = x; j < board.length; j++, k++) {
            // If you are on the bottom row, there is nothing down and right
            if (k == board.length) {
                break;
            } else if (board[j][k] == 1) {
                return false;
            }
        }
        // Up and right
        for (int j = y, k = x; j > -1; j--, k++) {
            if (k == board.length) {
                break;
            } else if (board[j][k] == 1) {
                return false;
            }
        }
        // Down and left
        for (int j = y, k = x; j < board.length; j++, k--) {
            if (k < 0) {
                break;
            } else if (board[j][k] == 1) {
                return false;
            }
        }
        // Up and right
        for (int j = y, k = x; j > -1; j--, k--) {
            if (k < 0) {
                break;
            } else if (board[j][k] == 1) {
                return false;
            }
        }

        return true;
    }

    private void printBoard(int[][] board) {
        System.out.println("Completed Board #" + solvedBoardCount);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 1) {
                    System.out.print("Q ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println(" ");
        }
    }

    private class QueenLocation {
        int x;
        int y;

        public QueenLocation(int y, int x) {
            this.x = x;
            this.y = y;
        }

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
