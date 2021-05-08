package com.aojiaoo.leetcode;//给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和
//。假定每组输入只存在唯一答案。
//
//
//
// 示例：
//
// 输入：nums = [-1,2,1,-4], target = 1
//输出：2
//解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
//
//
//
//
// 提示：
//
//
// 3 <= nums.length <= 10^3
// -10^3 <= nums[i] <= 10^3
// -10^4 <= target <= 10^4
//
// Related Topics 数组 双指针
// 👍 769 👎 0


import lombok.extern.slf4j.Slf4j;
import util.GenUtil;

import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
@Slf4j
class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        Integer result = null;
        for (int i1 = 0; i1 < nums.length; i1++) {
            int i = i1, j = nums.length - 1;
            while (i < j) {
                if (i1 == i) {
                    i++;
                    continue;
                }
                if (i1 == j) {
                    j--;
                    continue;
                }
                int temp = nums[i] + nums[j] + nums[i1];
                log.info("i1={},i={},j={},res={}", i1, i, j, temp);

                if (temp < target) {
                    i++;
                } else if (temp > target) {
                    j--;
                } else {
                    return target;
                }
                result = getResult(temp, result, target);
            }
        }
        return result;
    }

    public int getResult(int res1, Integer res2, int target) {
        if (res2 == null) {
            return res1;
        }
        int temp1 = Math.abs(res1 - target);
        int temp2 = Math.abs(res2 - target);
        return temp1 < temp2 ? res1 : res2;
    }


    public static void main(String[] args) {
        Solution16 solution16 = new Solution16();
        System.out.println(solution16.threeSumClosest(GenUtil.getIntArray("[-55,-24,-18,-11,-7,-3,4,5,6,9,11,23,33]"), 0));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
