package com.lev1.easy;

/**
 * ����һ�� 32 λ���з�������������Ҫ�����������ÿλ�ϵ����ֽ��з�ת��
 * �������ǵĻ���ֻ�ܴ洢���� 32 λ���з�������
 * ������ֵ��ΧΪ [?231,  231 ? 1]��
 * �����������裬�����ת�����������ô�ͷ��� 0��
 */
public class IntegerReverseDemo {

    public static void main(String[] args) {
        System.out.println(reverse(153423646));
    }

    /**
     * ˼·���ظ�����x�����һ�����֣����������뵽rev�ĺ��棬���rev����x�෴
     * ʹ����ѧ������
     * //pop operation:
     * pop = x % 10;
     * x /= 10;
     *
     * //push operation:
     * temp = rev * 10 + pop;
     * rev = temp;
     * �� temp=rev?10+pop ʱ���ܻᵼ�������
     * temp>Integer.MAX_VALUE�� temp<Integer.MIN_VALUE��
     * ����ж�(����x����0,x<0ʱͬ��)��
     * ��ʽ�У�rev>Integer.MAX_VALUE/10ʱ��temp���
     * rev == Integer.MAX_VALUE/10����pop>Integer.MAX_VALUE�����һλ����(7)��temp���
     * @param x ��Ҫ��ת��intֵ
     * @return ���ط�ת���intֵ������������������0��
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
