package com.lev1;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 */
public class FindMedianSortedArrays {

    public static void main(String[] args) {
        int a[] = {2,4,6,8};
        int b[] = {1,3,5,7};
        double median = findMedianSortedArraysOwn(a,b);
        System.out.println(median);
    }


    // 官方解决办法
    public static double findMedianSortedArrays(int[] nums1, int[] nums2){

        return 0;
    }

    // 使用归并排序，先将两个数组归并到一个新的数组中
    // 然后通过新的数组计算出中位数
    // 该方法时间复杂度为O(nlogn)，题目要求时间复杂度为O(log(m + n))，所以该方法无效。
    public static double findMedianSortedArraysOwn(int[] nums1, int[] nums2){
        int i=0, j=0, foot = 0;
        int arr[] = new int[nums1.length+nums2.length];

        while (i<nums1.length && j< nums2.length){
            if (nums1[i]<=nums2[j]){
                arr[foot] = nums1[i];
                i++;
                foot++;
            }else {
                arr[foot] = nums2[j];
                j++;
                foot++;
            }
        }
        while (i<nums1.length){
            arr[foot] = nums1[i];
            foot++;
            i++;
        }
        while (j<nums2.length){
            arr[foot] = nums2[j];
            foot++;
            j++;
        }

        if (arr.length%2!=0){
            return arr[arr.length/2];
        }else {
            return (double) (arr[arr.length/2]+arr[arr.length/2-1])/2;
        }
    }
}
