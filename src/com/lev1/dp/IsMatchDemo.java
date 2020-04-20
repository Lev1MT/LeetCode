package com.lev1.dp;

/**
 * 正则表达式匹配，','匹配任意单个字符，'*'匹配零个或多个前面的那一个元素
 * 全部匹配整个字符串，而不是部分字符串
 */
public class IsMatchDemo {

  /**
   * @param text    待匹配字符串
   * @param pattern 规律字符串
   * @return 是否匹配成功
   */
  public static boolean isMatchDP(String text, String pattern) {
        int m = text.length(), n = pattern.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        // 初始化第0列，因为pattern 的空字符只能匹配空字符，所以除了dp[0][0]第0列其他值都为false
        for (int i = 1; i <= m; i++) dp[i][0] = false;
        //初始化第0行，只有x*能匹配空串，如果有*，它的真值一定和dp[0][j-2]的相同(略过它之前的符号)
        for (int j = 1; j <= n; j++)
            dp[0][j] = j > 1 && '*' == pattern.charAt(j - 1) && dp[0][j - 2];
        // 因为dp数组中编号=实际字符在字符串中的位置+1，所以以下i-1或j-1才是字符在字符串中实际位置
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                // 当*为0，或者当前字符匹配了*之前的字符，才能传递dp[i-1][j]的值
                if (pattern.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 2] || (text.charAt(i - 1) == pattern.charAt(j - 2) || pattern.charAt(j - 2) == '.') && dp[i - 1][j];
                } else {
                    // 只有当前字符完全匹配，才能传递dp[i-1][j-1]的值
                    dp[i][j] = (text.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') && dp[i - 1][j - 1];
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        System.out.println(isMatchDP("abc", "a*b*c*"));
    }
}
