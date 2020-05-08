package com.lingnan.ymzgzyz.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lingnan.ymzgzyz.common.util.MD5Util;
import com.lingnan.ymzgzyz.mapper.ChildMapper;
import com.lingnan.ymzgzyz.mapper.VolunteerMapper;
import com.lingnan.ymzgzyz.model.entity.Child;
import com.lingnan.ymzgzyz.model.entity.Volunteer;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

/**
 * @author Ponking
 * @ClassName VolunteerRealm
 * @date 2020/3/28--20:16
 **/
@Slf4j
public class VolunteerRealm extends AuthorizingRealm {
    @Autowired
    private VolunteerMapper volunteerMapper;

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
        log.info("=>> VolunteerRealm认证");
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String password = new String(token.getPassword());
        String username = token.getUsername();
        // 根据用户名去DB查询对应的用户信息
        QueryWrapper<Volunteer> wrapper = new QueryWrapper<>();
        wrapper.eq("name",username);
        Volunteer volunteer = volunteerMapper.selectOne(wrapper);
        if(StringUtils.isEmpty(volunteer)){
            throw new UnknownAccountException("用户名不存在");
        }
        // 两个密码的密文进行比对
        if (!volunteer.getPassword().equals(MD5Util.md5(password,volunteer.getSalt()))) {
            throw new CredentialsException("密码错误");
        }
        // 创建简单认证信息对象
        SimpleAuthenticationInfo info =
                new SimpleAuthenticationInfo(volunteer, token.getCredentials(), getName());
        log.info("<== VolunteerRealm认证成功");
        return info;
    }
}
