package com.example.txcloud.data.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="test_user")
public class UserEntity {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private Boolean sex;

    private Byte status;

    private String password;

    private Long wechatId;

    private Long qqId;

    private Long weiboId;

    private String phone;

    private String introduction;

    private Timestamp createTime;

    private Timestamp updateTime;

    private Timestamp birthday;

    private Integer age;
}
