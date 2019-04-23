package com.meorient.controller;

import com.meorient.common.constant.EMsgCommon;
import com.meorient.common.pojo.OptResult;
import com.meorient.common.pojo.ResponseData;
import com.meorient.pojo.User;
import com.meorient.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author sunwanghe
 * @date 2019/4/22 18:19
 */
@RestController
public class UserController {
    /** 日志对象 */
    protected Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/api/users/v1",method = RequestMethod.GET)
    public ResponseData getUserList(User user){
        List<User> resultList = userService.getUserList(user);
        OptResult info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
        return new ResponseData(info,resultList);
    }

    @RequestMapping(value = "/api/user/v1",method = RequestMethod.GET)
    public ResponseData getUser(User user){
        User resultList = userService.getUserInfo(user);
        OptResult info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
        return new ResponseData(info,resultList);
    }

    @RequestMapping(value = "/api/users/v1",method = RequestMethod.PUT)
    public ResponseData insertUserList(List<User> userList){
        int resultList = userService.insertUserList(userList);
        OptResult info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
        return new ResponseData(info,resultList);
    }

    @RequestMapping(value = "/api/user/v1",method = RequestMethod.PUT)
    public ResponseData insertUser(User user){
        int resultList = userService.insertUser(user);
        OptResult info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
        return new ResponseData(info,resultList);
    }

    @RequestMapping(value = "/api/users/v1",method = RequestMethod.POST)
    public ResponseData updateUserList(List<User> userlist){
        int resultList = userService.updateUserList(userlist);
        OptResult info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
        return new ResponseData(info,resultList);
    }

    @RequestMapping(value = "/api/user/v1",method = RequestMethod.POST)
    public ResponseData updateUser(User user){
        int resultList = userService.updateUser(user);
        OptResult info = EMsgCommon.svceRigGetDataSuccess.getOptResult(logger);
        return new ResponseData(info,resultList);
    }
}
