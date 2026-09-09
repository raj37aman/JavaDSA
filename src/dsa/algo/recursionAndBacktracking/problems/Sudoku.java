package dsa.algo.recursionAndBacktracking.problems;

public class Sudoku {

    public static void main(String[] args) {

        System.out.println("!!! Sudoku Problem !!!");

        int[][] board = {
                {5,3,0,0,7,0,0,0,0},
                {6,0,0,1,9,5,0,0,0},
                {0,9,8,0,0,0,0,6,0},
                {8,0,0,0,6,0,0,0,3},
                {4,0,0,8,0,3,0,0,1},
                {7,0,0,0,2,0,0,0,6},
                {0,6,0,0,0,0,2,8,0},
                {0,0,0,4,1,9,0,0,5},
                {0,0,0,0,8,0,0,7,9}
        };

        boolean solved = sudokuSolver(board, 0, 0);

        if (solved)
            System.out.println("Sudoku Solved!");
        else
            System.out.println("Sudoku Not Solved!");

        for (int[] a: board) {
            for (int b: a) {
                System.out.print(b + " ");
            }
            System.out.println();
        }
    }

    static boolean sudokuSolver(int[][] a, int row, int col) {

        if (row == 9) return true;
        if (col == 9) return sudokuSolver(a, row+1, 0);// move to next row & start from 1st column
        if (a[row][col] != 0) return sudokuSolver(a, row, col+1);// move to next column

        for (int i = 1; i <= 9; i++) {// check for each possible number
            if (isPossibleNumber(a, row, col, i)) {
                a[row][col] = i;
                if (sudokuSolver(a, row, col+1)) return true;// check that cell filling was a success
                a[row][col] = 0;// if now success then reset value to 0 & go to next iteration to fill next number in it
            }
        }
        return false;
    }

    private static boolean isPossibleNumber(int[][] a, int row, int col, int number) {

        // check number existing in row/column
        for (int i = 0; i < 9; i++) {
            if (a[row][i] == number) return false;
            if (a[i][col] == number) return false;
        }

        // check number existing in grid
        // row/column of small grid's position in whole big grid
        // /3 bcz 9x9 grid is considered as big grid of 3x3 (3 row/column makes 1 position)
        int gridRow = row/3;
        int gridCol = col/3;
        // run normal for loop for all positions in 3x3 grid
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // to get position according to 9x9 grid
                // *3 to convert position in 3x3 grid into 9x9 grid's position (3 row/column makes 1 position)
                int cellRow = 3 * gridRow + i;
                int cellCol = 3 * gridCol + j;
                // if that position contain the number
                if (a[cellRow][cellCol] == number) return false;
            }
        }
        return true;
    }

}
