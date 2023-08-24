package com.vodafone.authorization.rolebasedcourse.Services;

import com.vodafone.authorization.rolebasedcourse.Model.Role;
import com.vodafone.authorization.rolebasedcourse.Repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    @Autowired
    RoleRepository roleRepository;

    public void addRole(Role role) {
        roleRepository.save(role);
    }
}
