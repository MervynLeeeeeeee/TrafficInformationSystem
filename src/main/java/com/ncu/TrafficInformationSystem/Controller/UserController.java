package com.ncu.TrafficInformationSystem.Controller;

import com.ncu.TrafficInformationSystem.Bean.User;
import com.ncu.TrafficInformationSystem.Mapper.UserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/login")
    public ResponseEntity<String> login(User requestUser) {
        logger.info("ss");

        System.out.println(requestUser.toString());
        try{
            User queryUser = userMapper.selectUserByUsername(requestUser);
            if (null == queryUser) {
                return new ResponseEntity<>("您输入的用户名不存在", HttpStatus.NOT_FOUND);
            }
            else if (requestUser.getUserPassword() == null || !queryUser.getUserPassword().equals(requestUser.getUserPassword())) {
                return new ResponseEntity<>("您输入的密码不匹配", HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>("登录成功", HttpStatus.OK);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("您当前的网络有问题", HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/register")
    public ResponseEntity<String> registerUser(User requestUser) {

        System.out.println(requestUser.toString());
        try{
            User queryUser = userMapper.selectUserByUserId(requestUser);
            if (null != queryUser) {
                return new ResponseEntity<>("您输入的邮箱已被注册", HttpStatus.NOT_FOUND);
            }
            else {
                userMapper.insertUser(requestUser);
                return new ResponseEntity<>("注册成功", HttpStatus.OK);
            }
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("您当前的网络有问题", HttpStatus.NOT_FOUND);
        }
    }
}
