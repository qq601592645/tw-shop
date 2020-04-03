package com.tw.utils;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by chijr on 17/6/13.
 */
public class WeChatUtils {

    /**
     * 是否签名正确,规则是:按参数名称a-z排序,遇到空值的参数不参加签名。
     * @return boolean
     */
    public static boolean isTenpaySign(String characterEncoding, SortedMap<Object, Object> packageParams, String API_KEY) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while(it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if(!"sign".equals(k) && null != v && !"".equals(v)) {
                sb.append(k + "=" + v + "&");
            }
        }

        sb.append("key=" + API_KEY);

        //算出摘要
        String mysign = MD5Utils.MD5Encode(sb.toString(), characterEncoding).toLowerCase();
        String tenpaySign = ((String)packageParams.get("sign")).toLowerCase();

        //System.out.println(tenpaySign + "    " + mysign);
        return tenpaySign.equals(mysign);
    }

    /**
     * @author
     * @date 2016-4-22
     * @Description：sign签名
     *            编码格式
     * @param
     * @return
     */
    public static String createSign(SortedMap<Object, Object> packageParams, String API_KEY) {
        StringBuffer sb = new StringBuffer();
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k + "=" + v + "&");
            }
        }
        sb.append("key=" + API_KEY);
        String sign = MD5Utils.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
        return sign;
    }


    public static String createSignNew(SortedMap<Object, Object> packageParams, String API_KEY) {
        StringBuffer sb = new StringBuffer();
        sb.append(API_KEY);
        Set es = packageParams.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            Object v =  entry.getValue();
            if (null != v && !"".equals(v) && !"sign".equals(k) && !"key".equals(k)) {
                sb.append(k.toUpperCase() + v);
            }
        }
        sb.append(API_KEY);
        System.out.print(sb);
        String sign = MD5Utils.MD5Encode(sb.toString(), "UTF-8").toUpperCase();
        return sign;
    }

    /**
     * @author
     * @date 2016-4-22
     * @Description：将请求参数转换为xml格式的string
     * @param parameters
     *            请求参数
     * @return
     */
    public static String getRequestXml(SortedMap<Object, Object> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            String k = (String) entry.getKey();
            String v = (String) entry.getValue();
            if ("attach".equalsIgnoreCase(k) || "body".equalsIgnoreCase(k) || "sign".equalsIgnoreCase(k)) {
                sb.append("<" + k + ">" + "<![CDATA[" + v + "]]></" + k + ">");
            } else {
                sb.append("<" + k + ">" + v + "</" + k + ">");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 取出一个指定长度大小的随机正整数.
     *
     * @param length
     *            int 设定所取出随机数的长度。length小于11
     * @return int 返回生成的随机数。
     */
    public static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }

    /**
     * 获取当前时间 yyyyMMddHHmmss
     *
     * @return String
     */
    public static String getCurrTime() {
        Date now = new Date();
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = outFormat.format(now);
        return s;
    }

    /**
     * 获取当前时间 微信随机字符串
     *
     * @return String
     */


    static public String nonceString(){

        String currTime = String.format("%d",(long)System.currentTimeMillis()/1000);

        String strTime = currTime.substring(8, currTime.length());

        Random random = new Random();
        int num = (int) (random.nextDouble() * (1000000 - 100000) + 100000);
        String code = String.format("%06d", num);

        String nonce_str = currTime.substring(2)+code;
        return nonce_str;

    }

    /**
     * 返回微信秒为单位时间戳
     *
     * @return String
     */


    static public String timeStamp(){

        String currTime = String.format("%d",(long)System.currentTimeMillis()/1000);

        return currTime;


    }







}
