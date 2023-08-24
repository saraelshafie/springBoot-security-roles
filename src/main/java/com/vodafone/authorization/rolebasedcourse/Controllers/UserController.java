package com.vodafone.authorization.rolebasedcourse.Controllers;

import com.vodafone.authorization.rolebasedcourse.Model.UserEntity;
import com.vodafone.authorization.rolebasedcourse.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController

public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public void addUser(@RequestBody UserEntity user){
        userService.addUser(user);
    }

    @GetMapping("/user")
    public ArrayList<UserEntity> getAllUsers(){
        return userService.getAllUsers();
    }
}
