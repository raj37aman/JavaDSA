package dsa.algo.recursionAndBacktracking.problems;

import java.util.ArrayList;
import java.util.Arrays;

public class CombinationSum {

    public static void main(String[] args) {

        System.out.println("!!! Combination Sum Problem !!!");

        int[] a = {8, 1, 3, 7, 2, 1, 5};
        int target = 12;

        // to test for duplicate combinations
//        int[] a = {1,1,1,1};
//        int target = 2;

        Arrays.sort(a);
        ArrayList<ArrayList<Integer>> answer = combinationSum(a, target);

        for (ArrayList<Integer> ans : answer) {
            System.out.println(ans);
        }
    }

    static ArrayList<ArrayList<Integer>> combinationSum(int[] a, int target) {
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        combinationSumHelper(a, ansList, 0, new ArrayList<>(), target);
        return ansList;
    }

    static void combinationSumHelper(int[] a, ArrayList<ArrayList<Integer>> ansList,
                                     int index, ArrayList<Integer> currList, int target) {

        if (target == 0) {
            ArrayList<Integer> currCopy = new ArrayList<>(currList);
            ansList.add(currCopy);
            return;
        }

        for (int i = index; i < a.length; i++) {

            if (a[i] > target) return;
            if (i > index && a[i] == a[i-1]) continue;// to skip duplicate combinations

            currList.add(a[i]);
            combinationSumHelper(a, ansList, i+1, currList, target-a[i]);
            currList.removeLast();// backtracking
        }
    }
}
