package com.lev1.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsDemo {

    private static Map<String, String> dict = new HashMap<>();

    static {
        dict.put("2", "abc");
        dict.put("3", "def");
        dict.put("4", "ghi");
        dict.put("5", "jkl");
        dict.put("6", "mno");
        dict.put("7", "pqrs");
        dict.put("8", "tuv");
        dict.put("9", "wxyz");
    }

    List<String> output = new ArrayList<>();

    public void backtrack(String combination, String next_digits) {
        if (next_digits.length() == 0) {
            output.add(combination);
        } else {
            String digit = next_digits.substring(0, 1);
            String letters = dict.get(digit);
            if (letters != null) {
                for (int i = 0; i < letters.length(); i++) {
                    String letter = letters.substring(i, i + 1);
                    backtrack(combination + letter, next_digits.substring(1));
                }
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits != null && digits.length() != 0) backtrack("", digits);
        return output;
    }
}
