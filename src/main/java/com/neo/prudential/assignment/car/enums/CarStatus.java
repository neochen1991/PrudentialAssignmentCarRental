package com.neo.prudential.assignment.car.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author neo
 * @date 2022/12/8
 */
@AllArgsConstructor
public enum CarStatus implements BaseEnum {

    SHELVES("CAR_IS_ON_SHELVES"),
    OCCUPY("CAR_IS_OCCUPY"),
    FROZEN("CAR_IS_FROZEN"),
    UNSHELVES("CAR_IS_OFF_SHELVES"),
    DELETED("CAR_IS_DELETED"),
    ;

    @Getter
    private String msg;

    @Override
    public String getMsg() {
        return msg;
    }
}
