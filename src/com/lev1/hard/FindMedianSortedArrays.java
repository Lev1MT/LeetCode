package com.lev1.hard;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int a[] = {2, 4, 6, 8};
        int b[] = {1, 3, 5, 7};
        double median = findMedianSortedArraysOwn(a, b);
        double median2 = findMedianSortedArrays(a,b);
        System.out.println(median2);
        System.out.println(median);
    }


    // 官方解决办法
    // 需要找到两个数组的中位数，因为中位数左右两边元素个数确定为((num1.length+num2.length+1)/2)
    // 将两个数组用halfLen分为两部分，然后从较短数组的第i个元素开始遍历查找，直到找到中间大小元素为止
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        //
        int m = nums1.length;
        int n = nums2.length;
        if (m > n) {    // 确保m<=n
            int temp[] = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }
        // 二叉树搜索，通过iMin和iMax的循环赋值来找到一个合适的中位数位置
        // iMin和iMax为辅助区间，用于确定i的位置
        int iMin = 0, iMax = m, halfLen = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;  // 从第一个数组的中间位置开始遍历
            int j = halfLen - i;    // 通过i的位置确定j的位置
            if (i < iMax && nums2[j - 1] > nums1[i]) {  // 如果i所在位置元素小于j-1所在位置元素
                iMin = i + 1;
            } else if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = i - 1;
            } else {
                int maxLeft = 0;
                if (i == 0) {
                    maxLeft = nums2[j - 1];
                } else if (j == 0) {
                    maxLeft = nums1[i - 1];
                } else {
                    maxLeft = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                if ((m + n) % 2 == 1) {
                    return maxLeft;
                }
                int minRight = 0;
                if (i == m) {
                    minRight = nums2[j];
                } else if (j == n) {
                    minRight = nums1[i];
                } else {
                    minRight= Math.min(nums1[i],nums2[j]);
                }
                return (maxLeft+minRight)/2.0;
            }
        }

        return 0.0;
    }

    // 使用归并排序，先将两个数组归并到一个新的数组中
    // 然后通过新的数组计算出中位数
    // 该方法时间复杂度为O(nlogn)，题目要求时间复杂度为O(log(m + n))，所以该方法无效。
    public static double findMedianSortedArraysOwn(int[] nums1, int[] nums2) {
        int i = 0, j = 0, foot = 0;
        int arr[] = new int[nums1.length + nums2.length];

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] <= nums2[j]) {
                arr[foot] = nums1[i];
                i++;
                foot++;
            } else {
                arr[foot] = nums2[j];
                j++;
                foot++;
            }
        }
        while (i < nums1.length) {
            arr[foot] = nums1[i];
            foot++;
            i++;
        }
        while (j < nums2.length) {
            arr[foot] = nums2[j];
            foot++;
            j++;
        }

        if (arr.length % 2 != 0) {
            return arr[arr.length / 2];
        } else {
            return (double) (arr[arr.length / 2] + arr[arr.length / 2 - 1]) / 2;
        }
    }
}
