package com.lev1.easy;

/**
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 * 假设我们的环境只能存储得下 32 位的有符号整数
 * 则其数值范围为 [?231,  231 ? 1]。
 * 请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
public class IntegerReverseDemo {

    public static void main(String[] args) {
        System.out.println(reverse(153423646));
    }

    /**
     * 思路：重复弹出x的最后一个数字，并将它推入到rev的后面，最后rev将于x相反
     * 使用数学方法：
     * //pop operation:
     * pop = x % 10;
     * x /= 10;
     *
     * //push operation:
     * temp = rev * 10 + pop;
     * rev = temp;
     * 当 temp=rev?10+pop 时可能会导致溢出：
     * temp>Integer.MAX_VALUE或 temp<Integer.MIN_VALUE。
     * 溢出判断(假设x大于0,x<0时同理)：
     * 上式中，rev>Integer.MAX_VALUE/10时，temp溢出
     * rev == Integer.MAX_VALUE/10并且pop>Integer.MAX_VALUE的最后一位数字(7)，temp溢出
     * @param x 需要反转的int值
     * @return 返回反转后的int值，如果整数溢出，返回0。
     */
    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x = x / 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
