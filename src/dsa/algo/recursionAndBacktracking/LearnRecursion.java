package dsa.algo.recursionAndBacktracking;

public class LearnRecursion {

    public static void main(String[] args) {

        System.out.println("!!! Learn Recursion !!!");

        /*
        * Recursion - function(); calling function();
        * Execution follows recursion stack
        */

        func(10);

        fun(10);

        treeFunc(3);

    }

    // example of linear recursion
    static void func(int n) {
        if (n > 0) {
            System.out.println(n + ". Hello!");
            func(n - 1);
        }
    }

    // example of linear recursion
    static void fun(int n) {
        if (n > 0) {
            fun(n - 1);
            System.out.println(n + ". Hey!");
        }
    }

    // example of tree recursion
    static void treeFunc(int n) {
        if (n > 0) {
            System.out.println(n + ". Hi!");
            treeFunc(n - 1);
            treeFunc(n - 1);
        }
    }

}
