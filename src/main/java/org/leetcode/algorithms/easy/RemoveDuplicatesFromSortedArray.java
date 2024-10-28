package org.leetcode.algorithms.easy;

public class RemoveDuplicatesFromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int numOfDuplicates = 0;
        int duplicatedIndex = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            int currentElement = nums[i];
            int nextElement = nums[i + 1];


            if (currentElement == nextElement) {
                if (numOfDuplicates == 0) {
                    duplicatedIndex = i + 1;
                }
                ++numOfDuplicates;
            } else if (numOfDuplicates != 0 && duplicatedIndex != 0) {
                nums[duplicatedIndex] = nextElement;
                ++duplicatedIndex;
            }
        }

        return nums.length - numOfDuplicates;
    }
}
