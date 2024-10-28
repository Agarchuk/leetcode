package org.leetcode.algorithms.easy;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        int valCount = 0;


        while (left <= right) {
            while (right >= left && nums[right] == val) {
                ++valCount;
                --right;
            }
            while (left <= right && nums[left] != val) {
                ++left;
            }

            if (left < right && nums[left] == val) {
                nums[left] = nums[right];
                nums[right] = val;
                --right;
                ++valCount;
                ++left;
            }
        }
        return nums.length - valCount;
    }
}
