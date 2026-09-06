package dsa.algo.recursionAndBacktracking.problems;

public class KnightTour {

    public static void main(String[] args) {

        System.out.println("!!! Knight Tour Problem !!!");

        /*
        * Start knight from 1x1 & cover all boxes of chess board
        */

        int n = 5;
        int[][] answer = path(n);
        int[][] ans = new int[5][5];

        // print answer
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j]);
                System.out.print("  ");
            }
            System.out.println();
        }

    }

    static int[][] path(int n) {

        int[][] a = new int[n][n];
        int stepCount = 1;// 1st step
        a[0][0] = stepCount;// start point = taking 1st step
        stepCount+=1;// now will take 2nd step

        // to decide next move
        int[] movesX = {2, 1, -1, -2, -2, -1, 1, 2};
        int[] movesY = {1, 2, 2, 1, -1, -2, -2, -1};

        pathHelper(n, a, movesX, movesY, 0, 0, stepCount);

        return a;
    }

    static boolean pathHelper(int n, int[][] a, int[] movesX, int[] movesY, int currX, int currY, int stepCount) {

        if (stepCount > n*n) {// to run until step count is left [n=5 - run till 25]
            return true;
        }

        for (int i = 0; i < 8; i++) {// as knight has 8 possible moves from any position
            int nextX = currX + movesX[i];// to decide next move
            int nextY = currY + movesY[i];// to decide next move
            if (validPosition(n, a, nextX, nextY)) {
                a[nextX][nextY] = stepCount;
                boolean isTourCompletedByGoingThere = pathHelper(n, a, movesX, movesY, nextX, nextY, stepCount+1);
                if (isTourCompletedByGoingThere) {
                    return true;
                } else {
                    a[nextX][nextY] = 0;
                }
            }
        }

        return false;
    }

    static boolean validPosition(int n, int[][] a, int x, int y) {
        return x>=0 && y>=0 && x<n && y<n && a[x][y] == 0;
    }

}
