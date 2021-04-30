package com.aojiaoo.leetcode;//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
//
//
//
// 示例 1：
//
//
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
//
//
// 示例 2：
//
//
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
//
//
// 示例 3：
//
//
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
//
//
// 示例 4：
//
//
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
//
//
// 示例 5：
//
//
//输入：nums1 = [2], nums2 = []
//输出：2.00000
//
//
//
//
// 提示：
//
//
// nums1.length == m
// nums2.length == n
// 0 <= m <= 1000
// 0 <= n <= 1000
// 1 <= m + n <= 2000
// -106 <= nums1[i], nums2[i] <= 106
//
//
//
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
// Related Topics 数组 二分查找 分治算法
// 👍 4034 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length = nums1.length + nums2.length;
        int index1 = -1;
        int index2 = -1;
        if (length % 2 != 0) {
            index1 = (length - 1) / 2;
        } else {
            index2 = length / 2;
            index1 = index2 - 1;
        }

        int i = 0, j = 0;
        int pre = 0;
        int current = 0;
        while (i < nums1.length || j < nums2.length) {

            pre = current;

            boolean isOut = false;
            if (i >= nums1.length) {
                current = nums2[j];
                j++;
                isOut = true;
            } else {
                if (j >= nums2.length) {
                    current = nums1[i];
                    i++;
                    isOut = true;
                }
            }


            if (!isOut) {
                if (nums1[i] > nums2[j]) {
                    current = nums2[j];
                    j++;
                } else {
                    current = nums1[i];
                    i++;
                }
            }

            if (index2 == -1 && i + j - 1 == index1) {
                return (double) current;
            }
            if (index2 != -1 && (i + j - 1) == index2) {
                return (current + pre) / 2D;
            }
        }
        return (current + pre) >> 1;
    }

    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        double medianSortedArrays = solution.findMedianSortedArrays(new int[]{0}, new int[]{1});
        System.out.println(medianSortedArrays);
    }
}


//leetcode submit region end(Prohibit modification and deletion)

