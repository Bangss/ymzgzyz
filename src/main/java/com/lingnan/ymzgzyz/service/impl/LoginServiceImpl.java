package com.lingnan.ymzgzyz.service.impl;

import com.lingnan.ymzgzyz.mapper.LoginMapper;
import com.lingnan.ymzgzyz.pojo.Login;
import com.lingnan.ymzgzyz.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;
    @Override
    public List<Login> getAll ( ) {
        return loginMapper.getAll();
    }
}
