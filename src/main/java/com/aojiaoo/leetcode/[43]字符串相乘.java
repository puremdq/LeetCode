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
        if (chars1.length < chars2.length) {
            char[] temp = chars1;
            chars1 = chars2;
            chars2 = temp;
        }

        //chars2 是长度的数组
        for (int i = chars2.length - 1; i >= 0; i--) {
            multiplyAndAdd(res, chars1, chars2[i], (chars2.length - 1 - i));
        }
        return new String(res).trim();
    }

    public static char[] multiplyAndAdd(char[] res, char[] chars, char c, int step) {


        for (int i = chars.length - 1; i >= 0; i--) {
            int temp = (chars[i] - '0') * (c - '0');
            int currentStep = res.length - 1 - step - (chars.length - 1 - i);

            if (temp >= 10) {
                addChar(res, (char) (temp / 10 + '0'), currentStep - 1);
                temp = temp % 10;
            }
            addChar(res, (char) (temp + '0'), currentStep);
//
        }
        return res;
    }

    //倒序  ‘123’ 实际表示321

    /**
     * @param res  数组 正序 如‘0123’
     * @param c    要加的值 如‘1’
     * @param step 从多少位开始加 (一般为最低为 res.length-1)
     * @return
     */
    public static char[] addChar(char[] res, char c, int step) {

        boolean needAdd = false;
        do {
            int temp = charAdd(res[step], c);
            if (temp >= 10) {
                needAdd = true;
                c = '1';
                res[step] = (char) ('0' + (temp - 10));
                step--;
            } else {
                res[step] = (char) (temp + '0');
                needAdd = false;
            }
        } while (needAdd && step >= 0);
        return res;
    }


    public static int charAdd(char c1, char c2) {
        if (c1 == '\0') {
            c1 = '0';
        }
        if (c2 == '\0') {
            c2 = '0';
        }
        return (c1 - '0') + (c2 - '0');
    }

    public static void main(String[] args) {
        System.out.println(multiply("525555555555555555555552222222222222222222222222222222222222222222222222222222222222222222222222222222222656565", "605656565657777777777777777777777777777777777777777777777777777777"));
    }
}
//leetcode submit region end(Prohibit modification and deletion)
