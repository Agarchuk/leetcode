package org.leetcode.algorithms.easy;

import java.util.Arrays;

public class LongestCommonPrefix {

    public static String findLongestCommonPrefix (String[] strs) {
        String maxCommonPrefix = "";
        int maxCommonPrefixLength = 999999999;

        if (strs.length == 1) {
            return strs[0];
        }

        for (int i = 0; i < strs.length; i++) {
            String tmpCommonPrefix = "";
            int tmpMaxCommonPrefixLength = 0;

            char[] charArrayStr1 = strs[i].toCharArray();

            for (int j = strs.length - 1; j >= 0; j--) {
                char[] charArrayStr2 = strs[j].toCharArray();

                if (i != j) {
                    char[] smallestWord = charArrayStr1.length > charArrayStr2.length ? charArrayStr2 : charArrayStr1;
                    for (int k=0; k < smallestWord.length; k++) {
                        if (charArrayStr1[k] == charArrayStr2[k]) {
                            tmpMaxCommonPrefixLength++;
                            tmpCommonPrefix += charArrayStr1[k];
                        } else {
                            break;
                        }
                    }
                    if (tmpMaxCommonPrefixLength < maxCommonPrefixLength) {
                        maxCommonPrefix = tmpCommonPrefix;
                        maxCommonPrefixLength = tmpMaxCommonPrefixLength;
                    }
                }
                tmpCommonPrefix = "";
                tmpMaxCommonPrefixLength = 0;
            }
        }
        return maxCommonPrefix;
    }

    public static String longestCommonPrefixOptimised(String[] v) {
        StringBuilder ans = new StringBuilder();
        Arrays.sort(v);
        String firstWord = v[0];
        String lastWord = v[v.length-1];
        for (int i=0; i<Math.min(firstWord.length(), lastWord.length()); i++) {
            if (firstWord.charAt(i) != lastWord.charAt(i)) {
                return ans.toString();
            }
            ans.append(firstWord.charAt(i));
        }
        return ans.toString();
    }
}
