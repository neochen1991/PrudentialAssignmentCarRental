package com.neo.prudential.assignment.car.enums;

import lombok.Getter;

/**
 * @author neo
 * @date 2022/12/8
 */
public enum RestCode implements BaseEnum {

    SUCCESS("success", 100000),
    ERROR("fail", 111111),
    ;

    final private String msg;

    @Getter
    final private int code;

    RestCode(String msg, int code) {
        this.msg = msg;
        this.code = code;
    }

    @Override
    public String getMsg() {
        return msg;
    }

}
