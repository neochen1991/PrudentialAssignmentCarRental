package com.neo.prudential.assignment.car.service.impl;

import com.neo.prudential.assignment.car.entity.RentInfo;
import com.neo.prudential.assignment.car.repository.RentInfoRepository;
import com.neo.prudential.assignment.car.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author neo
 * @date 2022/12/8
 */
@Service
public class RentServiceImpl implements RentService {

    @Autowired
    RentInfoRepository rentInfoRepository;

    @Override
    public List<RentInfo> list() {
        return rentInfoRepository.findAll();
    }

    @Override
    public List<RentInfo> listByCustomer(String customerId) {
        return rentInfoRepository.listByCustomerId(customerId);
    }

    @Override
    public Optional<RentInfo> getById(String ticketId) {
        return rentInfoRepository.findById(ticketId);
    }

    @Override
    public RentInfo save(RentInfo rentInfo) {
        return rentInfoRepository.save(rentInfo);
    }
}
