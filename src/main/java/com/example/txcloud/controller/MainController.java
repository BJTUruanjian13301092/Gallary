package com.example.txcloud.controller;

import com.example.txcloud.data.dao.UserRepo;
import com.example.txcloud.data.data_util.UserBean;
import com.example.txcloud.data.entity.UserEntity;
import com.example.txcloud.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

@RestController
public class MainController extends BaseController {

    private static final Byte DEFAULT_STAUS = Byte.valueOf("0");

    @Autowired
    UserService userService;

    @Autowired
    UserRepo userRepo;

    @RequestMapping(value = "/user/saveUser", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView saveUser(UserBean user){

        UserEntity userEntity = new UserEntity();
        userEntity.setName(user.getName());
        userEntity.setAge(user.getAge());
        userEntity.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        userEntity.setIntroduction(user.getIntroduction());
        userEntity.setLocation(user.getLocation());
        userEntity.setPassword(user.getPassword());
        userEntity.setPhone(user.getPhone());
        userEntity.setQqId(user.getQqId());
        userEntity.setSex(user.getSex());
        userEntity.setStatus(DEFAULT_STAUS);
        userEntity.setWechatId(user.getWechatId());
        userEntity.setWeiboId(user.getWeiboId());
        userEntity.setUserName(user.getUserName());
        userEntity.setArtCoin(Long.valueOf("0"));

        String result = userService.saveUser(userEntity);
        if(result.equals("fail")){
            ModelAndView mav = new ModelAndView("sign_up");
            mav.getModel().put("message", "用户名已经存在");
            return mav;
        }
        else{
            ModelAndView mav = new ModelAndView("log_in");
            mav.getModel().put("message", "注册成功，请登录");
            return mav;
        }
    }

    @RequestMapping("/user/showAllUser")
    public List<UserEntity> showAllUser(){
        return userService.showAllUsers();
    }

    @RequestMapping("/")
    public ModelAndView toIndex(){
        return new ModelAndView("index");
    }

    @RequestMapping("/test")
    public ModelAndView toList() {
        return new ModelAndView("master_list");
    }

    @RequestMapping("/user/toSignUp")
    public ModelAndView toSignUp(){
        return new ModelAndView("sign_up");
    }

    @RequestMapping("/user/toLogIn")
    public ModelAndView toLogIn(){
        return new ModelAndView("log_in");
    }

    @RequestMapping("/user/toUserHome")
    public ModelAndView toUserHome(){
        return new ModelAndView("user_info");
    }


    @RequestMapping(value = "/user/logIn", method = {RequestMethod.GET, RequestMethod.POST})
    public UserBean logIn(UserEntity user){
        UserEntity result = userService.checkUser(user);

        if(result != null){
            UserBean userBean = new UserBean();
            userBean.setId(result.getId());
            userBean.setName(result.getName());
            userBean.setSex(result.getSex());
            userBean.setStatus(result.getStatus());
            userBean.setPassword(result.getPassword());
            userBean.setWechatId(result.getWechatId());
            userBean.setQqId(result.getQqId());
            userBean.setWeiboId(result.getWeiboId());
            userBean.setPhone(result.getPhone());
            userBean.setIntroduction(result.getIntroduction());
            userBean.setCreateTime(result.getCreateTime().toString());
            userBean.setUpdateTime(result.getUpdateTime().toString());
            userBean.setBirthday(result.getBirthday().toString());
            userBean.setAge(result.getAge());
            userBean.setLocation(result.getLocation());
            userBean.setUserName(result.getUserName());
            if(result.getSignDate() != null){
                userBean.setSignDate(result.getSignDate().toString());
            }
            userBean.setArtCoin(result.getArtCoin());

            return userBean;
        }
        else{
            return new UserBean();
        }
    }

    @RequestMapping(value = "user/updateUser", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView updateUser(UserBean user, BindingResult bindingResult){

        //检查绑定错误
        if(bindingResult.hasErrors()){
            List<ObjectError> ls = bindingResult.getAllErrors();
            for (int i = 0; i < ls.size(); i++) {
                System.out.println("error:"+ls.get(i));
            }
        }

        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setAge(user.getAge());
        userEntity.setBirthday(Timestamp.valueOf(user.getBirthday()));
        userEntity.setCreateTime(Timestamp.valueOf(user.getCreateTime()));
        userEntity.setUpdateTime(Timestamp.valueOf(LocalDateTime.now()));
        userEntity.setIntroduction(user.getIntroduction());
        userEntity.setLocation(user.getLocation());
        userEntity.setPassword(user.getPassword());
        userEntity.setPhone(user.getPhone());
        userEntity.setQqId(user.getQqId());
        userEntity.setSex(user.getSex());
        userEntity.setStatus(DEFAULT_STAUS);
        userEntity.setWechatId(user.getWechatId());
        userEntity.setWeiboId(user.getWeiboId());
        userEntity.setUserName(user.getUserName());
        userEntity.setArtCoin(user.getArtCoin());
        userEntity.setSignDate(Timestamp.valueOf(user.getSignDate()));

        if(user.getChangePassword() != null && !user.getChangePassword().equals("")){
            userEntity.setPassword(user.getChangePassword());
            user.setPassword(user.getChangePassword());
        }
        userService.updateUser(userEntity);

        ModelAndView mav = new ModelAndView("user_info");
        mav.getModel().put("userNew", user);

        return mav;
    }

    @RequestMapping(value = "user/signDate", method = {RequestMethod.GET, RequestMethod.POST})
    public String toSignDate(UserBean user){
        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setName(user.getName());
        userEntity.setAge(user.getAge());
        userEntity.setBirthday(Timestamp.valueOf(user.getBirthday()));
        userEntity.setCreateTime(Timestamp.valueOf(user.getCreateTime()));
        userEntity.setUpdateTime(Timestamp.valueOf(user.getUpdateTime()));
        userEntity.setIntroduction(user.getIntroduction());
        userEntity.setLocation(user.getLocation());
        userEntity.setPassword(user.getPassword());
        userEntity.setPhone(user.getPhone());
        userEntity.setQqId(user.getQqId());
        userEntity.setSex(user.getSex());
        userEntity.setStatus(DEFAULT_STAUS);
        userEntity.setWechatId(user.getWechatId());
        userEntity.setWeiboId(user.getWeiboId());
        userEntity.setUserName(user.getUserName());
        userEntity.setSignDate(Timestamp.valueOf(user.getSignDate()));
        userEntity.setArtCoin(Long.valueOf("5") + userRepo.findUserById(user.getId()).getArtCoin());
        userService.updateUser(userEntity);
        Gson gson = new Gson();
        return gson.toJson("签到成功, +5艺术值");
    }

}
