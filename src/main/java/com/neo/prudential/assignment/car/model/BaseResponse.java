package com.neo.prudential.assignment.car.model;

import com.neo.prudential.assignment.car.enums.Constant;
import com.neo.prudential.assignment.car.enums.RestCode;
import lombok.Data;
import org.slf4j.MDC;

/**
 * @author neo
 * @date 2022/12/8
 */
@Data
public class BaseResponse<T>{

    private int code;

    private String msg;

    private T data;

    private String logId;

    public BaseResponse() {
        this.code = RestCode.SUCCESS.getCode();
        this.msg = RestCode.SUCCESS.getMsg();
        this.data = null;
    }

    public BaseResponse(T content) {
        this.data = content;
        this.code = RestCode.SUCCESS.getCode();
        this.msg = RestCode.SUCCESS.getMsg();
    }

    public BaseResponse(RestCode restCode) {
        this.code = restCode.getCode();
        this.msg = restCode.getMsg();
        this.data = null;
    }

    public BaseResponse(RestCode restCode, T data) {
        this.data = data;
        this.code = restCode.getCode();
        this.msg = restCode.getMsg();
    }

    public BaseResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public BaseResponse<T> success() {
        setCode(RestCode.SUCCESS.getCode());
        setMsg(RestCode.SUCCESS.getMsg());
        return this;
    }

    public BaseResponse<T> success(T data) {
        setData(data);
        setCode(RestCode.SUCCESS.getCode());
        setMsg(RestCode.SUCCESS.getMsg());
        return this;
    }

    public BaseResponse<T> success(T data, String msg) {
        setData(data);
        setCode(RestCode.SUCCESS.getCode());
        setMsg(msg);
        return this;
    }

    public BaseResponse<T> error(RestCode restCode) {
        setCode(restCode.getCode());
        setMsg(restCode.getMsg());
        setLogId(getLogId());
        return this;
    }

    public BaseResponse<T> error(RestCode restCode, String msg) {
        setCode(restCode.getCode());
        setMsg(msg);
        setLogId(getLogId());
        return this;
    }

    public String getLogId() {
        return MDC.get(Constant.LOG_ID);
    }


}
