package com.neo.prudential.assignment.car.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author neo
 * @date 2022/12/8
 */
@AllArgsConstructor
public enum RentStatus implements BaseEnum {

    INITIAL("RENT_INITIAL"),
    PENDING("RENT_IS_PENDING"),
    PAYED("ORDER_HAS_BE_PAYED"),
    DELIVERY("RENT_IS_DELIVERY"),
    RECEIVED("CAR_HAS_RECEIVED"),
    RETURN("CAR_HAS_BEEN_RETURN"),
    CANCELED("RENT_HAS_BEEN_CANCELED"),
    ;

    @Getter
    private String msg;

    @Override
    public String getMsg() {
        return msg;
    }
}
