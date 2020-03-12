package com.hwua.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Permission {
    private String id;
    private String permissionName;
    private String url;

}
