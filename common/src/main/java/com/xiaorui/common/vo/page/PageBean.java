package com.xiaorui.common.vo.page;

import com.github.pagehelper.Page;
import com.xiaorui.common.exception.BizException;

import java.util.ArrayList;
import java.util.List;

public class PageBean<T> {

    private int currentPage;
    private int numPerPage = 1;
    private int totalCount;
    private List<T> recordList;
    private int pageCount;
    private int listCount;

    public PageBean() {
    }

    public PageBean(List<T> recordList) {
            if (!(recordList instanceof Page)) {
                throw BizException.PARAM_DELETION;
            }
            Page<T> page = (Page)recordList;
            this.totalCount = (int)page.getTotal();
            this.currentPage = page.getPageNum();
            this.numPerPage = page.getPageSize();
            this.recordList = recordList;
            this.listCount = recordList.size();
    }

    public PageBean(List<?> pageList, List<T> recordList) {
        if (pageList instanceof Page) {
            Page page = (Page)pageList;
            this.totalCount = (int)page.getTotal();
            this.currentPage = page.getPageNum();
            this.numPerPage = page.getPageSize();
            this.recordList = recordList;
            this.listCount = recordList.size();
        } else {
            throw BizException.PARAM_DELETION;
        }
    }

    public PageBean(int currentPage, int numPerPage, List<T> recordList) {
        this.currentPage = currentPage;
        this.numPerPage = numPerPage;
        this.totalCount = recordList == null ? 0 : recordList.size();
        List<T> subList = new ArrayList();
        if (currentPage < this.getPageCount()) {
            int startIndex = currentPage * numPerPage;
            int endIndex = startIndex + numPerPage;

            for(int i = startIndex; i < endIndex && i < this.totalCount; ++i) {
                subList.add(recordList.get(i));
            }
        }
        this.recordList = subList;
        this.listCount = subList.size();
    }

    public PageBean(int currentPage, int numPerPage, int totalCount, List<T> recordList) {
        this.currentPage = currentPage;
        this.numPerPage = numPerPage;
        this.totalCount = totalCount;
        this.recordList = recordList;
        this.listCount = recordList.size();
    }

    public List<T> getRecordList() {
        return this.recordList;
    }

    public void setRecordList(List<T> recordList) {
        this.recordList = recordList;
    }

    public int getCurrentPage() {
        return this.currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageCount() {
        return (this.getTotalCount() + this.getNumPerPage() - 1) / this.getNumPerPage();
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getNumPerPage() {
        return this.numPerPage;
    }

    public void setNumPerPage(int numPerPage) {
        this.numPerPage = numPerPage;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getListCount() {
        return listCount;
    }

    public void setListCount(int listCount) {
        this.listCount = listCount;
    }
}
