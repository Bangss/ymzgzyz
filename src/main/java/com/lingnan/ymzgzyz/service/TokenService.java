package com.lingnan.ymzgzyz.service;

import com.lingnan.ymzgzyz.model.entity.Admin;
import com.lingnan.ymzgzyz.model.entity.Child;
import com.lingnan.ymzgzyz.model.entity.Volunteer;

/**
 * TokenService
 * token下发
 * @author Bangss
 * @since 2020-5-15
 */
public interface TokenService {
    String getAdminToken( Admin admin );
    String getChildToken( Child child );
    String getVolunteerToken( Volunteer volunteer );

}
