package com.hwua.pojo;

import lombok.Data;

import java.util.List;

@Data
public class User {
    private String id;
    private String email;
    private String username;
    private String password;
    private String phoneNum;
    private long status;
    private List<Role> role;

}
