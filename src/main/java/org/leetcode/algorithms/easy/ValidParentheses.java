package org.leetcode.algorithms.easy;

import java.util.*;

public class ValidParentheses {

    public static boolean isValid(String s) {
        List<Character> openParentheses = Arrays.asList('(', '{', '[');
        HashMap<Character, Character> pairedParenthesesForOpening = new HashMap<>();

        pairedParenthesesForOpening.put('(', ')');
        pairedParenthesesForOpening.put('{', '}');
        pairedParenthesesForOpening.put('[', ']');
        int stringLength = s.length();
        char[] array = s.toCharArray();

        if (stringLength % 2 == 1) {
            return false;
        }

        Stack<Character> stack = new Stack<>();

        for (Character parentheses : array) {
            if (openParentheses.contains(parentheses)) {
                stack.push(parentheses);
            } else {
                Character lastStackElement;
                try {
                    lastStackElement = stack.peek();
                } catch (EmptyStackException e) {
                    return false;
                }

                Character closingParenthesis = pairedParenthesesForOpening.get(lastStackElement);
                if (parentheses != closingParenthesis) {
                    return false;
                } else {
                    stack.pop();
                }

            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
