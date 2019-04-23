package com.meorient.dao;

import com.meorient.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;

/**
 * @author sunwanghe
 * @date 2019/4/22 18:20
 */

@Repository
public class UserDao extends BaseDao<User> {

    /**
     * 查询用户列表
     * @param user
     * @return
     */
    public List<User> selectUserList(User user){
        return this.selectList(user);
    }


    /**
     * 查询单个用户信息
     * @param user
     * @return
     */
    public User selectUserInfo(User user){
        return this.selectUnique(user);
    }

    /**
     * 插入单条用户信息
     * @param user
     * @return
     */
    public int insertUser(User user){
        return this.insert(user);
    }

    /**
     * 批量插入用户信息
     * @param userList
     * @return
     */
    public int insertUserList(List<User> userList){
        return this.insertList(userList);
    }

    /**
     * 更新单条 用户信息
     * @param user
     * @return
     */
    public int updateUser(User user){
        return this.update(user);
    }

    /**
     * 批量更新用户信息
     * @param userList
     * @return
     */
    public int updateUserList(List<User> userList){
        return this.updateList(userList);
    }

}
