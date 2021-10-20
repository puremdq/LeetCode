package com.aojiaoo.leetcode;//编写一个程序，通过填充空格来解决数独问题。
//
// 数独的解法需 遵循如下规则：
//
//
// 数字 1-9 在每一行只能出现一次。
// 数字 1-9 在每一列只能出现一次。
// 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
//
//
// 数独部分空格内已填入了数字，空白格用 '.' 表示。
//
//
//
//
//
//
// 示例：
//
//
//输入：board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".
//",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".
//","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6
//"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[
//".",".",".",".","8",".",".","7","9"]]
//输出：[["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8
//"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],[
//"4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9",
//"6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4",
//"5","2","8","6","1","7","9"]]
//解释：输入的数独如上图所示，唯一有效的解决方案如下所示：
//
//
//
//
//
//
// 提示：
//
//
// board.length == 9
// board[i].length == 9
// board[i][j] 是一位数字或者 '.'
// 题目数据 保证 输入数独仅有一个解
//
//
//
//
// Related Topics 数组 回溯 矩阵 👍 971 👎 0


import util.GenUtil;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution37 {

    Map<String, Set<Character>> dataMap = new HashMap<>();
    Stack<Integer> waysX = new Stack<>();
    Stack<Integer> waysY = new Stack<>();

    public void solveSudoku(char[][] board) {
        int i = 0, j = 0;
        boolean goBack = false;
        while (i < 9) {
            if (board[i][j] != '.') {
                j++;
            } else {
                String keys = i + "-" + j;
                Set<Character> backups = goBack ? dataMap.get(keys) : find(board, i, j);
                if (backups.size() == 0) {
                    //回溯
                    goBack = true;
                    i = waysX.pop();
                    j = waysY.pop();
                    board[i][j] = '.';
                } else {
                    for (Character backup : backups) {
                        board[i][j] = backup;
                    }
                    backups.remove(board[i][j]);
                    waysX.push(i);
                    waysY.push(j);
                    dataMap.put(keys, backups);
                    j++;
                    goBack = false;
                }
            }

            if (j >= 9) {
                i++;
                j = 0;
            }
        }


    }


    public static Set<Character> find(char[][] board, int i, int j) {
        Set<Character> currentSet = new LinkedHashSet<>();
        for (int i1 = 1; i1 <= 9; i1++) {
            currentSet.add((char) ('0' + i1));
        }

        for (int i1 = 0; i1 < 9; i1++) {
            currentSet.remove(board[i][i1]);
            if (currentSet.size() < 1) {
                return currentSet;
            }
        }

        for (int i1 = 0; i1 < 9; i1++) {
            currentSet.remove(board[i1][j]);
            if (currentSet.size() < 1) {
                return currentSet;
            }
        }

        int i1 = i / 3 * 3;
        int j1 = j / 3 * 3;

        while (i1 <= (i / 3 * 3 + 2)) {
            currentSet.remove(board[i1][j1]);
            if (currentSet.size() < 1) {
                return currentSet;
            }
            j1++;
            if (j1 > (j / 3 * 3 + 2)) {
                j1 = j1 - 3;
                i1++;
            }
        }
        return currentSet;
    }

    public static void main(String[] args) {
        String s = "[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]";
        char[][] intArrays = GenUtil.getIntArrays(s);
        Solution37 solution = new Solution37();
        solution.solveSudoku(intArrays);
        System.out.println(Arrays.deepToString(intArrays));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
