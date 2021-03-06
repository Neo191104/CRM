package com.hwua.realm;

import com.hwua.pojo.User;
import com.hwua.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * realm主要就是两个功能：
 * 1. 对登录的用户进行授权
 * 2. 用来做登录认证
 */
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private UserService userService;
    /**
     * 对当前登录用具进行授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        System.out.println("授权....");
        return null;
    }

    /**
     * 对当前登录用具进行身份验证
     * 此方法什么时候调用，调用调用subject对象调用login方法的时候，底层调用的是securityManager对象的login方法，此login方法最终调用realm方法中的doGetAuthenticationInfo 方法
     * @param token 此参数就是我们controller传过来的令牌，UsernamePasswordToken对象
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String username=(String)token.getPrincipal();//获取令牌中传过来的用户名
        User user=null;
        try {
             user = userService.findUserByName(username);//从数据中找到的用户信息
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(user==null){
            throw  new UnknownAccountException();
        }

        ByteSource salt = ByteSource.Util.bytes(user.getUsername());//得到salt,salt要不一样
        //SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),super.getName());
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user,user.getPassword(),salt,super.getName());
        return authenticationInfo;//把此对象返回给Shiro，shiro会拿这个对象去和你subject传过来的token进行密码比对
    }
}
