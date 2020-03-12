package com.hwua.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hwua.pojo.User;
import com.hwua.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    private UserService userService=null;

    @GetMapping("/findUsersBylimit")
    public PageInfo<User> findUsersByLimit(Integer pageNum, Integer pageSize) throws Exception{
        PageHelper.startPage(pageNum, pageSize);
        List<User> userList = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(userList);
        System.out.println(pageInfo);
        return pageInfo;
    }

    @PostMapping("/user/save.do")
    public ModelAndView login(String username, String password) throws Exception {
        return null;
    }

    @PutMapping("/updateUsersByStatus")
    public Map<String, Object> updateProductsByClose(String [] ids, Integer status) throws Exception{
        Integer res = userService.updateUsersStatus(ids,status);
        Map<String,Object> map = new HashMap<>();
        if(res>0){
            map.put("info","更新成功");
        }else{
            map.put("info","更新失败");
        }
        return map;
    }

}
