package com.aojiaoo.leetcode;//给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
//
// 示例 1:
//
// 输入: num1 = "2", num2 = "3"
//输出: "6"
//
// 示例 2:
//
// 输入: num1 = "123", num2 = "456"
//输出: "56088"
//
// 说明：
//
//
// num1 和 num2 的长度小于110。
// num1 和 num2 只包含数字 0-9。
// num1 和 num2 均不以零开头，除非是数字 0 本身。
// 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
//
// Related Topics 数学 字符串
// 👍 630 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution43 {

    public static String multiply(String num1, String num2) {
        if ("0".equals(num1) || "0".equals(num2)) {
            return "0";
        }

        char[] chars1 = num1.toCharArray();
        char[] chars2 = num2.toCharArray();
        char[] res = new char[chars1.length + chars2.length];

        int needAdd = 0;

        for (int index1 = chars1.length - 1; index1 >= 0; index1--) {
            for (int index2 = chars2.length - 1; index2 >= 0; index2--) {
                int indexRes = res.length - 1 - (chars1.length - 1 - index1) - (chars2.length - 1 - index2);
                int current = (chars2[index2] - '0') * (chars1[index1] - '0');
                int i1 = charAdd(res[indexRes], current % 10);
                if (i1 >= 10) {
                    needAdd = needAdd + 1;
                }
                res[indexRes] = (char) (i1 % 10 + '0');

                if (current >= 10 || needAdd > 0) {
                    int i2 = charAdd(res[indexRes - 1], current / 10 + needAdd);
                    needAdd = 0;
                    if (i2 >= 10) {
                        needAdd = 1;
                    }
                    res[indexRes - 1] = (char) (i2 % 10 + '0');
                }
            }
        }


        if (needAdd > 0) {
            int index = res.length - 1 - (chars1.length - 1) - (chars2.length - 1) - 2;
            int i = charAdd(res[index], needAdd);
            if (i >= 10) {
                i = i - 10;
                res[index - 1] = (char) (1 + '0');
            }
            res[index] = (char) (i + '0');
        }
        return new String(res).trim();
    }


    public static int charAdd(char c1, int c2) {
        if (c1 == '\0') {
            c1 = '0';
        }
        return (c1 - '0') + c2;
    }



    public static void main(String[] args) {
        System.out.println(multiply("88", "556"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
