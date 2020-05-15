package com.lingnan.ymzgzyz.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.lingnan.ymzgzyz.model.entity.Admin;
import com.lingnan.ymzgzyz.model.entity.Child;
import com.lingnan.ymzgzyz.model.entity.Volunteer;
import com.lingnan.ymzgzyz.service.TokenService;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TokenServiceImpl implements TokenService {
    @Override
    public String getAdminToken ( Admin admin ) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 60 * 1000; //一小时有效时间
        Date end = new Date(currentTime);
        //带上身份信息
        String key = "admin" + ":" + admin.getId();
        return JWT.create().withAudience(key).withIssuedAt(start).withExpiresAt(end).sign(Algorithm.HMAC256(admin.getPassword()));
    }

    @Override
    public String getChildToken ( Child child ) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 60 * 1000; //一小时有效时间
        Date end = new Date(currentTime);
        String key = "child" + ":" + child.getId();
        return JWT.create().withAudience(key).withIssuedAt(start).withExpiresAt(end).sign(Algorithm.HMAC256(child.getPassword()));
    }

    @Override
    public String getVolunteerToken ( Volunteer volunteer ) {
        Date start = new Date();
        long currentTime = System.currentTimeMillis() + 60 * 60 * 1000; //一小时有效时间
        Date end = new Date(currentTime);
        String key = "volunteer" + ":"  + volunteer.getId();
        return JWT.create().withAudience(key).withIssuedAt(start).withExpiresAt(end).sign(Algorithm.HMAC256(volunteer.getPassword()));
    }
}
