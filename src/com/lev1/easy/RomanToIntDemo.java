package com.lev1.easy;

import java.util.HashMap;
import java.util.Map;

/**
 * ��������ת����:
 * �������ְ������������ַ�:I��V��X��L��C��D��M��
 * <p>
 * �ַ�          ��ֵ
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * ���磬 �������� 2 д�� II ����Ϊ�������е� 1��12 д�� XII ����Ϊ X + II�� 27 д�� XXVII, ��Ϊ XX+V+II��
 * ͨ������£�����������С�������ڴ�����ֵ��ұߡ���Ҳ�������������� 4 ��д��IIII������IV��
 * ���� 1 ������ 5 ����ߣ�����ʾ�������ڴ��� 5 ��С�� 1 �õ�����ֵ 4 ��ͬ���أ����� 9 ��ʾΪIX��
 * �������Ĺ���ֻ�������������������
 * I���Է���V(5) ��X(10) ����ߣ�����ʾ 4 �� 9��
 * X���Է���L(50) ��C(100) ����ߣ�����ʾ 40 �� 90��
 * C���Է���D(500) ��M(1000) ����ߣ�����ʾ400 �� 900��
 * ����һ���������֣�����ת��������������ȷ���� 1 �� 3999 �ķ�Χ�ڡ�
 */
public class RomanToIntDemo {

    public static void main(String[] args) {
        System.out.println(romanToInt("DMXIVII"));
    }

    public static int romanToInt(String s) {
        // ���������ֿ��ܵ�������뵽hashMap��
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int ans = 0;
        for (int i = 0; i < s.length(); ) {    // i���������������һ������λ�������i+=2��һ���Ƿ��������i++;
            if (i + 1 < s.length() && map.containsKey(s.substring(i, i + 2))) {
                ans += map.get(s.substring(i, i + 2));
                i += 2;
            } else {
                ans += map.get(s.substring(i, i + 1));
                i++;
            }
        }
        return ans;
    }
}