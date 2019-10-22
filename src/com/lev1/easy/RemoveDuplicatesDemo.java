/**
 * Alipay.com Inc. Copyright (c) 2004-2019 All Rights Reserved.
 */
package com.lev1.easy;

public class RemoveDuplicatesDemo {

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,3,4,5,5,6,7};
        int length = removeDuplicates(nums);
        printArray(nums, length);
    }

    /**
     * 移除给定排序数组中的重复元素，返回移除重复元素后的数据长度
     * @param nums 给定的数组
     * @return 移除重复元素后的数据长度
     */
    public static int removeDuplicates(int[] nums) {
        int j = 0;
        int temp;
        for (int i = 1; i < nums.length; i++) {
            if (nums[j] == nums[i]) {
                continue;
            } else {
                j++;
                temp = nums[i];
                nums[j] = temp;
            }
        }

        return j + 1;
    }

    public static void printArray(int[] array, int length) {
        for (int i = 0; i < length; i++) {
            System.out.print(array[i]+",");
        }
    }
}