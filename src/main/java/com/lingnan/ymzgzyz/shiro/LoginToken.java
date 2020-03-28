package com.lingnan.ymzgzyz.shiro;

import lombok.Getter;
import lombok.Setter;
import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author Ponking
 * @ClassName LoginToken
 * @date 2020/3/28--20:35
 **/
public class LoginToken extends UsernamePasswordToken {

    @Getter
    @Setter
    private String loginType;

    public LoginToken() {
        super();
    }

    public LoginToken(final String username,final String password,final String loginType){
        super(username,password);
        this.loginType = loginType;
    }
}
