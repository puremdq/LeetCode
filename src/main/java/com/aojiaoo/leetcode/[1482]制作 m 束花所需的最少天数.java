package com.aojiaoo.leetcode;//给你一个整数数组 bloomDay，以及两个整数 m 和 k 。
//
// 现需要制作 m 束花。制作花束时，需要使用花园中 相邻的 k 朵花 。
//
// 花园中有 n 朵花，第 i 朵花会在 bloomDay[i] 时盛开，恰好 可以用于 一束 花中。
//
// 请你返回从花园中摘 m 束花需要等待的最少的天数。如果不能摘到 m 束花则返回 -1 。
//
//
//
// 示例 1：
//
// 输入：bloomDay = [1,10,3,10,2], m = 3, k = 1
//输出：3
//解释：让我们一起观察这三天的花开过程，x 表示花开，而 _ 表示花还未开。
//现在需要制作 3 束花，每束只需要 1 朵。
//1 天后：[x, _, _, _, _]   // 只能制作 1 束花
//2 天后：[x, _, _, _, x]   // 只能制作 2 束花
//3 天后：[x, _, x, _, x]   // 可以制作 3 束花，答案为 3
//
//
// 示例 2：
//
// 输入：bloomDay = [1,10,3,10,2], m = 3, k = 2
//输出：-1
//解释：要制作 3 束花，每束需要 2 朵花，也就是一共需要 6 朵花。而花园中只有 5 朵花，无法满足制作要求，返回 -1 。
//
//
// 示例 3：
//
// 输入：bloomDay = [7,7,7,7,12,7,7], m = 2, k = 3
//输出：12
//解释：要制作 2 束花，每束需要 3 朵。
//花园在 7 天后和 12 天后的情况如下：
//7 天后：[x, x, x, x, _, x, x]
//可以用前 3 朵盛开的花制作第一束花。但不能使用后 3 朵盛开的花，因为它们不相邻。
//12 天后：[x, x, x, x, x, x, x]
//显然，我们可以用不同的方式制作两束花。
//
//
// 示例 4：
//
// 输入：bloomDay = [1000000000,1000000000], m = 1, k = 1
//输出：1000000000
//解释：需要等 1000000000 天才能采到花来制作花束
//
//
// 示例 5：
//
// 输入：bloomDay = [1,10,2,9,3,8,4,7,5,6], m = 4, k = 2
//输出：9
//
//
//
//
// 提示：
//
//
// bloomDay.length == n
// 1 <= n <= 10^5
// 1 <= bloomDay[i] <= 10^9
// 1 <= m <= 10^6
// 1 <= k <= n
//
// Related Topics 数组 二分查找
// 👍 145 👎 0


import util.GenUtil;

import java.util.*;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1482 {
    private final List<Integer> notNeedList = new ArrayList<>();
    /*
     * int compare(Object o1, Object o2) 返回一个基本类型的整型，
     * 返回负数表示：o1 小于o2，
     * 返回0 表示：o1和o2相等，
     * 返回正数表示：o1大于o2。
     */
    private final Map<Integer, List<Integer>> bloomDayMap = new TreeMap<>(Comparator.reverseOrder());

    private int m;
    private int k;
    private int total;
    private int currentCanHave;

    public int minDays(int[] bloomDay, int m, int k) {

        this.m = m;
        this.k = k;
        total = bloomDay.length;
        if (m * k > bloomDay.length) {
            return -1;
        }
        int notNeed = bloomDay.length - m * k;
        currentCanHave = m;
        for (int i = 0; i < bloomDay.length; i++) {
            int key = bloomDay[i];
            List<Integer> temp = bloomDayMap.getOrDefault(key, new ArrayList<>());
            temp.add(i);
            bloomDayMap.put(key, temp);
        }
        while (notNeed > 0) {
            boolean b = setNotNeed();
            if (!b) {
                break;
            }
            notNeed--;
        }
        for (Integer integer : bloomDayMap.keySet()) {
            return integer;
        }
        return 0;
    }

    private boolean setNotNeed() {
        for (int key : bloomDayMap.keySet()) {
            List<Integer> v = bloomDayMap.get(key);
            for (int i = 0; i < v.size(); i++) {
                Integer index = v.get(i);
                boolean b = checkIndex(index);
                if (!b) {
                    return false;
                }
                notNeedList.add(index);
                v.remove(i);
                if (v.size() == 0) {
                    bloomDayMap.remove(key);
                }
                return true;
            }
        }
        return true;
    }

    private boolean checkIndex(int toAddIndex) {
        if (notNeedList.size() == 0) {
            int temp = toAddIndex / k + (total - toAddIndex - 1) / k;
            if (temp >= m) {
                currentCanHave = temp;
                return true;
            } else {
                return false;
            }
        }
        notNeedList.sort(Integer::compareTo);

        int start = 0;
        int end = notNeedList.size() - 1;

        int pre = 0;
        int after = notNeedList.size();
        boolean find = false;

        if (toAddIndex <= notNeedList.get(0)) {
            if (notNeedList.get(0) == toAddIndex) {
                return true;
            }
            pre = -1;
            after = notNeedList.get(0);
            find = true;
        } else if (notNeedList.get(notNeedList.size() - 1) <= toAddIndex) {
            if (notNeedList.get(notNeedList.size() - 1) == toAddIndex) {
                return true;
            }
            pre = notNeedList.get(notNeedList.size() - 1);
            after = total;
            find = true;
        }

        if (!find) {
            while (end - start > 1) {
                int i = (start + end) / 2;
                Integer currentIndex = notNeedList.get(i);
                if (currentIndex.equals(toAddIndex)) {
                    return true;
                }
                if (currentIndex < toAddIndex) {
                    start = i;
                } else {
                    end = i;
                }
            }
        }

        int tempD = (after - pre - 1) / k - (after - toAddIndex - 1) / k - (toAddIndex - pre - 1) / k;
        int temp = currentCanHave - tempD;
        if (temp >= m) {
            currentCanHave = temp;
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        Solution1482 solution = new Solution1482();
        System.out.println(solution.minDays(GenUtil.getIntArray("[1,10,3,10,2]"), 3, 1));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
