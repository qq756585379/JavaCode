package com.yang.base;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class PageRequestBody extends BaseRequestBody {

    @Valid
    @NotNull
    private PageCondition page;

    public PageCondition getPage() {
        return page;
    }

    public void setPage(PageCondition page) {
        this.page = page;
    }

}
