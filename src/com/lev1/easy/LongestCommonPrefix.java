package com.lev1.easy;

/**
 * ��дһ�������������ַ��������е������ǰ׺��
 * ��������ڹ���ǰ׺�����ؿ��ַ��� ""��
 * ��������ֻ����Сд��ĸ a-z ��
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strs = {"flower", "flow", "flight"};
        System.out.println(longestCommonPrefix(strs));
        System.out.println(longestCommonPrefix2(strs));
        System.out.println(longestCommonPrefix3(strs));
    }

    /**
     * ��һ�ַ�����ˮƽɨ��
     * ʹ��String�е�indexOf()�������ж�prefix�Ƿ����Ӵ�
     * indexOf()�����������Ӵ�����λ�ã��������������Ӵ�����ͷ
     *
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

    /**
     * �ڶ��ַ�����ˮƽɨ�裬������String��indexOf����
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * �����ַ���������(�ݹ�)
     *
     * @param strs �ַ�������
     * @return �����ǰ׺
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix3(strs, 0, strs.length-1);
    }

    public static String longestCommonPrefix3(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        } else {
            int mid = (l + r) / 2;
            String left = longestCommonPrefix3(strs, l, mid);
            String right = longestCommonPrefix3(strs, mid + 1, r);
            return commonPrefix(left, right);
        }
    }

    public static String commonPrefix(String left, String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if (left.charAt(i) != right.charAt(i)) {
                return left.substring(0, i);
            }
        }
        return left.substring(0, min);
    }
}
