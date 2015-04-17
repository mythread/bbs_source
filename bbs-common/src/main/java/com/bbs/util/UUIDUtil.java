package com.bbs.util;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.apache.commons.lang.math.RandomUtils;

/**
 * UUID生成
 * 
 */
public class UUIDUtil {

    private UUIDUtil() {
    }

    public final static String getUUID() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    public final static String getVehicleCode() {
        Random random = new Random();
        return DateUtil.formatPureMiddleDatetime(new Date())
                + RandomUtils.nextInt(random, 10)
                + RandomUtils.nextInt(random, 10);
    }

    public final static String getTimestampUUID() {
        return DateUtil.formatPureLongDatetime(new Date())
                + RandomUtils.nextInt(10);
    }
}
