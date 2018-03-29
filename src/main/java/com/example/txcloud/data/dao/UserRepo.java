package com.example.txcloud.data.dao;

import com.example.txcloud.data.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserEntity, String> {
}
