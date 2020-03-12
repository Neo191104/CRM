package com.hwua.controller;

import com.hwua.pojo.User;
import com.hwua.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

//@Controller
//@ResponseBody

@Controller
public class LoginRegisterController {
    @Autowired
    private UserService us=null;

    @PostMapping("/login.do")
    public ModelAndView login(String username,String password) throws Exception{
        String info=null;
        ModelAndView mv = new ModelAndView();
        Subject currentUser = SecurityUtils.getSubject();//创建一个用户（主题）
        //判断当前用户是否登录成功
        if(!currentUser.isAuthenticated()){
            //把用户名和密码封装在UsernamePasswordToken中
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            try {
                //进行登录验证
                currentUser.login(token);
                //底层交给securityManager对象去调用注册得realm从文件或数据库中找到此登录用户的用户名和密码信息，拿到这些信息以后
                //和token中的用户名、密码进行比对。
            } catch (UnknownAccountException uae) {
                info="不存在此用户";
            } catch (IncorrectCredentialsException ice) {
                info="密码不正确";
            } catch (LockedAccountException lae) {
                info="账号锁定";
            } catch (AuthenticationException ae) {
                info=ae.getMessage();
            }
        }
        if(info==null){
            mv.setViewName("pages/main");
        }else{
            mv.setViewName("login");
            mv.addObject("info",info);
        }
        return mv;

    }

    @PostMapping("/register")
    public ModelAndView register(User user) throws Exception{
      ModelAndView mv = new ModelAndView();
      Boolean res = us.register(user);
      if(res){
          mv.addObject("info","注册成功");
          mv.setViewName("register");
          return mv;
      }else{
          mv.addObject("info","注册失败");
          mv.setViewName("register");
          return mv;
      }
    }

}
