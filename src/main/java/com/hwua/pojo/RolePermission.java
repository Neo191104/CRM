package com.hwua.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RolePermission {
    private String permissionId;
    private String roleId;

}
