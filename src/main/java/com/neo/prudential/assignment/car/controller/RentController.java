package com.neo.prudential.assignment.car.controller;

import com.neo.prudential.assignment.car.entity.Car;
import com.neo.prudential.assignment.car.entity.Customer;
import com.neo.prudential.assignment.car.entity.RentInfo;
import com.neo.prudential.assignment.car.enums.CarStatus;
import com.neo.prudential.assignment.car.enums.CustomerStatus;
import com.neo.prudential.assignment.car.enums.RestCode;
import com.neo.prudential.assignment.car.enums.RentStatus;
import com.neo.prudential.assignment.car.model.BaseResponse;
import com.neo.prudential.assignment.car.service.CarService;
import com.neo.prudential.assignment.car.service.CustomerService;
import com.neo.prudential.assignment.car.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.neo.prudential.assignment.car.enums.Constant;

/**
 * @author neo
 * @date 2022/12/8
 */
@RestController
@RequestMapping("/rent")
public class RentController extends BaseRestController {

    @Autowired
    CustomerService customerService;

    @Autowired
    CarService carService;

    @Autowired
    RentService rentService;
    

    @GetMapping("/listByCustomer")
    public BaseResponse listByCustomer(@RequestParam("customerId") String customerId) {
        List<RentInfo> rentInfos = rentService.listByCustomer(customerId);
        return success(rentInfos);
    }

    /**
     * customer place an order to rent a car
     *
     * @param customerId
     * @param carId
     * @return
     */
    @PostMapping("/order")
    public BaseResponse order(@RequestParam("customerId") @NotNull String customerId,
                              @RequestParam("carId") @NotNull String carId) {
        Optional<Customer> customer = customerService.getById(customerId);

        if (!customer.isPresent()) {
            return error(RestCode.ERROR);
        }
        Optional<Car> car = carService.getById(carId);
        if (!car.isPresent()) {
            return error(RestCode.ERROR);
        }
//        customer is not available
        if (customer.get().getStatus() != CustomerStatus.NORMAL) {
            return error(RestCode.ERROR);
        }
//        the car is not available
        if (car.get().getStatus() != CarStatus.SHELVES) {
            return error(RestCode.ERROR);
        }

//        rentInfo init
        RentInfo build = RentInfo.builder().customer(customer.get())
                .car(car.get())
                .orderTime(LocalDateTime.now())
                .status(RentStatus.INITIAL)
                .build();

        RentInfo save = rentService.save(build);

        return success(save);
    }


    /**
     * @param customerId
     * @param carId
     * @param rentId
     * @return
     */
    @PostMapping("/payment")
    public BaseResponse payment(@RequestParam("customerId") @NotNull String customerId,
                                @RequestParam("carId") @NotNull String carId,
                                @RequestParam("rentId") @NotNull String rentId) {
        Optional<RentInfo> rentInfo = rentService.getById(rentId);
        if (!rentInfo.isPresent()) {
            return error(RestCode.ERROR);
        }

        Customer customer = rentInfo.get().getCustomer();
        Car car = rentInfo.get().getCar();

        if (!customer.getId().equals(customerId) || car.getId().equals(carId)) {
            return error(RestCode.ERROR);
        }
        rentInfo.get().setStatus(RentStatus.PAYED);
        RentInfo save = rentService.save(rentInfo.get());

//        frozen the car after payment
        car.setStatus(CarStatus.FROZEN);
        carService.save(car);

        return success(save);
    }

    @PostMapping("/operate")
    public BaseResponse cancel(@RequestParam("rentId") @NotNull String rentId,String operate) {
        Optional<RentInfo> rentInfo = rentService.getById(rentId);
        if (!rentInfo.isPresent()) {
            return error(RestCode.ERROR);
        }
        RentInfo tt = rentInfo.get();
        tt.setStatus(RentStatus.getStatusByOperate(operate));

        RentInfo save = rentService.save(tt);

        Car car = tt.getCar();
        car.setStatus(CarStatus.SHELVES);
        carService.save(car);

        return success();
    }

}
