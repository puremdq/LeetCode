package com.aojiaoo.leetcode;//给定一个无重复元素的正整数数组 candidates 和一个正整数 target ，找出 candidates 中所有可以使数字和为目标数 target 的
//唯一组合。
//
// candidates 中的数字可以无限制重复被选取。如果至少一个所选数字数量不同，则两种组合是唯一的。
//
// 对于给定的输入，保证和为 target 的唯一组合数少于 150 个。
//
//
//
// 示例 1：
//
//
//输入: candidates = [2,3,6,7], target = 7
//输出: [[7],[2,2,3]]
//
//
// 示例 2：
//
//
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]]
//
// 示例 3：
//
//
//输入: candidates = [2], target = 1
//输出: []
//
//
// 示例 4：
//
//
//输入: candidates = [1], target = 1
//输出: [[1]]
//
//
// 示例 5：
//
//
//输入: candidates = [1], target = 2
//输出: [[1,1]]
//
//
//
//
// 提示：
//
//
// 1 <= candidates.length <= 30
// 1 <= candidates[i] <= 200
// candidate 中的每个元素都是独一无二的。
// 1 <= target <= 500
//
// Related Topics 数组 回溯 👍 1592 👎 0


import util.GenUtil;

import java.util.*;
//TODO
//leetcode submit region begin(Prohibit modification and deletion)
class Solution39 {
    private final Map<Integer, Integer> candidatesDict = new HashMap<>();
    private int[] sortedCandidates;


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        sortedCandidates = candidates;
        for (int i = 0; i < candidates.length; i++) {
            candidatesDict.put(candidates[i], i);
        }
        return find(target);
    }


    public List<List<Integer>> find(int target) {

        int i = 0;
        List<List<Integer>> res = new ArrayList<>();
        boolean find = false;
        while (i < sortedCandidates.length) {
            if (sortedCandidates[i] > target) {
                return res;
            }
            List<Integer> currentSet = new ArrayList<>();
            if (sortedCandidates[i] == target) {
                currentSet.add(target);
                res.add(currentSet);
                return res;
            }

            int need = target - sortedCandidates[i];
            if (need < sortedCandidates[i]) {
                i++;
                continue;
            }
            if (need == sortedCandidates[i] && find) {
                return res;
            }

            if (candidatesDict.get(need) != null) {
                find = true;
                currentSet.add(sortedCandidates[i]);
                currentSet.add(need);
                res.add(currentSet);
            }

            List<List<Integer>> currentRes = find(need);
            if (currentRes.size() > 0) {
                find = true;
                for (List<Integer> currentRe : currentRes) {
                    if (currentRe.size() <= 1) {
                        continue;
                    }
                    currentRe.add(sortedCandidates[i]);
                    res.add(currentRe);
                }
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution39 solution = new Solution39();
        int[] intArray = GenUtil.getIntArray("[2,3,6,7]");
        List<List<Integer>> sets = solution.combinationSum(intArray, 7);
        System.out.println(sets);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
