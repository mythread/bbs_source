package com.bbs.util;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import com.google.common.base.Throwables;

public final class UrlUtil {
    private static final String DEFAULT_CHARSET = "UTF-8";

    public static String encode(String value) {
        return encode(value, DEFAULT_CHARSET);
    }

    public static String encode(String value, String charset) {
        try {
            return URLEncoder.encode(value, charset);
        } catch (UnsupportedEncodingException e) {
            throw Throwables.propagate(e);
        }
    }

    public static String decode(String value) {
        return decode(value, DEFAULT_CHARSET);
    }

    public static String decode(String value, String charset) {
        try {
            return URLDecoder.decode(value, charset);
        } catch (UnsupportedEncodingException e) {
            throw Throwables.propagate(e);
        }
    }

    private UrlUtil() {
    }
}
