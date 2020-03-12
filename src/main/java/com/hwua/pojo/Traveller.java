package com.hwua.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Traveller {
    private String id;
    private String name;
    private String sex;
    private String phoneNum;
    private long credentialsType;
    private String credentialsNum;
    private long travellerType;

}
