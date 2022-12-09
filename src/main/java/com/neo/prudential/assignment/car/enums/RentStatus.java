package com.neo.prudential.assignment.car.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author neo
 * @date 2022/12/8
 */
@AllArgsConstructor
public enum RentStatus implements BaseEnum {

    INITIAL("INITIAL","RENT_INITIAL"),
    PENDING("PENDING","RENT_IS_PENDING"),
    PAYED("PAYED","ORDER_HAS_BE_PAYED"),
    DELIVERY("DELIVERY","RENT_IS_DELIVERY"),
    RECEIVED("RECEIVED","CAR_HAS_RECEIVED"),
    RETURN("RETURN","CAR_HAS_BEEN_RETURN"),
    CANCELED("CANCELED","RENT_HAS_BEEN_CANCELED"),
    ;

    @Getter
    private String opetate;
    private String msg;

    @Override
    public String getMsg() {
        return msg;
    }

    public String getOperate() {
        return opetate;
    }

    public static RentStatus getStatusByOperate(String operate){
        for(RentStatus s: values()){
            if(s.getOperate().equals(operate))
                return s;
        }
        return INITIAL;
    }
}
