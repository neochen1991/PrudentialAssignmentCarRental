package com.neo.prudential.assignment.car.service;

import com.neo.prudential.assignment.car.entity.Customer;

import java.util.List;
import java.util.Optional;

/**
 * @author neo
 * @date 2022/12/8
 */
public interface CustomerService extends BaseService<Customer> {

    List<Customer> list();

    Customer save(Customer build);

    Optional<Customer> getById(String customerId);
}
