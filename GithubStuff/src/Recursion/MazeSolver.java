package Recursion;

/**
 * Created by ag877r on 2/2/2018.
 */
public class MazeSolver {

    char[][] maze;

    public boolean solve(char[][]maze, int x, int y){

        // If we go out of bound, return false
        if(x >= maze.length || x < 0 || y >= maze[x].length || y < 0)
            return false;
        // If we found a '*', return false
        if(maze[x][y] == '*')
            return false;
        // If we found 'E', return true
        if(maze[x][y] == 'E')
            return true;
        if(maze[x][y] == 'Z')
            return false;

        printMazeWithLocation(maze, x, y);
        maze = visitLocation(maze, x, y);

        // Explore to the left
        if(solve(maze, x, y - 1))
            return true;
        // Explore to the right
        if(solve(maze, x, y + 1))
            return true;
        // Explore upward
        if(solve(maze, x + 1, y))
            return true;
        // Explore downward
        if(solve(maze, x -1, y))
            return true;

        return false;
    }

    static void printMaze(char[][] maze){
        for(int x = 0; x < maze.length; x++){
            for(int y = 0; y < maze[x].length; y++){
                System.out.print(maze[x][y]);
            }
            System.out.println();
        }
    }

    static void printMazeWithLocation(char[][] maze, int x, int y){
        char temp = maze[x][y];
        maze[x][y] = 'X';
        System.out.println("X: " + x + ", Y: " + y);
        printMaze(maze);
        maze[x][y] = temp;
    }

    private char[][] visitLocation(char[][] maze, int x, int y){
        maze[x][y] = 'Z';
        return maze;
    }
    public static void main(String[] args){
        char[][] maze =
            {
                {'*', 'S', '*', '*', '*', '~'},
                {'*', '~', '*', '*', '~', '~'},
                {'*', '~', '*', '~', '*', '*'},
                {'*', '~', '~', '*', '~', '~'},
                {'*', 'E', '*', '*', '*', '*'}
            };
        MazeSolver solver = new MazeSolver();
        solver.maze = maze;

        solver.printMaze(maze);

        System.out.println("Here we go!");

        System.out.println("Answer: " + solver.solve(maze, 0, 1));

    }
}
