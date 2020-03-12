package com.hwua.pojo;

import java.util.List;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class Orders {
    private String id;
    private String orderNum;
    private String orderTime;
    private long peopleCount;
    private String orderDesc;
    private long payType;
    private long orderStatus;
    private Product product = null;//一个订单对象一个旅游产品
    private Member member = null;//会员就是订单的人员
    private List<Traveller> tList = null;//一个订单有多个随行人员

}
