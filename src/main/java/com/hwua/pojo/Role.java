package com.hwua.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Role {
    private String id;
    private String roleName;
    private String roleDesc;
    private List<Permission> permission;

}
