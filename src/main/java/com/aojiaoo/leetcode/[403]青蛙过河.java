package com.aojiaoo.leetcode;//一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
//
// 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。 
//
// 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃一个单位（即只能从单元格 1 跳至单元格 2 ）。 
//
// 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。
// 
//
// 
//
// 示例 1： 
//
// 
//输入：stones = [0,1,3,5,6,8,12,17]
//输出：true
//解释：青蛙可以成功过河，按照如下方案跳跃：跳 1 个单位到第 2 块石子, 然后跳 2 个单位到第 3 块石子, 接着 跳 2 个单位到第 4 块石子, 然
//后跳 3 个单位到第 6 块石子, 跳 4 个单位到第 7 块石子, 最后，跳 5 个单位到第 8 个石子（即最后一块石子）。 
//
// 示例 2： 
//
// 
//输入：stones = [0,1,2,3,4,8,9,11]
//输出：false
//解释：这是因为第 5 和第 6 个石子之间的间距太大，没有可选的方案供青蛙跳跃过去。 
//
// 
//
// 提示： 
//
// 
// 2 <= stones.length <= 2000 
// 0 <= stones[i] <= 231 - 1 
// stones[0] == 0 
// 
// Related Topics 动态规划 
// 👍 303 👎 0


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.GenUtil;

import java.util.HashMap;
import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution403 {

    //石头位置所在的索引
    Map<Integer, Integer> stonesAreaIndex = new HashMap<>();
    Map<Integer, Map<Integer, Integer>> deadWays = new HashMap<>();
    //step[1]=1  //表示第0个石头是由调一步得来的
    int[] stoneIndexWitchFrom;
    public static final Logger logger = LoggerFactory.getLogger(Solution403.class);

    private boolean init(int[] stones) {
        if (stones.length == 1) {
            return true;
        }
        stonesAreaIndex.put(0, 0);
        for (int i = 1; i < stones.length; i++) {
            if (stones[i] - stones[i - 1] > i) {
                return false;
            }
            stonesAreaIndex.put(stones[i], i);
        }
        stoneIndexWitchFrom = new int[stones.length];
        stoneIndexWitchFrom[1] = 0;

        return true;
    }

    public boolean canCross(int[] stones) {

        if (!init(stones)) {
            return false;
        }

        int currentStoneIndex = 1;
        while (currentStoneIndex != stones.length - 1) {
            //从上一步 过来跳的步数
            int currentIndexFromStep = stones[currentStoneIndex] - stones[stoneIndexWitchFrom[currentStoneIndex]];

            //尝试要跳的步数
            boolean notFound = true;
            for (int i = -1; i <= 1; i++) {
                int jumpStep = currentIndexFromStep + i;
                Integer tryNextIndex = tryJumpStep(stones, currentStoneIndex, jumpStep);
                if (tryNextIndex != null) {
                    logger.info("currentStoneIndex:{},tryNextIndex:{} 成功,jumpStep={}", currentStoneIndex, tryNextIndex, jumpStep);
                    currentStoneIndex = tryNextIndex;
                    notFound = false;
                    break;
                }
            }

            if (notFound) {
                if (currentStoneIndex == 0) {
                    //第一个走不通退出
                    return false;
                }

                int fromIndex = stoneIndexWitchFrom[currentStoneIndex];
                Map<Integer, Integer> currentDeadWaysMap = deadWays.getOrDefault(fromIndex, new HashMap<>());

                logger.info("currentStoneIndex:{},尝试所有无法走通,添加死路:{}-{}", currentStoneIndex, fromIndex, currentStoneIndex);

                currentDeadWaysMap.put(currentStoneIndex, 1);
                deadWays.put(fromIndex, currentDeadWaysMap);
                logger.info("currentStoneIndex:{},尝试所有无法走通,回溯到:{}", currentStoneIndex, fromIndex);
                //回溯
                stoneIndexWitchFrom[currentStoneIndex] = 0;
                currentStoneIndex = fromIndex;
            }
        }
        return true;
    }

    public Integer tryJumpStep(int[] stones, int currentStoneIndex, int jumpStep) {

        int currentArea = stones[currentStoneIndex];
        //尝试要跳的步数所在index
        Integer tryNextIndex = stonesAreaIndex.get(currentArea + jumpStep);
        //当前位置所有的死路
        Map<Integer, Integer> currentDeadWaysMap = deadWays.get(currentStoneIndex);

        if (jumpStep > 0 && tryNextIndex != null && (currentDeadWaysMap == null || currentDeadWaysMap.get(tryNextIndex) == null)) {
            stoneIndexWitchFrom[tryNextIndex] = currentStoneIndex;
            return tryNextIndex;
        }
        return null;
    }

    public static void main(String[] args) {
        Solution403 solution403 = new Solution403();
        System.out.println(solution403.canCross(GenUtil.getIntArray(" [0,1,2,4,5,6,8,9,11,14,19,20,22,23,24,25,27,30]")));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
