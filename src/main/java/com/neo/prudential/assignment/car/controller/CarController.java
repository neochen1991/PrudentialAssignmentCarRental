package com.neo.prudential.assignment.car.controller;

import com.neo.prudential.assignment.car.entity.Car;
import com.neo.prudential.assignment.car.enums.CarStatus;
import com.neo.prudential.assignment.car.enums.RestCode;
import com.neo.prudential.assignment.car.model.BaseResponse;
import com.neo.prudential.assignment.car.model.vo.CarInStock;
import com.neo.prudential.assignment.car.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author neo
 * @date 2022/12/8
 */
@RestController
@RequestMapping("/api/v1/car")
public class CarController extends BaseRestController {

    @Autowired
    CarService carService;

    @GetMapping("/ping")
    public String ping() {
        return "pong";
    }

    @PostMapping("/save")
    public BaseResponse save(@RequestParam(name = "model") String model) {

        Car build = Car.builder().model(model)
                .status(CarStatus.UNSHELVES)
                .build();

        Car save = carService.save(build);
        return success(save);
    }

    @GetMapping("/list")
    public BaseResponse list() {
        List<Car> cars = carService.listAll();
        return success(cars);
    }

    @GetMapping("/listByModel")
    public BaseResponse listByModel(@RequestParam("model") @NotNull String model) {
        List<Car> listByModel = carService.listByModel(model);
        return success(listByModel);
    }

    @GetMapping("/listCarInStock")
    public BaseResponse listCarsInStock() {
        List<Car> cars = carService.listCarsInStock();
        Map<String, Long> collect = cars.stream().collect(Collectors.groupingBy(Car::getModel, Collectors.counting()));
        List<CarInStock> carInStocks = CarInStock.fromMap(collect);
        return success(carInStocks);
    }

    @GetMapping("/listPage")
    public BaseResponse listPage(@RequestParam("page") int page,
                                 @RequestParam("size") int size) {
        Page<Car> cars = carService.listPage(PageRequest.of(page, size));
        return success(cars);
    }

    @PostMapping("/shelves")
    public BaseResponse shelves(@RequestParam("id") @NotNull String id) {
        Optional<Car> car = carService.getById(id);
        if (car.isPresent()) {
            carService.shelvesCar(id);
        } else {
            return error(RestCode.ERROR);
        }
        return success();
    }
}
