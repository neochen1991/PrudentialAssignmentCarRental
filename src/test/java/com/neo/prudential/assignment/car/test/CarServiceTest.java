package com.neo.prudential.assignment.car.test;

import com.neo.prudential.assignment.car.CarRentalApplication;
import com.neo.prudential.assignment.car.entity.Car;
import com.neo.prudential.assignment.car.enums.CarStatus;
import com.neo.prudential.assignment.car.service.CarService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author neo
 * @date 2022/12/8
 */
@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = CarRentalApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarServiceTest {

    @Autowired
    private CarService carService;

    @Test
    public void testListAll() {
        List<Car> cars = carService.listAll();
        Assert.assertEquals("total car num is wrong", 4, cars.size());
    }
    @Test
    public void testListByModel() {
        String model = "BMW 650";
        List<Car> cars = carService.listByModel(model);
        Assert.assertEquals("total car num is wrong", 4, cars.size());
    }

    @Test
    public void testListPage() {
        Page<Car> cars = carService.listPage(PageRequest.of(0, 5));
        long totalElements = cars.getTotalElements();
        Assert.assertEquals("total car number is wrong", 5, totalElements);
    }

    @Test
    public void testGetById() {
        String carId = "1";
        Car byId = carService.getById(carId).orElse(null);
        Assert.assertNotNull("car is wrong", byId);
    }

    @Test
    public void testCarSave() {
        Car car = Car.builder().model("BENZ").build();
        Car save = carService.save(car);

        Assert.assertEquals(car, save);
    }

    @Test
    public void testCarUpdate() {
        String model = "BENZ";
        String carId = "1";
        Car car = carService.getById(carId).orElse(null);

        assert car != null;

        car.setModel(model);
        Car save = carService.save(car);

        Assert.assertEquals(save.getModel(), model);

    }

    @Test
    public void testShelvesCar() {
        String carId = "1";
        carService.shelvesCar(carId);

        Car car = carService.getById(carId).orElse(null);
        assert car != null;

        Assert.assertEquals(car.getStatus(), CarStatus.SHELVES);

    }

}
