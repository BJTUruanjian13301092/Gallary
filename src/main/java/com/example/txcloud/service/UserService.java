package com.example.txcloud.service;

import com.example.txcloud.data.dao.UserRepo;
import com.example.txcloud.data.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepo userRepo;

    public void saveUser(){

        List<UserEntity> listEntity = new ArrayList<>();
        UserEntity user1 = new UserEntity();
        user1.setAge(18);
        user1.setName("Larry");
        user1.setSex("male");

        UserEntity user2 = new UserEntity();
        user2.setAge(18);
        user2.setName("Euphie");
        user2.setSex("female");

        listEntity.add(user1);
        listEntity.add(user2);
        userRepo.saveAll(listEntity);
    }

    public List<UserEntity> showUsers(){
        return userRepo.findAll();
    }
}
