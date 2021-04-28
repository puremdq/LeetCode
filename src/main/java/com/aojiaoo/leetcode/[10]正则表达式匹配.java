package com.aojiaoo.leetcode;//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
//
//
// '.' 匹配任意单个字符
// '*' 匹配零个或多个前面的那一个元素
//
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
//
//
// 示例 1：
//
//
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
//
//
// 示例 2:
//
//
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
//
//
// 示例 3：
//
//
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
//
//
// 示例 4：
//
//
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
//
//
// 示例 5：
//
//
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false
//
//
//
// 提示：
//
//
// 0 <= s.length <= 20
// 0 <= p.length <= 30
// s 可能为空，且只包含从 a-z 的小写字母。
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。
// 保证每次出现字符 * 时，前面都匹配到有效的字符
//
// Related Topics 字符串 动态规划 回溯算法
// 👍 2070 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution10 {
    public static boolean isMatch(String s, String p) {
        if (s.length() == 0 || p.length() == 0) {
            return false;
        }
        int i = 0, j = 0;
        while (i < s.length() || j < p.length()) {
            if (j == p.length()) {
                return false;
            }

            if (i == s.length()) {
                if (p.charAt(j) == '*') {
                    int diff = p.length() - j - 1;
                    if (diff <= 0) {
                        return true;
                    }
                    s = s.substring(s.length() - diff);
                    p = p.substring(j + 1);
                    i = 0;
                    j = 0;
                } else {
                    return false;
                }
            }

            char s1 = s.charAt(i);
            char p1 = p.charAt(j);
            if ('.' == p1 || s1 == p1) {
                i++;
                j++;
                continue;
            }
            if ('*' == p1) {
                if (j - 1 < 0) {
                    return false;
                }
                char pre = p.charAt(j - 1);
                if (pre == '.' || s1 == pre) {
                    i++;
                } else {
                    j++;
                }
                continue;
            }

            if (j + 1 < p.length() && '*' == p.charAt(j + 1)) {
                j++;
                j++;
                continue;
            }
            return false;
        }
        return i == s.length() && j == p.length();
    }

    public static boolean isMatch1(String s, String p) {
        if (s.length() == 0 || p.length() == 0) {
            return false;
        }


        int i = 0, j = 0;
        while (i < s.length() || j < p.length()) {
            if (j == p.length()) {
                return false;
            }

            if (i == s.length()) {
                if (p.charAt(j) == '*') {
                    int diff = p.length() - j - 1;
                    if (diff <= 0) {
                        return true;
                    }
                    s = s.substring(s.length() - diff);
                    p = p.substring(j + 1);
                    i = 0;
                    j = 0;
                } else {
                    return false;
                }
            }

            char s1 = s.charAt(i);
            char p1 = p.charAt(j);
            if ('.' == p1 || s1 == p1) {
                i++;
                j++;
                continue;
            }
            if ('*' == p1) {
                if (j - 1 < 0) {
                    return false;
                }
                char pre = p.charAt(j - 1);
                if (pre == '.' || s1 == pre) {
                    i++;
                } else {
                    j++;
                }
                continue;
            }

            if (j + 1 < p.length() && '*' == p.charAt(j + 1)) {
                j++;
                j++;
                continue;
            }
            return false;
        }
        return i == s.length() && j == p.length();
    }

    public static void main(String[] args) {
        System.out.println(isMatch("aaa", "b*a*c*a"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
