package com.neo.prudential.assignment.car.service;

import com.neo.prudential.assignment.car.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @author neo
 * @date 2022/12/8
 */
public interface CarService extends BaseService<Car> {

    Car save(Car car);

    List<Car> listAll();

    Page<Car> listPage(Pageable pageable);

    Optional<Car> getById(String carId);

    Car update(Car car);

    List<Car> listCarsInStock();

    List<Car> listByModel(String model);

    void shelvesCar(String id);
}
