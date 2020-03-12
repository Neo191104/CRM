package com.hwua.service;

import com.hwua.pojo.User;

import java.util.List;

/**
 * @author Administrator
 */
public interface UserService {
    public User findUserByName(String username) throws Exception;

    public User login(User user) throws Exception;//登录

    public boolean register(User user) throws Exception;//注册

    public List<User> getAllUsers() throws Exception; //查询所有的用户

    public boolean queryUserByName(String name) throws Exception;//判断用户名是否已经注册


    //更新人员状态
    public Integer updateUsersStatus(String [] ids,Integer status) throws Exception;

}
