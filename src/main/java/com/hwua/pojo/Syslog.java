package com.hwua.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Syslog {
    private String id;
    private String visitTime;
    private String username;
    private String ip;
    private String url;
    private long executionTime;
    private String method;
}
