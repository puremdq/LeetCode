package com.aojiaoo.leetcode;//编写一个函数来查找字符串数组中的最长公共前缀。
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 0 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 
// 👍 1585 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution14 {
    public String longestCommonPrefix(String[] strs) {

        int start = 0;
        StringBuilder res = new StringBuilder();
        char last = ' ';
        while (true) {
            last = ' ';
            for (String s : strs) {
                if (start >= s.length()) {
                    return res.toString();
                }
                char temp = s.charAt(start);
                if (last != ' ' && last != temp) {
                    return res.toString();
                }
                last = temp;
            }
            start++;
            res.append(last);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
