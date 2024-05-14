package com.securityjwt.SpringJWT.controller;


import com.securityjwt.SpringJWT.entity.User;
import com.securityjwt.SpringJWT.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping({"/register-new-user"})
    public User registerNewUser(@RequestBody User user){
        return userService.registerNewUser(user);
    }

    @PostConstruct
    public void initRoleAndUser(){
        userService.initRoleAndUser();

    }

    @GetMapping({"for-admin"})
    public String forAdmin(){
        return "this url is only accessible to admin";
    }

    @GetMapping({"for-user"})
    public String forUser(){
        return "this url is only accessible to user";
    }
}
