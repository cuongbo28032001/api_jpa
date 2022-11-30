package com.example.codeapi.dto;

import com.example.codeapi.models.DMNCC;

public class PageNCC {
    PageDto pageDto;
    DMNCC dmncc;

    public PageNCC(PageDto pageDto, DMNCC dmncc) {
        this.pageDto = pageDto;
        this.dmncc = dmncc;
    }

    public PageDto getPageDto() {
        return pageDto;
    }

    public void setPageDto(PageDto pageDto) {
        this.pageDto = pageDto;
    }

    public DMNCC getDmncc() {
        return dmncc;
    }

    public void setDmncc(DMNCC dmncc) {
        this.dmncc = dmncc;
    }
}
