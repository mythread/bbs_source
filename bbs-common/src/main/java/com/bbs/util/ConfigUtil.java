package com.bbs.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.io.IOUtils;

public final class ConfigUtil {
    private static final String CONFIG_FILENAME = "/config.properties";

    private static final String DEFAULT_CHAR_SET = "UTF-8";

    private static class ConfigHolder {
        private static final ConfigUtil CONFIG = new ConfigUtil();
    }

    private static Map<String, String> context = new HashMap<String, String>();

    static {
        Properties properties = new Properties();
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(ConfigUtil.class.getResourceAsStream(CONFIG_FILENAME), DEFAULT_CHAR_SET));
            properties.load(in);
        } catch (Exception e) {
            throw new RuntimeException("Can not find config file：" + CONFIG_FILENAME, e);
        } finally {
            IOUtils.closeQuietly(in);
        }

        put(properties);
    }

    public static ConfigUtil getConfig() {
        return ConfigHolder.CONFIG;
    }

    public String get(String key) {
        return context.get(key);
    }

    private static void put(Properties properties) {
        for (Object key : properties.keySet()) {
            context.put((String) key, evaluate((String) key, properties));
        }
    }

    private static String evaluate(String key, Properties properties) {
        String value = (String) properties.get(key);
        if (value == null) {
            throw new RuntimeException("Key [" + key + "] is undefined");
        }

        value = value.trim();

        StringBuilder sb = new StringBuilder();

        int index = 0;
        int beginIndex;
        int endIndex;
        for (;;) {
            beginIndex = value.indexOf("${", index);
            endIndex = value.indexOf("}", beginIndex);
            if (beginIndex == -1 ||  endIndex == -1) {
                sb.append(value.substring(index));
                break;
            } else {
                sb.append(value.substring(index, beginIndex));
                sb.append(evaluate(value.substring(beginIndex + 2, endIndex), properties));
                index = endIndex + 1;
                if (index >= value.length()) {
                    break;
                }
            }
        }

        return sb.toString();
    }

    private ConfigUtil() {
    }
}
