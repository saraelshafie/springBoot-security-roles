package com.vodafone.authorization.rolebasedcourse.Controllers;

import com.vodafone.authorization.rolebasedcourse.Model.Role;
import com.vodafone.authorization.rolebasedcourse.Services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoleController {

    @Autowired
    RoleService roleService;


    @PostMapping("/role")
    public ResponseEntity<String> addRoles(@RequestBody Role role){
        roleService.addRole(role);
        return new ResponseEntity<>("Role added successfully", HttpStatus.OK);
    }
}
