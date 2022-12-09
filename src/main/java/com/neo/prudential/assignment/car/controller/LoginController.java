package com.neo.prudential.assignment.car.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.neo.prudential.assignment.car.entity.Car;
import com.neo.prudential.assignment.car.enums.CarStatus;
import com.neo.prudential.assignment.car.enums.RestCode;
import com.neo.prudential.assignment.car.model.BaseResponse;
import com.neo.prudential.assignment.car.model.vo.CarInStock;
import com.neo.prudential.assignment.car.service.CarService;

/**
 * @author neo
 * @date 2022/12/8
 */
@RestController
@RequestMapping("/user")
public class LoginController extends BaseRestController {

    @Autowired
    CarService carService;

    @PostMapping("/login")
    public BaseResponse login(@RequestParam(name = "user") String user) {

        return success();
    }

    @GetMapping("/logOut")
    public BaseResponse logOut(@RequestParam(name = "user") String user) {
        return success();
    }


}
