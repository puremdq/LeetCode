package com.aojiaoo.leetcode;//给你一个整数数组 nums ，你可以对它进行一些操作。
//
// 每次操作中，选择任意一个 nums[i] ，删除它并获得 nums[i] 的点数。之后，你必须删除每个等于 nums[i] - 1 或 nums[i] +
// 1 的元素。 
//
// 开始你拥有 0 个点数。返回你能通过这些操作获得的最大点数。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,2]
//输出：6
//解释：
//删除 4 获得 4 个点数，因此 3 也被删除。
//之后，删除 2 获得 2 个点数。总共获得 6 个点数。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2,2,3,3,3,4]
//输出：9
//解释：
//删除 3 获得 3 个点数，接着要删除两个 2 和 4 。
//之后，再次删除 3 获得 3 个点数，再次删除 3 获得 3 个点数。
//总共获得 9 个点数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 2 * 104 
// 1 <= nums[i] <= 104 
// 
// Related Topics 动态规划 
// 👍 269 👎 0


import util.GenUtil;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution740 {

    private Map<Integer, Integer> map = new TreeMap<>();

    public int deleteAndEarn(int[] nums) {

        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + num);
        }
        List<Integer> list = new ArrayList<>(map.keySet());

        //上一个计算到的位置
        int preKeyIndex = 0;
        int keyIndex = 1;
        int resPre = 0;
        int res = map.get(list.get(preKeyIndex));


        while (keyIndex < list.size()) {
            if (list.get(keyIndex) - list.get(preKeyIndex) <= 1) {
                //差值在1个单位以内不能要
                //判断是否可以去掉上一个数
                if (resPre + map.get(list.get(keyIndex)) > res) {
                    //要这一步的值比较大
                    int resTemp = res;
                    preKeyIndex = keyIndex;
                    res = resPre + map.get(list.get(keyIndex));
                    resPre = resTemp;
                }
                keyIndex++;
            } else {
                preKeyIndex = keyIndex;
                resPre = res;
                res = res + map.get(list.get(keyIndex));
                keyIndex++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution740 solution = new Solution740();
        System.out.println(solution.deleteAndEarn(GenUtil.getIntArray("[2,2,3,3,3,4]")));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
