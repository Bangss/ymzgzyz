package com.lingnan.ymzgzyz.service;

import com.lingnan.ymzgzyz.model.entity.ActiveInf;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 活动信息 服务类
 * </p>
 *
 * @author Bangss
 * @since 2020-05-09
 */
public interface IActiveInfService extends IService<ActiveInf> {

    List<ActiveInf> getByUserRole(Integer userRole);

    List<ActiveInf> getByUserId(Integer userId);

    List<ActiveInf> getByCompany (String company);

    List<ActiveInf> getByBoss (String boss);

    List<ActiveInf> getByStates (Integer states);

    List<ActiveInf> getByAttendTime ( Date date );

    List<ActiveInf> getByBeforeAttendTime (Date date);

    List<ActiveInf> getByAfterAttendTime (Date date);

    List<ActiveInf> getByCloseTime (Date date);

    List<ActiveInf> getByBeforeCloseTime (Date date);

    List<ActiveInf> getByAfterCloseTime (Date date);

    List<ActiveInf> getByStartTime (Date date);

    List<ActiveInf> getByBeforeStartTime (Date date);

    List<ActiveInf> getByAfterStarTime (Date date);

    List<ActiveInf> getByEndTime (Date date);

    List<ActiveInf> getByBeforeEndTime (Date date);

    List<ActiveInf> getByAfterEndTime (Date date);

    List<ActiveInf> getByTitle (String title);

    List<ActiveInf> getByContent(String content);

    List<ActiveInf> getByPN (Integer pn);

    List<ActiveInf> getByGreaterThanPN (Integer num);

    List<ActiveInf> getByLessThanPN (Integer num);

    List<ActiveInf> getByExtent (Integer num1 , Integer num2);
}
