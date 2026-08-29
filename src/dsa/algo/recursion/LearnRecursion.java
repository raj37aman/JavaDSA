package dsa.algo.recursion;

import java.util.ArrayList;

public class LearnRecursion {

    public static void main(String[] args) {

        System.out.println("!!! Learn Recursion !!!");

        /*
        * Recursion - function(); calling function();
        * Execution follows recursion stack
        */

//        func(10);

//        fun(10);

//        treeFunc(3);

        int sumOfN = sumOfN(5);
        System.out.println("Sum of n numbers: " + sumOfN);

        int fibOfN = fibOfN(5);
        System.out.println("Fib of n: " + fibOfN);

        int ncr = calculateNCR(5, 5);
        System.out.println("Calculate nCr: " + ncr);

        int josh = josephus(5, 3);
        System.out.println("Josephus: " + josh);

        boolean isPalindrome = isPalindrome("racecar");
        System.out.println("String is palindrome: " + isPalindrome);

        int occurrences = findOccurrence("aaaa", "aa");
        System.out.println("Count occurrences: " + occurrences);

        getAllSubstrings("abc");

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

    // sum of n numbers
    static int sumOfN(int n) {
        if (n == 1) return 1;
        return sumOfN(n-1) + n;
    }

    // fib of n
    static int fibOfN(int n) {
        if (n <= 1) return n;
        return fibOfN(n-1) + fibOfN(n-2);
    }

    // calculate value of nCr (calculation of combination) via Pascal's Triangle
    // nCr = n! / ((n-r)! * r!)
    // nCr = (n-1)C(r-1) + (n-1)Cr
    static int calculateNCR(int n, int r) {
        if (r == 0 || n == r) return 1;
        return calculateNCR(n-1, r-1) + calculateNCR(n-1, r);
    }

    // Josephus Problem
    static int josephus(int n, int k) {
        if (n==1) return 0;
        return (josephus(n-1, k) + k) % n;
    }

    // Palindrome String
    static boolean isPalindrome(String s) {
        return isPalindromeHelper(s, 0, s.length()-1);
    }
    static boolean isPalindromeHelper(String s, int l, int r) {
        // condition means if l & r comes in middle
        // even/odd characters of string vary in finding middle point (3 letters word: middle found at l == r || 4 letters word: middle found after l & r crossed each other)
        if (l >= r) return true;
        if (s.charAt(l) == s.charAt(r))
            return isPalindromeHelper(s, l+1, r-1);
        return false;
    }

    // find number of occurrence of subString in a string
    static int findOccurrence(String s, String ss) {
        return findOccurrenceHelper(s, ss, 0);
    }
    static int findOccurrenceHelper(String s, String ss, int i) {
        // condition means s=10, ss=3, index > 7 then there will be nothing to check.
        // bcz we are not left with 3 letters (including char at index) anymore to check ss occurrence.
        if (i > s.length() - ss.length()) return 0;
        int subProblemResponse = findOccurrenceHelper(s, ss, i+1);
//        if (s.substring(i, i+ss.length()).equals(ss))
        // OR can be written as:
        if (s.startsWith(ss, i))
            return subProblemResponse + 1;
        return subProblemResponse;
    }

    // print all subsets of a string [const: string's char is unique]
    static void getAllSubstrings(String s) {
        getAllSubstringsHelper(s, 0, "");
    }
    static void getAllSubstringsHelper(String s, int i, String curr) {
        if (i == s.length()) {
            System.out.println(curr);
            return;
        }
        getAllSubstringsHelper(s, i+1, curr + s.charAt(i));
        getAllSubstringsHelper(s, i+1, curr);
    }


}
