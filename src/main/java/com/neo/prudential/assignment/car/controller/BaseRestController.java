package com.neo.prudential.assignment.car.controller;

import com.neo.prudential.assignment.car.model.BaseResponse;
import com.neo.prudential.assignment.car.controller.AbstractController;
import com.neo.prudential.assignment.car.enums.RestCode;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author neo
 * @date 2022/12/8
 */
@RestController
public class BaseRestController extends AbstractController {

    protected BaseResponse error(RestCode responseCode) {
        return new BaseResponse().error(responseCode);
    }

    protected BaseResponse error(String msg) {
        return new BaseResponse().error(RestCode.ERROR, msg);
    }

    protected BaseResponse error(RestCode responseCode, String... msg) {
        return new BaseResponse().error(responseCode, String.format(responseCode.getMsg(), msg));
    }

    protected BaseResponse success() {
        return new BaseResponse().success();
    }

    protected BaseResponse success(Object data) {
        return new BaseResponse().success(data);
    }

}
