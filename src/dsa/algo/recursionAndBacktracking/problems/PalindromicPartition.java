package dsa.algo.recursionAndBacktracking.problems;

import java.util.ArrayList;
import java.util.List;

public class PalindromicPartition {

    public static void main(String[] args) {

        System.out.println("!!! Palindrome Partitioning Problem !!!");

        String s = "abbaca";
        List<List<String>> answer = palindromicPartitioning(s);

        for (List<String> ans: answer) {
            for (String str: ans) {
                System.out.print(str + " ");
            }
            System.out.println();
        }
    }

    static List<List<String>> palindromicPartitioning(String s) {
        List<List<String>> answer = new ArrayList<>();
        palindromicPartitioningHelper(s, answer, 0, new ArrayList<>());
        return answer;
    }

    static void palindromicPartitioningHelper(String s, List<List<String>> answer, int index, List<String> curr) {

        if (index == s.length()) {
            List<String> currCopy = new ArrayList<>(curr);
            answer.add(currCopy);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                curr.add(s.substring(index, i+1));
                palindromicPartitioningHelper(s, answer, i+1, curr);
                curr.removeLast();// backtracking
            }
        }
    }

    static boolean isPalindrome(String s, int l, int r) {
        while (l < r) {
            if(s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
