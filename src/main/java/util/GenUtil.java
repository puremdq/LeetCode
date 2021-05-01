package util;

import com.aojiaoo.common.utils.JsonUtil;

import java.util.Arrays;

public class GenUtil {

    // [0,1,3,5,6,8,12,17]
    public static int[] getIntArray(String s) {
        return JsonUtil.parse(s, int[].class);
    }


}
