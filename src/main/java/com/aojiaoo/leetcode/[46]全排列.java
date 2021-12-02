package com.aojiaoo.leetcode;

import util.GenUtil;

import java.util.ArrayList;
import java.util.List;

class Solution46 {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        execPermute(nums, new ArrayList<>(), res);
        return res;
    }


    public void execPermute(int[] nums, List<Integer> list, List<List<Integer>> res) {

        if (list.size() == nums.length) {
            res.add(list);
        }

        List<Integer> listBak = new ArrayList<>(list);
        boolean used = false;
        for (int num : nums) {
            if (!listBak.contains(num)) {
                List<Integer> currentList = list;
                if (!used) {
                    used = true;
                } else {
                    currentList = new ArrayList<>(listBak);
                }
                currentList.add(num);
                execPermute(nums, currentList, res);
            }
        }
    }

    public static void main(String[] args) {
        Solution46 solution = new Solution46();
        System.out.println(solution.permute(GenUtil.getIntArray("[1,2,3]")));
    }
}
