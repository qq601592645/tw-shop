package com.tw.utils;

/**
 * Created by chijr on 17/7/23.
 */

import org.apache.commons.lang3.StringUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.InputSource;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.*;


public class XmlUtils {


    /** <一句话功能简述>
     * <功能详细描述>request转字符串
     * @param request
     * @return
     * @see [类、类#方法、类#成员]
     */
    public static String parseRequst(HttpServletRequest request){
        String body = "";
        try {
            ServletInputStream inputStream = request.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            while(true){
                String info = br.readLine();
                if(info == null){
                    break;
                }
                if(body == null || "".equals(body)){
                    body = info;
                }else{
                    body += info;
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return body;
    }

    public static String parseXML(SortedMap<String, String> parameters) {
        StringBuffer sb = new StringBuffer();
        sb.append("<xml>");
        Set es = parameters.entrySet();
        Iterator it = es.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry)it.next();
            String k = (String)entry.getKey();
            String v = (String)entry.getValue();
            if (null != v && !"".equals(v) && !"appkey".equals(k)) {
                sb.append("<" + k + ">" + parameters.get(k) + "</" + k + ">\n");
            }
        }
        sb.append("</xml>");
        return sb.toString();
    }

    /**
     * 从request中获得参数Map，并返回可读的Map
     *
     * @return
     */
    public static SortedMap getParameterMap(Map properties) {
//        // 参数Map
//        Map properties = request.getParameterMap();
        // 返回值Map
        SortedMap returnMap = new TreeMap();
        Iterator entries = properties.entrySet().iterator();
        Map.Entry entry;
        String name = "";
        String value = "";
        while (entries.hasNext()) {
            entry = (Map.Entry) entries.next();
            name = (String) entry.getKey();
            Object valueObj = entry.getValue();
            if(null == valueObj){
                value = "";
            }else if(valueObj instanceof String[]){
                String[] values = (String[])valueObj;
                for(int i=0;i<values.length;i++){
                    value = values[i] + ",";
                }
                value = value.substring(0, value.length()-1);
            }else{
                value = valueObj.toString();
            }
            returnMap.put(name, value.trim());
        }
        return returnMap;
    }

    /**
     * 转XMLmap
     * @author
     * @param xmlBytes
     * @param charset
     * @return
     * @throws Exception
     */
    public static Map<String, String> toMap(byte[] xmlBytes,String charset) throws Exception{
        SAXReader reader = new SAXReader(false);
        InputSource source = new InputSource(new ByteArrayInputStream(xmlBytes));
        source.setEncoding(charset);
        Document doc = reader.read(source);
        Map<String, String> params = XmlUtils.toMap(doc.getRootElement());
        return params;
    }

    /**
     * 转MAP
     * @author
     * @param element
     * @return
     */
    public static Map<String, String> toMap(Element element){
        Map<String, String> rest = new HashMap<String, String>();
        List<Element> els = element.elements();
        for(Element el : els){
            rest.put(el.getName().toLowerCase(), el.getTextTrim());
        }
        return rest;
    }

    public static String toXml(Map<String, String> params){
        StringBuilder buf = new StringBuilder();
        List<String> keys = new ArrayList<String>(params.keySet());
        Collections.sort(keys);
        buf.append("<xml>");
        for(String key : keys){
            buf.append("<").append(key).append(">");
            buf.append("<![CDATA[").append(params.get(key)).append("]]>");
            buf.append("</").append(key).append(">\n");
        }
        buf.append("</xml>");
        return buf.toString();
    }



    public static HashMap<String, String> parseXML(String xml) throws Exception {
        // 将解析结果存储在HashMap中
        HashMap<String, String> map = new HashMap<String, String>();

        SAXReader reader = new SAXReader();
        Document document = reader.read(new ByteArrayInputStream(xml.getBytes("UTF-8")));
        // 得到xml根元素
        Element root = document.getRootElement();

        recursiveParseXML(root,map);

        return map;
    }


    private static void recursiveParseXML(Element root,HashMap<String, String> map){
        // 得到根元素的所有子节点
        List<Element> elementList = root.elements();
        //判断有没有子元素列表
        if(elementList.size() == 0){
            map.put(root.getName(), root.getText());
        }else{
            //遍历
            for (Element e : elementList){
                recursiveParseXML(e,map);
            }
        }
    }



    /**
     * 根据Map组装xml消息体，值对象仅支持基本数据类型、String、BigInteger、BigDecimal，以及包含元素为上述支持数据类型的Map
     *
     * @param vo
     * @param rootElement
     * @return
     */
    public static String map2xmlBody(Map<String, Object> vo, String rootElement) {
        Document doc = DocumentHelper.createDocument();
        Element body = DocumentHelper.createElement(rootElement);
        doc.add(body);
        __buildMap2xmlBody(body, vo);
        return doc.asXML();
    }

    private static void __buildMap2xmlBody(Element body, Map<String, Object> vo) {
        if (vo != null) {
            Iterator<String> it = vo.keySet().iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                if (StringUtils.isNotEmpty(key)) {
                    Object obj = vo.get(key);
                    Element element = DocumentHelper.createElement(key);
                    if (obj != null) {
                        if (obj instanceof String) {
                            element.setText((String) obj);
                        } else {
                            if (obj instanceof Character || obj instanceof Boolean || obj instanceof Number
                                    || obj instanceof java.math.BigInteger || obj instanceof java.math.BigDecimal) {
                                org.dom4j.Attribute attr = DocumentHelper.createAttribute(element, "type", obj.getClass().getCanonicalName());
                                element.add(attr);
                                element.setText(String.valueOf(obj));
                            } else if (obj instanceof Map) {
                                org.dom4j.Attribute attr = DocumentHelper.createAttribute(element, "type", Map.class.getCanonicalName());
                                element.add(attr);
                                __buildMap2xmlBody(element, (Map<String, Object>) obj);
                            } else {
                            }
                        }
                    }
                    body.add(element);
                }
            }
        }
    }

