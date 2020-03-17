package com.lingnan.ymzgzyz.mapper;

import com.lingnan.ymzgzyz.pojo.Login;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface LoginMapper {
    List<Login> getAll();
}
