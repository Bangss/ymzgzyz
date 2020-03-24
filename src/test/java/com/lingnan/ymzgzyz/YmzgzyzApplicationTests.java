package com.lingnan.ymzgzyz;


import com.lingnan.ymzgzyz.model.entity.Admin;
import com.lingnan.ymzgzyz.service.IAdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class YmzgzyzApplicationTests {

    @Autowired
    private IAdminService adminService;

    @Test
    public void contextLoads ( ) {
    }

    /**
     * 测试数据库连接
     */
    @Test
    public void testConnectionDataSource(){
        Admin admin = adminService.getById(1);
        System.out.println(admin);
    }

}
