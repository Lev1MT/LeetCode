package com.lev1.array;

/**
 * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。
 * 在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 */
public class MaxAreaDemo {

    public static int maxArea(int[] height) {
        int res = 0;
        // 双指针，较小的一边往较大的一边移动
        for (int i = 0, j = height.length - 1; j > i; ) {
            int he = Math.min(height[i], height[j]);
            int wi = j - i;
            res = Math.max(res, he * wi);
            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
