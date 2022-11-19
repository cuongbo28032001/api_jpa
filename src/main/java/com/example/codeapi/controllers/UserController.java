package com.example.codeapi.controllers;


import com.example.codeapi.dto.PageUser;
import com.example.codeapi.dto.Request;
import com.example.codeapi.models.User;
import com.example.codeapi.serveice.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public User save(@RequestBody User user)
    {
        return this.userService.save(user);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public Request update(@RequestBody  User user)
    {
            return this.userService.update(user);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public Request delete(@RequestBody User user)
    {
        return userService.delete(user);
    }

    @RequestMapping(value = "/listuser", method = RequestMethod.GET)
    public List<User> findAll()
    {
        return this.userService.findAll();
    }

    @RequestMapping(value = "/query", method = RequestMethod.POST)
    public Request test(@RequestBody PageUser pageUser)
    {
        return  this.userService.findByPagingCriteria(pageUser);
    }
}
