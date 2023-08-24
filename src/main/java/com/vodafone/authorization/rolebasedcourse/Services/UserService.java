package com.vodafone.authorization.rolebasedcourse.Services;

import com.vodafone.authorization.rolebasedcourse.Model.UserEntity;
import com.vodafone.authorization.rolebasedcourse.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    public void addUser(UserEntity user) {
        userRepository.save(user);
    }

    public ArrayList<UserEntity> getAllUsers() {
        return (ArrayList<UserEntity>) userRepository.findAll();
    }
}
