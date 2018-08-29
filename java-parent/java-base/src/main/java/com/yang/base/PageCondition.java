package com.yang.base;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class PageCondition implements Serializable {

    @NotNull
    @Min(1)
    private int pageIndex;

    @NotNull
    @Min(0)
    private int pageSize;

    /**
     * 排序字段，可为空
     */
    private Integer sortBy;

    /**
     * 排序方案
     */
    private SortDirection direction = SortDirection.ASC;

    /**
     * 默认构造函数
     */
    public PageCondition() {
    }

    /**
     * 通过页码和页大小构造分页条件对象。
     *
     * @param pageIndex 页码数
     * @param pageSize  页大小
     */
    public PageCondition(int pageIndex, int pageSize) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
    }

    /**
     * 通过排序标记和排序规则构建排序对象。
     *
     * @param sortBy    排序标记
     * @param direction 排序规则
     */
    public PageCondition(Integer sortBy, SortDirection direction) {
        this.sortBy = sortBy;
        this.direction = direction;
    }

    /**
     * 通过页码和页大小、排序标记和排序规则分页排序对象。
     *
     * @param pageIndex 页码
     * @param pageSize  页大小
     * @param sortBy    排序标记
     * @param direction 排序规则
     */
    public PageCondition(int pageIndex, int pageSize, Integer sortBy, SortDirection direction) {
        this.pageIndex = pageIndex;
        this.pageSize = pageSize;
        this.sortBy = sortBy;
        this.direction = direction;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getSortBy() {
        return sortBy;
    }

    public void setSortBy(Integer sortBy) {
        this.sortBy = sortBy;
    }

    public SortDirection getDirection() {
        return direction;
    }

    public void setDirection(SortDirection direction) {
        this.direction = direction;
    }
}
