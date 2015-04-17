package com.bbs.util;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.HashMap;

import org.apache.commons.lang.math.NumberUtils;

/**
 * 简单货币格式工具
 * 
 * @author jie.xu 2014年10月14日 下午1:32:45
 */
public class CurrencyFormattor {

    private static ThreadLocal<HashMap<String, NumberFormat>> formatHolder = new ThreadLocal<HashMap<String, NumberFormat>>();
    private static final String                               CURRENCY     = "#0.##";

    /**
     * 将元转化为分
     * 
     * @param yuan 输入金额元(类似 10.00或者10)
     * @return
     */
    public static int yuan2fen(String yuan) {
        return (int) (NumberUtils.toFloat(yuan) * 100);
    }

    /**
     * 将“分”格式化为“元”的样式
     * 
     * @param price 输入的“分”的价格
     * @return 元的价格
     */
    public static String fen2yuan(Integer fen) {
        if (fen != null) {
            double yuan = 0;
            yuan = fen / 100d;
            NumberFormat numberInstance = getFormat(CURRENCY);
            return numberInstance.format(yuan);
        }
        return "";
    }

    /**
     * 格式化数字,原值输出大小
     * 
     * <pre>
     * format(null) ""
     * format(6) 6
     * format(6.02) 6.02
     * format(6.020) 6.02
     * format(6.10) 6.1
     * format(6.00) 6
     * </pre>
     * 
     * @param num
     * @return
     */
    public static String format(Number num) {
        if (num == null) return "";

        NumberFormat numberInstance = getFormat(CURRENCY);
        try {
            return numberInstance.format(num);
        } catch (Exception e) {
            return "";
        }
    }

    private static NumberFormat getFormat(String key) {
        HashMap<String, NumberFormat> map = formatHolder.get();
        if (map == null) {
            map = new HashMap<String, NumberFormat>(3);
            formatHolder.set(map);// 保存回去
        }
        NumberFormat format = map.get(key);
        if (format == null) {
            format = new DecimalFormat(key);
            map.put(key, format);
            formatHolder.set(map);// 保存回去
        }
        return format;
    }

}
