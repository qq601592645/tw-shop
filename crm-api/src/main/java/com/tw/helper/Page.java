package com.tw.helper;
import org.apache.ibatis.session.RowBounds;

import java.io.Serializable;
import java.util.List;

public class Page<E> implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -4973539948210269342L;
    /**
     * 默认页码 
     */
    public static final Integer DEFAULT_PAGE_NO = 1;
    /**
     * 默认页面大小 
     */
    public static final Integer DEFAULT_PAGE_SIZE = 10;
    /**
     * 默认的快速导航页码显示个数 
     */
    public static final Integer DEFAULT_PAGE_NAV_SIZE = 5;

    private Integer pageNo = DEFAULT_PAGE_NO; // 页码
    private Integer pageSize = DEFAULT_PAGE_SIZE; // 页面大小
    private Integer pageNaviSize = DEFAULT_PAGE_NAV_SIZE; // 页码快速导航显示的个数
    private long totalCount; // 总的记录数
    private List<E> resultList; // 返回的查询结果集  

    public Page() {
        super();
    }

    public Page(Integer pageNo, Integer pageSize) {
        super();
        setPageNo(pageNo);
        setPageSize(pageSize);
    }

    public Page(Integer pageNo, Integer pageSize, Integer pageNaviSize) {
        this(pageNo, pageSize);
        setPageNaviSize(pageNaviSize);
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        if (pageNo < 1) {
            pageNo = DEFAULT_PAGE_NO;
        }
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        if (pageSize < 1) {
            pageSize = DEFAULT_PAGE_SIZE;
        }
        this.pageSize = pageSize;
    }

    public long getTotalCount() {
        return totalCount;
    }
    public long getPageCount() {
        return totalCount/pageSize;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public List<E> getResultList() {
        return resultList;
    }

    public void setResultList(List<E> resultList) {
        this.resultList = resultList;
    }

    public Integer getPageNaviSize() {
        return pageNaviSize;
    }


    public void setPageNaviSize(Integer pageNaviSize) {
        if (pageNaviSize < 1) {
            pageNaviSize = DEFAULT_PAGE_NAV_SIZE;
        }
        this.pageNaviSize = pageNaviSize;
    }

    /**
     * 获得总的页码数量 
     *
     * @return
     */


    /**
     * 获取从哪一条记录开始查询 
     *
     * @return
     */
    public int getFirstIndex() {
        return (pageNo - 1) * pageSize;
    }

    /**
     * 获取最后一条记录的下标数（不包含） 
     *
     * @return
     */
    public int getLastIndex() {
        return getFirstIndex() + pageSize;
    }

    /**
     * 判断是否还有下一页 
     *
     * @return
     */

    /**
     * 获取下一个页码，在调用之前先调用<code>isHasNextPage()</code>方法进行判断 
     *
     * @return
     */
    public int getNextPage() {
        return pageNo + 1;
    }

    /**
     * 判断是否还有上一页 
     *
     * @return
     */
    public boolean isHasPrePage() {
        return (pageNo - 1) > 0;
    }

    /**
     * 获取上一个页码，在调用之前先调用<code>isHasPrePage()</code>方法进行判断 
     *
     * @return
     */
    public int getPrePage() {
        return pageNo - 1;
    }
    public RowBounds createRowBounds() {
        return createRowBounds(pageNo, pageSize);
    }
    public RowBounds createRowBounds(int page) {
        return createRowBounds(page, pageSize);
    }

    public RowBounds createRowBounds(int page, int pageSize) {
        int offset = (page-1) * pageSize;

        if (offset < 0) {
            offset = 0;
        }
        return new RowBounds(offset, pageSize);
    }
}  