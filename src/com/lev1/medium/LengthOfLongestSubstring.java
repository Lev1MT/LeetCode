package com.lev1.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String str = "sdafklajhdfahkfsad";
        int a = lengthOfLongestSubstring(str);
        System.out.println(a);
    }

    // 滑动窗口
    // 遍历字符串中的字符，记录字符和字符所在位置+1
    // 如果发现map中有重复的字符，将重复字符的位置替换为重复的字符所在位置+1
    // 使用ans来记录每一次遍历的非重复长度最大值
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        int length = s.length();
        for (int i = 0,j= 0; j < length; j++) {
            Character character = s.charAt(j);
            // 如果map中存在该字符，更新i的位置为重复字符的下一个位置
            if (map.containsKey(character)) {
                i = Math.max(map.get(character), i);
            }
            // 更新最大子串长度
            ans = Math.max(ans,j-i+1);
            // 记录字符以及字符下一个位置索引
            map.put(character,j+1);
        }

        return ans;
    }
}
