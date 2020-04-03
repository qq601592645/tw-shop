package com.tw.view;

/**
 * Created by aisiA on 2019/4/8.
 */
public class BrandSearchView {
    private Integer pageNo;//页码
    private Integer pageSize;//页数
    private String key;//关键字
    private String show;

    public String getShow() {
        return show;
    }

    public void setShow(String show) {
        this.show = show;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
