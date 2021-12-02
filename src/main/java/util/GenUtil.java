package util;

import com.aojiaoo.common.utils.JsonUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenUtil {

    // [0,1,3,5,6,8,12,17]
    public static int[] getIntArray(String s) {
        return JsonUtil.parse(s, int[].class);
    }

    public static char[][] getCharArrays(String s) {
        return JsonUtil.parse(s, char[][].class);
    }

    public static int[][] getIntArrays(String s) {
        return JsonUtil.parse(s, int[][].class);
    }

    public static void main(String[] args) {
        char[][] intArrays = getCharArrays("[[\"5\",\"3\",\".\",\".\",\"7\",\".\",\".\",\".\",\".\"],[\"6\",\".\",\".\",\"1\",\"9\",\"5\",\".\",\".\",\".\"],[\".\",\"9\",\"8\",\".\",\".\",\".\",\".\",\"6\",\".\"],[\"8\",\".\",\".\",\".\",\"6\",\".\",\".\",\".\",\"3\"],[\"4\",\".\",\".\",\"8\",\".\",\"3\",\".\",\".\",\"1\"],[\"7\",\".\",\".\",\".\",\"2\",\".\",\".\",\".\",\"6\"],[\".\",\"6\",\".\",\".\",\".\",\".\",\"2\",\"8\",\".\"],[\".\",\".\",\".\",\"4\",\"1\",\"9\",\".\",\".\",\"5\"],[\".\",\".\",\".\",\".\",\"8\",\".\",\".\",\"7\",\"9\"]]");
        for (char[] intArray : intArrays) {
            System.out.println(intArray);
        }

    }


}
