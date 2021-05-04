package com.aojiaoo.leetcode;//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -105 <= nums[i] <= 105 
// 
// Related Topics 数组 双指针 
// 👍 3303 👎 0


import util.GenUtil;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {


        if (nums.length < 3) {
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return new ArrayList<>();
        }

        List<List<Integer>> res = new ArrayList<>();

        for (int i1 = 0; i1 < nums.length; i1++) {
            int i = i1, j = nums.length - 1;
            while (i < j) {
                if (nums[i1] == nums[i]) {
                    i++;
                    continue;
                }
                if (nums[i1] == nums[j]) {
                    j--;
                    continue;
                }
                int temp = nums[i] + nums[j] + nums[i1];
                if (temp < 0) {
                    i++;
                } else if (temp > 0) {
                    j--;
                } else {
                    ArrayList<Integer> tempArray = new ArrayList<>();
                    tempArray.add(nums[i1]);
                    tempArray.add(nums[i]);
                    tempArray.add(nums[j]);
                    res.add(tempArray);
                    i++;
                    j--;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        System.out.println(solution15.threeSum(GenUtil.getIntArray("[-1,0,1,2,-1,-4]")));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
