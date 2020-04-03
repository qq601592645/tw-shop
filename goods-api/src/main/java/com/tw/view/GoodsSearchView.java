package com.tw.view;

/**
 * Created by aisiA on 2019/4/8.
 */
public class GoodsSearchView {
    private Integer pageNo;//页码
    private Integer pageSize;//页数
    private String key;//关键字
    private String  hot;//热门
    private String onlineStatus;//上架

    public String getOnlineStatus() {
        return onlineStatus;
    }

    public void setOnlineStatus(String onlineStatus) {
        this.onlineStatus = onlineStatus;
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

    public String getHot() {
        return hot;
    }

    public void setHot(String hot) {
        this.hot = hot;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
