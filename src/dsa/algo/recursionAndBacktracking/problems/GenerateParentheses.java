package dsa.algo.recursionAndBacktracking.problems;

public class GenerateParentheses {

    public static void main(String[] args) {

        System.out.println("!!! Generate Parentheses !!!");

        int n = 3;
        generateParentheses(0, 0, n, 0, "");
    }

    static void generateParentheses(int o, int c, int n, int i, String current) {

        if (i == 2*n) {
            System.out.println(current);
            return;
        }

        if (o < n) {
            current = current + '(';
            generateParentheses(o+1, c, n, i+1, current);
            current = current.substring(0, current.length()-1);// backtracking [remove "(" bcz you want to go to add ")"]
        }

        if (c < o) {
            current = current + ')';
            generateParentheses(o, c+1, n, i+1, current);
        }
    }
}
