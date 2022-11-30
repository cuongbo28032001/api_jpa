package com.example.codeapi.serveice.User;

import com.example.codeapi.dto.PageUser;
import com.example.codeapi.dto.Request;
import com.example.codeapi.models.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    Request<?> findByPagingCriteria(PageUser pageUser);
    User save(User user);
    Request<?> delete(User user);
    Request<?> update(User user);
}
