package com.lev1.array;

import java.util.*;

/**
 * 给定一个整数数组 nums，从数组中找到三个数之和为0，找到所有满足条件的值，并且结果数组中不能重复
 */
public class ThreeSumDemo {

    /**
     * 一次hash表
     * @param nums 给定的数组
     * @return 所有满足三个数和为0的组合，不允许重复
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        Set<List<Integer>> cache = new HashSet();
        Arrays.sort(nums);
        int dig1 = 0;
        List<List<Integer>> lst = new ArrayList<>();
        for (int x = 0; x < nums.length; x++) {
            for (int y = x + 1; y < nums.length; y++) {
                dig1 = nums[x];
                int dig2 = nums[y];
                int comp = (dig1 + dig2) * -1;
                if (set.contains(comp)) {
                    List<Integer> lst2 = new ArrayList<>();
                    lst2.add(dig1);
                    lst2.add(dig2);
                    lst2.add(comp);

                    if (!cache.contains(lst2)) {
                        lst.add(lst2);
                        cache.add(lst2);
                    }
                }
            }
            set.add(dig1);
        }

        return lst;
    }

    /**
     * 双指针，通过左右两个指针来查找和等于0的数
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                break;
            } else if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int low = i + 1, high = nums.length - 1;
            while (low < high) {
                if (nums[i] + nums[low] + nums[high] < 0) {
                    low++;
                } else if (nums[i] + nums[low] + nums[high] > 0) {
                    high--;
                } else {
                    result.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;
                    while (low < high && nums[low] == nums[low - 1]) low++;
                    while (low < high && nums[high] == nums[high - 1]) high--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum1(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
