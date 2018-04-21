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

    public String saveUser(UserEntity userEntity){
        List<UserEntity> listUser = userRepo.findUserByUserName(userEntity.getUserName());
        if(listUser.size() != 0){
            return "fail";
        }
        else{
            userRepo.save(userEntity);
            return "success";
        }
    }

    public UserEntity checkUser(UserEntity userEntity){
        String password = userRepo.findPasswordByUserName(userEntity.getUserName());
        if(password == null){
            return null;
        }
        if(password.equals(userEntity.getPassword())){
            UserEntity user;
            user = userRepo.findUserByUserName(userEntity.getUserName()).get(0);
            return user;
        }
        else{
            return null;
        }
    }

    public List<UserEntity> showAllUsers(){
        return userRepo.findAll();
    }
}
