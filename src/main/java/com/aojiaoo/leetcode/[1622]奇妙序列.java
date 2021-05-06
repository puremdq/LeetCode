package com.aojiaoo.leetcode;//请你实现三个 API append，addAll 和 multAll 来实现奇妙序列。
//
// 请实现 Fancy 类 ：
//
//
// Fancy() 初始化一个空序列对象。
// void append(val) 将整数 val 添加在序列末尾。
// void addAll(inc) 将所有序列中的现有数值都增加 inc 。
// void multAll(m) 将序列中的所有现有数值都乘以整数 m 。
// int getIndex(idx) 得到下标为 idx 处的数值（下标从 0 开始），并将结果对 109 + 7 取余。如果下标大于等于序列的长度，请返回
// -1 。
//
//
//
//
// 示例：
//
//
//输入：
//["Fancy", "append", "addAll", "append", "multAll", "getIndex", "addAll", "appe
//nd", "multAll", "getIndex", "getIndex", "getIndex"]
//[[], [2], [3], [7], [2], [0], [3], [10], [2], [0], [1], [2]]
//输出：
//[null, null, null, null, null, 10, null, null, null, 26, 34, 20]
//
//解释：
//Fancy fancy = new Fancy();
//fancy.append(2);   // 奇妙序列：[2]
//fancy.addAll(3);   // 奇妙序列：[2+3] -> [5]
//fancy.append(7);   // 奇妙序列：[5, 7]
//fancy.multAll(2);  // 奇妙序列：[5*2, 7*2] -> [10, 14]
//fancy.getIndex(0); // 返回 10
//fancy.addAll(3);   // 奇妙序列：[10+3, 14+3] -> [13, 17]
//fancy.append(10);  // 奇妙序列：[13, 17, 10]
//fancy.multAll(2);  // 奇妙序列：[13*2, 17*2, 10*2] -> [26, 34, 20]
//fancy.getIndex(0); // 返回 26
//fancy.getIndex(1); // 返回 34
//fancy.getIndex(2); // 返回 20
//
//
//
//
// 提示：
//
//
// 1 <= val, inc, m <= 100
// 0 <= idx <= 105
// 总共最多会有 105 次对 append，addAll，multAll 和 getIndex 的调用。
//
// Related Topics 设计 数学
// 👍 29 👎 0


import java.util.ArrayList;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)


class Fancy {
    class Operate {
        //操作时数组的长度;
        int onOperateLength;
        //操作数
        int operateNumber;

        //操作符号
        int operateSymbol;  //0 加 1乘

        Operate(int onOperateLength, int operateNumber, int operateSymbol) {
            this.onOperateLength = onOperateLength;
            this.operateNumber = operateNumber%(1000000000+7);
            this.operateSymbol = operateSymbol;
        }
    }

    List<Long> list;

    List<Operate> operateList;


    public Fancy() {
        this.list = new ArrayList<>();
        this.operateList = new ArrayList<>();
    }

    public void append(int val) {
        this.list.add((long) val);
    }

    public void addAll(int inc) {
        this.operateList.add(new Operate(this.list.size(), inc, 0));
    }

    public void multAll(int m) {
        this.operateList.add(new Operate(this.list.size(), m, 1));
    }

    public int getIndex(int idx) {
        if (idx >= this.list.size()) {
            return -1;
        }
        long res = this.list.get(idx);
        for (Operate operate : this.operateList) {
            if(operate.onOperateLength>idx){
                if (operate.operateSymbol==0) {
                    res=res+operate.operateNumber;
                }else {
                    res=res*operate.operateNumber;
                }
                res=res%(1000000000+7);
            }
        }
        return (int) res;
    }
}

/**
 * Your Fancy object will be instantiated and called as such:
 * Fancy obj = new Fancy();
 * obj.append(val);
 * obj.addAll(inc);
 * obj.multAll(m);
 * int param_4 = obj.getIndex(idx);
 */
//leetcode submit region end(Prohibit modification and deletion)
