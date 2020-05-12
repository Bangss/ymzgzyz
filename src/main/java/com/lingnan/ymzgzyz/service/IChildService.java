package com.lingnan.ymzgzyz.service;


import com.lingnan.ymzgzyz.model.entity.Child;
import com.baomidou.mybatisplus.extension.service.IService;




import java.util.Date;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
public interface IChildService extends IService<Child> {

    Child getByName (String name);

    List<Child> getByLevel ( String level);

    List<Child> getByBorn ( String born );

    List<Child> getByPlace (String place);

    List<Child> getByAddress (String address);
}
