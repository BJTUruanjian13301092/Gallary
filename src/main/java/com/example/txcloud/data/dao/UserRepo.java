package com.example.txcloud.data.dao;

import com.example.txcloud.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepo extends JpaRepository<UserEntity, String> {

    @Query("select user from UserEntity user where user.userName = ?1")
    List<UserEntity> findUserByUserName(String userName);

    @Query("select user.password from UserEntity user where user.userName = ?1")
    String findPasswordByUserName(String userName);
}
