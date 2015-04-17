package com.bbs.util;

import java.util.Random;

public final class RandomUtil {

    public static enum TicketType {

        IPHONE_APP_CHECKCODE("1234567890", 4),
        WEBSITE_ACCOUNT_CHECKCODE("1234567890", 6),
        DEFAULT_MEMBER_PASSWORD("1234567890abcdefghijklmnopqrstuvwxyz", 6);

        private String acceptChars;
        private int length;

        private TicketType(String acceptChars, int length) {
            this.acceptChars = acceptChars;
            this.length = length;
        }

        public String getAcceptChars() {
            return acceptChars;
        }

        public int getLength() {
            return length;
        }
    }

    private RandomUtil() {
    }

    public static String getRandomString(TicketType ticketType) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ticketType.getLength(); ++i) {
            sb.append(getRandomCharacter(ticketType.getAcceptChars()));
        }
        return sb.toString();
    }

    public static String getRandomString(String acceptChars, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            sb.append(getRandomCharacter(acceptChars));
        }
        return sb.toString();
    }

	public static char getRandomCharacter(String acceptChars) {
		int index = new Random().nextInt(acceptChars.length());
		return acceptChars.charAt(index);
	}

	/**
	 * 生成随即密码
	 * 
	 * @param pwd_len
	 *            生成的密码的总长度
	 * @return 密码的字符串
	 */
	public static String genRandomNum(int pwd_len) {
		// 35是因为数组是从0开始的，26个字母+10个数字
		final int maxNum = 36;
		int i; // 生成的随机数
		int count = 0; // 生成的密码的长度
		char[] str = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
				'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
				'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		StringBuffer pwd = new StringBuffer("");
		Random r = new Random();
		while (count < pwd_len) {
			// 生成随机数，取绝对值，防止生成负数，

			i = Math.abs(r.nextInt(maxNum)); // 生成的数最大为36-1

			if (i >= 0 && i < str.length) {
				pwd.append(str[i]);
				count++;
			}
		}

		return pwd.toString();
	}
}