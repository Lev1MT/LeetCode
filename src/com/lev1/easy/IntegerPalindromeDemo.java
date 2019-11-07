package com.lev1.easy;


/**
 * 判断一个整数是否是回文数。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 不将整数转为字符串来解决这个问题。
 */
public class IntegerPalindromeDemo {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12121));
    }

    /**
     * 每次进行取余操作 （ %10），取出最低的数字：y = x % 10
     * 将最低的数字加到取出数的末尾：revertNum = revertNum * 10 + y
     * 每取一个最低位数字，x 都要自除以 10
     * 判断 x 是不是小于 revertNum ，当它小于的时候，说明数字已经对半或者过半了
     * 最后，判断奇偶数情况：如果是偶数的话，revertNum 和 x 相等；
     * 如果是奇数的话，最中间的数字就在revertNum 的最低位上，将它除以 10 以后应该和 x 相等。
     * @param x 需要判断的回文整数
     * @return 返回true或false
     */
    public static boolean isPalindrome(int x) {
        // 因为x<0时，第一位为-号，不存在回文；当x末尾为0时，因为整数第一位数不可能为0，所以也不存在回文
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {   // 当x>rev时，将x的后半部分数字弹出，推入到rev的末尾，直到x<rev
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev / 10;
    }
}
