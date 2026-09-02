package dsa.algo.recursionAndBacktracking.problems;

import java.util.ArrayList;

public class SmartKeypad {

    public static void main(String[] args) {

        System.out.println("!!! Smart Keypad Problem !!!");

        String input = "23";
        System.out.println(smartKeypad(input));
    }

    static ArrayList<String> smartKeypad(String input) {

        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        ArrayList<String> answer = new ArrayList<>();

        smartKeypadHelper(input, map, 0, answer, "");

        return answer;
    }

    static void smartKeypadHelper(String input, String[] map, int index, ArrayList<String> answer, String curr) {

        if (index == input.length()) {
            answer.add(curr);
            return;
        }

//        int keypadNumber = Integer.valueOf(String.valueOf(input.charAt(index)));
        int keypadNumber = input.charAt(index) - '0';// to bring int value from any char, subtract it by char zero [- '0']
        String keypadString = map[keypadNumber];

        for (int i = 0; i < keypadString.length(); i++) {
            curr = curr + keypadString.charAt(i);
            smartKeypadHelper(input, map, index+1, answer, curr);
            curr = curr.substring(0, curr.length()-1);// backtracking
        }
    }

}
