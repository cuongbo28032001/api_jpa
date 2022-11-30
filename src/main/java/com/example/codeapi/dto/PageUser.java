package com.example.codeapi.dto;

import com.example.codeapi.dto.PageDto;
import com.example.codeapi.models.User;

public class PageUser {

    User user;

    PageDto page;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public PageDto getPage() {
        return page;
    }

    public void setPage(PageDto page) {
        this.page = page;
    }
}
