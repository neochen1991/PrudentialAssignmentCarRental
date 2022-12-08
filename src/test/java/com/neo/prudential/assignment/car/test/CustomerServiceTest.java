package com.neo.prudential.assignment.car.test;

import com.neo.prudential.assignment.car.CarRentalApplication;
import com.neo.prudential.assignment.car.entity.Customer;
import com.neo.prudential.assignment.car.enums.CustomerStatus;
import com.neo.prudential.assignment.car.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author neo
 * @date 2022/12/8
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CarRentalApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CustomerServiceTest {

    @Autowired
    CustomerService customerService;

    @Test
    public void testCustomerList() {
        customerService.list();
    }

    @Test
    public void testSaveCustomer() {

        Customer customer = Customer.builder().name("tom")
                .status(CustomerStatus.NORMAL)
                .build();
        Customer save = customerService.save(customer);

        Assert.assertEquals(customer, save);
    }

    @Test
    public void testGetById() {
        String customerId = "1";
        Customer customer = customerService.getById(customerId).orElse(null);

        assert customer != null;

        Assert.assertEquals(customerId, customer.getId());
    }
}
