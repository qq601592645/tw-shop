package com.tw.utils;

/**
 * Created by chijr on 16/11/5.
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.serializer.SimpleDateFormatSerializer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.types.ObjectId;
import sun.misc.BASE64Encoder;

import java.io.*;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class EncryptUtils {


    private static SerializeConfig mapping = new SerializeConfig();
    private static String dateFormat;

    static {
        dateFormat = "yyyy-MM-dd HH:mm:ss";
        mapping.put(Date.class, new SimpleDateFormatSerializer(dateFormat));
    }


    public EncryptUtils() {


    }

    public static String formatDateTime(Date dt) {

        String tmstr = String.format("%1$tY-%1$tm-%1$td %1$tH:%1$tM:%1$tS", dt);
        return tmstr;


    }


    public static String getHashMD5(String source) {

        return EncryptUtils.getHash(source, "MD5");
    }

    public static String getHashSHA(String source) {

        return EncryptUtils.getHash(source, "SHA");
    }


    /**
     * 由于MD5 与SHA-1均是从MD4 发展而来，它们的结构和强度等特性有很多相似之处
     * SHA-1与MD5 的最大区别在于其摘要比MD5 摘要长 32 比特（1byte=8bit，相当于长4byte，转换16进制后比MD5多8个字符）。
     * 对于强行攻击，：MD5 是2128 数量级的操作，SHA-1 是2160数量级的操作。
     * 对于相同摘要的两个报文的难度：MD5是 264 是数量级的操作，SHA-1 是280 数量级的操作。
     * 因而，SHA-1 对强行攻击的强度更大。 但由于SHA-1 的循环步骤比MD5 多（80:64）且要处理的缓存大（160 比特:128 比特），SHA-1 的运行速度比MD5 慢。
     *
     * @param source   需要加密的字符串
     * @param hashType 加密类型 （MD5 和 SHA）
     * @return
     */

    public static String getHash(String source, String hashType) {
        // 用来将字节转换成 16 进制表示的字符
        char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

        try {
            MessageDigest md = MessageDigest.getInstance(hashType);
            md.update(source.getBytes()); // 通过使用 update 方法处理数据,使指定的 byte数组更新摘要
            byte[] encryptStr = md.digest(); // 获得密文完成哈希计算,产生128 位的长整数
            char str[] = new char[16 * 2]; // 每个字节用 16 进制表示的话，使用两个字符
            int k = 0; // 表示转换结果中对应的字符位置
            for (int i = 0; i < 16; i++) { // 从第一个字节开始，对每一个字节,转换成 16 进制字符的转换
                byte byte0 = encryptStr[i]; // 取第 i 个字节
                str[k++] = hexDigits[byte0 >>> 4 & 0xf]; // 取字节中高 4 位的数字转换, >>> 为逻辑右移，将符号位一起右移
                str[k++] = hexDigits[byte0 & 0xf]; // 取字节中低 4 位的数字转换
            }
            return new String(str); // 换后的结果转换为字符串
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static String getTransId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "T" + id;

    }

    public static String getPreTransId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "P" + id;

    }


    public static String getToken() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "TK" + id;

    }

    public static String getFileName() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "file" + id;

    }


    public static String getId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "ID" + id;

    }


    public static String getAttrId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "ATTR" + id;

    }

    public static String getValueId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "VAL" + id;

    }


    public static String getSKuId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "SKU" + id;

    }


    public static String getAccountId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "A" + id;

    }

    public static String getUserId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "U" + id;

    }

    public static String getSysTypeId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "ST" + id;

    }

    public static String getSysSonTypeId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "SST" + id;

    }


    public static String getSupplierId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "SP" + id;

    }

    public static String getMessageId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "Msg" + id;

    }


    public static String getSubAccountId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "SUB" + id;

    }

    public static String getAddressId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "ADD" + id;

    }

    public static String getCatId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "CAT" + id;

    }

    public static String getCartSupplierId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "CS" + id;

    }

    public static String getProductId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "PD" + id;

    }

    public static String getPayId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "P" + id;

    }


    public static String getOrderId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        Date now = new Date();
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        String s = outFormat.format(now);

        return s + id.substring(8);

    }

    public static String getOrderDetailId() {

        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "OD" + id;


    }

    public static String getCartId() {

        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "Cart" + id;


    }

    public static String getPrepareId() {

        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "Pre" + id;

    }

    public static String getPubId() {

        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "Pub" + id;

    }

    public static String getPriceId() {

        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "Prc" + id;

    }

    public static String getMaintainGroupId() {

        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "MG" + id;

    }

    public static String getMaintainInfoId() {

        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "MI" + id;

    }

    public static String getMaintainColumnId() {

        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "MC" + id;

    }

    public static String getMaintainColumnGroupId() {
        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "MCG" + id;

    }

    public static String getMerchantAppInfoId() {

        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "MAI" + id;

    }


    public static String getPassword() {

        ObjectId objId = ObjectId.get();
        String id = objId.toString();
        return "Pw" + id;

    }




    public static int getInt(Object o) {


        if (o == null) {
            return 0;
        }

        if (o instanceof Integer) {
            Integer i = (Integer) o;
            return i.intValue();
        }

        if (o instanceof BigDecimal) {
            BigDecimal b = (BigDecimal) o;
            return b.intValue();
        }

        if (o instanceof Long) {
            Long b = (Long) o;
            return b.intValue();
        }

        if (o instanceof Float) {
            Float b = (Float) o;
            return b.intValue();
        }

        if (o instanceof Double) {
            Double b = (Double) o;
            return b.intValue();
        }

        return 0;


    }

    public static String md5(String str) {
        String newstr = null;
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");

            BASE64Encoder base64en = new BASE64Encoder();
            //加密后的字符串
            newstr = base64en.encode(md5.digest(str.getBytes("utf-8")));
        } catch (Exception e) {

        }
        return newstr;
    }

    public static String getString(Map m, String key) {

        Object o = m.get(key);

        if (o == null) {
            return null;
        }

        return String.valueOf(o);

    }


    public static String objectToString(Object objectInstance) {


        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

        String str = JSON.toJSONString(objectInstance, SerializerFeature.WriteDateUseDateFormat);


        return str;


    }


    public static List<Map<String, Object>> objectToArray(Object objectInstance) {


        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

        String str = JSON.toJSONString(objectInstance, SerializerFeature.WriteDateUseDateFormat);


        List<Map<String, Object>> map = JSON.parseObject(str, new TypeReference<List<Map<String, Object>>>() {
        });

        return map;


    }


    public static String timeString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

        return sdf.format(date);
    }

    public static String yearString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");

        return sdf.format(date);
    }


    public static String dayString(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

        return sdf.format(date);
    }

    public static String dayString(Date date, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);

        return sdf.format(date);
    }


    public static Date parseDate(String dateString) {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            return sdf.parse(dateString);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }


    }

    public static Date getEndDate(Integer month) {
        Date date = new Date();//取时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);
        calendar.add(calendar.MONTH, month);//把日期往后增加一个月.整数往后推,负数往前移动
        date = calendar.getTime();   //这个时间就是日期往后推一天的结果
        return date;
    }


    public static int daysBetween(Date bdate, Date smdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);

        return Integer.parseInt(String.valueOf(between_days));
    }


    public static HashMap<String, Object> objectToMap(Object objectInstance) {


        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

        String str = JSON.toJSONString(objectInstance, SerializerFeature.WriteDateUseDateFormat, SerializerFeature.WriteMapNullValue);


        HashMap<String, Object> map = JSON.parseObject(str, new TypeReference<HashMap<String, Object>>() {
        });

        return map;


    }


    public static ObjectMapper getObjectMap() {

        ObjectMapper mapper = new ObjectMapper();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(format);
        return mapper;

    }


    public static String objectToJsonString(Object o) {

        try {
            String outJson = EncryptUtils.getObjectMap().writeValueAsString(o);
            return outJson;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "";
        }


    }

    public static HashMap<String, Object> stringToMap(String content) {

        JSON.DEFFAULT_DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

        HashMap<String, Object> map = JSON.parseObject(content, new TypeReference<HashMap<String, Object>>() {
        });

        return map;

    }


    public static Date string2Date(String str) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        try {
            str = str.substring(0, str.length() - 2) + "00";
            Date dt = df.parse(str);
            return dt;
        } catch (ParseException e) {
            return null;
        }


    }


    public static int getInt(Map m, String key) {

        Object o = m.get(key);

        if (o == null) {
            return 0;
        }

        if (o instanceof Integer) {
            Integer i = (Integer) o;
            return i.intValue();
        }

        if (o instanceof BigDecimal) {
            BigDecimal b = (BigDecimal) o;
            return b.intValue();
        }

        if (o instanceof Long) {
            Long b = (Long) o;
            return b.intValue();
        }

        if (o instanceof Float) {
            Float b = (Float) o;
            return b.intValue();
        }

        if (o instanceof Double) {
            Double b = (Double) o;
            return b.intValue();
        }

        return 0;


    }


    public static String file2String(File file, String encoding) {
        InputStreamReader reader = null;
        StringWriter writer = new StringWriter();
        try {
            if (encoding == null || "".equals(encoding.trim())) {
                reader = new InputStreamReader(new FileInputStream(file), encoding);
            } else {
                reader = new InputStreamReader(new FileInputStream(file));
            }
            //将输入流写入输出流
            char[] buffer = new char[10 * 1024];
            int n = 0;
            while (-1 != (n = reader.read(buffer))) {
                writer.write(buffer, 0, n);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (reader != null)
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        //返回转换结果
        if (writer != null)
            return writer.toString();
        else return null;
    }


    public static String convertStreamToString(InputStream is) {
        /*
          * To convert the InputStream to String we use the BufferedReader.readLine()
          * method. We iterate until the BufferedReader return null which means
          * there's no more data to read. Each line will appended to a StringBuilder
          * and returned as String.
          */
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return sb.toString();
    }


}
