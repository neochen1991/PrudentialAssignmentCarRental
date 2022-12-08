package com.neo.prudential.assignment.car.service.impl;

import com.neo.prudential.assignment.car.entity.Customer;
import com.neo.prudential.assignment.car.repository.CustomerRepository;
import com.neo.prudential.assignment.car.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author neo
 * @date 2022/12/8
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public List<Customer> list() {
        return customerRepository.findAll();
    }

    @Override
    public Customer save(Customer build) {
        return customerRepository.save(build);
    }

    @Override
    public Optional<Customer> getById(String customerId) {
        return customerRepository.findById(customerId);
    }
}
