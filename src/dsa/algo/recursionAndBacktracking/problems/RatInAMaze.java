package dsa.algo.recursionAndBacktracking.problems;

public class RatInAMaze {

    public static void main(String[] args) {

        System.out.println("!!! Rat In A Maze Problem !!!");


        int[][] mat = {
                {1, 1, 1, 0},
                {1, 1, 0, 1},
                {1, 1, 0, 0},
                {1, 1, 1, 1},
        };

        int n = mat.length;// give length of mat (outer)
        int m = mat[0].length;// give length of a row of mat (inner)

        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;// starting point is covered already

        ratInAMaze(mat, 0, 0, n, m, visited, "");
    }

    // possible directions: U D L R
    static void ratInAMaze(int[][] mat, int i, int j, int n, int m, boolean[][] visited, String path) {

        if (i == n-1 && j == m-1) {// bottom right corner reached
            System.out.println(path);
            return;
        }

        // check for up
        if (isValid(mat, i-1, j, n, m, visited)) {
            visited[i-1][j] = true;// mark visited
            ratInAMaze(mat, i-1, j, n, m, visited, path+'U');
            visited[i-1][j] = false;// backtracking
        }

        // check for down
        if (isValid(mat, i+1, j, n, m, visited)) {
            visited[i+1][j] = true;
            ratInAMaze(mat, i+1, j, n, m, visited, path+'D');
            visited[i+1][j] = false;
        }

        // check for left
        if (isValid(mat, i, j-1, n, m, visited)) {
            visited[i][j-1] = true;
            ratInAMaze(mat, i, j-1, n, m, visited, path+'L');
            visited[i][j-1] = false;
        }

        // check for right
        if (isValid(mat, i, j+1, n, m, visited)) {
            visited[i][j+1] = true;
            ratInAMaze(mat, i, j+1, n, m, visited, path+'R');
            visited[i][j+1] = false;
        }

    }

    static boolean isValid(int[][] mat, int i, int j, int n, int m, boolean[][] visited) {
        return i < n && i >= 0 && j < m && j >= 0 && mat[i][j] == 1 && !visited[i][j];
    }

}
