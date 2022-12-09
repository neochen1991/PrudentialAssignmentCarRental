package com.neo.prudential.assignment.car.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author neo
 * @date 2022/12/8
 */
@AllArgsConstructor
public enum CarStatus implements BaseEnum {

    SHELVES("INITIAL","CAR_IS_ON_SHELVES"),
    OCCUPY("RECEIVED","CAR_IS_OCCUPY"),
    FROZEN("DELIVERY","CAR_IS_FROZEN"),
    UNSHELVES("RETURN","CAR_IS_OFF_SHELVES"),
    DELETED("CANCELED","CAR_IS_DELETED"),
    ;

    @Getter
    private String msg;
    @Getter
    private String operate;

    @Override
    public String getMsg() {
        return msg;
    }

    public String getOperate() {
        return operate;
    }

    public static CarStatus getStatusByOperate(String operate){
        for(CarStatus s: values()){
            if(s.getOperate().equals(operate))
                return s;
        }
        return SHELVES;
    }
}
