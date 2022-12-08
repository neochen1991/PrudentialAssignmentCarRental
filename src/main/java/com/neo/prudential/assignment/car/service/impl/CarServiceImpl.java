package com.neo.prudential.assignment.car.service.impl;

import com.neo.prudential.assignment.car.entity.Car;
import com.neo.prudential.assignment.car.enums.CarStatus;
import com.neo.prudential.assignment.car.repository.CarRepository;
import com.neo.prudential.assignment.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author neo
 * @date 2022/12/8
 */
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Override
    public Car save(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> listAll() {
        return carRepository.findAll();
    }

    @Override
    public Page<Car> listPage(Pageable pageable) {
        return carRepository.findAll(pageable);
    }

    @Override
    public Optional<Car> getById(String carId) {
        return carRepository.findById(carId);
    }

    @Override
    public Car update(Car car) {
        return carRepository.save(car);
    }

    @Override
    public List<Car> listCarsInStock() {
        List<Car> cars = carRepository.listByCarStatus(CarStatus.SHELVES);
        return cars;
    }

    @Override
    public List<Car> listByModel(String model) {
        return carRepository.listByModel(model);
    }

    @Override
    public void shelvesCar(String id) {
        carRepository.switchCarStatus(id, CarStatus.SHELVES);
    }
}
