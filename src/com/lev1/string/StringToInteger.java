package com.lev1.string;

/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 * 说明：
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 */
public class StringToInteger {

    public static int myAtoi(String str) {
        if (str == null) return 0;
        int n = str.length();
        int i = 0, res = 0;
        boolean isNagetive = false;
        // 去掉字符串首部的空格
        while (i < n && str.charAt(i) == ' ') {
            i++;
        }
        if (i == n) return 0;
        // 记录字符串首字符的正负信息
        if (str.charAt(i) == '-') isNagetive = true;
        if (str.charAt(i) == '-' || str.charAt(i) == '+') i++;
        while (i < n && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            int tmp = str.charAt(i) - '0';
            // 判断是否大于 最大32位整数
            if (!isNagetive && (res > 214748364 || (res == 214748364 && tmp >= 7))) {
                return Integer.MAX_VALUE;
            }
            // 判断是否小于 最小32位整数
            if (isNagetive && (-res < -214748364 || (-res == -214748364 && tmp >= 8))) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + tmp;
            i++;
        }
        if (isNagetive) {
            return -res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(myAtoi("   -20932049230492"));
    }
}
