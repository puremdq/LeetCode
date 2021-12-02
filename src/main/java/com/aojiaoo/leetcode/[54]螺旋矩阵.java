package com.aojiaoo.leetcode;//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
//
//
// 示例 1：
//
//
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
//
//
// 示例 2：
//
//
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
//
//
//
//
// 提示：
//
//
// m == matrix.length
// n == matrix[i].length
// 1 <= m, n <= 10
// -100 <= matrix[i][j] <= 100
//
// Related Topics 数组 矩阵 模拟 👍 907 👎 0


import util.GenUtil;

import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int xMax = matrix.length;
        int yMax = matrix[0].length;
        int size = xMax * yMax;
        List<Integer> res = new ArrayList<>();
        int used = 1000;
        int i = 0, j = 0;
        int step = 1;
        boolean isY = true;
        while (res.size() < size) {
            if (matrix[i][j] != used) {
                res.add(matrix[i][j]);
                matrix[i][j] = used;
            }

            if (isY) {
                j = j + step;
                if (j >= yMax || j < 0 || matrix[i][j] == used) {
                    isY = false;
                    j = j - step;
                }

            } else {
                i = i + step;
                if (i >= xMax || i < 0 || matrix[i][j] == used) {
                    isY = true;
                    i = i - step;
                    step = -step;
                }
            }

        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(GenUtil.getIntArrays("[[1,2,3],[4,5,6],[7,8,9]]")));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
