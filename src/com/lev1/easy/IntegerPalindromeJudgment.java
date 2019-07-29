package com.lev1.easy;


/**
 * �ж�һ�������Ƿ��ǻ�������
 * ��������ָ���򣨴������ң��͵��򣨴������󣩶�����һ����������
 * ��������תΪ�ַ��������������⡣
 */
public class IntegerPalindromeJudgment {

    public static void main(String[] args) {
        System.out.println(isPalindrome(12121));
    }

    /**
     * ÿ�ν���ȡ����� �� %10����ȡ����͵����֣�y = x % 10
     * ����͵����ּӵ�ȡ������ĩβ��revertNum = revertNum * 10 + y
     * ÿȡһ�����λ���֣�x ��Ҫ�Գ��� 10
     * �ж� x �ǲ���С�� revertNum ������С�ڵ�ʱ��˵�������Ѿ��԰���߹�����
     * ����ж���ż������������ż���Ļ���revertNum �� x ��ȣ�
     * ����������Ļ������м�����־���revertNum �����λ�ϣ��������� 10 �Ժ�Ӧ�ú� x ��ȡ�
     * @param x ��Ҫ�жϵĻ�������
     * @return ����true��false
     */
    public static boolean isPalindrome(int x) {
        // ��Ϊx<0ʱ����һλΪ-�ţ������ڻ��ģ���xĩβΪ0ʱ����Ϊ������һλ��������Ϊ0������Ҳ�����ڻ���
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {   // ��x>revʱ����x�ĺ�벿�����ֵ��������뵽rev��ĩβ��ֱ��x<rev
            rev = rev * 10 + x % 10;
            x /= 10;
        }
        return x == rev || x == rev / 10;
    }
}
