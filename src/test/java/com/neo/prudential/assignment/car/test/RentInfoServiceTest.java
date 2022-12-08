package com.neo.prudential.assignment.car.test;

import com.neo.prudential.assignment.car.CarRentalApplication;
import com.neo.prudential.assignment.car.entity.Car;
import com.neo.prudential.assignment.car.entity.Customer;
import com.neo.prudential.assignment.car.entity.RentInfo;
import com.neo.prudential.assignment.car.enums.CarStatus;
import com.neo.prudential.assignment.car.enums.CustomerStatus;
import com.neo.prudential.assignment.car.enums.RentStatus;
import com.neo.prudential.assignment.car.service.RentService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author neo
 * @date 2022/12/8
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CarRentalApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class RentInfoServiceTest {

    @Autowired
    private RentService rentService;

    @Test
    public void testTicketList() {
        List<RentInfo> list = rentService.list();

        Assert.assertNotEquals(0, list.size());

    }

    @Test
    public void testListByCustomer() {
        String customerId = "111111";
        List<RentInfo> rentInfos = rentService.listByCustomer(customerId);

        Assert.assertNotEquals(0, rentInfos.size());
    }

    @Test
    public void testGetById() {
        String ticketId = "111111";

        RentInfo rentInfo = rentService.getById(ticketId).orElse(null);

        assert rentInfo != null;

        Assert.assertEquals(ticketId, rentInfo.getId());
    }

    @Test
    public void testTicketSave() {
        Car car = Car.builder().model("model").status(CarStatus.SHELVES).build();
        Customer customer = Customer.builder().status(CustomerStatus.NORMAL).name("tom").build();

        RentInfo rentInfo = RentInfo.builder().status(RentStatus.INITIAL)
                .car(car)
                .customer(customer)
                .orderTime(LocalDateTime.now())
                .build();
        RentInfo save = rentService.save(rentInfo);

        Assert.assertEquals(rentInfo, save);
    }
}
