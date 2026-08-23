package dsa.algo.timeComplexity;

public class BigONotation {

    public static void main(String[] args) {

        System.out.println("!!! Learn BigONotation !!!");

        int[] arr = {5, 3, 7, 2, 6, 1, 7, 4, 6};
        int key = 10;

        printAllPairsInArray(arr);

    }

    static int getFirstNumber(int[] arr) {
        return arr[0];
    }

    static boolean checkIfNumberIsPresent(int[] arr, int key) {
        for (int a: arr) {
            if (a == key) return true;
        }
        return false;
    }

    static void printAllPairsInArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                System.out.println(arr[i] + " " + arr[j]);
            }
        }
    }

}
