package com.lingnan.ymzgzyz.service;

import com.lingnan.ymzgzyz.model.entity.ActiveSign;
import com.baomidou.mybatisplus.extension.service.IService;

import java.sql.Time;
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
public interface IActiveSignService extends IService<ActiveSign> {

    List<ActiveSign> getByActiveId (Integer activeId);

    List<ActiveSign> getByVId (Integer vId);

    List<ActiveSign> getByTime ( String time );
}
