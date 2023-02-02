package com.example.codeapi.dto;

public class PageDto {

    private int pageSize;

    private int pageNo;

    public PageDto(int pageSize, int pageNo) {
        super();
        this.pageSize = pageSize;
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }
}
