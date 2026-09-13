package dsa.algo.recursionAndBacktracking.problems;

import java.util.ArrayList;

public class Subsequence {

    public static void main(String[] args) {

        System.out.println("!!! Find All Possible Subsequence Problem !!!");

        int[] a = {4, 5, 6};
        ArrayList<ArrayList<Integer>> answer = subsequences(a);

        for (ArrayList<Integer> ans : answer) {
            System.out.println(ans);
        }
    }

    static ArrayList<ArrayList<Integer>> subsequences(int[] a) {
        ArrayList<ArrayList<Integer>> ansList = new ArrayList<>();
        subsequencesHelper(a, ansList, 0, new ArrayList<>());
        return ansList;
    }

    static void subsequencesHelper(int[] a, ArrayList<ArrayList<Integer>> ansList, int index, ArrayList<Integer> currList) {

        ArrayList<Integer> currCopy = new ArrayList<>(currList);
        ansList.add(currCopy);

        for (int i = index; i < a.length; i++) {

            if (i > index && a[i] == a[i-1]) continue;// to skip duplicate combinations

            currList.add(a[i]);
            subsequencesHelper(a, ansList, i+1, currList);
            currList.removeLast();// backtracking
        }
    }
}
