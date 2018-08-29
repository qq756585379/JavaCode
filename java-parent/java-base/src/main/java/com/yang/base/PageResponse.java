package com.yang.base;

public class PageResponse extends BaseResponse {

    /**
     * 当前页码
     */
    private int pageIndex;

    /**
     * 当前页的真实记录数
     */
    private int pageSize;

    /**
     * 总页数
     */
    private int pages;

    /**
     * 总记录数
     */
    private int count;

    /**
     * 获取当前页码
     *
     * @return 当前页码
     */
    public int getPageIndex() {
        return pageIndex;
    }

    /**
     * 设置当前页码
     *
     * @param pageIndex 当前页面
     */
    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    /**
     * 获取当前页的真实记录数
     *
     * @return 当前页的真实记录数
     */
    public int getPageSize() {
        return pageSize;
    }

    /**
     * 设置当前页的真实记录数
     *
     * @param pageSize 当前页的真实记录数
     */
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    /**
     * 获取总页数
     *
     * @return 总页数
     */
    public int getPages() {
        return pages;
    }

    /**
     * 设置总页数
     *
     * @param pages 总页数
     */
    public void setPages(int pages) {
        this.pages = pages;
    }

    /**
     * 获取总记录数
     *
     * @return 总记录数
     */
    public int getCount() {
        return count;
    }

    /**
     * 设置总记录数
     *
     * @param count 总记录数
     */
    public void setCount(int count) {
        this.count = count;
    }
}
