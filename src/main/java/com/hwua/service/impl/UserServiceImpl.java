package com.hwua.service.impl;

import com.hwua.mapper.UserMapper;
import com.hwua.pojo.User;
import com.hwua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper usersMapper;

    @Override
    public User findUserByName(String username) throws Exception {
        return null;
    }

    @Override
    public User login(User user) throws Exception {
        return usersMapper.queryUserByUser(user);
    }
    @Override
    public boolean register(User user) throws Exception {
        return usersMapper.saveUser(user) == 1 ? true : false;
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        return usersMapper.queryAllUsers();
    }


    @Override
    public boolean queryUserByName(String name) throws Exception {
        return usersMapper.queryUserByName(name) != null ? true : false;
    }

    @Override
    public Integer updateUsersStatus(String[] ids, Integer status) throws Exception {
        return usersMapper.updateUsersStatus(ids,status);
    }
}

