package com.example.txcloud.data.data_util;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserBean {

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

    private String createTime;

    private String updateTime;

    private String birthday;

    private Integer age;

    private Integer location;

    private String userName;

    private String[] hobby;

    private String changePassword;

    private String signDate;

    private Long artCoin;
}
