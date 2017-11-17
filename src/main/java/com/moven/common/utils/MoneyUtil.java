package com.moven.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * 金额处理 工具类
 *
 * @author swy
 * @ClassName:MoneyUtil
 * @date 2016-12-22
 */
public class MoneyUtil {

    /**
     * 金额转换为中文
     *
     * @param obj
     * @return
     */
    private static String[] digit = {"", "拾", "佰", "仟", "万", "拾万", "佰万", "仟万", "亿", "拾亿", "佰亿", "仟亿", "万亿"};
    private static String[] bb = {"分", "角"};
    private static final String YUAN = "元";
    private static final String ZHENG = "整";
    private static final char   CHAR_ZERO = '零';
    private static final String ZERO = "零";

    /**
     * 取得数字对应的中文
     *
     * @param money
     * @return
     */
    public static String getMoneyCDesc(BigDecimal money) {

        if (null == money || money.compareTo(BigDecimal.ZERO) == 0) {
            return ZERO + YUAN + ZHENG;
        }

        String strMoney = "" + money.setScale(2, BigDecimal.ROUND_UNNECESSARY);
        String[] amt = strMoney.split("\\.");
        strMoney = getYuan(amt[0]) + YUAN + getJiaoFen(amt[1]);
        return strMoney;
    }

    /**
     * 得到分角部分
     *
     * @param s
     * @return
     */
    public static String getJiaoFen(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        String ch = "";
        String d = "";
        for (int i = 0; i < c.length; i++) {
            if (i > 0 && c[i] == '0' && c[i] == c[i - 1]) {
                --len;
                continue;
            }
            // 得到数字对应的中文
            ch += (getChinese(c[i]));
            // 非零时, 显示是几百, 还是几千

            if (!ZERO.equals(getChinese(c[i]))) {
                if (c.length == 2) {
                    d = bb[--len];
                } else {
                    d = bb[len];
                }
                ch += d;
            } else {
                --len; // 如果是0则不取位数
            }
        }
        // 如果最后一位是 0, 则去掉
        if ((ch.charAt(ch.length() - 1)) == CHAR_ZERO) {
            ch = ch.substring(0, ch.length() - 1);
        }

        if (ch.indexOf(bb[1]) == -1 && ch.indexOf(bb[1]) == -1) {
            ch += ZHENG;
        }
        return ch;
    }

    /**
     * 得到元的部分
     *
     * @param s
     * @return
     */
    public static String getYuan(String s) {
        char[] c = s.toCharArray();
        StringBuffer chSb = new StringBuffer();
        int len = c.length;
        List<String> list = new ArrayList<String>();
        String d = "";
        for (int i = 0; i < c.length; i++) {
            // 如果有几个0挨在一起时, 只显示一个零即可
            if (i > 0 && c[i] == '0' && c[i] == c[i - 1]) {
                --len;
                continue;
            }
            // 得到数字对应的中文
            chSb.append(getChinese(c[i]));

            // 非零时, 显示是几百, 还是几千
            if (!ZERO.equals(getChinese(c[i]))) {
                d = digit[--len];
                // 当数字中有万和十万时, 要去掉十万
                list.add(d);
                chSb.append(d);
            } else {
                // 如果是0则不取位数
                --len;
            }
        }
        String chStr = chSb.toString();
        // 如果同时包含有万和十万, 则将十万中的万去掉
        if (list.contains("万")) {
        		chStr = chStr.replaceAll("拾万", "拾");
        		chStr = chStr.replaceAll("佰万", "佰");
        		chStr = chStr.replaceAll("仟万", "仟");
        } else if (list.contains("拾万")) {
        		chStr = chStr.replaceAll("佰万", "佰");
        		chStr = chStr.replaceAll("仟万", "仟");
        } else if (list.contains("佰万")) {
	        	chStr = chStr.replaceAll("仟万", "仟");
        }
        // 如果同时包含亿和十亿, 则将十亿中的亿字去掉
        if (list.contains("亿")) {
	        	chStr = chStr.replaceAll("拾亿", "拾");
	        	chStr = chStr.replaceAll("佰亿", "佰");
	        	chStr = chStr.replaceAll("仟亿", "仟");
	        	chStr = chStr.replaceAll("万亿", "万");
        } else if (list.contains("拾亿")) {
            chStr = chStr.replaceAll("佰亿", "佰");
            chStr = chStr.replaceAll("仟亿", "仟");
            chStr = chStr.replaceAll("万亿", "万");
        } else if (list.contains("佰亿")) {
	        	chStr = chStr.replaceAll("仟亿", "仟");
	        	chStr = chStr.replaceAll("万亿", "万");
        } else if (list.contains("仟亿")) {
	        	chStr = chStr.replaceAll("万亿", "万");
        }
        // 如果最后一位是 0, 则去掉
        if ((chSb.charAt(chSb.length() - 1)) == CHAR_ZERO) {
            chStr = chStr.substring(0, chStr.length() - 1);
        }
        return chStr;
    }

    /**
     * 取得数字对应的中文
     *
     * @param i
     * @return
     */
    public static String getChinese(char i) {
        String ch = "";
        switch (i) {
            case '0':
                ch = ZERO;
                break;
            case '1':
                ch = "壹";
                break;
            case '2':
                ch = "贰";
                break;
            case '3':
                ch = "叁";
                break;
            case '4':
                ch = "肆";
                break;
            case '5':
                ch = "伍";
                break;
            case '6':
                ch = "陆";
                break;
            case '7':
                ch = "柒";
                break;
            case '8':
                ch = "捌";
                break;
            case '9':
                ch = "玖";
                break;
            default:
                break;
        }
        return ch;
    }


    /**
     * 数字 转成金额千分位
     *
     * @param bigDecimal 值
     * @return
     */
    public static String fmtMicrometer(BigDecimal bigDecimal) {
        if (bigDecimal == null) {return "";}
        DecimalFormat df = new DecimalFormat("###,##0.00");
        return df.format(bigDecimal);
    }
}
