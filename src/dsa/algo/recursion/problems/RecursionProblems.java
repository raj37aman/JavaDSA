package dsa.algo.recursion.problems;

public class RecursionProblems {

    public static void main(String[] args) {

        System.out.println("!!! Recursion Problems !!!");


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

        double powerResult = power(2, 3);
        System.out.println("Power result: " + powerResult);

        double fastPowerResult = fastPower(7, 7);
        System.out.println("Fast power result: " + fastPowerResult);

        double powerWithModuloResult = powerWithModulo(7, 7, 30);
        System.out.println("Power with modulo result: " + powerWithModuloResult);

        int matrixPathResult = matrixPath(3, 3);
        System.out.println("Matrix Path Result: " + matrixPathResult);
    }


    /* sum of n numbers */
    static int sumOfN(int n) {
        if (n == 1) return 1;
        return sumOfN(n-1) + n;
    }

    /* fib of n */
    static int fibOfN(int n) {
        if (n <= 1) return n;
        return fibOfN(n-1) + fibOfN(n-2);
    }

    /* calculate value of nCr (calculation of combination) via Pascal's Triangle */
    // nCr = n! / ((n-r)! * r!)
    // nCr = (n-1)C(r-1) + (n-1)Cr
    static int calculateNCR(int n, int r) {
        if (r == 0 || n == r) return 1;
        return calculateNCR(n-1, r-1) + calculateNCR(n-1, r);
    }

    /* Josephus Problem */
    static int josephus(int n, int k) {
        if (n==1) return 0;
        return (josephus(n-1, k) + k) % n;
    }

    /* Palindrome String */
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

    /* find number of occurrence of subString in a string */
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

    /* print all subsets of a string [const: string's char is unique] */
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

    /* power */
    // writing Math.pow(); in recursion [O(b)]
    static double power(double a, double b) {
//        return Math.pow(a, b);
        if (b == 0) return 1;// n^0 = 1
        if (b == 1) return a;// n^1 = n
        return (a * power(a, b-1));// a^b = a * a^(b-1)
    }

    /* fast power */
    // writing Math.pow(); in recursion [O(log b)]
    static double fastPower(double a, double b) {
        /*
        if power is even: a^b = (a^2)^(b/2)
        if power is odd: a^b = a * a^(b-1)
        now (b-1) is even
        */
        if (b == 0) return 1;// n^0 = 1
        if (b == 1) return a;// n^1 = n
        if (b % 2 == 1)// odd power
            return a * fastPower(a, b-1);
        else// even power
            return fastPower(a*a, b/2);
    }

    /* power with modulo */
    // (a + b) % m = (a % m + b % m) % m
    // (a * b) % m = (a % m * b % m) % m
    static double powerWithModulo(double a, double b, int m) {
        if (b == 0) return 1;// n^0 = 1
        if (b == 1) return a;// n^1 = n
        if (b % 2 == 1)// odd power
            return (a%m * powerWithModulo(a, b-1, m) % m) % m;
        else// even power
            return powerWithModulo((a%m * a%m) % m, b/2, m);
    }

    // find no of possible path to reach from a[0][0] to a[i][j] point [O(2^n)]
    static int matrixPath(int i, int j) {
        if (i == 1 || j == 1) return 1;
        return matrixPath(i-1, j) + matrixPath(i, j-1);
    }

}
