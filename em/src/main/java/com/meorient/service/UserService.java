package com.meorient.service;

import com.meorient.dao.UserDao;
import com.meorient.pojo.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sunwanghe
 * @date 2019/4/22 18:20
 */

@Service
public class UserService extends BaseService<User, UserDao> {

    /**
     * 获取用户信息列表
     * @param user
     * @return
     */
    public List<User> getUserList(User user){
        return this.dao.selectUserList(user);
    }

    /**
     * 获取用户信息
     * @param user
     * @return
     */
    public User getUserInfo(User user){
        return this.dao.selectUserInfo(user);
    }

    /**
     * 插入单条用户信息
     * @param user
     * @return
     */
    public int insertUser(User user){
        return this.dao.insertUser(user);
    }

    /**
     * 批量插入用户信息
     * @param userList
     * @return
     */
    public int insertUserList(List<User> userList){
        return this.dao.insertUserList(userList);
    }

    /**
     * 更新单条 用户信息
     * @param user
     * @return
     */
    public int updateUser(User user){
        return this.dao.updateUser(user);
    }

    /**
     * 批量更新用户信息
     * @param userList
     * @return
     */
    public int updateUserList(List<User> userList){
        return this.dao.updateUserList(userList);
    }
}
