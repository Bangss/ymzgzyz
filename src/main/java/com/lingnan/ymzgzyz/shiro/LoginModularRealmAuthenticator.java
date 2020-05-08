package com.lingnan.ymzgzyz.shiro;

import org.apache.shiro.ShiroException;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/**
 * @author Ponking
 * @ClassName LoginModularRealmAuthenticator
 * @date 2020/3/28--20:48
 * @Des 全局shiro拦截分发realm
 **/
public class LoginModularRealmAuthenticator extends ModularRealmAuthenticator {

    @Override
    protected AuthenticationInfo doAuthenticate(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        // 判断getRealms()是否返回为空
        assertRealmsConfigured();
        // 强制转换回自定义的CustomizedToken
        LoginToken token = (LoginToken) authenticationToken;
        // 找到当前登录人的登录类型
        String loginType = token.getLoginType();
        // 所有Realm
        Collection<Realm> realms = getRealms();
        // 找到登录类型对应的指定Realm
        Collection<Realm> typeRealms = new ArrayList<>();
        for (Realm realm : realms) {
            if (realm.getName().toLowerCase().contains(loginType)){
                typeRealms.add(realm);
            }
        }
        // 判断是单Realm还是多Realm
        if (typeRealms.size() == 1) {
            return doSingleRealmAuthentication(typeRealms.iterator().next(), token);
        } else {
            return doMultiRealmAuthentication(typeRealms, token);
        }
    }
}
