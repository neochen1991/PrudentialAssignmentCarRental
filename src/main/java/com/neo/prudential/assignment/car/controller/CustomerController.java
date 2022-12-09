package com.neo.prudential.assignment.car.controller;

import com.neo.prudential.assignment.car.entity.Customer;
import com.neo.prudential.assignment.car.model.BaseResponse;
import com.neo.prudential.assignment.car.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author neo
 * @date 2022/12/8
 */
@RestController
@RequestMapping("/customer")
public class CustomerController extends BaseRestController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/ping")
    public String ping(){
        return "pong";
    }

    @PostMapping("/save")
    public BaseResponse save(@RequestParam("name") @NotNull String name){
        Customer build = Customer.builder().name(name).build();
        Customer save = customerService.save(build);
        return  success(save);
    }

    @PostMapping("/list")
    public BaseResponse list(){
        List<Customer> list = customerService.list();
        return success(list);
    }
}
