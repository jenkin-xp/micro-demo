package com.xiaorui.common.util;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * @Description:
 * @Author: xp
 * @Date: 2020/10/22 13:55
 * @Version: 1.0
 **/
public class IdUtil {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("yyyyMMddHHmmssS");

    private static final String[] RANDOM_STR = {"0", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F",
            "G", "H", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z"};

    public static String generateOrderCode() {
        return SIMPLE_DATE_FORMAT.format(new Date()) + String.format("%05d", 1 + (int) (Math.random() * 99999));
    }

    public static String get4Code() {
        int code = (int) ((Math.random() * 9 + 1) * 1000);
        return String.valueOf(code);
    }

    public static String get6Code() {
        int code = (int) ((Math.random() * 9 + 1) * 100000);
        return String.valueOf(code);
    }

    public static String getCode(int size) {
        String code = "";
        Random random = new Random();
        for (int i = 0; i < size; i ++) {
            int result = random.nextInt(10);
            code += result;
        }
        return code;
    }

    public static int getRandomNumber(int initValue, int range) {
        return new Random().nextInt(range) + initValue;
    }

    /**
     * 获取指定长度的随机字符串（包含数字或字母）
     * @param length 表示生成随机数的位数
     * @return
     */
    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();
        for(int i = 0; i < length; i++) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            //输出字母还是数字
            if( "char".equalsIgnoreCase(charOrNum) ) {
                //输出是大写字母还是小写字母
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val += (char)(random.nextInt(26) + temp);
            } else if( "num".equalsIgnoreCase(charOrNum) ) {
                val += String.valueOf(random.nextInt(10));
            }
        }
        return val;
    }

    /**
     * 获取指定长度的随机字符串（包含数字或字母）,屏蔽不好区分的几个i、I、1
     * @param length 表示生成随机数的位数
     * @return
     */
    public static String getRandomStr(int length) {
        String val = "";
        Random random = new Random();
        List<String> randomList = Arrays.asList(RANDOM_STR);
        int size = randomList.size();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(size);
            val += randomList.get(index);
        }
        return val;
    }

}