    /**
     * 根据xml消息体转化为Map
     *
     * @param xml
     * @param rootElement
     * @return
     * @throws org.dom4j.DocumentException
     */
    public static Map xmlBody2map(String xml, String rootElement) throws DocumentException {
        Document doc = DocumentHelper.parseText(xml);
        Element body = (Element) doc.selectSingleNode("/" + rootElement);
        Map vo = __buildXmlBody2map(body);
        return vo;
    }

    private static Map __buildXmlBody2map(Element body) {
        Map vo = new HashMap();
        if (body != null) {
            List<Element> elements = body.elements();
            for (Element element : elements) {
                String key = element.getName();
                if (StringUtils.isNotEmpty(key)) {
                    String type = element.attributeValue("type", "java.lang.String");
                    String text = element.getText().trim();
                    Object value = null;
                    if (String.class.getCanonicalName().equals(type)) {
                        value = text;
                    } else if (Character.class.getCanonicalName().equals(type)) {
                        value = new Character(text.charAt(0));
                    } else if (Boolean.class.getCanonicalName().equals(type)) {
                        value = new Boolean(text);
                    } else if (Short.class.getCanonicalName().equals(type)) {
                        value = Short.parseShort(text);
                    } else if (Integer.class.getCanonicalName().equals(type)) {
                        value = Integer.parseInt(text);
                    } else if (Long.class.getCanonicalName().equals(type)) {
                        value = Long.parseLong(text);
                    } else if (Float.class.getCanonicalName().equals(type)) {
                        value = Float.parseFloat(text);
                    } else if (Double.class.getCanonicalName().equals(type)) {
                        value = Double.parseDouble(text);
                    } else if (java.math.BigInteger.class.getCanonicalName().equals(type)) {
                        value = new java.math.BigInteger(text);
                    } else if (java.math.BigDecimal.class.getCanonicalName().equals(type)) {
                        value = new java.math.BigDecimal(text);
                    } else if (Map.class.getCanonicalName().equals(type)) {
                        value = __buildXmlBody2map(element);
                    } else {
                    }
                    vo.put(key, value);
                }
            }
        }
        return vo;
    }

}
