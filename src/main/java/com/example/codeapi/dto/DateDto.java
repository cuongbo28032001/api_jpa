package com.example.codeapi.dto;

import java.util.Date;

public class DateDto {
    private Date datefrom;
    private  Date dateto;

    public Date getDatefrom() {
        return datefrom;
    }

    public void setDatefrom(Date datefrom) {
        this.datefrom = datefrom;
    }

    public Date getDateto(){
        return dateto;
    }

    public void setDateto(Date dateto) {
        this.dateto = dateto;
    }

    public DateDto(Date datefrom, Date dateto) {
        this.datefrom = datefrom;
        this.dateto = dateto;
    }

    public DateDto() {
    }
}
