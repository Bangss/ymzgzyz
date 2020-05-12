package com.lingnan.ymzgzyz.service;

import com.lingnan.ymzgzyz.model.entity.Volunteer;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Select;

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
public interface IVolunteerService extends IService<Volunteer> {

    Volunteer getByName(String name);

    List<Volunteer> getByBorn( String born );

    Volunteer getByCard (String card);

    List<Volunteer> getBySchool (String school);

    List<Volunteer> getByAddress (String address);

    List<Volunteer> getByPlace (String place);

    List<Volunteer> getByOrg (String org);

    List<Volunteer> getByPP (Integer pp);

    List<Volunteer> getByVP (Integer vp);

}
