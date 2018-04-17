package com.example.txcloud.service;

import com.example.txcloud.data.dao.UserRepo;
import com.example.txcloud.data.entity.UserEntity;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void saveUser(UserEntity userEntity){
        userRepo.save(userEntity);
    }

    public List<UserEntity> showAllUsers(){
        return userRepo.findAll();
    }
}
