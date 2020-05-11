package com.lingnan.ymzgzyz.model;

import lombok.Data;

//权限对应实体类，用于对实体加权限
@Data
public class Permissions {
    private String id;
    private String permissions;
}
