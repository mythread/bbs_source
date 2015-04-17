package com.bbs.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

/**
 * 日期格式化
 */
public final class DateUtil {

    public static final String STANDARD_DATE_TIME_FORMAT_STR = "yyyy-MM-dd HH:mm:ss";
    public static final String PURE_LONG_DATE_TIME_FORMAT_STR = "yyyyMMddHHmmssSSS";
    public static final String PURE_MIDDLE_DATE_TIME_FORMAT_STR = "yyyyMMddHHmm";
    public static final String PURE_DATE__FORMAT_STR = "yyyyMMdd";
    public static final String STANDARD_DATE_FORMAT_STR = "yyyy-MM-dd";
    public static final String DATE_FORMAT_SHORT = "yyMMdd"; // 短时间格式标签(业务规则时间戳)
    public static final String DATE_FORMAT_LONG = "yyMMddHHmm"; // 长时间格式标签(业务规则时间戳)
    public static final SimpleDateFormat SIMPLE_DATE_TIME_FORMAT = new SimpleDateFormat(STANDARD_DATE_TIME_FORMAT_STR);
    public static final String MAX_TIME = " 23:59:59";
    public static final String MIN_TIME = " 00:00:00";

    /**
     * 通用日期模式
     */
    private static final String[] GENERIC_DATE_PATTERNS = {STANDARD_DATE_TIME_FORMAT_STR, STANDARD_DATE_FORMAT_STR,
            STANDARD_DATE_TIME_FORMAT_STR, "yyyy/MM/dd HH:mm:ss", "yyyy-MM"};

    private DateUtil() {
    }

    /**
     * 日期字符串转化为日期
     * 
     * @param src
     *            日期字符串
     * @return
     * @throws ParseException
     */
    public static Date parseDate(String str) throws ParseException {
        return DateUtils.parseDate(str, GENERIC_DATE_PATTERNS);
    }

    /**
     * 格式日期时间为系统的标准格式(yyyy-MM-dd HH:mm:ss)
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatDatetime(Date date) {
        return DateFormatUtils.format(date, STANDARD_DATE_TIME_FORMAT_STR);
    }

    /**
     * 格式日期时间为系统的标准格式(yyyy-MM-dd)
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatSimpleDatetime(Date date) {
        return DateFormatUtils.format(date, STANDARD_DATE_FORMAT_STR);
    }

    /**
     * 格式日期时间为系统的标准格式(yyyyMMddHHmmssSSS)
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatPureLongDatetime(Date date) {
        return DateFormatUtils.format(date, PURE_LONG_DATE_TIME_FORMAT_STR);
    }

    /**
     * 格式日期时间为系统的标准格式(yyyyMMddHHmmssSSS)
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatPureMiddleDatetime(Date date) {
        return DateFormatUtils.format(date, PURE_MIDDLE_DATE_TIME_FORMAT_STR);
    }

    /**
     * 业务规则时间戳生成
     * 
     * @param date
     * @return
     * @throws ParseException
     */
    public static String formatBusinessRuleDate(String formatType) {
        return DateFormatUtils.format(new Date(), formatType);
    }

    /**
     * 当天最大值
     * 
     * @param endDate
     * @return
     */
    public static Object parseDateMax(String endDate) throws ParseException {
        return DateUtils.parseDate(endDate + " 23:59:59", GENERIC_DATE_PATTERNS);
    }

    /**
     * 生成如2014-10-14 23:59:59格式时间
     * 
     * @Title: getMaxDateTime
     * @Description: 生成指定时间/日期当天的结束时间，如2014-10-14 23:59:59
     * @param date
     * @throws ParseException
     * @return Date
     * @throws
     * @author yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年10月14日 上午11:16:19
     */
    public static Date getMaxDateTime(Date date) throws ParseException {
        return padDateTime(date, MAX_TIME);
    }

    /**
     * @Title: getMinDateTime
     * @Description: 生成指定时间/日期当天的开始时间，如2014-10-14 00:00:00
     * @param date
     * @throws ParseException
     * @return Date
     * @throws
     * @author yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年10月14日 上午11:55:15
     */
    public static Date getMinDateTime(Date date) throws ParseException {
        return padDateTime(date, MIN_TIME);
    }

    /**
     * 示例：padDateTime(2014-10-14," 00:00:00") ---> 2014-10-14 00:00:00
     * 
     * @Title: padDateTime
     * @Description: 日期拼接时间转换成日期格式
     * @param date
     * @param strTime
     * @throws ParseException
     * @return Date
     * @throws
     * @author yanqing.luo （roceys#gmail.com）
     * @version V1.0
     * @date 2014年10月14日 上午11:53:30
     */
    private static Date padDateTime(Date date, String strTime) throws ParseException {
        return DateUtils.parseDate(DateFormatUtils.format(date, STANDARD_DATE_FORMAT_STR) + strTime,
                GENERIC_DATE_PATTERNS);
    }

    /**
     * 
     * 功能描述: <br>
     * 获得时间的文本内容 ：几分钟前，几小时前，几天前，几个月前
     * 
     * @param now
     * @return
     * @see [相关类/方法](可选)
     * @since [产品/模块版本](可选)
     */
    public static String getDateText(Date now) {
        if (now == null) {
            return "";
        }
        long diffTime = System.currentTimeMillis() - now.getTime();
        if (diffTime <= 0) {
            return "";
        }
        if (diffTime < 60 * 1000) {
            return "刚刚";
        }
        if (diffTime >= 60 * 1000 && diffTime < 60 * 60 * 1000) {
            int min = (int) Math.ceil(diffTime / (60 * 1000));
            return min + "分钟前";
        }
        if (diffTime >= 60 * 60 * 1000 && diffTime < 60 * 60 * 24 * 1000) {
            int hour = (int) Math.ceil(diffTime / (60 * 60 * 1000));
            return hour + "小时前";
        }
        long dayLong = 60 * 60 * 24 * 30 * 1000l;
        if (diffTime >= 60 * 60 * 24 * 1000 && diffTime < dayLong) {
            int day = (int) Math.ceil((diffTime / (60 * 60 * 24 * 1000)));
            return day + "天前";
        }
        if (diffTime >= dayLong) {
            int month = (int) Math.ceil(diffTime / dayLong);
            return month + "个月前";
        }

        return "";
    }
}
