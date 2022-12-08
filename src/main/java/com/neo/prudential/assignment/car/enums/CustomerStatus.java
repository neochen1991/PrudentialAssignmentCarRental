package com.neo.prudential.assignment.car.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author neo
 * @date 2022/12/8
 */
@AllArgsConstructor
public enum CustomerStatus implements BaseEnum {

    INITIAL("CUST_IS_INIT"),
    NORMAL("CUST_IS_NORMAL"),
    FROZEN("CUST_IS_FROZEN"),
    DELETED("CUST_IS_DELETED"),
    ;

    @Getter
    private String msg;

    @Override
    public String getMsg() {
        return msg;
    }
}
