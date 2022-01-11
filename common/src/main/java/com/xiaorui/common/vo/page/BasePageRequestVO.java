package com.xiaorui.common.vo.page;

public class BasePageRequestVO {

    private Integer currentPage;
    private Integer numPerPage;

    public BasePageRequestVO() {
    }


    public Boolean checkPageParam() {
        return null == this.getCurrentPage() || null == this.getNumPerPage();
    }

    public Integer getCurrentPage() {
        return this.currentPage == null ? 1 : this.currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getNumPerPage() {
        return this.numPerPage;
    }

    public void setNumPerPage(Integer numPerPage) {
        this.numPerPage = numPerPage;
    }


}
