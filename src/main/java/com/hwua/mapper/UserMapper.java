package com.hwua.mapper;

import com.hwua.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserMapper {
    public User findUserByName(String username) throws Exception;
    public User queryUserByUser(User User) throws Exception;//登录
    public Integer saveUser(User User) throws Exception;;//注册
    public List<User> queryAllUsers() throws Exception;; //查询所有的用户

    public User queryUserByName(String name) throws Exception;;//判断用户名是否已经注册

    //更新人员状态
    public Integer updateUsersStatus(@Param("ids") String [] ids, @Param("status") Integer status) throws Exception;
}
