package com.neo.prudential.assignment.car.service;

import com.neo.prudential.assignment.car.entity.RentInfo;

import java.util.List;
import java.util.Optional;

/**
 * @author neo
 * @date 2022/12/8
 */
public interface RentService extends BaseService<RentInfo> {

    List<RentInfo> list();

    List<RentInfo> listByCustomer(String customerId);

    Optional<RentInfo> getById(String ticketId);

    RentInfo save(RentInfo rentInfo);
}
