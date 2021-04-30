package com.aojiaoo.leetcode;//给你一个字符串 s，找到 s 中最长的回文子串。
//
//
//
// 示例 1：
//
//
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
//
//
// 示例 2：
//
//
//输入：s = "cbbd"
//输出："bb"
//
//
// 示例 3：
//
//
//输入：s = "a"
//输出："a"
//
//
// 示例 4：
//
//
//输入：s = "ac"
//输出："a"
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 1000
// s 仅由数字和英文字母（大写和/或小写）组成
//
// Related Topics 字符串 动态规划
// 👍 3594 👎 0

//abcdefghijkl
//leetcode submit region begin(Prohibit modification and deletion)
class Solution5 {
    public static String longestPalindrome(String s) {
        if (s == null || s.length() == 1) {
            return s;
        }
        int start = 0;
        int resStart = 0;
        int resEnd = 0;

        while (start < s.length() - (resEnd - resStart)) {

            int j = s.length() - 1;

            //寻找i-j是不是回文数
            // 如果是  j++  直到 res.length()
            while (start <= j) {
                if (isPalindrome(s, start, j)) {

                    if (j + 1 - start > resEnd - resStart) {
                        resStart = start;
                        resEnd = j + 1;
                    }
                    break;
                } else {
                    j--;
                }
            }
            start++;
        }
        return s.substring(resStart, resEnd);
    }


    public static boolean isPalindrome(String s, int start, int end) {
        if (start > end) {
            return false;
        }

        boolean res = true;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            } else {
                start++;
                end--;
            }

        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
