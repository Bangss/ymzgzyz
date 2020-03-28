package com.lingnan.ymzgzyz.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lingnan.ymzgzyz.common.util.MD5Util;
import com.lingnan.ymzgzyz.mapper.ChildMapper;
import com.lingnan.ymzgzyz.model.entity.Child;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @author Ponking
 * @ClassName ChildRealm
 * @date 2020/3/28--18:31
 * @Des 学生Realm
 **/
@Slf4j
public class ChildRealm extends AuthorizingRealm {

    @Autowired
    private ChildMapper childMapper;

    /**
     * 授权
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        return null;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.info("=>> childRealm认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String password = new String(token.getPassword());
        String username = token.getUsername();
        // 根据用户名去DB查询对应的用户信息
        QueryWrapper<Child> wrapper = new QueryWrapper<>();
        wrapper.eq("name",username);
        Child child = childMapper.selectOne(wrapper);
        if(StringUtils.isEmpty(child)){
            throw new UnknownAccountException("用户名不存在");
        }
        // 两个密码的密文进行比对
        if (!child.getPassword().equals(MD5Util.md5(password,child.getSalt()))) {
            throw new CredentialsException("密码错误");
        }
        // 创建简单认证信息对象
        SimpleAuthenticationInfo info =
                new SimpleAuthenticationInfo(child, token.getCredentials(), getName());
        log.info("<== childRealm认证成功");
        return info;
    }
}
