package com.aojiaoo.leetcode;//给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
//
//
//
//
//
// 示例 1：
//
//
//输入：s = "(()"
//输出：2
//解释：最长有效括号子串是 "()"
//
//
// 示例 2：
//
//
//输入：s = ")()())"
//输出：4
//解释：最长有效括号子串是 "()()"
//
//
// 示例 3：
//
//
//输入：s = ""
//输出：0
//
//
//
//
// 提示：
//
//
// 0 <= s.length <= 3 * 10⁴
// s[i] 为 '(' 或 ')'
//
//
//
// Related Topics 栈 字符串 动态规划 👍 1478 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution32 {
    public int longestValidParentheses(String s) {
        int max=0;//存放最大的长度
        int len=s.length();//字符串长度
        int[] dp=new int[len];//存放每个位置的长度
        for(int i=1;i<len;i++) {//遍历字符串
            if(s.charAt(i)==')') {//字符串存在)
                if(s.charAt(i-1)=='(')//当前下标的前一位是（
                    if(i>=2) {//确定i是否能够移动到前一组符号组
                        dp[i]=dp[i-2]+2;
                    }else
                        dp[i]=2;
                else if(i-dp[i-1]>0&&s.charAt(i-dp[i-1]-1)=='(')
                    //当前下标前一位是），且前面存在（
                    if(i-dp[i-1]>=2) {//确定i是否能够移动到前一组符号组
                        dp[i]=dp[i-1]+dp[i-dp[i-1]-2]+2;
                    }else
                        dp[i]=dp[i-1]+2;
                max=Math.max(max, dp[i]);//选出最大的长度
            }
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
