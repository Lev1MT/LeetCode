package com.lev1.easy;

/**
 * ��дһ�������������ַ��������е������ǰ׺��
 * <p>
 * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
 * ��������ֻ����Сд��ĸ a-z ��
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    /**
     * ��һ�ַ�����ˮƽɨ��
     *
     * https://sofa.alipay.com/docs sofa�ٷ��ĵ�
     * @param strs �ַ�������
     * @return ���������ǰ׺
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 0; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) return "";
            }
        }
        return prefix;
    }

//    public static String longestCommonPrefix2(String[] strs){
//        String prefix = strs[0];
//
//
//        return prefix;
//    }
}
