package com.aojiaoo.leetcode;//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//
//
//
//
//
// 示例 1：
//
//
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
//
//
// 示例 2：
//
//
//输入：digits = ""
//输出：[]
//
//
// 示例 3：
//
//
//输入：digits = "2"
//输出：["a","b","c"]
//
//
//
//
// 提示：
//
//
// 0 <= digits.length <= 4
// digits[i] 是范围 ['2', '9'] 的一个数字。
//
// Related Topics 深度优先搜索 递归 字符串 回溯算法
// 👍 1295 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution17 {
    private List<String> res = new ArrayList<>();
    private String digitStr = "";
    String[] strArr = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};


    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return res;
        }
        digitStr = digits;
        gen("", 0, 0);
        return res;
    }


    public void gen(String current, int start1, int start2) {

        String currentStr = strArr[digitStr.charAt(start1) - '0' - 2];

        char c = currentStr.charAt(start2);
        if (start1 == digitStr.length() - 1) {
            res.add(current + c);
        } else {
            gen(current + c, start1 + 1, 0);
        }
        if (start2 + 1 < currentStr.length()) {
            gen(current, start1, start2 + 1);
        }
    }

    public static void main(String[] args) {
        Solution17 solution17 = new Solution17();
        System.out.println(solution17.letterCombinations("23"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
