package com.bbs.enums;

/**
 * 图片属性信息
 * 
 * @author jie.xu 2014年12月8日 下午4:07:31
 */
public enum PicsInfoEnum {

    /**
     * 头像
     */
    AVATAR_IMG("/avatar", "bbs_avatar", 1024 * 1024, 64, 64, new String[] {"jpg", "jpeg", "png"}),

    /**
     * 主题帖子
     */
    TOPIC_IMG("/topic", "bbs_topic", 1024 * 1024 * 6, 0, 0, new String[] {"jpg", "jpeg", "png"});

    private PicsInfoEnum(String dirPrefix, String type, int maxSize, int width, int height, String[] suffixs) {
        this.dirPrefix = dirPrefix;
        this.type = type;
        this.maxSize = maxSize;
        this.width = width;
        this.height = height;
        this.suffixs = suffixs;
    }

    private String dirPrefix;// 图片目录前缀
    private String type;// 类型：应用名 + "_" + 类型
    private int maxSize;// 图片最大值 单位b
    private int width;// 宽
    private int height;// 高
    private String[] suffixs;// 后缀

    public String[] getSuffixs() {
        return suffixs;
    }

    public void setSuffixs(String[] suffixs) {
        this.suffixs = suffixs;
    }

    public String getDirPrefix() {
        return dirPrefix;
    }

    public void setDirPrefix(String dirPrefix) {
        this.dirPrefix = dirPrefix;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void setMaxSize(int maxSize) {
        this.maxSize = maxSize;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public static PicsInfoEnum getEnum(String type) {
        for (PicsInfoEnum pe : values()) {
            if (pe.getType().equals(type)) {
                return pe;
            }
        }
        return null;
    }
}
