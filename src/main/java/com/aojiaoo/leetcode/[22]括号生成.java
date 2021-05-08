package com.aojiaoo.leetcode;//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：["()"]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 8
//
// Related Topics 字符串 回溯算法
// 👍 1758 👎 0


import lombok.extern.slf4j.Slf4j;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
@Slf4j
class Solution22 {

    private final Map<Integer, Set<String>> tempMap = new HashMap<>();

    public List<String> generateParenthesis(int n) {

        Set<String> res = new HashSet<>();
        res.add("()");
        tempMap.put(1, res);

        res = new HashSet<>();
        res.add("(())");
        res.add("()()");
        tempMap.put(2, res);


        Set<String> strings = tempMap.get(n);
        if (strings != null) {
            return new ArrayList<>(strings);
        }
        return new ArrayList<>( gen(n));


    }

    public Set<String> gen(int n) {
        Set<String> strings = tempMap.get(n);
        if (strings != null) {
            return strings;
        }
        log.info("开始递归n={}",n);
        Set<String> res = new HashSet<>();
        for (int i = 1; i <= n / 2; i++) {
            int j = n - i;
            log.info("i={},j={}",i,j);
            Set<String> gen1 = gen(i);
            Set<String> gen2 = gen(j);
            for (String value : gen1) {
                for (String s : gen2) {
                    res.add(value + s);
                    if (i != j) {
                        res.add(s + value);
                    }
                    if (i == 1) {
                        res.add("(" + s + ")");
                    }
                }
            }
        }
        tempMap.put(n, res);
        return res;
    }


    public static void main(String[] args) {
        Solution22 solution22 = new Solution22();
        System.out.println(solution22.generateParenthesis(10));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
