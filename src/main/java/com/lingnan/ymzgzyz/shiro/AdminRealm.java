//package com.lingnan.ymzgzyz.shiro;
//
//import com.lingnan.ymzgzyz.mapper.AdminMapper;
//import com.lingnan.ymzgzyz.mapper.ChildMapper;
//import com.lingnan.ymzgzyz.model.Permissions;
//import com.lingnan.ymzgzyz.model.Role;
//import com.lingnan.ymzgzyz.model.entity.Admin;
//import com.lingnan.ymzgzyz.model.entity.Child;
//import com.lingnan.ymzgzyz.service.IChildService;
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.authz.SimpleAuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * @author Banagss
// * @since 2020-5-10
// * ChildRealm
// */
//
//public class AdminRealm extends AuthorizingRealm {
//
//    @Autowired
//    private AdminMapper adminMapper;
//
//    /**
//     * 获取授权信息
//     * @param principalCollection
//     * @return
//     */
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo ( PrincipalCollection principalCollection ) {
//        System.out.println("进入doGetAuthorizationInfo");
//        String username = (String) SecurityUtils.getSubject().getPrincipal();
//        //获取该用户角色
//        Admin admin = adminMapper.getByName(username);
//        //添加角色和权限
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addRole(admin.getRole().toString());
//        return info;
//    }
//
//    /**
//     * 获取身份验证信息
//     * Shiro中，最终是通过 Realm 来获取应用程序中的用户、角色及权限信息的。
//     *
//     * @param authenticationToken 用户身份信息 token
//     * @return 返回封装了用户信息的 AuthenticationInfo 实例
//     */
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo ( AuthenticationToken authenticationToken ) throws AuthenticationException {
//        System.out.println("进入doGetAuthenticationInfo");
//        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
//        System.out.println(token.getUsername());
//        //从数据库获取对应用户名和密码的用户
//        Admin admin = adminMapper.getByName(token.getUsername());
//        String password = admin.getPassword();
//        if (password == null)
//        {
//            throw new AccountException("用户名不正确");
//        }
//        else if (!password.equals(token.getCredentials().toString())) {
//            throw new AccountException("密码不正确");
//        }
//        return new SimpleAuthenticationInfo(token.getPrincipal(),password,getName());
//    }
//}
