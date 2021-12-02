package com.aojiaoo.leetcode;//给你一个正整数 n ，生成一个包含 1 到 n² 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
//
//
//
// 示例 1：
//
//
//输入：n = 3
//输出：[[1,2,3],[8,9,4],[7,6,5]]
//
//
// 示例 2：
//
//
//输入：n = 1
//输出：[[1]]
//
//
//
//
// 提示：
//
//
// 1 <= n <= 20
//
// Related Topics 数组 矩阵 模拟 👍 523 👎 0


import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution59 {
    public static int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];
        int size = n * n;
        int i = 0, j = 0;
        int step = 1;
        boolean isY = true;
        int index = 1;
        while (true) {
            if (matrix[i][j] == 0) {
                matrix[i][j] = index;
                if (index == size) {
                    break;
                }
                index++;
            }

            if (isY) {
                j = j + step;
                if (j >= n || j < 0 || matrix[i][j] != 0) {
                    isY = false;
                    j = j - step;
                }

            } else {
                i = i + step;
                if (i >= n || i < 0 || matrix[i][j] != 0) {
                    isY = true;
                    i = i - step;
                    step = -step;
                }
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(generateMatrix(1)));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
