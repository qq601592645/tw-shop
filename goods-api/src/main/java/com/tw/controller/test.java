package com.tw.controller;

import com.google.common.collect.Sets;
import org.apache.commons.collections.CollectionUtils;
import sun.applet.Main;

import java.util.*;

/**
 * Created by aisiA on 2019/4/29.
 */
public class test {


    public void excute() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        ArrayList<String> child = new ArrayList<>();
        List<ArrayList<String>> result = new ArrayList<>();
        getSubList(list, 0, child, result);
        System.out.println("真子集 " + result.size() + " 个");
        for (List<String> results : result) {
            System.out.println(results);
        }
    }

    public void getSubList(List<String> resourses, int nonius, ArrayList<String> childs, List<ArrayList<String>> results) {
        for (int i = nonius; i < resourses.size(); i++) {
            // 去掉自己本身
            if (childs.size() < resourses.size() - 1) {
                // 将数据源中的每个元素分别拿出来
                childs.add(resourses.get(i));
                // 将每个元素的集合作为元素放入结果集合
                results.add(new ArrayList<>(childs));
                // 递归向后移动
                getSubList(resourses, i + 1, childs, results);
                // 移除
                childs.remove(childs.size() - 1);
            }
        }
    }
    public static void main(String[] args)
    {
        test t=new test();
        t.excute();
    }
}
