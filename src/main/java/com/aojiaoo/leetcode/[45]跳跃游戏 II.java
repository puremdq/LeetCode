package com.aojiaoo.leetcode;

import util.GenUtil;

class Solution45 {
    public static int jump(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return 0;
        }
        int res = 0;
        int[] numsStep = new int[length];

        int endIndex = length - 1;
        for (int i = 0; i <= endIndex; i++) {

            if (numsStep[i] == 0) {
                numsStep[i] = i + nums[i];
            }
            if (numsStep[i] >= endIndex) {
                endIndex = i;
                res++;
                if (i == 0) {
                    break;
                }
                i = -1;

            }
        }
        return res;

    }

    public static void main(String[] args) {
        int[] intArray = GenUtil.getIntArray("[2,3,0,1,4]");
        System.out.println(jump(intArray));
    }
}
