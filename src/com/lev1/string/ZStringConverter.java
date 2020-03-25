package com.lev1.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 */
public class ZStringConverter {
    public static String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        // 初始化每一行的字符builder
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            list.add(new StringBuilder());
        }
        int curRow = 0; //当前第几行
        boolean goingDown = false;  // 判断当前行是否需要转向
        for (char c : s.toCharArray()) {
            list.get(curRow).append(c);
            // 当当前行为第一行或者最后一行时，需要进行转向
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder builder : list) result.append(builder);
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(convert("LEETCODEISHIRING", 3));
        System.out.println("LCIRETOESIIGEDHN".equals(convert("LEETCODEISHIRING", 3)));
    }
}
